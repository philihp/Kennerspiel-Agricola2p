package game.agricola2p;

public class Trough extends Element {

	public Trough(Board board) {
		super(board);
	}
	
	@Override
	public String getType() {
		return "TROUGH";
	}

}
