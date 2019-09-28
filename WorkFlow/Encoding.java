package WorkFlow;

public class Encoding {

	String insFunction = new String();
	public int insToDec(String instruction) {
		if(instruction.substring(0, 3)=="LDR") {
			insFunction += "000001";
		}
		else if(instruction.substring(0, 3)=="STR") {
			insFunction += "000010";
		}
		else if(instruction.substring(0, 3)=="LDA") {
			insFunction += "000011";
		}
		else if(instruction.substring(0, 3)=="LDX") {
			insFunction += "101001";
		}
		else if(instruction.substring(0, 3)=="STX") {
			insFunction += "101010";
		}
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
		String addressString = Integer.toBinaryString(Integer.parseInt(instruction.substring(10)));
		while(addressString.length() < 5) {
			addressString = "0" + addressString;
		}
		insFunction += addressString;
		int decimalInstruction = Integer.parseInt(insFunction, 2);
		return decimalInstruction;
		
	}
}
