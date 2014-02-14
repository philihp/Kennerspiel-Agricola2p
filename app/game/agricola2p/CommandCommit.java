package game.agricola2p;

import game.Command;
import game.GameError;
import static game.agricola2p.PlayerColor.*;

import org.apache.commons.lang3.StringUtils;

public class CommandCommit implements Command {

	private Board board;

	public CommandCommit(Board board) {
		this.board = board;
	}

	/**
	 * Swaps the color.
	 * 
	 * I guess this should actually just go to the next player with a worker
	 * unplaced, but that would only happen in an expansion.
	 * 
	 * @param board
	 */
	private void pickNextPlayer(Board board) {
		switch (board.currentPlayer) {
		case BLUE:
			board.currentPlayer = PlayerColor.RED;
			break;
		case RED:
			board.currentPlayer = PlayerColor.BLUE;
			break;
		default:
			throw new RuntimeException(
					"Unable to pick next player because current player is \""
							+ board.currentPlayer + "\"");
		}
	}

	@Override
	public void execute() throws GameError {

		pickNextPlayer(board);

		if (board.activeFarm().hasWorker() == false) {
			board.gameBoard.onRoundEnd();
			board.farmBoards.get(RED).onRoundEnd();
			board.farmBoards.get(BLUE).onRoundEnd();
			board.round++;
			board.gameBoard.onRoundStart();
			board.farmBoards.get(RED).onRoundStart();
			board.farmBoards.get(BLUE).onRoundStart();
		}
		board.move++;

		board.resetTasks();
	}

}
