package game.agricola2p;

import game.GameError;
import java.util.*;

public class ActionStable extends Action {
	
	public static final String COMMAND = "STABLE";
	
	public ActionStable(Board board) {
		super(COMMAND, board);
	}

	@Override
	protected void onTake() throws GameError {
		super.onTake();
		board.tasks.put(COMMAND, new TaskStable(board));
	}
	
}
