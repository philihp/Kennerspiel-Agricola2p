package game.agricola2p;

import game.GameError;
import java.util.*;

public class ActionPigsAndSheep extends Action implements CommittableAfterTaken {
	
	private boolean isEmpty = true;

	public ActionPigsAndSheep(Board board) {
		super("PIGS", board);
	}

	@Override
	protected void onRoundStart() {
		super.onRoundStart();
		
		if(isEmpty) {
			resources.add(new Pig(board));
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
