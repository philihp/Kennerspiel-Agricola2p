package game.agricola2p;

import game.GameError;

import java.util.*;

public class FarmBoard extends Element {
	
	protected List<Element> resources;
	
	protected final PlayerColor color;
	
	private List<Worker> workers = new ArrayList<Worker>(3);

	public FarmBoard(Board board, PlayerColor color) {
		super(board);
		this.color = color;
		this.resources = new ArrayList<Element>();

		workers.add(new Worker(board, color));
		workers.add(new Worker(board, color));
		workers.add(new Worker(board, color));
		resources.addAll(workers);
	}
	
	protected Worker getFreeWorker() throws GameError {
		for(Worker w : workers) {
			if(resources.contains(w)) {
				return w;
			}
		}
		throw new GameError("No free workers for "+color+" farm");
	}

	@Override
	protected void onRoundStart() {
		super.onRoundStart();
		
		//go through all actions and remove any of my workers from them
		for(Action a : board.gameBoard.actions.values()) {
			a.resources.removeAll(workers);
		}
		
		//then put them back on the farm
		resources.addAll(workers);
	}
	
}
