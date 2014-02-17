package game.agricola2p;

import game.Command;
import game.GameError;

import java.util.ArrayList;
import java.util.List;

public class CommandTrough implements Command {
	
	private String[] params;
	
	private Board board;
	
	public CommandTrough(Board board, String[] params) {
		this.board = board;
		this.params = params;
	}

	@Override
	public void execute() throws GameError {		
		if(params.length != 2)
			throw new GameError("TROUGH needs a row and column as parameters");
		
		int row = Integer.parseInt(params[0]);
		int col = Integer.parseInt(params[1]);
		FarmBoard farm = board.activeFarm();
		LotPasture lot = (LotPasture)farm.terrain.get(row, col);
		Trough trough = board.gameBoard.find(Trough.class);
		
		TaskTrough task = (TaskTrough)board.tasks.get("TROUGH");
		List<Element> cost = new ArrayList<Element>(3);
		
		if(task.timesUsed < 1) {
			cost.add(new Wood(board));
			cost.add(new Wood(board));
			cost.add(new Wood(board));
		}
		else {
			for(int i = 0; i < 3; i++) {
				Wood wood = farm.find(Wood.class);
				farm.resources.remove(wood);
				cost.add(wood);
			}
			//add it back because we haven't actually spent it yet
			farm.resources.addAll(cost);
		}
 
		if(lot == null) {
			throw new GameError("Lot "+row+", "+col+" does not exist.");
		}
		else if((lot instanceof LotPasture) == false) {
			throw new GameError("Lot "+row+", "+col+" is not a pasture, so it can't contain a trough."); 
		}
		else if(lot.trough != null) {
			throw new GameError("Lot "+row+", "+col+" already has a trough.");
		}
		else if(trough == null) {
			throw new GameError("No unbuilt trough available.");
		}
		else if(cost.size() < 3) {
			throw new GameError("Need 3 wood to build a trough.");
		}
		else {
			task.timesUsed++;
			lot.trough = trough;
			farm.resources.removeAll(cost);
			board.gameBoard.resources.remove(trough);
		}
	
	}

}
