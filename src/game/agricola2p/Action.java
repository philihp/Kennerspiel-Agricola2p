package game.agricola2p;

import java.util.ArrayList;
import java.util.List;

import game.GameError;

abstract class Action extends Element {
	
	protected String id;
	
	List<Element> resources;
	
	public Worker occupant = null;
	
	public Action(String id, Board board) {
		super(board);
		this.id = id;
		resources = new ArrayList<Element>();
	}
	
	protected void onTake() throws GameError {
		Worker worker = board.activeFarm().getFreeWorker();
		
		// move all of the stuff on this action to the active player's farm
		board.activeFarm().resources.addAll(resources);
		for(Element e : resources) {
			e.touch();
		}
		resources.clear();
		
		// then move the active player's worker onto this farm
		board.activeFarm().resources.remove(worker);
		this.resources.add(worker);
		worker.touch();
	}

}
