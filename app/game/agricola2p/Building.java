package game.agricola2p;

import game.GameError;

import java.util.ArrayList;
import java.util.List;

abstract class Building extends Element {
	
	/**
	 * The owner of this building. Really only useful for the Storage Building.
	 */
	protected FarmBoard owner;
	
	public Building(Board board) {
		super(board);
	}
	
	public abstract int getValue();
	
	/**
	 * Returns the number of animals that can be contained in this building.
	 * 
	 * @return
	 */
	public abstract int contains();
	
	/**
	 * Returns true if the building can be built on this pasture.
	 * 
	 * @param pasture
	 * @return
	 */
	public abstract boolean canBuildAt(LotPasture pasture);

	/**
	 * Returns true if the active player has the materials necessary
	 * to build this.
	 * 
	 * @param farm
	 * @return
	 */
	public abstract boolean canBuild();
	
	protected void build(FarmBoard owner, String[] params) throws GameError {
		this.owner = owner;
	}

	protected boolean canBuildWith(int wood, int stone, int reed) {
		for(Element e : board.activeFarm().resources) {
			if(e instanceof Wood) wood--;
			else if(e instanceof Stone) stone--;
			else if(e instanceof Reed) reed--;
		}
		return (reed <= 0 && stone <= 0 && wood <= 0);
	}

	protected void eatResources(int wood, int stone, int reed) throws GameError {
		List<Element> toEat = new ArrayList<Element>(wood+stone+reed);
		
		for(Element e : board.activeFarm().resources) {
			if(wood >= 0 && e instanceof Wood) {
				wood--;
				toEat.add(e);
			}
			else if(stone >= 0 && e instanceof Stone) {
				stone--;
				toEat.add(e);
			}
			else if(reed >= 0 && e instanceof Reed) {
				reed--;
				toEat.add(e);
			}
		}
		
		if(wood > 0 || stone > 0 || reed > 0) {
			throw new GameError("Not enough resources, missing: wood="+wood+" stone="+stone+" reed="+reed);
		}
		board.activeFarm().resources.removeAll(toEat);
	}

}
