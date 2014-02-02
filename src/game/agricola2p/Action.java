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
		touch();
		board.activeFarm().resources.addAll(resources);
		resources.clear();
	}

}
