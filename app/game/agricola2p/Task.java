package game.agricola2p;

import java.util.List;

abstract class Task {
	
	protected Board board;
	
	public Task(Board board) {
		this.board = board;
	}
	
	public abstract List<String> getPossibleParameters();
	
	public abstract boolean isUsable();

}
