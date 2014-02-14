package game.agricola2p;

import game.GameError;
import java.util.*;

public class ActionSpecialBuilding extends Action {
	
	public static final String COMMAND = "BUILD";
	
	public ActionSpecialBuilding(Board board) {
		super(COMMAND, board);
	}

	@Override
	protected void onTake() throws GameError {
		super.onTake();
		board.tasks.put(COMMAND, new TaskBuild(board));
	}
	
}
