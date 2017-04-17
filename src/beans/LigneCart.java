package beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LigneCart implements Serializable {
	
	private int cart;
	private String game;
	private int quantity;
	
	public LigneCart() {
		
	}

	public int getCart() {
		return cart;
	}

	public void setCart(int cart) {
		this.cart = cart;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

