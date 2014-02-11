package game.agricola2p;

import game.GameError;
import java.util.*;

public class ActionWalls extends Action {
	
	public static final String COMMAND = "WALL";
	
	public ActionWalls(Board board) {
		super(COMMAND, board);
	}

	@Override
	protected void onTake() throws GameError {
		super.onTake();
		board.tasks.put(COMMAND, new TaskWall(board));
	}
	
}
