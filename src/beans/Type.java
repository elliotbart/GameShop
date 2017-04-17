package beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Type implements Serializable {
	
	private String type;
	
	public Type() {
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
