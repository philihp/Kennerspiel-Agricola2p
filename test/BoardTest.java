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
		assertEquals(board.getMove(), 0);
		board.runCommand(board.getCommand("ACTION 2S"));
		assertEquals(board.getMove(), 1);
		board.runCommand(board.getCommand("ACTION SP1W"));
		assertEquals(board.getMove(), 2);
		board.runCommand(board.getCommand("ACTION 3W"));
		assertEquals(board.getMove(), 3);

	}

}
