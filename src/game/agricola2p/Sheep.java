package game.agricola2p;

public class Sheep extends Element {

	public Sheep(Board board) {
		super(board);
	}
	
	@Override
	public String getType() {
		return "SHEEP";
	}

}
