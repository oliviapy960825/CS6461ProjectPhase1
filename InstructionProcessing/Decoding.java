package InstructionProcessing;
/**
 * @author Dishit, Peiyu, Zhaoning, Charitha
 *
 */
public class Decoding {
	
	//This is the class for Decoding procedure. Decoding class has one function decToBinary
	//which takes the decimal instruction and decode it into Binary form and store each part in its own place
	//in instruction array for later access
	public int[] decToBinary(int decInstruction) {
		//This function is to take the integer form of Instruction and convert it into binary
				//form, then divide it into parts and store each part in its own index in instruction array
		String binaryInstruction = Integer.toBinaryString(decInstruction);
		int[] instruction = new int[5];
		for(int i =0;i<5 ;i++) {
			instruction[i]=0;
		}
		while(binaryInstruction.length() < 16) {
			binaryInstruction = "0" + binaryInstruction;
		}
		System.out.println(binaryInstruction);
		String insFunctionString = binaryInstruction.substring(0, 6); 
		switch (insFunctionString) {
		case "000001":
			instruction[0] = 1;
			instruction[1]=Integer.parseInt((binaryInstruction.substring(6,8)), 2);
			instruction[2]=Integer.parseInt((binaryInstruction.substring(8,10)), 2);
			instruction[3]=Integer.parseInt((binaryInstruction.substring(10, 11)), 2);
			instruction[4]=Integer.parseInt((binaryInstruction.substring(11)), 2);
			break;
		case "000010":
			instruction[0] = 2;
			instruction[1]=Integer.parseInt((binaryInstruction.substring(6,8)), 2);
			instruction[2]=Integer.parseInt((binaryInstruction.substring(8,10)), 2);
			instruction[3]=Integer.parseInt((binaryInstruction.substring(10, 11)), 2);
			instruction[4]=Integer.parseInt((binaryInstruction.substring(11)), 2);
			break;
		case "000011":
			instruction[0] = 3;
			instruction[1]=Integer.parseInt((binaryInstruction.substring(6,8)), 2);
			instruction[2]=Integer.parseInt((binaryInstruction.substring(8,10)), 2);
			instruction[3]=Integer.parseInt((binaryInstruction.substring(10, 11)), 2);
			instruction[4]=Integer.parseInt((binaryInstruction.substring(11)), 2);
			break;
		case "101001":
			instruction[0] = 41;
			instruction[1]=Integer.parseInt(binaryInstruction.substring(6,8), 2);
			instruction[2]=Integer.parseInt(binaryInstruction.substring(8,9), 2);
			instruction[3]=Integer.parseInt(binaryInstruction.substring(9), 2);
			break;
		case "101010":
			instruction[0] = 42;
			instruction[1]=Integer.parseInt(binaryInstruction.substring(6,8), 2);
			instruction[2]=Integer.parseInt(binaryInstruction.substring(8,9), 2);
			instruction[3]=Integer.parseInt(binaryInstruction.substring(9), 2);
			break;
		case "00":
			instruction[0]=00;
		default:
			break;
		}
		return instruction;
		
	}
}
