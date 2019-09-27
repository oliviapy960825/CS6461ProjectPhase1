package CPUAttributes;
/**
 * @author dk
 *
 */
public class ConditionCodeRegister {

	private int ccSize = 4;
	private int ccValue;
	public int getccSize() {
		return ccSize;
	}
	public void setccSize(int ccSize) {
		this.ccSize = ccSize;
	}
	public int getccValue() {
		return ccValue;
	}
	public void setccValue(int ccValue) {
		this.ccValue = ccValue;
	}
	public ConditionCodeRegister(int size, int value) {
		super();
		this.ccSize = size;
		this.ccValue = value;
	}
	public ConditionCodeRegister() {
		super();
	}
}
