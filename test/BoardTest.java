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
		board.runCommand(board.getCommand("ACTION SP1W"));
		board.runCommand(board.getCommand("COMMIT"));
		board.runCommand(board.getCommand("ACTION 3W"));
		board.runCommand(board.getCommand("COMMIT"));
		board.runCommand(board.getCommand("ACTION 1S"));
		board.runCommand(board.getCommand("COMMIT"));
		board.runCommand(board.getCommand("ACTION COWS"));
		board.runCommand(board.getCommand("COMMIT"));
		board.runCommand(board.getCommand("ACTION 2S"));
		board.runCommand(board.getCommand("COMMIT"));
		
		
		board.runCommand(board.getCommand("ACTION RSW"));
		board.runCommand(board.getCommand("COMMIT"));

		System.out.println(board);
	}

}
