package game.agricola2p;

public class Stall extends Building {
	
	protected boolean isStable;

	public Stall(Board board) {
		super(board);
		isStable = false;
	}

	@Override
	public int getValue() {
		return isStable?4:1;
	}

	@Override
	public String getType() {
		return isStable?"STABLE":"STALL";
	}
	
	@Override
	public boolean canBuild() {
		int reed = 1;
		int stone = 3;
		
		for(Element e : board.activeFarm().resources) {
			if(e instanceof Stone) stone--;
			else if(e instanceof Reed) reed--;
		}
		
		return (reed <= 0 && stone <= 0);
	}

	@Override
	public int contains() {
		return 3;
	}

}
