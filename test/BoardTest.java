import static org.junit.Assert.*;
import game.GameError;
import game.agricola2p.*;

import org.junit.*;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class BoardTest {

	public static Board board;

	@BeforeClass
	public static void setUpClass() {
		board = new Board();
	}

	@Test
	public void test() throws GameError {
		board.runCommand(board.getCommand("ACTION RSW"));
		board.runCommand(board.getCommand("COMMIT"));
		board.runCommand(board.getCommand("ACTION WALL"));
		board.runCommand(board.getCommand("WALL 0 11"));
		board.runCommand(board.getCommand("WALL 1 10"));
		board.runCommand(board.getCommand("COMMIT"));
		board.runCommand(board.getCommand("ACTION 2S"));
		board.runCommand(board.getCommand("COMMIT"));
		board.runCommand(board.getCommand("ACTION EXPAND"));
		board.runCommand(board.getCommand("EXPAND LEFT"));
		board.runCommand(board.getCommand("COMMIT"));
		board.runCommand(board.getCommand("ACTION STALL"));
		board.runCommand(board.getCommand("STALL 1 11"));
		board.runCommand(board.getCommand("COMMIT"));
		board.runCommand(board.getCommand("ACTION 3W"));
		board.runCommand(board.getCommand("COMMIT"));
		
		
		
		
		//board.runCommand(board.getCommand("ACTION RSW"));
		//board.runCommand(board.getCommand("COMMIT"));

		System.out.println(board);
	}

}
