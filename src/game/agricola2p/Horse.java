package game.agricola2p;

public class Horse extends Element {

	public Horse(Board board) {
		super(board);
	}
	
	@Override
	public String getType() {
		return "HORSE";
	}

}
