package CPUAttributes;

import FrontPanel.UserInterface;
import InstructionProcessing.Decoding;
import InstructionProcessing.Encoding;
import InstructionProcessing.MachineFaultException;

public class ALU {
	private static CU cu=new CU();
	private static UserInterface userInterface=new UserInterface();
	public void setUserInterface(UserInterface userInterface){
		this.userInterface=userInterface;
	}
	public int calculateEA(int X,int I,int address){
		int EA=0;
		switch(I){
		case 0:
			switch(X){
			case 0:
				EA=address;
				break;
			case 1:
				EA=cu.getX1Value()+address;
				break;
			case 2:
				EA=cu.getX2Value()+address;
				break;
			case 3:
				EA=cu.getX3Value()+address;
				break;
			default:
				break;
			}
			break;
		case 1:
			switch(X){
			case 0:
				EA=cu.fetchFromMemory(address);
				break;
			case 1:
				EA=cu.fetchFromMemory(cu.getX1Value()+address);
				break;
			case 2:
				EA=cu.fetchFromMemory(cu.getX2Value()+address);
				break;
			case 3:
				EA=cu.fetchFromMemory(cu.getX3Value()+address);
				break;
			default:
				break;
			}
			break;
		default:
			break;
		}
		return EA;
	}
	public Boolean iExec(int Address) throws MachineFaultException {
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
		int R,X,I,address,RX,RY;
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
		case 10:
			R = instructionDec[1];
			X = instructionDec[2];
			I = instructionDec[3];
			address = instructionDec[4];
			JZ(R,X,I,address);
			break;
		case 11:
			R = instructionDec[1];
			X = instructionDec[2];
			I = instructionDec[3];
			address = instructionDec[4];
			JNE(R,X,I,address);
			break;
		case 12:
			R = instructionDec[1];
			X = instructionDec[2];
			I = instructionDec[3];
			address = instructionDec[4];
			JCC(R,X,I,address);
			break;
		case 13:
			X = instructionDec[1];
			I = instructionDec[2];
			address = instructionDec[3];
			JMA(X,I,address);
			break;
		case 14:
			X = instructionDec[1];
			I = instructionDec[2];
			address = instructionDec[3];
			JSR(X,I,address);
			break;
		case 15:
			break;
		case 00:
			status = false;
			return status;
		case 04:
			R = instructionDec[1];
			X = instructionDec[2];
			I = instructionDec[3];
			address = instructionDec[4];
			AMR(R,X,I,address);
			break;
		case 05:
			R = instructionDec[1];
			X = instructionDec[2];
			I = instructionDec[3];
			address = instructionDec[4];
			SMR(R,X,I,address);
			break;
		case 06:
			R = instructionDec[1];
			address = instructionDec[2];
			AIR(R,address);
			break;
		case 07:
			R = instructionDec[1];
			address = instructionDec[2];
			SIR(R,address);
			break;
		case 20:
			RX = instructionDec[1];
			RY = instructionDec[2];
			MLT(RX,RY);
			break;
		case 21:
			RX = instructionDec[1];
			RY = instructionDec[2];
			DVD(RX,RY);
			break;
		case 22:
			RX = instructionDec[1];
			RY = instructionDec[2];
			TRR(RX,RY);
			break;
		case 23:
			RX = instructionDec[1];
			RY = instructionDec[2];
			AND(RX,RY);
			break;
		case 24:
			RX = instructionDec[1];
			RY = instructionDec[2];
			ORR(RX,RY);
			break;
		case 25:
			RX = instructionDec[1];
			NOT(RX);
			break;	
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

	private void AMR(int R,int X,int I,int address){
		int currentRegisterValue;
		int EAValue;
		switch(R){
		case 0:
			currentRegisterValue=cu.getR0Value();
			EAValue=cu.fetchFromMemory(calculateEA(X,I,address));
			cu.setR0Value(currentRegisterValue+EAValue);
			break;
		case 1:
			currentRegisterValue=cu.getR1Value();
			EAValue=cu.fetchFromMemory(calculateEA(X,I,address));
			cu.setR1Value(currentRegisterValue+EAValue);
			break;
		case 2:
			currentRegisterValue=cu.getR2Value();
			EAValue=cu.fetchFromMemory(calculateEA(X,I,address));
			cu.setR2Value(currentRegisterValue+EAValue);
			break;
		case 3:
			currentRegisterValue=cu.getR3Value();
			EAValue=cu.fetchFromMemory(calculateEA(X,I,address));
			cu.setR3Value(currentRegisterValue+EAValue);
			break;
		default:
			break;
		}
	}

	private void JZ (int R, int X, int I, int address){
		if(I==0) {
			switch (R) {
			case 0:
				if(cu.getR0Value()==0) {
					userInterface.setPCText(address);
					cu.setPCValue(address);
				}
				else {
					userInterface.setPCText(cu.getPCValue()+1);
					cu.setPCValue(cu.getPCValue()+1);
				}
				break;
			case 1:
				if(cu.getR1Value()==0) {
					userInterface.setPCText(address);
					cu.setPCValue(address);
				}
				else {
					userInterface.setPCText(cu.getPCValue()+1);
					cu.setPCValue(cu.getPCValue()+1);
				}
				break;
			case 2:
				if(cu.getR2Value()==0) {
					userInterface.setPCText(address);
					cu.setPCValue(address);
				}
				else {
					userInterface.setPCText(cu.getPCValue()+1);
					cu.setPCValue(cu.getPCValue()+1);
				}
				break;
			case 3:
				if(cu.getR3Value()==0) {
					userInterface.setPCText(address);
					cu.setPCValue(address);
				}
				else {
					userInterface.setPCText(cu.getPCValue()+1);
					cu.setPCValue(cu.getPCValue()+1);
				}
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
				IX = cu.getX2Value();
			}
			else {
				IX = cu.getX3Value();
			}
			int ADD = IX + address;
			switch (R) {
			case 0:
				if(cu.getR0Value()==0) {
					userInterface.setPCText(ADD);
					cu.setPCValue(ADD);
				}
				else {
					userInterface.setPCText(cu.getPCValue()+1);
					cu.setPCValue(cu.getPCValue()+1);
				}
				break;
			case 1:
				if(cu.getR1Value()==0) {
					userInterface.setPCText(ADD);
					cu.setPCValue(ADD);
				}
				else {
					userInterface.setPCText(cu.getPCValue()+1);
					cu.setPCValue(cu.getPCValue()+1);
				}
				break;
			case 2:
				if(cu.getR2Value()==0) {
					userInterface.setPCText(ADD);
					cu.setPCValue(ADD);
				}
				else {
					userInterface.setPCText(cu.getPCValue()+1);
					cu.setPCValue(cu.getPCValue()+1);
				}
				break;
			case 3:
				if(cu.getR3Value()==0) {
					userInterface.setPCText(ADD);
					cu.setPCValue(ADD);
				}
				else {
					userInterface.setPCText(cu.getPCValue()+1);
					cu.setPCValue(cu.getPCValue()+1);
				}
				break;
			default:
				break;
			}
			
		}
		
	}
	
	public void JNE(int R,int X,int I,int address) {
		if(I==0) {
			switch (R) {
			case 0:
				if(cu.getR0Value()!=0) {
					userInterface.setPCText(address);
					cu.setPCValue(address);
				}
				else {
					userInterface.setPCText(cu.getPCValue()+1);
					cu.setPCValue(cu.getPCValue()+1);
				}
				break;
			case 1:
				if(cu.getR1Value()!=0) {
					userInterface.setPCText(address);
					cu.setPCValue(address);
				}
				else {
					userInterface.setPCText(cu.getPCValue()+1);
					cu.setPCValue(cu.getPCValue()+1);
				}
				break;
			case 2:
				if(cu.getR2Value()!=0) {
					userInterface.setPCText(address);
					cu.setPCValue(address);
				}
				else {
					userInterface.setPCText(cu.getPCValue()+1);
					cu.setPCValue(cu.getPCValue()+1);
				}
				break;
			case 3:
				if(cu.getR3Value()!=0) {
					userInterface.setPCText(address);
					cu.setPCValue(address);
				}
				else {
					userInterface.setPCText(cu.getPCValue()+1);
					cu.setPCValue(cu.getPCValue()+1);
				}
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
				IX = cu.getX2Value();
			}
			else {
				IX = cu.getX3Value();
			}
			int ADD = IX + address;
			switch (R) {
			case 0:
				if(cu.getR0Value()!=0) {
					userInterface.setPCText(ADD);
					cu.setPCValue(ADD);
				}
				else {
					userInterface.setPCText(cu.getPCValue()+1);
					cu.setPCValue(cu.getPCValue()+1);
				}
				break;
			case 1:
				if(cu.getR1Value()!=0) {
					userInterface.setPCText(ADD);
					cu.setPCValue(ADD);
				}
				else {
					userInterface.setPCText(cu.getPCValue()+1);
					cu.setPCValue(cu.getPCValue()+1);
				}
				break;
			case 2:
				if(cu.getR2Value()!=0) {
					userInterface.setPCText(ADD);
					cu.setPCValue(ADD);
				}
				else {
					userInterface.setPCText(cu.getPCValue()+1);
					cu.setPCValue(cu.getPCValue()+1);
				}
				break;
			case 3:
				if(cu.getR3Value()!=0) {
					userInterface.setPCText(ADD);
					cu.setPCValue(ADD);
				}
				else {
					userInterface.setPCText(cu.getPCValue()+1);
					cu.setPCValue(cu.getPCValue()+1);
				}
				break;
			default:
				break;
			}
			
		}
		
	}
	
	public void JMA(int X,int I,int address) {
		if(I==0) {
			userInterface.setPCText(address);
			cu.setPCValue(address);
		}
		else {
			int IX=0;
			if(X==1) {
				IX = cu.getX1Value();
			}
			else if(X==2) {
				IX = cu.getX2Value();
			}
			else {
				IX = cu.getX3Value();
			}
			int ADD = IX + address;
			userInterface.setPCText(ADD);
			cu.setPCValue(ADD);	
		}	
	}
	
	public void JSR(int X,int I,int address) {
		userInterface.setR3Text(cu.getPCValue());
		cu.setR3Value(cu.getPCValue()+1);
		if(I==0) {
			userInterface.setPCText(address);
			cu.setPCValue(address);
		}
		else {
			int IX=0;
			if(X==1) {
				IX = cu.getX1Value();
			}
			else if(X==2) {
				IX = cu.getX2Value();
			}
			else {
				IX = cu.getX3Value();
			}
			int ADD = IX + address;
			userInterface.setPCText(ADD);
			cu.setPCValue(ADD);	
		}
	}
	private void JCC(int CC,int X,int I,int address) {
		int ccBit = 0;
		int ADD = address;
		if(CC == 0) {
			ccBit = cu.getCCValue()/1000;
		}
		else if(CC == 1) {
			ccBit = (cu.getCCValue()%1000)/100;
		}
		else if(CC == 2) {
			ccBit = ((cu.getCCValue()%1000)%100)/10;
		}
		else if(CC == 3) {
			ccBit = ((cu.getCCValue()%1000)%100)%10;
		}
		switch (I) {
		case 0:
			break;
		case 1:
			switch (X) {
			case 1:
				ADD += cu.getX1Value();
				break;
			case 2:
				ADD += cu.getX2Value();
				break;
			case 3:
				ADD += cu.getX3Value();
				break;
			default:
				break;
			}
			break;

		default:
			break;
		}
		switch (ccBit) {
		case 1:
			userInterface.setPCText(ADD);
			cu.setPCValue(ADD);
			break;
		case 0:
			userInterface.setPCText(cu.getPCValue());
			cu.setPCValue(cu.getPCValue()+1);
		default:
			break;
		}
	}
	private void SMR(int R, int X, int I, int address) {
		// TODO Auto-generated method stub
		int currentRegisterValue;
		int EAValue;
		switch(R){
		case 0:
			currentRegisterValue=cu.getR0Value();
			EAValue=cu.fetchFromMemory(calculateEA(X,I,address));
			cu.setR0Value(currentRegisterValue-EAValue);
			break;
		case 1:
			currentRegisterValue=cu.getR1Value();
			EAValue=cu.fetchFromMemory(calculateEA(X,I,address));
			cu.setR1Value(currentRegisterValue-EAValue);
			break;
		case 2:
			currentRegisterValue=cu.getR2Value();
			EAValue=cu.fetchFromMemory(calculateEA(X,I,address));
			cu.setR2Value(currentRegisterValue-EAValue);
			break;
		case 3:
			currentRegisterValue=cu.getR3Value();
			EAValue=cu.fetchFromMemory(calculateEA(X,I,address));
			cu.setR3Value(currentRegisterValue-EAValue);
			break;
		default:
			break;
		}
		
	}
	private void AIR(int R, int immed){
		if(immed!=0){
			int currentRegisterValue;
			switch(R){
				case 0:
					currentRegisterValue=cu.getR0Value();
					if(currentRegisterValue==0){
						cu.setR0Value(immed);
					}
					else{
					cu.setR0Value(currentRegisterValue+immed);
					}
					break;
				case 1:
					currentRegisterValue=cu.getR1Value();
					if(currentRegisterValue==0){
						cu.setR1Value(immed);
					}
					else{
					cu.setR1Value(currentRegisterValue+immed);
					}
					break;
				case 2:
					currentRegisterValue=cu.getR2Value();
					if(currentRegisterValue==0){
						cu.setR2Value(immed);
					}
					else{
					cu.setR2Value(currentRegisterValue+immed);
					}
					break;
				case 3:
					currentRegisterValue=cu.getR3Value();
					if(currentRegisterValue==0){
						cu.setR3Value(immed);
					}
					else{
					cu.setR3Value(currentRegisterValue+immed);
					}
					break;
				default:
					break;
			}
		}
	}
	private void SIR(int R, int immed){
		if(immed!=0){
			int currentRegisterValue;
			switch(R){
				case 0:
					currentRegisterValue=cu.getR0Value();
					if(currentRegisterValue==0){
						cu.setR0Value(-immed);
					}
					else{
					cu.setR0Value(currentRegisterValue-immed);
					}
					break;
				case 1:
					currentRegisterValue=cu.getR1Value();
					if(currentRegisterValue==0){
						cu.setR1Value(-immed);
					}
					else{
					cu.setR1Value(currentRegisterValue-immed);
					}
					break;
				case 2:
					currentRegisterValue=cu.getR2Value();
					if(currentRegisterValue==0){
						cu.setR2Value(-immed);
					}
					else{
					cu.setR2Value(currentRegisterValue-immed);
					}
					break;
				case 3:
					currentRegisterValue=cu.getR3Value();
					if(currentRegisterValue==0){
						cu.setR3Value(-immed);
					}
					else{
					cu.setR3Value(currentRegisterValue-immed);
					}
					break;
				default:
					break;
			}
		}
	}
	private void MLT(int RX, int RY) throws MachineFaultException{
		boolean overflow=false;
		int RXValue;
		int RYValue;
		int RX1Value;
		String temp;
		switch(RX){
		case 0:
			RXValue=cu.getR0Value();
			switch(RY){
			case 0:
				RYValue=cu.getR0Value();//can RX & RY both be R0 or R2?
				//RX contains the high order bits of the result while RX+1 contains the low order bits of the results
				
				temp=Integer.toBinaryString(RXValue*RYValue);
				//Integer.toBinaryString(decInstruction)
				if(temp.length()>32){
					overflow=true;
					throw new MachineFaultException("Overflow!");
				}
				else{
					RXValue=Integer.parseInt(temp.substring(0, 16),2);
					RX1Value=Integer.parseInt(temp.substring(16), 2);
				}
				//how many bits should be stored in RX and RX+1 respectively when there's overflow?
				break;
			case 2:
				RYValue=cu.getR2Value();
				temp=Integer.toBinaryString(RXValue*RYValue);
				if(temp.length()>32){
					overflow=true;
					throw new MachineFaultException("Overflow!");
				}
				else{
					RXValue=Integer.parseInt(temp.substring(0, 16),2);
					RX1Value=Integer.parseInt(temp.substring(16), 2);
				}
				break;
			default:
				break;
			}
			break;
		case 2:
			RXValue=cu.getR2Value();
			switch(RY){
			case 0:
				RYValue=cu.getR0Value();//can RX & RY both be R0 or R2?
				//RX contains the high order bits of the result while RX+1 contains the low order bits of the results
				
				temp=Integer.toBinaryString(RXValue*RYValue);
				//Integer.toBinaryString(decInstruction)
				if(temp.length()!=32){
					overflow=true;
					throw new MachineFaultException("Overflow!");
				}
				else{
					RXValue=Integer.parseInt(temp.substring(0, 16),2);
					RX1Value=Integer.parseInt(temp.substring(16), 2);
				}
				//how many bits should be stored in RX and RX+1 respectively when there's overflow?
				break;
			case 2:
				RYValue=cu.getR2Value();
				temp=Integer.toBinaryString(RXValue*RYValue);
				if(temp.length()!=32){
					overflow=true;
					throw new MachineFaultException("Overflow!");
				}
				else{
					RXValue=Integer.parseInt(temp.substring(0, 16),2);
					RX1Value=Integer.parseInt(temp.substring(16), 2);
				}
				break;
			default:
				break;
			}
			break;
		}
	}
		
	public void DVD(int rx,int ry) {
				int data=0;
				switch(rx) {
				case 0:
					data=cu.getR0Value();
					break;
				case 1:
					data=cu.getR1Value();
					break;
				case 2:
					data=cu.getR2Value();
					break;
				case 3:
					data=cu.getR3Value();
					break;
				default:
					break;
				}
				userInterface.updateLogText("\nRx ", data);
				int temp=0;
				switch(ry){
				case 0:
					temp=cu.getR0Value();
					break;
				case 1:
					temp=cu.getR1Value();
					break;
				case 2:
					temp= cu.getR2Value();
					break;
				case 3:
					temp=cu.getR3Value();
					break;
				default:
					break;
				}
				userInterface.updateLogText("\nRy ", temp);
				int quotient = data/temp;
				int reminder = data%temp;
				userInterface.setR0Text(quotient);
				userInterface.setR1Text(reminder);
				userInterface.updateLogText("\n R0 : ",quotient);
				userInterface.updateLogText("\n R1 : ",reminder);
			}
	public void TRR(int rx, int ry) {
				int data=0;
				switch(rx) {
				case 0:
					data=cu.getR0Value();
					break;
				case 1:
					data=cu.getR1Value();
					break;
				case 2:
					data=cu.getR2Value();
					break;
				case 3:
					data=cu.getR3Value();
					break;
				default:
					break;
				}
				userInterface.updateLogText("\nRx ", data);
				int temp=0;
				switch (ry) {
				case 0:
					temp=cu.getR0Value();
					break;
				case 1:
					temp=cu.getR1Value();
					break;
				case 2:
					temp=cu.getR2Value();
					break;
				case 3:
					temp=cu.getR3Value();
					break;
				default:
					break;
				}
				userInterface.updateLogText("\nRy ", temp);
				if(data==temp) {
					ConditionCodeRegister.setccValue(1);
					userInterface.updateLogText("\nCC: True ");
				}
				else {
					ConditionCodeRegister.setccValue(0);
					userInterface.updateLogText("\nCC:False");
				}
			}
	public void ORR(int rx, int ry) {
				int data=0;
				switch(rx) {
				case 0:
					data=cu.getR0Value();
					break;
				case 1:
					data=cu.getR1Value();
					break;
				case 2:
					data=cu.getR2Value();
					break;
				case 3:
					data=cu.getR3Value();
					break;
				default:
					break;
				}
				userInterface.updateLogText("\nRx ", rx);
				String s1=Integer.toBinaryString(data);
				int temp=0;
				switch (ry) {
				case 0:
					temp=cu.getR0Value();
					break;
				case 1:
					temp=cu.getR1Value();
					break;
				case 2:
					temp=cu.getR2Value();
					break;
				case 3:
					temp=cu.getR3Value();
					break;
				default:
					break;
				}
				userInterface.updateLogText("\nRy: ",temp);
				String s2= Integer.toBinaryString(temp);
				int len= Math.max(s1.length(),s2.length());
				if(s1.length() < s2.length()) {
					for(int i=0;i<(s2.length()-s1.length());i++) {
						s1= "0"+s1;
					}
				}
				else if(s2.length() < s1.length()) {
					for(int i=0;i<(s1.length()-s2.length());i++) {
						s2= "0"+s2;
					}
				}
				char[] or= { };
				for(int i=0;i<len;i++) {
					char[] s3 =s1.toCharArray();
					char[] s4= s2.toCharArray();
					if(s3[i]=='1' || s4[i]=='1') {
						or[i]=1; 
					}
					else
						or[i]=0;
				}
				int ans= Integer.parseInt(new String(or));
				userInterface.setR0Text(ans);
				userInterface.updateLogText("\n R0 : ",ans);
			}
	public void AND(int rx, int ry) {
				int data=0;
				switch(rx) {
				case 0:
					data=cu.getR0Value();
					break;
				case 1:
					data=cu.getR1Value();
					break;
				case 2:
					data=cu.getR2Value();
					break;
				case 3:
					data=cu.getR3Value();
					break;
				default:
					break;
				}
				userInterface.updateLogText("\nRx ", data);
				String s1=Integer.toBinaryString(data);
				int temp=0;
				switch (ry) {
				case 0:
					temp=cu.getR0Value();
					break;
				case 1:
					temp=cu.getR1Value();
					break;
				case 2:
					temp=cu.getR2Value();
					break;
				case 3:
					temp=cu.getR3Value();
					break;
				default:
					break;
				}
				userInterface.updateLogText("\nRy: ",temp);
				String s2= Integer.toBinaryString(temp);
				int len= Math.max(s1.length(),s2.length());
				if(s1.length() < s2.length()) {
					for(int i=0;i<(s2.length()-s1.length());i++) {
						s1= "0"+s1;
					}
				}
				else if(s2.length() < s1.length()) {
					for(int i=0;i<(s1.length()-s2.length());i++) {
						s2= "0"+s2;
					}
				}
				char[] or= { };
				for(int i=0;i<len;i++) {
					char[] s3 =s1.toCharArray();
					char[] s4= s2.toCharArray();
					if(s3[i]=='0' || s4[i]=='0') {
						or[i]=0; 
					}
					else
						or[i]=1;
				}
				int and= Integer.parseInt(new String(or));
				userInterface.setR0Text(and);
				userInterface.updateLogText("\n R0 : ",and);
				System.out.print(and);
			}

	public void NOT(int rx) {
				userInterface.updateLogText("\nMAR ", rx);
				int data=0;
				switch(rx) {
				case 0:
					data=cu.getR0Value();
					break;
				case 1:
					data=cu.getR1Value();
					break;
				case 2:
					data=cu.getR2Value();
					break;
				case 3:
					data=cu.getR3Value();
					break;
				default:
					break;
				}
				userInterface.updateLogText("\nRx ", data);
				String s1=Integer.toBinaryString(data);
				int len=s1.length();
				char[] not= { };
				for(int i=0;i<len;i++) {
					char[] s2 =s1.toCharArray();
					if(s2[i]=='0') {
						not[i]='1';
						break;
					}
					else if(s2[i]=='1') {
						not[i]='0';
					}		
				}
				int ans= Integer.parseInt(new String(not));
				userInterface.setR0Text(ans);
				userInterface.updateLogText("\n R0 : ",ans);
		
}
}
