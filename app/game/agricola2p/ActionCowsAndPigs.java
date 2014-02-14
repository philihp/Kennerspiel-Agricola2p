package game.agricola2p;

import game.GameError;
import java.util.*;

public class ActionCowsAndPigs extends Action implements CommittableAfterTaken {
	
	private boolean isEmpty = true;

	public ActionCowsAndPigs(Board board) {
		super("COWS", board);
	}

	@Override
	protected void onRoundStart() {
		super.onRoundStart();
		
		if(isEmpty) {
			resources.add(new Cow(board));
			isEmpty = false;
		}
		else {
			resources.add(new Pig(board));
		}
	}
	
	@Override
	protected void onTake() throws GameError {
		super.onTake();
		isEmpty = true;
	}

}
