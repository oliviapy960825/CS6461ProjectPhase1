package CPU;

public class Register {//This Class is for Register
	int address;
	String value;
	public Register(int address, String value){
		this.address=address;
		this.value=value;
	}
	//Register class should have functions getValue(), getMAR(), getMBR(), setMAR(), setMBR() 
	public String getValue(){
		return value;
	}
	public void setValue(String newValue){
		this.value=newValue;
	}
	public int getAddress(){
		return this.address;
	}
	public void setAddress(int newAddress){
		this.address=newAddress;
	}
}
