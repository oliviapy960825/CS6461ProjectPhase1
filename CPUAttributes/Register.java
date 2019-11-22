package CPUAttributes;

public class Register {
	private int size = 16;
	private int value;
	private static CU cu;
	public Register() {
		//constructor for GeneralPurposeRegister class
		this.value = 0;
		
		// TODO Auto-generated constructor stub
	}
	public void setCU(CU cu){
		this.cu=cu;
	}
	
	public int getSize() {
		//get the size of the general purpose register
		return size;
	}
	public int getValue() {
		//get the value of the general purpose register
		return value;
	}

	public void setValue(int value) {
		//set the value of the general purpose register
		this.value = value;
	}


}
