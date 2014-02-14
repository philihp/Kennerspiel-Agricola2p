package game.agricola2p;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.Table.Cell;

abstract class Task {

	protected Board board;

	public Task(Board board) {
		this.board = board;
	}

	public abstract List<String> getPossibleParameters();

	public abstract boolean isUsable();
//
//	protected List<int> getPastureList() {
//		List<String> p = new ArrayList<String>();
//		ArrayTable<Integer, Integer, Lot> terrain = board.activeFarm().terrain;
//
//		for (Cell<Integer, Integer, Lot> cell : terrain.cellSet()) {
//			int row = cell.getRowKey();
//			int col = cell.getColumnKey();
//			if (row % 2 == 1 && col % 2 == 1) {
//				p.add(row + " " + col);
//			}
//		}
//
//	}

}
