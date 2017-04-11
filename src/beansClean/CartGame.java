package beansClean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CartGame implements Serializable {
	
	private int cart;
	private String game;
	
	public CartGame() {
		
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

}

