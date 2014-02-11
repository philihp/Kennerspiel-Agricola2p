package game.agricola2p;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.Table.Cell;

public class TaskWall extends Task {
	
	protected int timesUsed;
	
	public TaskWall(Board board) {
		super(board);
		timesUsed = 0;
	}
	
	public boolean isUsable() {
		if(timesUsed < 2) return true;
		
		int stone = 0;
		for(Element e : board.activeFarm().resources) {
			if(e instanceof Stone) stone++;
			if(stone >= 2) return true;
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