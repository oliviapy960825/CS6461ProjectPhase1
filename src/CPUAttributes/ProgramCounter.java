package CPUAttributes;
/**
 * @author dk
 *
 */
public class ProgramCounter {

	private int pcSize = 12;
	private int pcValue;
	public int getSize() {
		return pcSize;
	}
	public void setSize(int size) {
		this.pcSize = size;
	}
	public int getValue() {
		return pcValue;
	}
	public void setValue(int value) {
		this.pcValue = value;
	}
	public ProgramCounter() {
		super();
	}

}
