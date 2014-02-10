package game.agricola2p;

public class LotIntersection extends Lot {

	public LotIntersection(Board board) {
		super(board);
	}


	@Override
	public String getType() {
		return "LOT_I";
	}
}
