package beansClean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Game implements Serializable {
	
	private String title;
	private int price;
	
	public Game() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}

