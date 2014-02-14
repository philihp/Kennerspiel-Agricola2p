package game.agricola2p;

import game.GameError;
import java.util.*;

public class ActionTrough extends Action {
	
	public static final String COMMAND = "TROUGH";
	
	public ActionTrough(Board board) {
		super(COMMAND, board);
	}

	@Override
	protected void onTake() throws GameError {
		super.onTake();
		board.tasks.put(COMMAND, new TaskTrough(board));
	}
	
}
