package game.agricola2p;

import game.GameError;
import java.util.*;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.Table.Cell;

public class ActionSpecialBuilding extends Action {

	public static final String COMMAND = "BUILD";

	public ActionSpecialBuilding(String id, Board board) {
		super(id, board);
	}

	@Override
	protected void onTake() throws GameError {
		super.onTake();
		board.tasks.put(COMMAND, new TaskBuild(board));
	}

	@Override
	protected boolean isUsable() {
		if (super.isUsable() == false)
			return false;

		ArrayTable<Integer, Integer, Lot> terrain = board.activeFarm().terrain;

		for (Element e : board.gameBoard.resources) {
			if (e instanceof Building && ((Building) e).canBuild()) {
				Building b = (Building)e;
				for (Cell<Integer, Integer, Lot> cell : terrain.cellSet()) {
					int row = cell.getRowKey();
					int col = cell.getColumnKey();
					if (row % 2 == 1 && col % 2 == 1) {
						LotPasture lot = (LotPasture) terrain.get(row, col);
						if (b.canBuildAt(lot)) {
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
}
