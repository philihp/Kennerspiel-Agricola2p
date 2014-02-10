package game.agricola2p;

public class Fence extends Element {

	public Fence(Board board) {
		super(board);
	}
	
	@Override
	public String getType() {
		return "FENCE";
	}

}
