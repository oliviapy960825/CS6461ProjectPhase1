package WorkFlow;

//This class is for machine exception detecting and handling
public class MachineException extends Exception{

	int errorID;
	String errorMessage;
	public MachineException(int errorID, String errorMessage){//constructor for MachineException Class
		this.errorID=errorID;
		this.errorMessage=errorMessage;
	}
	public int getErrorID(){//getter function for attribute errorID 
		return errorID;
	}
	public String getErrorMessage(){//getter function for attribute errorMessage
		return errorMessage;
	}
	public void setErrorID(int ID){//setter function for attribute errorID
		this.errorID=ID;
	}
	public void setErrorMessage(String errorMessage){//setter function for attribute errorMessage
		this.errorMessage=errorMessage;
	}
}
