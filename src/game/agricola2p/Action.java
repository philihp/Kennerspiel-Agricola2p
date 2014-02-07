package game.agricola2p;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import game.GameError;

@JsonInclude(Include.NON_NULL)
abstract class Action extends Element {
	
	protected String id;
	
	List<Element> resources;
	
	public Action(String id, Board board) {
		super(board);
		this.id = id;
		resources = new ArrayList<Element>();
	}
	
	protected void onTake() throws GameError {
		Worker occupant = board.activeFarm().getFreeWorker();
		
		// move all of the stuff on this action to the active player's farm
		board.activeFarm().resources.addAll(resources);
		for(Element e : resources) {
			e.touch();
		}
		resources.clear();
		
		// then move the active player's worker onto this farm
		board.activeFarm().resources.remove(occupant);
		this.resources.add(occupant);
		occupant.touch();
	}
	
	@Override
	protected void onRoundStart() {
		super.onRoundStart();
	}

	@Override
	protected void onRoundEnd() {
		super.onRoundEnd();
		
		List<Worker> workers = new ArrayList<Worker>(1);
		for(Element e : resources) {
			if(e instanceof Worker) {
				workers.add((Worker)e);
			}
		}
		
		for(Worker w : workers) {
			resources.remove(w);
			board.farmBoards.get(w.color).resources.add(w);
		}
		
	}

	public List<Element> getResources() {
		return resources;
	}

	@Override
	public String getType() {
		return "ACTION";
	}

}
