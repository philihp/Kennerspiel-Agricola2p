package game.agricola2p;

import java.util.ArrayList;
import java.util.List;

import game.GameError;

abstract class Action extends Element {
	
	List<Element> resources;
	
	public Worker occupant = null;
	
	public Action(Board board) {
		super(board);
		resources = new ArrayList<Element>();
	}
	
	protected void onTake() throws GameError {
		board.activeFarm().resources.addAll(resources);
		resources.clear();
	}

}
