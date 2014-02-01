package game.agricola2p;

import game.GameError;
import java.util.*;

public class ActionA2 extends Action {
	

	public ActionA2(Board board) {
		super(board);
	}

	@Override
	protected void onRoundStart() {
		super.onRoundStart();
		resources.add(new Wood(board));
		resources.add(new Wood(board));
		resources.add(new Wood(board));
	}

	@Override
	protected void onTake() throws GameError {
		
	}

}
