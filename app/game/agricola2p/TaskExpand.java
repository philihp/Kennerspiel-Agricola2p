package game.agricola2p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.Table.Cell;

public class TaskExpand extends Task {
	
	protected boolean usable;
	
	public TaskExpand(Board board) {
		super(board);
		usable = true;
	}
	
	public boolean isUsable() {
		return usable && board.gameBoard.findExpansion() != null;
	}

	@Override
	public List<String> getPossibleParameters() {
		if(isUsable())
			return Arrays.asList(new String[] {"LEFT", "RIGHT"});
		else
			return Arrays.asList(new String[] {});
	}

}