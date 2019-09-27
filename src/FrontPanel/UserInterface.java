/**
 * 
 */
package FrontPanel;

import CPUAttributes.ConditionCodeRegister;
import CPUAttributes.GeneralPurposeRegister;
import CPUAttributes.IndexRegister;
import CPUAttributes.InstructionRegister;
import CPUAttributes.MemoryAccessRegister;
import CPUAttributes.MemoryBufferRegister;
import CPUAttributes.ProgramCounter;

/**
 * @author dk
 *
 */
public class UserInterface {

	
	private static ProgramCounter PC = new ProgramCounter();
	private static MemoryAccessRegister MAR = new MemoryAccessRegister();
	private static MemoryBufferRegister MBR = new MemoryBufferRegister();
	private static InstructionRegister IR = new InstructionRegister();
	private static IndexRegister[] IX = new IndexRegister[3];
	private static GeneralPurposeRegister[] R = new GeneralPurposeRegister[4];
	private static ConditionCodeRegister CC = new ConditionCodeRegister();
	
	private static int Memory[] = new int[4096];
	
	
	/**
	 * 
	 */
	public UserInterface() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}
