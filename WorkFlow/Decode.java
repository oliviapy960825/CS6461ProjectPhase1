package WorkFlow;
import CPU.Registers;

public class Decode {//This class is for instruction decoding process only
  String opcode;
  String r;
	String ix;
	String i;
	String address;
	Registers registers;
	public Decode(String opcode, String r, String ix, String i, String address, Registers registers){
		this.opcode=opcode;
		this.r=r;
		this.ix=ix;
		this.i=i;
		this.address=address;
		this.registers=registers;
	}
	void Fetch(int address) {
		String instruction= Integer.toString(address);
		this.opcode= instruction.substring(0,5);
		this.r= instruction.substring(6,8);
		this.ix= instruction.substring(9,11);
		this.i= instruction.substring(8,9);
		this.address= instruction.substring(11,15);

	}
		public String getInstruction(String opcode){
			if (opcode == "00000" ){
				return "HLT";
			}
			if ( opcode == "00001" ){
				return "LDR";
			}
			if ( opcode == "00002" ){
				return "STR";
			}
			if ( opcode == "00003" ){
				return "LDA";
			}
			if ( opcode == "00041" ){
				return "LDX";
			}
			if ( opcode == "00042" ){
				return "STX";
			}
			return "No Corresponding Instruction yet";
		}
		public int getRegister(String r) {
	        if (r == "00"){
	            return registers.getR0();
	            }
	        if (r == "01"){
	            return registers.getR1();
	        }
	        if (r == "10"){
	            return registers.getR2();
	        }
	        if (r == "11"){
	            return registers.getR3();
	        }
	        return 0;
	    }
		public int getIndexRegister(String ix) {
	        if (ix == "01"){
	            return registers.getX1();
	        }
	        if (ix == "10"){
	            return registers.getX2();
	        }
	        if (ix == "11"){
	            return registers.getX3();
	        }
	        return 0;
	    }

}
