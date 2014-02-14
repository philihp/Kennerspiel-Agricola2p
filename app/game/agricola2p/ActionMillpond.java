package game.agricola2p;

import game.GameError;
import java.util.*;

public class ActionMillpond extends Action implements CommittableAfterTaken {
	
	private boolean isEmpty = true;

	public ActionMillpond(Board board) {
		super("MILL", board);
	}

	@Override
	protected void onRoundStart() {
		super.onRoundStart();
		
		if(isEmpty) {
			resources.add(new Reed(board));
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
