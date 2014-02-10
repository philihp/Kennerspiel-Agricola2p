package game.agricola2p;

public class LotVerticalFence extends LotFence {

	public LotVerticalFence(Board board) {
		super(board);
	}

	@Override
	public String getType() {
		return "LOT_V";
	}

}
