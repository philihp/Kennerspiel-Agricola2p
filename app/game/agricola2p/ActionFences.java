package game.agricola2p;

import game.GameError;
import java.util.*;

public class ActionFences extends Action {
	
	public ActionFences(Board board) {
		super("FENCE", board);
	}

	@Override
	protected void onTake() throws GameError {
		super.onTake();
		board.tasks.add(new TaskFence(board));
	}
	
}
