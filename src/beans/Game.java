package beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Game implements Serializable {
	
	@Id
	@Column(name="pk_title")
	private String title;
	
	private Double price;
	
	@Column(name="fk_console")
	private String console;
	
	public Game() {
		
	}
	
	public Game(String title, String console, Double price) {
		this.title = title;
		this.console = console;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}

}

