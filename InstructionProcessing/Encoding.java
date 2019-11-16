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
        String ins;
        int whiteSpaceIndex=instruction.indexOf(' ');
        int decimalInstruction = 0;
        if (instruction.length() > 4) {
           if(whiteSpaceIndex==2){
            switch (instruction.substring(0, 2)) {
                case "IN":
                    insFunction = "111101";
                    switch (instruction.substring(3, 4)) {


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
                    insFunction += "000";

                    switch (instruction.substring(5, 6)) {

                        case "0":
                            insFunction += "00000";
                            break;
                        case "2":
                            insFunction += "00010";
                            break;
                        default:
                            break;
                    }
                    break;
                    
                case "JZ ": //JZ 0,1,0,10
                    insFunction = "001010";
                    switch (instruction.substring(3, 4)) {
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
                    switch (instruction.substring(5, 6)) {
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

                    switch (instruction.substring(7, 8)) {
                        case "0":
                            insFunction += "0";
                            break;
                        case "1":
                            insFunction += "1";
                            break;
                        default:
                            break;
                    }

                    addressString = Integer.toBinaryString(Integer.parseInt(instruction.substring(9)));
                    while (addressString.length() < 5) {
                        addressString = "0" + addressString;
                    }
                    insFunction += addressString;
                    break;

            }
           }
           
            if(whiteSpaceIndex==3){
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
                    while (addressString.length() < 5) {
                        addressString = "0" + addressString;
                    }
                    insFunction += addressString;
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
                    while (addressString.length() < 5) {
                        addressString = "0" + addressString;
                    }
                    insFunction += addressString;
                    break;
                case "LDA":
                    insFunction = "000011";
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
                    while (addressString.length() < 5) {
                        addressString = "0" + addressString;
                    }
                    insFunction += addressString;
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
                    while (addressString.length() < 5) {
                        addressString = "0" + addressString;
                    }
                    insFunction += addressString;
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
                    while (addressString.length() < 5) {
                        addressString = "0" + addressString;
                    }
                    insFunction += addressString;
                    break;
               
                case "JNE"://JNE 0,1,0,10
                    insFunction = "001011";
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
                    while (addressString.length() < 5) {
                        addressString = "0" + addressString;
                    }
                    insFunction += addressString;
                    break;
                case "JCC": //JCC 0,1,0,10
                    insFunction = "001100";
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
                    while (addressString.length() < 5) {
                        addressString = "0" + addressString;
                    }
                    insFunction += addressString;
                    break;
                case "JMA": //JMA 1,0,10
                    insFunction = "001101";
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
                            insFunction += "0";
                            break;
                        case "1":
                            insFunction += "1";
                            break;
                        default:
                            break;
                    }
                    addressString = Integer.toBinaryString(Integer.parseInt(instruction.substring(9)));
                    while (addressString.length() < 8) {
                        addressString = "0" + addressString;
                    }
                    insFunction += addressString;
                    break;
                case "JSR": //JSR 1,0,10
                    insFunction = "001110";
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
                            insFunction += "0";
                            break;
                        case "1":
                            insFunction += "1";
                            break;
                        default:
                            break;
                    }
                    addressString = Integer.toBinaryString(Integer.parseInt(instruction.substring(9)));
                    while (addressString.length() < 5) {
                        addressString = "0" + addressString;
                    }
                    insFunction += addressString;
                    break;
                case "RFS":
                    insFunction = "001111";
                    addressString=Integer.toBinaryString(Integer.parseInt(instruction.substring(4)));
                    while(addressString.length()<10){
                    	addressString="0"+addressString;
                    }
                    insFunction+=addressString;
                   
                    
                    break;

                case "AMR": //AMR R,X,I,ADDRESS
                    insFunction = "000100";
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
                    while (addressString.length() < 5) {
                        addressString = "0" + addressString;
                    }
                    insFunction += addressString;
                    break;
                case "SMR": //SMR R,X,I,ADDRESS
                    insFunction = "000101";
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
                    while (addressString.length() < 5) {
                        addressString = "0" + addressString;
                    }
                    insFunction += addressString;
                    break;
                case "AIR": //AIR R, address OF Immed Value
                    insFunction = "000110";
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
                    }
                    //Integer.toBinaryString(Integer.parseInt(instruction.substring(10)));
                    addressString = Integer.toBinaryString(Integer.parseInt(instruction.substring(6)));
                    while (addressString.length() < 8) {
                        addressString = "0" + addressString;
                    }
                    insFunction += addressString;
                    break;
                case "SIR": //SIR R, Immed address
                    insFunction = "000111";
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
                    addressString = Integer.toBinaryString(Integer.parseInt(instruction.substring(6)));
                    while (addressString.length() < 8) {
                        addressString = "0" + addressString;
                    }
                    insFunction += addressString;
                    break;
                case "MLT"://MLT rx, ry
                    insFunction = "010100";
                    switch (instruction.substring(4, 5)) {
                        case "0":
                            insFunction += "00";
                            break;

                        case "2":
                            insFunction += "10";
                            break;

                        default:
                            break;
                    }
                    switch (instruction.substring(6, 7)) {
                        case "0":
                            insFunction += "00";
                            break;

                        case "2":
                            insFunction += "10";
                            break;
                        default:
                            break;
                    }
                    addressString = "";
                    while (addressString.length() < 6) {
                        addressString = "0" + addressString;
                    }
                    insFunction += addressString;

                    break;
                case "DVD"://DVD rx, ry
                    insFunction = "010101";
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

                    addressString = "";
                    while (addressString.length() < 6) {
                        addressString = "0" + addressString;
                    }
                    insFunction += addressString;

                    break;
                case "TRR"://TRR rx, ry
                    insFunction = "010110";
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


                    break;
                case "ORR"://ORR rx, ry
                    insFunction = "011000";
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


                    break;

                case "AND"://AND rx, ry
                    insFunction = "010111";

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

                    addressString = "";
                    while (addressString.length() < 6) {
                        addressString = "0" + addressString;
                    }
                    insFunction += addressString;
                    break;
                case "NOT"://NOT rx
                    insFunction = "011001";
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

                    addressString = "";
                    while (addressString.length() < 8) {
                        addressString = "0" + addressString;
                    }
                    insFunction += addressString;

                    break;
                case "SOB":
                    insFunction = "010000";
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
                    while (addressString.length() < 5) {
                        addressString = "0" + addressString;
                    }
                    break;

                case "JGE":
                    insFunction = "010001";
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
                    while (addressString.length() < 5) {
                        addressString = "0" + addressString;
                    }
                    break;


                case "OUT":

                    insFunction = "111110";
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
                    insFunction += "000";
                    switch (instruction.substring(6, 7)) {
                        case "1":
                            insFunction += "00001";
                            break;
                        default:
                            break;
                    }
                    break;

                case "SRC":
                    insFunction = "011111";
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
                    switch (instruction.substring(11, 12)) {
                        case "0":
                            insFunction += "0";
                            break;
                        case "1":
                            insFunction += "1";
                            break;
                        default:
                            break;
                    }
                    switch (instruction.substring(9, 10)) {
                        case "0":
                            insFunction += "0";
                            break;
                        case "1":
                            insFunction += "1";
                            break;
                        default:
                            break;
                    }
                    insFunction += "00";
                    switch (instruction.substring(6, 8)) {
                        case "00":
                            insFunction += "0000";
                            break;
                        case "01":
                            insFunction += "0001";
                            break;
                        case "02":
                            insFunction += "0010";
                            break;
                        case "03":
                            insFunction += "0011";
                            break;
                        case "04":
                            insFunction += "0100";
                            break;
                        case "05":
                            insFunction += "0101";
                            break;
                        case "06":
                            insFunction += "0110";
                            break;
                        case "07":
                            insFunction += "0111";
                            break;
                        case "08":
                            insFunction += "1000";
                            break;
                        case "09":
                            insFunction += "1001";
                            break;
                        case "10":
                            insFunction += "1010";
                            break;
                        case "11":
                            insFunction += "1011";
                            break;
                        case "12":
                            insFunction += "1100";
                            break;
                        case "13":
                            insFunction += "1101";
                            break;
                        case "14":
                            insFunction += "1110";
                            break;
                        case "15":
                            insFunction += "1111";
                            break;
                        default:
                            break;
                    }
                    //String count = Integer.toBinaryString(Integer.parseInt(instruction.substring(6,8)));
                    //System.out.println(count);
                    //insFunction += count;
                    break;

                case "RRC":
                    insFunction = "011111";
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
                    switch (instruction.substring(11, 12)) {
                        case "0":
                            insFunction += "0";
                            break;
                        case "1":
                            insFunction += "1";
                            break;
                        default:
                            break;
                    }
                    switch (instruction.substring(9, 10)) {
                        case "0":
                            insFunction += "0";
                            break;
                        case "1":
                            insFunction += "1";
                            break;
                        default:
                            break;
                    }
                    insFunction += "00";
                    switch (instruction.substring(6, 8)) {
                        case "00":
                            insFunction += "0000";
                            break;
                        case "01":
                            insFunction += "0001";
                            break;
                        case "02":
                            insFunction += "0010";
                            break;
                        case "03":
                            insFunction += "0011";
                            break;
                        case "04":
                            insFunction += "0100";
                            break;
                        case "05":
                            insFunction += "0101";
                            break;
                        case "06":
                            insFunction += "0110";
                            break;
                        case "07":
                            insFunction += "0111";
                            break;
                        case "08":
                            insFunction += "1000";
                            break;
                        case "09":
                            insFunction += "1001";
                            break;
                        case "10":
                            insFunction += "1010";
                            break;
                        case "11":
                            insFunction += "1011";
                            break;
                        case "12":
                            insFunction += "1100";
                            break;
                        case "13":
                            insFunction += "1101";
                            break;
                        case "14":
                            insFunction += "1110";
                            break;
                        case "15":
                            insFunction += "1111";
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            
            //decimalInstruction = Integer.parseInt(insFunction, 2);
            //return decimalInstruction;
            }
            }
            if(whiteSpaceIndex==4){
            switch (instruction.substring(0,4)) {
            		case "TRAP":
            			insFunction = "100100";
    	 
    	 
    	 //String string=Integer.toBinaryString(instruction.substring(5));
            			int trapCode=Integer.parseInt(instruction.substring(5));
            			String binaryTrapCode=Integer.toBinaryString(trapCode);
            			while(binaryTrapCode.length()<4){
            				binaryTrapCode="0"+binaryTrapCode;
            			}
            			insFunction+=binaryTrapCode;
    	 
            			while(insFunction.length()<16){
            				insFunction+="0";
            			}
            			break;
            
    	 //insFunction+=instruction.substring(6);//length=4
            		default:
            			break;
            		
            					}
            		}
	
        }
        decimalInstruction = Integer.parseInt(insFunction, 2);
		return decimalInstruction;

	}
}
