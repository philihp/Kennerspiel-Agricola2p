import static org.junit.Assert.*;
import game.agricola2p.*;

import org.junit.*;


public class BoardTest {
	
	public static Board board;
	
	@BeforeClass
	public static void setUpClass() {
		board = new Board();
	}

	@Test
	public void test() {
		assertEquals(board.move, 0);
	}

}
