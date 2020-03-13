package datatypes;




/* A project has one of the following states*/
public enum StatusData {
 
OPEN("Open"),SUCCESSFUL("Successful"),FAILED("Failed");
	private String label ;
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	private StatusData (String label)
	{  this.setLabel(label);
	}

	
	
}
