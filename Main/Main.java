package Main;
import FrontPanel.UserInterface;

import java.awt.EventQueue;

import CPUAttributes.ALU;
import CPUAttributes.ProgramCounter;
import CPUAttributes.ConditionCodeRegister;
import CPUAttributes.FloatingPointRegister;
import CPUAttributes.CU;
import CPUAttributes.Cache1;
import CPUAttributes.GeneralPurposeRegister;
import CPUAttributes.IndexRegister;
import CPUAttributes.InstructionRegister;
import CPUAttributes.MachineFaultRegister;
import CPUAttributes.MemoryAccessRegister;
import CPUAttributes.MemoryBufferRegister;
import InstructionProcessing.Decoding;
import InstructionProcessing.Encoding;
import InstructionProcessing.MachineFaultException;
import Memory.Memory;
public class Main {
	//private static UserInterface userInterface=new UserInterface();
	//private static ALU alu=new ALU();
	//private static CU cu=new CU();
	//private static Memory memory=new Memory();
	//private static Cache cache =new Cache();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//PC.setValue(10);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							
							/*alu=new ALU();
							cu=new CU();
							memory=new Memory();
							cache =new Cache();*/
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
							
							userInterface.setVisible(true);
							
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
	}

}
