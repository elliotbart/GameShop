package beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Cart implements Serializable {
	
	@Id
	@GeneratedValue
    @Column(name="pk_id")
	private int id;
	
	private List<Game> games;
	
	public Cart() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public List<Game> getGames(){
		return games;
	}
	public void addGame(Game game){
		games.add(game);
	}
	public void removeGame(Game game){
		games.remove(game);
	}
	 
}
