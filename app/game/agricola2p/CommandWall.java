package game.agricola2p;

import game.Command;
import game.GameError;

import org.apache.commons.lang3.StringUtils;

public class CommandWall implements Command {
	
	private String[] params;
	
	private Board board;
	
	public CommandWall(Board board, String[] params) {
		this.board = board;
		this.params = params;
	}
	
	public String getText() {
		return "WALL "+params[0]+" "+params[1];
	}

	@Override
	public void execute() throws GameError {		
		if(params.length != 2)
			throw new GameError("WALL needs a row and column as parameters");
		
		int row = Integer.parseInt(params[0]);
		int col = Integer.parseInt(params[1]);
		FarmBoard farm = board.activeFarm();
		LotFence lot = (LotFence)farm.terrain.get(row, col);
		Fence fence = farm.find(Fence.class);
		
		TaskWall task = (TaskWall)board.tasks.get("WALL");
		Stone stone1;
		Stone stone2;
		
		if(task.timesUsed < 2) {
			stone1 = new Stone(board);
			stone2 = new Stone(board);
		}
		else { 
			stone1 = farm.find(Stone.class);
			farm.resources.remove(stone1);
			stone2 = farm.find(Stone.class);
			farm.resources.add(stone1);
		}
 
		if(lot == null) {
			throw new GameError("Lot "+row+", "+col+" does not exist.");
		}
		else if((lot instanceof LotFence) == false) {
			throw new GameError("Lot "+row+", "+col+" is not fencable."); 
		}
		else if(lot.fence != null) {
			throw new GameError("Lot "+row+", "+col+" is already fenced.");
		}
		else if(fence == null) {
			throw new GameError("No unbuilt fences available.");
		}
		else if(stone1 == null || stone2 == null) {
			throw new GameError("Need 2 stone to build wall.");
		}
		else {
			task.timesUsed++;
			lot.fence = fence;
			farm.resources.remove(stone1);
			farm.resources.remove(stone2);
			farm.resources.remove(fence);
		}
	
	}

}
