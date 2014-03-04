package game.agricola2p;

import game.Command;
import game.GameError;

import org.apache.commons.lang3.StringUtils;

public class CommandExpand implements Command {

	private String[] params;

	private Board board;

	public CommandExpand(Board board, String[] params) {
		this.board = board;
		this.params = params;
	}
	
	public String getText() {
		return "EXPAND "+params[0];
	}

	@Override
	public void execute() throws GameError {
		((TaskExpand)board.tasks.get("EXPAND")).usable = false;
		
		Expansion expansion = board.gameBoard.find(Expansion.class);
		if(expansion == null)
			//there are no more expansions
			return;
		
		String direction = null;
		if (params.length == 1) {
			direction = params[0];
		}
		switch (direction) {
		case "LEFT":
			board.activeFarm().colRangeMin -= 2;
			break;
		case "RIGHT":
			board.activeFarm().colRangeMin += 2;
			break;
		default:
			throw new GameError("EXPAND requires either LEFT or RIGHT if there are expansions left to place");
		}
		board.activeFarm().resizeTerrainTable();
		board.activeFarm().resources.add(expansion);
	}

}
