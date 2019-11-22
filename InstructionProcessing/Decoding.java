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
			case "001010":
				instruction[0] = 10;
				instruction[1]=Integer.parseInt((binaryInstruction.substring(6,8)), 2);
				instruction[2]=Integer.parseInt((binaryInstruction.substring(8,10)), 2);
				instruction[3]=Integer.parseInt((binaryInstruction.substring(10, 11)), 2);
				instruction[4]=Integer.parseInt((binaryInstruction.substring(11)), 2);
				break;
			case "001011":
				instruction[0] = 11;
				instruction[1]=Integer.parseInt((binaryInstruction.substring(6,8)), 2);
				instruction[2]=Integer.parseInt((binaryInstruction.substring(8,10)), 2);
				instruction[3]=Integer.parseInt((binaryInstruction.substring(10, 11)), 2);
				instruction[4]=Integer.parseInt((binaryInstruction.substring(11)), 2);
				break;
			case "001100":
				instruction[0] = 12;
				instruction[1]=Integer.parseInt((binaryInstruction.substring(6,8)), 2);
				instruction[2]=Integer.parseInt((binaryInstruction.substring(8,10)), 2);
				instruction[3]=Integer.parseInt((binaryInstruction.substring(10, 11)), 2);
				instruction[4]=Integer.parseInt((binaryInstruction.substring(11)), 2);
				break;
			case "001101":
				instruction[0] = 13;
				instruction[1]=Integer.parseInt(binaryInstruction.substring(8,10), 2);
				instruction[2]=Integer.parseInt(binaryInstruction.substring(10,11), 2);
				instruction[3]=Integer.parseInt(binaryInstruction.substring(11), 2);
				break;
			case "001110":
				instruction[0] = 14;
				instruction[1]=Integer.parseInt(binaryInstruction.substring(6,8), 2);
				instruction[2]=Integer.parseInt(binaryInstruction.substring(8,9), 2);
				instruction[3]=Integer.parseInt(binaryInstruction.substring(9), 2);
				break;
			case "001111":
				instruction[0] = 15;
				instruction[1]=Integer.parseInt(binaryInstruction.substring(6), 2);
				break;
			case "00":
				instruction[0]=0;
				break;
			case "000000":
				instruction[0]=0;
				break;
			case "000100":
				instruction[0]=4;
				instruction[1]=Integer.parseInt((binaryInstruction.substring(6,8)), 2);
				instruction[2]=Integer.parseInt((binaryInstruction.substring(8,10)), 2);
				instruction[3]=Integer.parseInt((binaryInstruction.substring(10, 11)), 2);
				instruction[4]=Integer.parseInt((binaryInstruction.substring(11)), 2);
				break;
			case "000101":
				instruction[0]=5;
				instruction[1]=Integer.parseInt((binaryInstruction.substring(6,8)), 2);
				instruction[2]=Integer.parseInt((binaryInstruction.substring(8,10)), 2);
				instruction[3]=Integer.parseInt((binaryInstruction.substring(10, 11)), 2);
				instruction[4]=Integer.parseInt((binaryInstruction.substring(11)), 2);
				break;
			case "000110":
				instruction[0]=6;
				instruction[1]=Integer.parseInt((binaryInstruction.substring(6,8)), 2);
				instruction[2]=Integer.parseInt((binaryInstruction.substring(8)), 2);
				break;
			case "000111":
				instruction[0]=7;
				instruction[1]=Integer.parseInt((binaryInstruction.substring(6,8)), 2);
				instruction[2]=Integer.parseInt((binaryInstruction.substring(8)), 2);
				break;
			case "010100":
				instruction[0]=20;
				instruction[1]=Integer.parseInt((binaryInstruction.substring(6,8)), 2);
				instruction[2]=Integer.parseInt((binaryInstruction.substring(8,10)), 2);
				break;
			case "010101":
				instruction[0]=21;
				instruction[1]=Integer.parseInt((binaryInstruction.substring(6,8)), 2);
				instruction[2]=Integer.parseInt((binaryInstruction.substring(8,10)), 2);
				break;
			case "010110":
				instruction[0]=22;
				instruction[1]=Integer.parseInt((binaryInstruction.substring(6,8)), 2);
				instruction[2]=Integer.parseInt((binaryInstruction.substring(8,10)), 2);
				break;
			case "010111":
				instruction[0]=23;
				instruction[1]=Integer.parseInt((binaryInstruction.substring(6,8)), 2);
				instruction[2]=Integer.parseInt((binaryInstruction.substring(8,10)), 2);
				break;
			case "011000":
				instruction[0]=24;
				instruction[1]=Integer.parseInt((binaryInstruction.substring(6,8)), 2);
				instruction[2]=Integer.parseInt((binaryInstruction.substring(8,10)), 2);
				break;
			case "011001":
				instruction[0]=25;
				instruction[1]=Integer.parseInt((binaryInstruction.substring(6,8)), 2);
				break;
			case "010000":
				instruction[0] = 16;
				instruction[1] = Integer.parseInt((binaryInstruction.substring(6,8)), 2);
				instruction[2]=Integer.parseInt((binaryInstruction.substring(8,10)), 2);
				instruction[3]=Integer.parseInt((binaryInstruction.substring(10, 11)), 2);
				instruction[4]=Integer.parseInt((binaryInstruction.substring(11)), 2);
				break;
			case "010001":
				instruction[0] = 17;
				instruction[1] = Integer.parseInt((binaryInstruction.substring(6,8)), 2);
				instruction[2]=Integer.parseInt((binaryInstruction.substring(8,10)), 2);
				instruction[3]=Integer.parseInt((binaryInstruction.substring(10, 11)), 2);
				instruction[4]=Integer.parseInt((binaryInstruction.substring(11)), 2);
				break;
			case "011111":
				instruction[0] = 31;
				instruction[1] = Integer.parseInt((binaryInstruction.substring(6,8)), 2);
				instruction[2] = Integer.parseInt((binaryInstruction.substring(8,9)), 2);
				instruction[3] = Integer.parseInt((binaryInstruction.substring(9,10)), 2);
				instruction[4] = Integer.parseInt((binaryInstruction.substring(12)), 2);
				break;
			case "100000":
				instruction[0] = 32;
				instruction[1] = Integer.parseInt((binaryInstruction.substring(6,8)), 2);
				instruction[2] = Integer.parseInt((binaryInstruction.substring(8,9)), 2);
				instruction[3] = Integer.parseInt((binaryInstruction.substring(9,10)), 2);
				instruction[4] = Integer.parseInt((binaryInstruction.substring(12)), 2);
				break;
			
				// IO Operations
			case "111101":  //IN instruction
				instruction[0] = 61;
				instruction[1] = Integer.parseInt(binaryInstruction.substring(6,8), 2);
				instruction[2] = Integer.parseInt(binaryInstruction.substring(11), 2);
				break;
			case "111110":  //OUT instruction
				instruction[0] = 62;
				instruction[1] = Integer.parseInt(binaryInstruction.substring(6,8), 2);
				instruction[2] = Integer.parseInt(binaryInstruction.substring(11), 2);
				break;
			case "111111":  //CHECK instruction
				instruction[0] = 63;
				instruction[1] = Integer.parseInt(binaryInstruction.substring(6,8), 2);
				instruction[2] = Integer.parseInt(binaryInstruction.substring(11), 2);
				break;
			case "011110":  //TRAP instruction
				instruction[0] = 30;
				instruction[1] = Integer.parseInt(binaryInstruction.substring(6,10), 2);//location 6-9 in the instructionStruction now stores the trap code
				break;
			case "100001"://FADD instruction
				instruction[0]=33;
				instruction[1]=Integer.parseInt((binaryInstruction.substring(6,8)), 2);
				instruction[2]=Integer.parseInt((binaryInstruction.substring(8,10)), 2);
				instruction[3]=Integer.parseInt((binaryInstruction.substring(10,11)), 2);
				instruction[4]=Integer.parseInt((binaryInstruction.substring(11)),2);
			case "100010"://FSUB instruction
				instruction[0]=34;
				instruction[1]=Integer.parseInt((binaryInstruction.substring(6,8)), 2);
				instruction[2]=Integer.parseInt((binaryInstruction.substring(8,10)), 2);
				instruction[3]=Integer.parseInt((binaryInstruction.substring(10,11)), 2);
				instruction[4]=Integer.parseInt((binaryInstruction.substring(11)),2);
			case "100011"://VADD instruction
				instruction[0]=35;
				instruction[1]=Integer.parseInt((binaryInstruction.substring(6,8)), 2);
				instruction[2]=Integer.parseInt((binaryInstruction.substring(8,10)), 2);
				instruction[3]=Integer.parseInt((binaryInstruction.substring(10,11)), 2);
				instruction[4]=Integer.parseInt((binaryInstruction.substring(11)),2);
			case "100100"://VSUB instruction
				instruction[0]=36;
				instruction[1]=Integer.parseInt((binaryInstruction.substring(6,8)), 2);
				instruction[2]=Integer.parseInt((binaryInstruction.substring(8,10)), 2);
				instruction[3]=Integer.parseInt((binaryInstruction.substring(10,11)), 2);
				instruction[4]=Integer.parseInt((binaryInstruction.substring(11)),2);
			case "100101"://CNVRT instruction
				instruction[0]=37;
				instruction[1]=Integer.parseInt((binaryInstruction.substring(6,8)), 2);
				instruction[2]=Integer.parseInt((binaryInstruction.substring(8,10)), 2);
				instruction[3]=Integer.parseInt((binaryInstruction.substring(10,11)), 2);
				instruction[4]=Integer.parseInt((binaryInstruction.substring(11)),2);
			case "110010"://LDFR instruction
				instruction[0]=50;
				instruction[1]=Integer.parseInt((binaryInstruction.substring(6,8)), 2);
				instruction[2]=Integer.parseInt((binaryInstruction.substring(8,10)), 2);
				instruction[3]=Integer.parseInt((binaryInstruction.substring(10,11)), 2);
				instruction[4]=Integer.parseInt((binaryInstruction.substring(11)),2);
			case "110011"://STFR instruction
				instruction[0]=51;
				instruction[1]=Integer.parseInt((binaryInstruction.substring(6,8)), 2);
				instruction[2]=Integer.parseInt((binaryInstruction.substring(8,10)), 2);
				instruction[3]=Integer.parseInt((binaryInstruction.substring(10,11)), 2);
				instruction[4]=Integer.parseInt((binaryInstruction.substring(11)),2);
			default:
				break;
			}
			return instruction;
			
		}
}
