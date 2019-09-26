package WorkFlow;

public class Decode {//This class is for instruction decoding process only
  int r;
	int ix;
	int i;
	int address;
	
	void Fetch(int address) {
		opcode= Instruction.substring(0,5)
		r= Instruction.substring(6,8);
		ix= Instruction.substring(9,11);
		i= Instruction.substring(8,9);
		address= Instruction.substring(11,15);
		public int getOpcode {
			if (opcode == 00000 )
				return HLT;
			if ( opcode == 00001 )
				return LDR;
			if ( opcode == 00002 )
				return STR;
			if ( opcode == 00003 )
				return LDA;
			if ( opcode == 00041 )
				return LDX;
			if ( opcode == 00042 )
				return STX;
		}
		public int getRegister(r) {
	        if (r == 00)
	            return r0;
	        if (r == 01)
	            return r1;
	        if (r == 10)
	            return r2;
	        if (r == 11)
	            return r3;
	        return 0;
	    }
		public int getIndexRegister(ix) {
	        if (ix == 00)
	            return 0;
	        if (ix == 1)
	            return ix1;
	        if (ix == 2)
	            return ix2;
	        if (ix == 3)
	            return ix3;
	        return 0;
	    }

}
