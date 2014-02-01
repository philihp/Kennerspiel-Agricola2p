package game.agricola2p;

import game.GameError;
import java.util.*;

public class ActionA1 extends Action {

	public ActionA1(Board board) {
		super(board);
	}

	@Override
	protected void onRoundStart() {
		super.onRoundStart();
		resources.add(new Wood(board));
	}

	@Override
	protected void onTake() throws GameError {
	}

}
