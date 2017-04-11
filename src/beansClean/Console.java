package beansClean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Console implements Serializable {
	
	private String name;
	
	public Console() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
;
