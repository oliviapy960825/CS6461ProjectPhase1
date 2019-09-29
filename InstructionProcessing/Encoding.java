package InstructionProcessing;
/**
 * @author Dishit, Peiyu, Zhaoning, Charitha
 *
 */
public class Encoding {
	//This is the class for Encoding procedure. Encoding class has two properties, insFunction and addressString,
	//it has one function insToDec, which takes a string form instruction and convert it into binary form and then 
	//convert it into decimal format for later use and access
	String insFunction = new String();
	String addressString = new String();
	public int insToDec(String instruction) {
		//This function takes a String format instruction and convert the instruction into binary form and then decimal
		//form for later usage
		switch (instruction.substring(0, 3)) {
		case "LDR":
			insFunction = "000001";
			switch (instruction.substring(4, 5)) {
			case "0":
				insFunction += "00";
				break;
			case "1":
				insFunction += "01";
				break;
			case "2":
				insFunction += "10";
				break;
			case "3":
				insFunction += "11";
				break;
			default:
				break;
			}
			
			switch (instruction.substring(6, 7)) {
			case "0":
				insFunction += "00";
				break;
			case "1":
				insFunction += "01";
				break;
			case "2":
				insFunction += "10";
				break;
			case "3":
				insFunction += "11";
				break;
			default:
				break;
			}
			
			switch (instruction.substring(8, 9)) {
			case "0":
				insFunction += "0";
				break;
			case "1":
				insFunction += "1";
				break;
			default:
				break;
			}
			
			addressString = Integer.toBinaryString(Integer.parseInt(instruction.substring(10)));
			while(addressString.length() < 5) {
				addressString = "0" + addressString;
			}
			break;
		case "STR":
			insFunction = "000010";
			switch (instruction.substring(4, 5)) {
			case "0":
				insFunction += "00";
				break;
			case "1":
				insFunction += "01";
				break;
			case "2":
				insFunction += "10";
				break;
			case "3":
				insFunction += "11";
				break;
			default:
				break;
			}
			
			switch (instruction.substring(6, 7)) {
			case "0":
				insFunction += "00";
				break;
			case "1":
				insFunction += "01";
				break;
			case "2":
				insFunction += "10";
				break;
			case "3":
				insFunction += "11";
				break;
			default:
				break;
			}
			
			switch (instruction.substring(8, 9)) {
			case "0":
				insFunction += "0";
				break;
			case "1":
				insFunction += "1";
				break;
			default:
				break;
			}
			
			addressString = Integer.toBinaryString(Integer.parseInt(instruction.substring(10)));
			while(addressString.length() < 5) {
				addressString = "0" + addressString;
			}
			break;
		case "LDA":
			insFunction = "000011";
			switch (instruction.substring(4, 5)) {
			case "0":
				insFunction += "00";
				break;
			case "1":
				insFunction += "01";
				break;
			case "2":
				insFunction += "10";
				break;
			case "3":
				insFunction += "11";
				break;
			default:
				break;
			}
			
			switch (instruction.substring(6, 7)) {
			case "0":
				insFunction += "00";
				break;
			case "1":
				insFunction += "01";
				break;
			case "2":
				insFunction += "10";
				break;
			case "3":
				insFunction += "11";
				break;
			default:
				break;
			}
			
			switch (instruction.substring(8, 9)) {
			case "0":
				insFunction += "0";
				break;
			case "1":
				insFunction += "1";
				break;
			default:
				break;
			}
			
			addressString = Integer.toBinaryString(Integer.parseInt(instruction.substring(10)));
			while(addressString.length() < 5) {
				addressString = "0" + addressString;
			}
			break;
		case "LDX":
			insFunction = "101001";
			switch (instruction.substring(4, 5)) {
			case "1":
				insFunction += "01";
				break;
			case "2":
				insFunction += "10";
				break;
			case "3":
				insFunction += "11";
				break;
			default:
				break;
			}
			switch (instruction.substring(6, 7)) {
			case "0":
				insFunction += "0";
				break;
			case "1":
				insFunction += "1";
				break;
			default:
				break;
			}
			addressString = Integer.toBinaryString(Integer.parseInt(instruction.substring(8)));
			while(addressString.length() < 5) {
				addressString = "0" + addressString;
			}
			break;
		case "STX":
			insFunction = "101010";
			switch (instruction.substring(4, 5)) {
			case "1":
				insFunction += "01";
				break;
			case "2":
				insFunction += "10";
				break;
			case "3":
				insFunction += "11";
				break;
			default:
				break;
			}
			switch (instruction.substring(6, 7)) {
			case "0":
				insFunction += "0";
				break;
			case "1":
				insFunction += "1";
				break;
			default:
				break;
			}
			addressString = Integer.toBinaryString(Integer.parseInt(instruction.substring(8)));
			while(addressString.length() < 5) {
				addressString = "0" + addressString;
			}
			break;		
		default:
			break;
		}

		insFunction += addressString;
		int decimalInstruction = Integer.parseInt(insFunction, 2);
		return decimalInstruction;
		
	}
}
