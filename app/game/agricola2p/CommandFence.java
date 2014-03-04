package game.agricola2p;

import game.Command;
import game.GameError;

import org.apache.commons.lang3.StringUtils;

public class CommandFence implements Command {
	
	private String[] params;
	
	private Board board;
	
	public CommandFence(Board board, String[] params) {
		this.board = board;
		this.params = params;
	}	
	
	public String getText() {
		return "FENCE "+params[0]+" "+params[1];
	}

	@Override
	public void execute() throws GameError {		
		if(params.length != 2)
			throw new GameError("FENCE needs a row and column as parameters");
		
		int row = Integer.parseInt(params[0]);
		int col = Integer.parseInt(params[1]);
		FarmBoard farm = board.activeFarm();
		LotFence lot = (LotFence)farm.terrain.get(row, col);
		Fence fence = farm.find(Fence.class);
		Wood wood = farm.find(Wood.class);
 
		
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
		else if(wood == null) {
			throw new GameError("No wood available to build fence.");
		}
		else {
			lot.fence = fence;
			farm.resources.remove(wood);
			farm.resources.remove(fence);
		}
	
	}

}
