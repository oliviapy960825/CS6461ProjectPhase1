package CPUAttributes;
/**
 * @author dk
 *
 */
public class GeneralPurposeRegister {

	//size of register is 16 bits
		private int size = 16;
		private int value;
		//get the size of register
		public int getSize() {
			return size;
		}
		//get the value of register
		public int getValue() {
			return value;
		}
		//set the value of register
		public void setValue(int value) {
			this.value = value;
		}
		//Constructor 
		public GeneralPurposeRegister() {
			super();
			this.value = 0;
			// TODO Auto-generated constructor stub
		}
}
