package game.agricola2p;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.Table.Cell;

public class TaskTrough extends Task {
	
	protected int timesUsed;
	
	public TaskTrough(Board board) {
		super(board);
		timesUsed = 0;
	}
	
	public boolean isUsable() {
		if(timesUsed < 1) return true;
		
		int wood = 0;
		for(Element e : board.activeFarm().resources) {
			if(e instanceof Wood) wood++;
			if(wood >= 3) return true;
		}
		return false;
	}

	@Override
	public List<String> getPossibleParameters() {
		List<String> p = new ArrayList<String>();

		ArrayTable<Integer, Integer, Lot> terrain = board.activeFarm().terrain;

		for(Cell<Integer, Integer, Lot> cell : terrain.cellSet()) {
			int row = cell.getRowKey();
			int col = cell.getColumnKey();
			if(row % 2 == 1 && col % 2 == 1) {
				LotPasture lot = (LotPasture)terrain.get(row, col);
				if(lot.trough == null) {
					p.add(row+" "+col);
				}
			}
		}
		
		return p;
	}

}