package game.agricola2p;

import game.GameError;
import java.util.*;

public class ActionFences extends Action {
	
	public static final String COMMAND = "FENCE";
	
	public ActionFences(Board board) {
		super(COMMAND, board);
	}
	
	@Override
	protected boolean isUsable() {
		return super.isUsable() && board.activeFarm().find(Wood.class) != null;
	}

	@Override
	protected void onTake() throws GameError {
		super.onTake();
		board.tasks.put(COMMAND, new TaskFence(board));
	}
	
}
