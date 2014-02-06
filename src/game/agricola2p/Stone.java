package game.agricola2p;

public class Stone extends Element {

	public Stone(Board board) {
		super(board);
	}

	@Override
	public String getType() {
		return "STONE";
	}


}
