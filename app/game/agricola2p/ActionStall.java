package game.agricola2p;

import game.GameError;
import java.util.*;

public class ActionStall extends Action {

	public static final String COMMAND = "STALL";

	public ActionStall(Board board) {
		super(COMMAND, board);
	}

	@Override
	protected boolean isUsable() {
		boolean superRet = super.isUsable();
		if (superRet == false)
			return false;

		int stone = 3;
		int reed = 1;
		
		for (Element e : board.activeFarm().resources) {
			if (e instanceof Stone)
				stone--;
			else if (e instanceof Reed)
				reed--;
		}
		
		return (reed <= 0 && stone <= 0);
	}

	@Override
	protected void onTake() throws GameError {
		super.onTake();
		TaskStall task = new TaskStall(board);
		board.tasks.put(COMMAND, task);

		if (board.gameBoard.find(Stall.class) == null) {
			task.usable = true;
		}
	}

}
