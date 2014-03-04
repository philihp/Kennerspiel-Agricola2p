package game.agricola2p;

import game.Command;

public class CommandComment implements Command {
	
	private String command;
	
	public CommandComment(String command) {
		
		if(command.charAt(0) == '#') {
			this.command = command.substring(1);
		}
		else {
			this.command = command;
		}
	}
	
	public String getText() {
		return "#"+command;
	}

	@Override
	public void execute() {
		System.out.println("# "+command);
	}

}
