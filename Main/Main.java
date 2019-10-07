package Main;
import FrontPanel.UserInterface;

import java.awt.EventQueue;

import CPUAttributes.ALU;
import CPUAttributes.ProgramCounter;
import CPUAttributes.ConditionCodeRegister;
import CPUAttributes.CU;
import CPUAttributes.GeneralPurposeRegister;
import CPUAttributes.IndexRegister;
import CPUAttributes.InstructionRegister;
import CPUAttributes.MemoryAccessRegister;
import CPUAttributes.MemoryBufferRegister;
import InstructionProcessing.Decoding;
import InstructionProcessing.Encoding;
import Memory.Memory;
public class Main {
	
	private static UserInterface userInterface=new UserInterface();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//PC.setValue(10);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							userInterface = new UserInterface();
							userInterface.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
	}

}
