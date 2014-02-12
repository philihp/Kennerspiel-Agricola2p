package game.agricola2p;

import static game.agricola2p.PlayerColor.RED;

import java.util.*;

public class GameBoard extends Element {

	protected Map<String, Action> actions;
	private StartingPlayerToken startingPlayerToken;
	
	public List<Element> resources = new ArrayList<Element>(4);
	
	private static void addAction(Map<String, Action> map, Action action) {
		map.put(action.id, action);
	}

	public GameBoard(Board board) {
		super(board);

		resources.add(new Expansion(board));
		resources.add(new Expansion(board));
		resources.add(new Expansion(board));
		resources.add(new Expansion(board));
		resources.add(new Stall(board));
		resources.add(new Stall(board));
		resources.add(new Stall(board));
		resources.add(new Stall(board));
		
		this.actions = new HashMap<String, Action>();
		this.startingPlayerToken = new StartingPlayerToken(board);
		addAction(actions, new ActionStartPlayerAnd1Wood(board, this.startingPlayerToken));
		addAction(actions, new Action3Wood(board));
		addAction(actions, new Action1Stone(board));
		addAction(actions, new Action2Stone(board));
		addAction(actions, new ActionFences(board));
		addAction(actions, new ActionWalls(board));
		addAction(actions, new ActionBuildingMaterials(board));
		addAction(actions, new ActionExpand(board));
		addAction(actions, new ActionStall(board));
		//
		addAction(actions, new ActionMillpond(board));
		addAction(actions, new ActionPigsAndSheep(board));
		//
		//
		addAction(actions, new ActionCowsAndPigs(board));
		addAction(actions, new ActionHorsesAndSheep(board));
		
		addActionTask();
	}
	
	protected Expansion findExpansion() {
		for(Element e : resources) {
			if(e instanceof Expansion)
				return (Expansion)e;
		}
		return null;
	}
	
	protected Stall findStall() {
		for(Element e : resources) {
			if(e instanceof Stall)
				return (Stall)e;
		}
		return null;
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
