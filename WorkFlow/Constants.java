package WorkFlow;

public class Constants {//This class is to store constants for other classes' use
public enum MemoryErrorCode{
	ILL_MEM_RSV(0, "Illegal Memory Address to Reserved Locations"),
	ILL_OPRC(2,"Illegal Operation Code"), 
	ILL_MEM_BYD(3, "Illegal Memory Address beyond 2048 (memory installed)");
	int errorID;
	String errorMessage;
	private MemoryErrorCode(int errorID, String errorMessage) {
		this.errorID = errorID;
		this.errorMessage = errorMessage;
	}

	public int getErrorID() {
		return this.errorID;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}
}
}
