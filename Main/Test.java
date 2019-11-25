package Main;

import CPUAttributes.ALU;
import CPUAttributes.CU;
import CPUAttributes.Cache1;
import CPUAttributes.ConditionCodeRegister;
import CPUAttributes.FloatingPointRegister;
import CPUAttributes.GeneralPurposeRegister;
import CPUAttributes.IndexRegister;
import CPUAttributes.InstructionRegister;
import CPUAttributes.MachineFaultRegister;
import CPUAttributes.MemoryAccessRegister;
import CPUAttributes.MemoryBufferRegister;
import CPUAttributes.ProgramCounter;
import FrontPanel.UserInterface;
import InstructionProcessing.Decoding;
import InstructionProcessing.Encoding;
import Memory.Memory;
public class Test {		
	public static void main(String[] args) {
		//you should write a simple program that demonstrates floating point add/subtract, vector add/subtract, and floating point conversion.
		// TODO Auto-generated method stub
		ALU alu=new ALU();
		Cache1 cache=new Cache1();
		Memory memory=new Memory();
		memory.storeIntoMemory(1, 6);//The memory address 1contains the address of a routine to handle machine faults. 
		memory.storeIntoMemory(6, 0);//HALT
		//MachineFaultException MFE = null;
		ProgramCounter PC=new ProgramCounter();
		MemoryAccessRegister MAR=new MemoryAccessRegister();
		MemoryBufferRegister MBR=new MemoryBufferRegister();
		MachineFaultRegister MFR=new MachineFaultRegister();
		InstructionRegister IR= new InstructionRegister();
		IndexRegister X1=new IndexRegister();
		IndexRegister X2=new IndexRegister();
		IndexRegister X3=new IndexRegister();
		GeneralPurposeRegister R0=new GeneralPurposeRegister();
		GeneralPurposeRegister R1= new GeneralPurposeRegister();
		GeneralPurposeRegister R2=new GeneralPurposeRegister();
		GeneralPurposeRegister R3=new GeneralPurposeRegister();
		FloatingPointRegister FR0= new FloatingPointRegister();
		FloatingPointRegister FR1= new FloatingPointRegister();
		ConditionCodeRegister CC=new ConditionCodeRegister();
		Encoding encode=new Encoding();
		Decoding decode=new Decoding();

		CU cu=new CU(alu,cache,memory,PC,MAR,MBR,MFR,IR,X1,X2,X3,R0,R1,R2,R3,FR0,FR1,CC,encode,decode);
		UserInterface userInterface=new UserInterface(cu,alu);
		userInterface.setVisible(false);
		cu.storeIntoMemory(10, 10);
		cu.storeIntoMemory(11, 11);
		cu.setFR0Value(10);
		cu.setFR1Value(-20);
		alu.FADD(0,0,0,11);
		alu.FADD(1, 0, 0, 10);
		//assertEquals((float)21,cu.getFR0Value());
		//This one is for checking FADD instructions
		System.out.println(Math.abs(21-cu.getFR0Value()) < 0.01);
		System.out.println(Math.abs(-10-cu.getFR1Value()) < 0.01);
		
		//This part is for checking FSUB instructions
		cu.storeIntoMemory(10, 10);
		cu.storeIntoMemory(11, 11);
		cu.setFR0Value(10);
		cu.setFR1Value(20);
		alu.FSUB(0,0,0,11);
		alu.FSUB(1, 0, 0, 10);
		System.out.println(Math.abs(-1-cu.getFR0Value()) < 0.01);
		System.out.println(Math.abs(10-cu.getFR1Value()) < 0.01);
		
		//This part is for checking VADD instructions
		int len=4;
		cu.setFR0Value(4);
		cu.storeIntoMemory(8, 10);
		cu.storeIntoMemory(9, 20);
		cu.storeIntoMemory(10, 10);
		cu.storeIntoMemory(11, 11);
		cu.storeIntoMemory(12, 12);
		cu.storeIntoMemory(13, 13);
		
		cu.storeIntoMemory(20, 20);
		cu.storeIntoMemory(21, 21);
		cu.storeIntoMemory(22, 22);
		cu.storeIntoMemory(23, 23);
		
		alu.VADD(0, 0, 0, 8);
		
		for(int i=cu.fetchFromMemory(8);i<cu.fetchFromMemory(8)+len;i++){
			System.out.println("The value at memory address "+i+" is: "+cu.fetchFromMemory(i));
			/*expected value is 10+20=30 at memory address location 10,
			 * 					11+21=32 at memory address location 11,
			 * 					12+22=34 at memory address location 12
			 * 					13+23=36 at memory address location 13
			 * 					and the printed out number confirmed that
			*/
			//assertEquals(Integer.valueOf(cu.fetchFromMemory(10)),Integer.valueOf(30));
			
		}
		System.out.println(Math.abs(30-cu.fetchFromMemory(10)) < 0.01);
		System.out.println(Math.abs(32-cu.fetchFromMemory(11)) < 0.01);
		System.out.println(Math.abs(34-cu.fetchFromMemory(12)) < 0.01);
		System.out.println(Math.abs(36-cu.fetchFromMemory(13)) < 0.01);
		
		cu.setFR0Value(4);
		cu.storeIntoMemory(8, 10);
		cu.storeIntoMemory(9, 20);
		cu.storeIntoMemory(10, 10);
		cu.storeIntoMemory(11, 11);
		cu.storeIntoMemory(12, 12);
		cu.storeIntoMemory(13, 13);
		
		cu.storeIntoMemory(20, -20);
		cu.storeIntoMemory(21, -31);
		cu.storeIntoMemory(22, -42);
		cu.storeIntoMemory(23, -53);
		
		System.out.println("Checking VADD with negative numbers");
		alu.VADD(0, 0, 0, 8);
		for(int i=cu.fetchFromMemory(8);i<cu.fetchFromMemory(8)+len;i++){
			System.out.println("The value at memory address "+i+" is: "+cu.fetchFromMemory(i));
			/*expected value is 10-20=-10 at memory address location 10,
			 * 					11-31=-20 at memory address location 11,
			 * 					12-42=-30 at memory address location 12
			 * 					13-53=-40 at memory address location 13
			 * 					and the printed out number confirmed that
			*/
			//assertEquals(Integer.valueOf(cu.fetchFromMemory(10)),Integer.valueOf(30));
			
		}
		System.out.println(Math.abs(-10-cu.fetchFromMemory(10)) < 0.01);
		System.out.println(Math.abs(-20-cu.fetchFromMemory(11)) < 0.01);
		System.out.println(Math.abs(-30-cu.fetchFromMemory(12)) < 0.01);
		System.out.println(Math.abs(-40-cu.fetchFromMemory(13)) < 0.01);
		
		//This part is for checking VSUB instruction
		len=4;
		cu.setFR0Value(4);
		cu.storeIntoMemory(8, 10);
		cu.storeIntoMemory(9, 20);
		cu.storeIntoMemory(10, 10);
		cu.storeIntoMemory(11, 11);
		cu.storeIntoMemory(12, 12);
		cu.storeIntoMemory(13, 13);
		
		cu.storeIntoMemory(20, 20);
		cu.storeIntoMemory(21, 24);
		cu.storeIntoMemory(22, 26);
		cu.storeIntoMemory(23, 28);
		
		alu.VSUB(0, 0, 0, 8);
		/*Expected output after VSUB:
		 * -10 at memory location 10
		 * -13 at memory location 11
		 * -14 at memory location 12
		 * -15 at memory location 13
		 * */
		for(int i=cu.fetchFromMemory(8);i<cu.fetchFromMemory(8)+len;i++){
			System.out.println("The value at memory address "+i+" is: "+cu.fetchFromMemory(i));
			/*expected value is 10+20=30 at memory address location 10,
			 * 					11-24=-13 at memory address location 11,
			 * 					12-26=-14 at memory address location 12
			 * 					13-28=-15 at memory address location 13
			 * 					and the printed out number confirmed that
			*/
			//assertEquals(Integer.valueOf(cu.fetchFromMemory(10)),Integer.valueOf(30));
			
		}
		System.out.println(Math.abs(-10-cu.fetchFromMemory(10)) < 0.01);
		System.out.println(Math.abs(-13-cu.fetchFromMemory(11)) < 0.01);
		System.out.println(Math.abs(-14-cu.fetchFromMemory(12)) < 0.01);
		System.out.println(Math.abs(-15-cu.fetchFromMemory(13)) < 0.01);
		
		
		System.out.println("Checking VSUB with negative numbers");
		len=4;
		cu.setFR0Value(4);
		cu.storeIntoMemory(8, 10);
		cu.storeIntoMemory(9, 20);
		cu.storeIntoMemory(10, -10);
		cu.storeIntoMemory(11, -11);
		cu.storeIntoMemory(12, -12);
		cu.storeIntoMemory(13, -13);
		
		cu.storeIntoMemory(20, -20);
		cu.storeIntoMemory(21, -24);
		cu.storeIntoMemory(22, -26);
		cu.storeIntoMemory(23, -28);
		
		alu.VSUB(0, 0, 0, 8);
		/*Expected output after VSUB:
		 * -10 at memory location 10
		 * -13 at memory location 11
		 * -14 at memory location 12
		 * -15 at memory location 13
		 * */
		for(int i=cu.fetchFromMemory(8);i<cu.fetchFromMemory(8)+len;i++){
			System.out.println("The value at memory address "+i+" is: "+cu.fetchFromMemory(i));
			/*expected value is -10+20=10 at memory address location 10,
			 * 					-11+24=13 at memory address location 11,
			 * 					-12+26=14 at memory address location 12
			 * 					-13+28=15 at memory address location 13
			 * 					and the printed out number confirmed that
			*/
			//assertEquals(Integer.valueOf(cu.fetchFromMemory(10)),Integer.valueOf(30));
			
		}
		System.out.println(Math.abs(10-cu.fetchFromMemory(10)) < 0.01);
		System.out.println(Math.abs(13-cu.fetchFromMemory(11)) < 0.01);
		System.out.println(Math.abs(14-cu.fetchFromMemory(12)) < 0.01);
		System.out.println(Math.abs(15-cu.fetchFromMemory(13)) < 0.01);
		
		
		//This part is for checking converting
		
		//checking fixed point number first
		cu.storeIntoMemory(10, 30);
		cu.setR0Value(0);
		alu.CNVRT(0,0,0,10);
		System.out.println(Math.abs(30-cu.getR0Value()) < 0.01);
		cu.setR1Value(1);
		alu.CNVRT(1, 0, 0, 10);
		System.out.println(Math.abs(30f-cu.getFR0Value()) < 0.01);
		//System.out.println(FR0.getValue() instanceOf float);
	}

	
	

}
