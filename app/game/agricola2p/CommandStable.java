package game.agricola2p;

import java.util.ArrayList;
import java.util.List;

import game.Command;
import game.GameError;

import org.apache.commons.lang3.StringUtils;

public class CommandStable implements Command {
	
	private String[] params;
	
	private Board board;
	
	public CommandStable(Board board, String[] params) {
		this.board = board;
		this.params = params;
	}

	@Override
	public void execute() throws GameError {		
		if(params.length != 2)
			throw new GameError("STALL needs a row and column as 2 parameters, as well as STONE or WOOD for the 3rd parameter.");
		
		int row = Integer.parseInt(params[0]);
		int col = Integer.parseInt(params[1]);
		FarmBoard farm = board.activeFarm();
		Lot lot = farm.terrain.get(row, col);
		LotPasture lotPasture = null;
		TaskStable task = (TaskStable)board.tasks.get("STABLE");
		Stall stall = null;
		
		List<Element> cost = new ArrayList<Element>(5);
		for(int i = 0; i < 5; i++) {
			Element resource = null;
			switch(params[2]) {
			case "WOOD" :
				resource = board.activeFarm().find(Wood.class);
				break;
			case "STONE":
				resource = board.activeFarm().find(Stone.class);
				break;
			}
			cost.add(resource);
			board.activeFarm().resources.remove(resource);
		}
		board.activeFarm().resources.addAll(cost);
 
		if(task == null) {
			throw new GameError("Unable to use task");
		}
		
		if(lot == null) {
			throw new GameError("Lot "+row+", "+col+" does not exist.");
		}
		
		if((lot instanceof LotPasture) == false) {
			throw new GameError("Lot "+row+", "+col+" can not contain a building because it isn't a pasture.");
		}
		else {
			lotPasture = (LotPasture)lot;
		}
		
		if(lotPasture.building == null) {
			throw new GameError("Lot "+row+", "+col+" doesn't have a stall on it.");
		}
		else if(lotPasture.building instanceof Stall == false) {
			throw new GameError("Lot "+row+", "+col+" must have a stall on it, but it has a "+lotPasture.building.getType());
		}
		else {
			stall = (Stall)lotPasture.building;
		}
		
		if(cost.size() < 5) {
			throw new GameError("Need 5 "+params[2]+" to convert STALL into STABLE.");
		}
		
		stall.isStable = true;
		farm.resources.removeAll(cost);
	}

}
