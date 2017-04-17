package beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class GameType implements Serializable {
	
	private String game;
	private String type;
	
	public GameType() {
		
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
