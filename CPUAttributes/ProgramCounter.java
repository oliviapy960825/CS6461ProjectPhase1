package CPUAttributes;
/**
 * @author Dishit, Peiyu, Zhaoning, Charitha
 *
 */
public class ProgramCounter extends Register{
	//This class is for Program Counter, it has two properties, pcSize and pcValue.
	//It has 1 constructor and 4 functions including getSize, setSize, getValue and setValue
	private int pcSize = 12;
	private int pcValue;
	public ProgramCounter() {
		//constructor 
		this.pcSize=12;
		this.pcValue=0;
	}
	public int getSize() {
		//get the size of PC 
		return pcSize;
	}
	public void setSize(int size) {
		//set the size of PC
		this.pcSize = size;
	}
	public int getValue() {
		//get the value of PC
		return pcValue;
	}
	public void setValue(int value) {
		//set the value of PC
		this.pcValue = value;
	}
	

}
