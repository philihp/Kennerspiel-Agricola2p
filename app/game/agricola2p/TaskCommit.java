package game.agricola2p;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.Table.Cell;

public class TaskCommit extends Task {
	
	protected boolean usable;
	
	public TaskCommit(Board board) {
		super(board);
		usable = false;
	}
	
	public boolean isUsable() {
		return usable;
	}

	@Override
	public List<String> getPossibleParameters() {
		return null;
	}

}