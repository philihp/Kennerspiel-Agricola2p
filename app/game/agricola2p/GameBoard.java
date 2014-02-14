package game.agricola2p;

import static game.agricola2p.PlayerColor.RED;

import java.util.*;

public class GameBoard extends Container {

	protected Map<String, Action> actions;
	private StartingPlayerToken startingPlayerToken;
	
	private void addAction(Action action) {
		actions.put(action.id, action);
	}

	public GameBoard(Board board) {
		super(board, 18);

		resources.add(new Expansion(board));
		resources.add(new Expansion(board));
		resources.add(new Expansion(board));
		resources.add(new Expansion(board));
		resources.add(new Stall(board));
		resources.add(new Stall(board));
		resources.add(new Stall(board));
		resources.add(new Stall(board));
		resources.add(new StorageBuilding(board));
		resources.add(new OpenStables(board));
		resources.add(new HalfTimberedHouse(board));
		resources.add(new Shelter(board));
		
		resources.add(new Trough(board));
		resources.add(new Trough(board));
		resources.add(new Trough(board));
		resources.add(new Trough(board));
		resources.add(new Trough(board));
		resources.add(new Trough(board));
		resources.add(new Trough(board));
		resources.add(new Trough(board));
		resources.add(new Trough(board));
		resources.add(new Trough(board));
		
		this.actions = new HashMap<String, Action>();
		this.startingPlayerToken = new StartingPlayerToken(board);
		addAction(new ActionStartPlayerAnd1Wood(board, this.startingPlayerToken));
		addAction(new Action3Wood(board));
		addAction(new Action1Stone(board));
		addAction(new Action2Stone(board));
		addAction(new ActionFences(board));
		addAction(new ActionWalls(board));
		addAction(new ActionBuildingMaterials(board));
		addAction(new ActionExpand(board));
		addAction(new ActionStall(board));
		addAction(new ActionTrough(board));
		addAction(new ActionMillpond(board));
		addAction(new ActionPigsAndSheep(board));
		addAction(new ActionStable(board));
		actions.put("BUILD1",new ActionSpecialBuilding(board));
		actions.put("BUILD2",new ActionSpecialBuilding(board));
		addAction(new ActionCowsAndPigs(board));
		addAction(new ActionHorsesAndSheep(board));
		
		addActionTask();
	}
	
	protected void addActionTask() {
		board.tasks.put("ACTION", new TaskAction(board));
	}

	@Override
	protected void onRoundStart() {
		board.currentPlayer = this.startingPlayerToken.owner;
		super.onRoundStart();
		for(Action e : actions.values()) {
			e.onRoundStart();
		}
	}
	
	@Override
	protected void onRoundEnd() {
		super.onRoundEnd();
		for(Action e : actions.values()) {
			e.onRoundEnd();
		}
	}
	
	public Map<String, Action> getActions() {
		return actions;
	}

	@Override
	public String getType() {
		return "BOARD";
	}

}
