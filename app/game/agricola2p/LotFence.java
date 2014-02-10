package game.agricola2p;

abstract class LotFence extends Lot {
	
	protected Fence fence = null;

	public LotFence(Board board) {
		super(board);
	}
	
	public Fence getFence() {
		return fence;
	}

}
