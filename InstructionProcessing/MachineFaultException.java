package InstructionProcessing;

import CPUAttributes.MachineFaultRegister;

public enum MachineFaultException{
	IllegalMemoryToReservedLocation(0,"Illegal Memory Address to Reserved Location",Integer.valueOf("0001")),
	IllegalTrapCode(1, "Illegal Trap Code", Integer.valueOf("0010")),
	IllegalOperationCode(2,"Illegal Operation Code", Integer.valueOf("0100")),
	IllegalMemoryAddressBeyondMemorySize(3, "Illegal Memory Address Beyond Memory Size", Integer.valueOf("1000")),
	OverFlow(4, "OverFlow", Integer.valueOf("0011"));
	int faultCode;
	String message;
	MachineFaultRegister MFR;
	
	/**
	 * @param faultCode
	 * @param message
	 */

	private MachineFaultException(int ID, String message, int MFRValue){
		this.faultCode = ID;
		this.message = message;
		this.setMFR(MFRValue);
		
	}
	
	private MachineFaultException(int faultCode){
		this.faultCode = faultCode;
	}
	private MachineFaultException(String message){
		this.message = message;
	}
	
	public int getFaultCode(){
		return this.faultCode;
	}
	public String getMFR(){
		return String.valueOf(MFR.getValue());
	}
	public void setMFR(int MFRValue){
		MFR.setValue(MFRValue);
	}
	public String getMessage(){
		return this.message;
	}
	
}
