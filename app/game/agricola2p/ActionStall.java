package game.agricola2p;

import game.GameError;
import java.util.*;

public class ActionStall extends Action {
	
	public static final String COMMAND = "STALL";
	
	public ActionStall(Board board) {
		super(COMMAND, board);
	}

	@Override
	protected void onTake() throws GameError {
		super.onTake();
		TaskStall task = new TaskStall(board);
		board.tasks.put(COMMAND, task);
		
		if(board.gameBoard.find(Stall.class) == null) {
			task.usable = true;
		}
	}
	
}
