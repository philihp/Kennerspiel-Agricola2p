import static org.junit.Assert.*;
import game.GameError;
import game.agricola2p.*;

import org.junit.*;


public class BoardTest {
	
	public static Board board;
	
	@BeforeClass
	public static void setUpClass() {
		board = new Board();
	}

	@Test
	public void test() throws GameError {
		board.getCommand("#Comamnd Comment");
		board.getCommand("ACTION");
		board.getCommand("ACTION ACT1");
		board.getCommand("ACTION A B C");
		assertEquals(board.move, 0);
	}

}
