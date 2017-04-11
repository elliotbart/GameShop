package beansClean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ConsoleGame implements Serializable {
	
	private String console;
	private String game;
	
	public ConsoleGame() {
		
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

}

