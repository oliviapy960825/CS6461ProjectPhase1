package CPUAttributes;

import FrontPanel.UserInterface;
import InstructionProcessing.Decoding;
import InstructionProcessing.Encoding;

public class ALU {
	private static CU cu=new CU();
	private static UserInterface userInterface=new UserInterface();
	
	public void setUserInterface(UserInterface userInterface){
		this.userInterface=userInterface;
	}
	public Boolean iExec(int Address) {
		//This function is for executing the instructions of user input
		//System.out.print(Address);
		Boolean status = true;
		String addString = Integer.toBinaryString(Address);
		
		int add = Integer.parseInt(addString,2);//why are we converting it to binaryString then covert it back to decimal?
		int value=cu.fetchFromMemory(add);
		int[] instructionDec = cu.decToBinary(value);
		userInterface.setMARText(add);
		cu.setMARValue(add);
		userInterface.updateLogText("\n PC --> MAR");
		userInterface.setMBRText(value);
		cu.setMBRValue(value);
		userInterface.updateLogText("\n MBR gets loaded with the value");
		userInterface.setIRText(value);
		cu.setIRValue(value);
		userInterface.updateLogText("\n MBR --> IR");
		//PC.setValue(PC.getValue() + 1);
		userInterface.setPCText(cu.getPCValue()+1);
		//txtFieldPC.setText(String.valueOf(PC.getValue()));
		cu.setPCValue(cu.getPCValue());
		userInterface.updateLogText("\n PC incremented by 1");
		int R,X,I,address;
		switch (instructionDec[0]) {
		case 1:
			R = instructionDec[1];
			X = instructionDec[2];
			I = instructionDec[3];
			address = instructionDec[4];
			LDR(R,X,I,address);
			break;
		case 2:
			R = instructionDec[1];
			X = instructionDec[2];
			I = instructionDec[3];
			address = instructionDec[4];
			STR(R,X,I,address);
			break;
		case 3:
			R = instructionDec[1];
			X = instructionDec[2];
			I = instructionDec[3];
			address = instructionDec[4];
			LDA(R,X,I,address);
			break;
		case 41:
			X = instructionDec[1];
			I = instructionDec[2];
			address = instructionDec[3];
			LDX(X,I,address);
			break;
		case 42:
			X = instructionDec[1];
			I = instructionDec[2];
			address = instructionDec[3];
			STX(X,I,address);
			break;
		case 00:
			status = false;
			return status;
		default:
			break;
		}
		return status;
	}
	
	public void LDR(int R,int X,int I,int address) {
		//This function is for load instruction workflow
		if(I==0) {
			//System.out.println(R);
			userInterface.setMARText(address);
			//txtFieldMAR.setText(Integer.toString(address));
			cu.setMARValue(address);
			userInterface.updateLogText("\n MAR : ",address);
			
			int data = cu.fetchFromMemory(address);

			userInterface.setMBRText(data);
			cu.setMBRValue(data);
			userInterface.updateLogText("\n MBR : ",data);
			switch (R) {
			case 0:
				userInterface.setR0Text(data);
				//txtFieldR0.setText(Integer.toString(data));
				cu.setR0Value(data);
				userInterface.updateLogText("\n R0 : ",data);
				//logTextArea.append("\n R0: "+data);
				break;
			case 1:
				userInterface.setR1Text(data);
				//txtFieldR1.setText(Integer.toString(data));
				cu.setR1Value(data);
				userInterface.updateLogText("\n R1 : ",data);
				//logTextArea.append("\n R1: "+data);
				break;
			case 2:
				userInterface.setR2Text(data);
				//txtFieldR2.setText(Integer.toString(data));
				cu.setR2Value(data);
				userInterface.updateLogText("\n R2 : ",data);
				//logTextArea.append("\n R2: "+data);
				break;
			case 3:
				userInterface.setR3Text(data);
				//txtFieldR3.setText(Integer.toString(data));
				cu.setR3Value(data);
				userInterface.updateLogText("\n R3 : ",data);
				//logTextArea.append("\n R3: "+data);
				break;
			default:
				break;
			}
		}
		else {
			int IX=0;
			if(X==1) {
				IX = cu.getX1Value();
			}
			else if(X==2) {
				IX=cu.getX2Value();
			}
			else {
				IX=cu.getX3Value();
			}
			int ADD = IX + address;
			userInterface.setMARText(ADD);
			//txtFieldMAR.setText(Integer.toString(ADD));
			cu.setMARValue(ADD);
			
			userInterface.updateLogText("\n MAR : ",ADD);
			//logTextArea.append("\n MAR : " + ADD);
			int data=cu.fetchFromMemory(ADD);
			//int data = Memory[ADD];
			userInterface.setMBRText(data);
			//txtFieldMBR.setText(Integer.toString(data));
			cu.setMBRValue(data);
			
			userInterface.updateLogText("\n MBR : ",data);
			//logTextArea.append("\n MBR : " +data);
			switch (R) {
			case 0:
				userInterface.setR0Text(data);
				//txtFieldR0.setText(Integer.toString(data));
				cu.setR0Value(data);
				
				userInterface.updateLogText("\n R0 : ",data);
				//logTextArea.append("\n R0: "+data);
				break;
			case 1:
				userInterface.setR1Text(data);
				//txtFieldR1.setText(Integer.toString(data));
				cu.setR1Value(data);
				
				userInterface.updateLogText("\n R1 : ",data);
				//logTextArea.append("\n R1: "+data);
				break;
			case 2:
				userInterface.setR2Text(data);
				//txtFieldR2.setText(Integer.toString(data));
				cu.setR2Value(data);
				
				userInterface.updateLogText("\n R2 : ",data);
				//logTextArea.append("\n R2: "+data);
				break;
			case 3:
				userInterface.setR3Text(data);
				//txtFieldR3.setText(Integer.toString(data));
				cu.setR3Value(data);
				
				userInterface.updateLogText("\n R3 : ",data);
				//logTextArea.append("\n R3: "+data);
				break;
			default:
				break;
			}
			
		}
		
	}
	
	public void STR(int R,int X,int I,int address) {
		//This function is for STR instruction workflow
		userInterface.setMARText(address);
		//txtFieldMAR.setText(Integer.toString(address));
		cu.setMARValue(address);
		
		int Reg = 0;
		switch (R) {
		case 0:
			Reg = cu.getR0Value();
			userInterface.setMBRText(Reg);
			//txtFieldMBR.setText(Integer.toString(Reg));
			cu.setMBRValue(Reg);
			
			userInterface.updateLogText("MBR : ",Reg);
			//logTextArea.append("MBR: "+ Reg);
			break;
		case 1:
			Reg = cu.getR1Value();
			userInterface.setMBRText(Reg);
			//txtFieldMBR.setText(Integer.toString(Reg));
			cu.setMBRValue(Reg);
			
			userInterface.updateLogText("MBR : ",Reg);
			//logTextArea.append("MBR: "+ Reg);
			break;
		case 2:
			Reg = cu.getR2Value();
			userInterface.setMBRText(Reg);
			//txtFieldMBR.setText(Integer.toString(Reg));
			cu.setMBRValue(Reg);
			
			userInterface.updateLogText("MBR : ",Reg);
			//logTextArea.append("MBR: "+ Reg);
			break;
		case 3:
			Reg = cu.getR3Value();
			userInterface.setMBRText(Reg);
			//txtFieldMBR.setText(Integer.toString(Reg));
			cu.setMBRValue(Reg);
			
			userInterface.updateLogText("MBR : ",Reg);
			//logTextArea.append("MBR: "+ Reg);
			break;
			
		default:
			break;
		}
		cu.storeIntoMemory(address, Reg);
		//Memory[address] = Reg;
	}
	
	public void LDA(int R,int X,int I,int address) {
		//This function is for LDA instruction workflow
		userInterface.setMBRText(address);
		//txtFieldMBR.setText(Integer.toString(address));
		cu.setMBRValue(address);
		
		switch (R) {
		case 0:
			cu.setR0Value(address);
			
			userInterface.setR0Text(address);
			//txtFieldR0.setText(Integer.toString(address));
			break;
		case 1:
			cu.setR1Value(address);
			
			userInterface.setR1Text(address);
			//txtFieldR1.setText(Integer.toString(address));
			break;
		case 2:
			cu.setR2Value(address);
			
			userInterface.setR2Text(address);
			//txtFieldR2.setText(Integer.toString(address));
			break;
		case 3:
			cu.setR3Value(address);
			
			userInterface.setR3Text(address);
			//txtFieldR3.setText(Integer.toString(address));
			break;
			
		default:
			break;
		}
	}
	
	public void LDX(int X,int I,int address) {
		//This instruction is for LDX instruction workflow
		userInterface.setMARText(address);
		//txtFieldMAR.setText(Integer.toString(address));
		cu.setMARValue(address);
		
		userInterface.updateLogText("\nMAR: ",address);
		//logTextArea.append("\nMAR:"+ address);
		int data=cu.fetchFromMemory(address);
		//int Data = Memory[address];
		userInterface.setMBRText(data);
		//txtFieldMBR.setText(Integer.toString(Data));
		cu.setMBRValue(data);
		
		userInterface.updateLogText("\nMBR: ",data);
		//logTextArea.append("\nMBR:"+ Data);
		switch (X) {
		case 1:
			cu.setX1Value(data);
			
		
			userInterface.setX1Text(data);
			//txtFieldX1.setText(Integer.toString(Data));
			break;
		case 2:
			cu.setX2Value(data);
			
			
			userInterface.setX2Text(data);
			//txtFieldX2.setText(Integer.toString(Data));
			break;
		case 3:
			cu.setX3Value(data);
		
			
			userInterface.setX3Text(data);
			//txtFieldX3.setText(Integer.toString(Data));
			break;
		default:
			break;
		}
	}
	
	public void STX(int X,int I,int address) {
		//This function is for STX instruction workflow
		userInterface.setMARText(address);
		//txtFieldMAR.setText(Integer.toString(address));
		
		cu.setMARValue(address);
		
		userInterface.updateLogText("\nMAR: ",address);
		//logTextArea.append("\nMAR:"+ address);		
		int DataIX = 0;
		switch (X) {
		case 1:
			DataIX = cu.getX1Value();
			userInterface.setMBRText(DataIX);
			//txtFieldMBR.setText(Integer.toString(DataIX));
			
			cu.setMBRValue(DataIX);
			
			break;
		case 2:
			DataIX = cu.getX2Value();
			userInterface.setMBRText(DataIX);
			//txtFieldMBR.setText(Integer.toString(DataIX));
			cu.setMBRValue(DataIX);
			
			break;
		case 3:
			DataIX = cu.getX3Value();
			userInterface.setMBRText(DataIX);
			//txtFieldMBR.setText(Integer.toString(DataIX));
			cu.setMBRValue(DataIX);
			
			break;
		default:
			break;
		}
		cu.storeIntoMemory(address, DataIX);
	}
}
