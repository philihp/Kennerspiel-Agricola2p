package game.agricola2p;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.Table.Cell;

public class TaskStall extends Task {
	
	protected boolean usable;
	
	public TaskStall(Board board) {
		super(board);
		usable = true;
	}
	
	public boolean isUsable() {
		if(usable == false) return false;

		int reed = 1;
		int stone = 3;
		for(Element e : board.activeFarm().resources) {
			if(e instanceof Stone) stone--;
			else if(e instanceof Reed) reed--;
		}
		return (reed <= 0 && stone <= 0);
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
				if(lot.building == null) {
					p.add(row+" "+col);
				}
			}
		}
		
		return p;
	}

}