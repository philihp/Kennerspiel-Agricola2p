package game.agricola2p;

import game.Command;
import game.GameError;

import org.apache.commons.lang3.StringUtils;

public class CommandAction implements Command {
	
	private String[] params;
	
	private Board board;
	
	public CommandAction(Board board, String[] params) {
		this.board = board;
		this.params = params;
	}

	@Override
	public void execute() throws GameError {
		if(params.length != 1)
			throw new GameError("ACTION needs exactly 1 parameter");
		
		Action a = board.gameBoard.actions.get(params[0]);
		if(a == null)
			throw new GameError("Unable to find action \""+params[0]+"\"");
		else {
			a.onTake();
		}
	
		((TaskAction)board.tasks.get("ACTION")).usable = false;
	}

}
