package game.agricola2p;

import game.GameError;
import java.util.*;

public class ActionExpand extends Action {
	
	public static final String COMMAND = "EXPAND";
	
	public ActionExpand(Board board) {
		super(COMMAND, board);
	}
	
	@Override
	protected void onRoundStart() {
		super.onRoundStart();
		resources.add(new Fence(board));
	}

	@Override
	protected void onTake() throws GameError {
		super.onTake();
		TaskExpand task = new TaskExpand(board);
		board.tasks.put(COMMAND, task);
		
		if(board.gameBoard.findExpansion() == null) {
			task.usable = false;
		}
	}
	
}
