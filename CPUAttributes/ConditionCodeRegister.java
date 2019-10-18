package CPUAttributes;
/**
 * @author Dishit, Peiyu, Zhaoning, Charitha
 *
 */
public class ConditionCodeRegister extends Register{
	/*This class is for ConditionCodeRegister Only
	 * ConditionCodeRegister has two properties, ccSize and ccValue;
	 * ConditionCodeRegister class has 2 constructors and 4 functions
	 * including setccSize, getccSize, getccValue and setccValue
	 * */
	private int ccSize = 4;
	private int ccValue;
	public ConditionCodeRegister() {
		/*Constructor, inherit parent properties and functions*/
		this.ccSize=4;
		this.ccSize=0;
	}
	public ConditionCodeRegister(int size, int value) {
		/*Constructor, inherit parent properties and functions and then set ccSize and ccValue*/
		super();
		this.ccSize = size;
		this.ccValue = value;
	}
	public int getccSize() {
		//This function is to getCCsize
		return ccSize;
	}
	public void setccSize(int ccSize) {
		//This function is to set ccSize
		this.ccSize = ccSize;
	}
	public int getccValue() {
		//This function is to get ccValue;
		return ccValue;
	}
	public static void setccValue(int value) {
		//This function is to set ccValue;
		this.ccValue =ccValue;
	}
	
	
}
