package InstructionProcessing;

public class Decoding {

	public int[] decToBinary(int decInstruction) {
		String binaryInstruction = Integer.toBinaryString(decInstruction);
		int[] instruction = new int[5];
		while(binaryInstruction.length() < 16) {
			binaryInstruction = "0" + binaryInstruction;
		}
		String insFunctionString = binaryInstruction.substring(0, 6); 
		if(insFunctionString == "000001" || insFunctionString == "000010" || insFunctionString == "000011") {
			// LDR & STR & LDA
			if(insFunctionString == "000001") {
				instruction[0]=1;
			}
			else if(insFunctionString == "000010") {
				instruction[0]=2;
			}
			else {
				instruction[0]=3;
			}
			instruction[1]=(int)Integer.parseInt(binaryInstruction.substring(6,8), 2);
			instruction[2]=(int)Integer.parseInt(binaryInstruction.substring(8,10), 2);
			instruction[3]=(int)Integer.parseInt(binaryInstruction.substring(10, 11), 2);
			instruction[4]=(int)Integer.parseInt(binaryInstruction.substring(11), 2);
			
		}
		else if(insFunctionString == "101001" || insFunctionString == "101010"){
			// LDX & STX
			if(insFunctionString == "101001") {
				instruction[0]=41;
			}
			else if(insFunctionString == "101010") {
				instruction[0]=42;
			}
			// doubt for register and index register selection
			instruction[1]=(int)Integer.parseInt(binaryInstruction.substring(6,8), 2);
			instruction[2]=(int)Integer.parseInt(binaryInstruction.substring(8,10), 2);
			instruction[3]=(int)Integer.parseInt(binaryInstruction.substring(10, 11), 2);
			instruction[4]=(int)Integer.parseInt(binaryInstruction.substring(11), 2);
		}
		else {
			//Halt Case
			instruction[0]=0;
		}
		return instruction;
		
	}
}
