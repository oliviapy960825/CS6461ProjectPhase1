package CPUAttributes;
/**
 * @author Dishit, Peiyu, Zhaoning, Charitha
 *
 */
public class GeneralPurposeRegister {
/*This class is for GeneralPurposeRegister
 * GeneralPurposeRegister class has two properties, size and value
 * GeneralPurposeRegister class has 1 constructor and 3 functions including getSize(),
 * getValue() and setValue()*/
	//size of register is 16 bits
		private int size = 16;
		private int value;
		public GeneralPurposeRegister() {
			//constructor for GeneralPurposeRegister class
			super();
			this.value = 0;
			// TODO Auto-generated constructor stub
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
