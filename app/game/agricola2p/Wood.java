package game.agricola2p;

public class Wood extends Element {

	public Wood(Board board) {
		super(board);
	}
	
	@Override
	public String getType() {
		return "WOOD";
	}

}
