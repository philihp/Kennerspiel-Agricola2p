package game.agricola2p;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.Table.Cell;

public class TaskFence extends Task {
	
	public TaskFence(Board board) {
		super(board);
	}
	
	public String getCommand() {
		return "FENCE";
	}
	
	public boolean isUsable() {
		for(Element e : board.activeFarm().resources) {
			if(e instanceof Wood) return true;
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
			if((row + col) % 2 == 1) {
				LotFence lot = (LotFence)terrain.get(row, col);
				if(lot.fence == null) {
					p.add(row+" "+col);
				}
			}
		}
		
		return p;
	}

}