package game.agricola2p;

public class LotHorizontalFence extends LotFence {

	public LotHorizontalFence(Board board) {
		super(board);
	}


	@Override
	public String getType() {
		return "LOT_H";
	}
}
