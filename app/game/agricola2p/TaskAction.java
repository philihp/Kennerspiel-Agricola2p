package game.agricola2p;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.Table.Cell;

public class TaskAction extends Task {
	
	protected boolean usable;
	
	public TaskAction(Board board) {
		super(board);
		usable = true;
	}
	
	public boolean isUsable() {
		return usable;
	}

	@Override
	public List<String> getPossibleParameters() {
		List<String> p = new ArrayList<String>();

		for(Action a : board.gameBoard.actions.values()) {
			if(a.isUsable())
				p.add(a.id);
		}
		
		return p;
	}

}