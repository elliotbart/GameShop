package beansClean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Cart implements Serializable {
	
	private int id;
	
	public Cart() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
