package game.agricola2p;

import game.Command;
import game.GameError;

import org.apache.commons.lang3.StringUtils;

public class CommandStall implements Command {
	
	private String[] params;
	
	private Board board;
	
	public CommandStall(Board board, String[] params) {
		this.board = board;
		this.params = params;
	}

	@Override
	public void execute() throws GameError {		
		if(params.length != 2)
			throw new GameError("STALL needs a row and column as parameters");
		
		int row = Integer.parseInt(params[0]);
		int col = Integer.parseInt(params[1]);
		FarmBoard farm = board.activeFarm();
		Lot lot = farm.terrain.get(row, col);
		Stall stall = board.gameBoard.find(Stall.class);
		TaskStall task = (TaskStall)board.tasks.get("STALL");
		Stone stone1;
		Stone stone2;
		Stone stone3;
		Reed reed;
		
		stone1 = farm.find(Stone.class);
		farm.resources.remove(stone1);
		stone2 = farm.find(Stone.class);
		farm.resources.remove(stone2);
		stone3 = farm.find(Stone.class);
		reed = farm.find(Reed.class);
		farm.resources.add(stone1);
		farm.resources.add(stone2);
 
		if(!(task != null && task.usable)) {
			throw new GameError("Unable to use task");
		}
		else if(lot == null) {
			throw new GameError("Lot "+row+", "+col+" does not exist.");
		}
		else if((lot instanceof LotPasture) == false) {
			throw new GameError("Lot "+row+", "+col+" can not contain a building because it isn't a pasture.");
		}
		else if(((LotPasture)lot).building != null) {
			throw new GameError("Lot "+row+", "+col+" already has a building.");
		}
		else if(stall == null) {
			throw new GameError("No unbuilt stalls available.");
		}
		else if(stone1 == null || stone2 == null || stone3 == null || reed == null) {
			throw new GameError("Need 3 stone and 1 reed to build stall.");
		}
		else {
			((LotPasture)lot).building = stall;
			farm.resources.remove(stone1);
			farm.resources.remove(stone2);
			farm.resources.remove(stone3);
			farm.resources.remove(reed);
			board.gameBoard.resources.remove(stall);
		}
	
	}

}
