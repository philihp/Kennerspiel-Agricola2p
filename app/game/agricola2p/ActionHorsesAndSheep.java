package game.agricola2p;

import game.GameError;
import java.util.*;

public class ActionHorsesAndSheep extends Action {
	
	private boolean isEmpty = true;

	public ActionHorsesAndSheep(Board board) {
		super("HORSES", board);
	}

	@Override
	protected void onRoundStart() {
		super.onRoundStart();
		
		if(isEmpty) {
			resources.add(new Horse(board));
			isEmpty = false;
		}
		else {
			resources.add(new Sheep(board));
		}
	}
	
	@Override
	protected void onTake() throws GameError {
		super.onTake();
		isEmpty = true;
	}

}
