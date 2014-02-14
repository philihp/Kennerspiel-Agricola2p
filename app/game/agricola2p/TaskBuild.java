package game.agricola2p;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.Table.Cell;

public class TaskBuild extends Task {

	protected boolean usable;

	public TaskBuild(Board board) {
		super(board);
		usable = true;
	}

	public boolean isUsable() {
		return usable;
	}

	@Override
	public List<String> getPossibleParameters() {
		ArrayTable<Integer, Integer, Lot> terrain = board.activeFarm().terrain;

		List<Building> buildable = new ArrayList<Building>();
		for (Element e : board.gameBoard.resources) {
			if (e instanceof Building && ((Building) e).canBuild()) {
				buildable.add((Building) e);
			}
		}

		List<String> p = new ArrayList<String>(buildable.size() * 5);
		for (Building building : buildable) {
			for (Cell<Integer, Integer, Lot> cell : terrain.cellSet()) {
				int row = cell.getRowKey();
				int col = cell.getColumnKey();
				if (row % 2 == 1 && col % 2 == 1) {
					LotPasture lot = (LotPasture) terrain.get(row, col);
					if (building.canBuildAt(lot)) {
						p.add(building.getType() + " " + row + " " + col);
					}
				}
			}
		}
		return p;
	}

}