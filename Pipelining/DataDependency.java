package Pipelining;

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
import InstructionProcessing.Decoding;
import InstructionProcessing.Encoding;
import Memory.Memory;

public class DataDependency {//RAW, WAW, WAR hazards
	public boolean checkDependency(){
	CU cu=new CU(new ALU(), new Cache1(), new Memory(), new ProgramCounter(), new MemoryAccessRegister(), new MemoryBufferRegister(),new MachineFaultRegister(), new InstructionRegister(),new IndexRegister(), new IndexRegister(), new IndexRegister(), new GeneralPurposeRegister(),  new GeneralPurposeRegister(),  new GeneralPurposeRegister(),  new GeneralPurposeRegister(), new FloatingPointRegister(), new FloatingPointRegister(), new ConditionCodeRegister(), new Encoding(), new Decoding());
	//This class is going to check the data dependencies between two instructions
	int currentPC=cu.getPCValue();
	int value=cu.fetchFromMemory(currentPC);
	int[] instructionDec =cu.decToBinary(value);
	int[] nextInstructionDec =cu.decToBinary(cu.fetchFromMemory(currentPC+1));
	boolean RAWFlag=false;
	boolean WAWFlag=false;
	boolean WARFlag=false;
	boolean dependentFlag=false;
	int R,X,RX,RY;
	switch(instructionDec[0]){
		//detect WAW hazard first
		case 1://LDR- write, can set WAW flag
			R = instructionDec[1];
			X = instructionDec[2];
			switch(nextInstructionDec[0]){
			case 1:
				if(nextInstructionDec[1]==R||nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 3:
				if(nextInstructionDec[1]==R||nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 41:
				if(nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 4:
				if(nextInstructionDec[1]==R||nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 5:
				if(nextInstructionDec[1]==R||nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 6:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 7:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 20:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 21:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 23:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 24:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 25:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 31:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 32:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 37:
				int nextR=0;
			switch(nextInstructionDec[1]){
			case 0:
				nextR=cu.getR0Value();
				break;
			case 1:
				nextR=cu.getR1Value();
				break;
			case 2:
				nextR=cu.getR2Value();
				break;
			case 3: 
				nextR=cu.getR3Value();
				break;
			}
			if(nextR==0&&R==nextInstructionDec[1]){
				WARFlag=true;
			}	
			break;	
			}
		case 3: //LDA, write, can set WAW flag
			R = instructionDec[1];
			X = instructionDec[2];
			switch(nextInstructionDec[0]){
			case 1:
				if(nextInstructionDec[1]==R||nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 3:
				if(nextInstructionDec[1]==R||nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 41:
				if(nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 4:
				if(nextInstructionDec[1]==R||nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 5:
				if(nextInstructionDec[1]==R||nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 6:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 7:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 20:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 21:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 23:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 24:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 25:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 31:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 32:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 37:
				int nextR=0;
			switch(nextInstructionDec[1]){
			case 0:
				nextR=cu.getR0Value();
				break;
			case 1:
				nextR=cu.getR1Value();
				break;
			case 2:
				nextR=cu.getR2Value();
				break;
			case 3: 
				nextR=cu.getR3Value();
				break;
			}
			if(nextR==0&&R==nextInstructionDec[1]){
				WARFlag=true;
			}	
			break;	
			}
		case 41:
			X = instructionDec[1];
			switch(nextInstructionDec[0]){
			case 1:
				if(nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 3:
				if(nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 41:
				if(nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 4:
				if(nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 5:
				if(nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			
			}
		case 4://AMR, write, can set WAW flag
			R = instructionDec[1];
			X = instructionDec[2];
			switch(nextInstructionDec[0]){
			case 1:
				if(nextInstructionDec[1]==R||nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 3:
				if(nextInstructionDec[1]==R||nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 41:
				if(nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 4:
				if(nextInstructionDec[1]==R||nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 5:
				if(nextInstructionDec[1]==R||nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 6:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 7:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 20:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 21:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 23:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 24:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 25:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 31:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 32:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 37:
				int nextR=0;
			switch(nextInstructionDec[1]){
			case 0:
				nextR=cu.getR0Value();
				break;
			case 1:
				nextR=cu.getR1Value();
				break;
			case 2:
				nextR=cu.getR2Value();
				break;
			case 3: 
				nextR=cu.getR3Value();
				break;
			}
			if(nextR==0&&R==nextInstructionDec[1]){
				WARFlag=true;
			}	
			break;	
			}
		case 5:
			R = instructionDec[1];
			X = instructionDec[2];
			switch(nextInstructionDec[0]){
			case 1:
				if(nextInstructionDec[1]==R||nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 3:
				if(nextInstructionDec[1]==R||nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 41:
				if(nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 4:
				if(nextInstructionDec[1]==R||nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 5:
				if(nextInstructionDec[1]==R||nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 6:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 7:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 20:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 21:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 23:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 24:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 25:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 31:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 32:
				if(nextInstructionDec[1]==R){
					WARFlag=true;
				}
			break;
			case 37:
				int nextR=0;
			switch(nextInstructionDec[1]){
			case 0:
				nextR=cu.getR0Value();
				break;
			case 1:
				nextR=cu.getR1Value();
				break;
			case 2:
				nextR=cu.getR2Value();
				break;
			case 3: 
				nextR=cu.getR3Value();
				break;
			}
			if(nextR==0&&R==nextInstructionDec[1]){
				WARFlag=true;
			}	
			break;	
			}
		case 6:
			X = instructionDec[1];
			switch(nextInstructionDec[0]){
			case 1:
				if(nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 3:
				if(nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 41:
				if(nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 4:
				if(nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 5:
				if(nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			
			}
		case 7:
			X = instructionDec[1];
			switch(nextInstructionDec[0]){
			case 1:
				if(nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 3:
				if(nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 41:
				if(nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 4:
				if(nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			case 5:
				if(nextInstructionDec[2]==X){
					WARFlag=true;
				}
			break;
			
			}
		
	}
	
	if(WAWFlag||RAWFlag||WARFlag){
		dependentFlag=true;
	}
	return dependentFlag;
	}
	
}
