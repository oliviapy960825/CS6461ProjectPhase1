package CPUAttributes;

import javax.swing.JOptionPane;

import FrontPanel.UserInterface;
import InstructionProcessing.Decoding;
import InstructionProcessing.Encoding;
import InstructionProcessing.MachineFaultException;

public class ALU {
	private CU cu;
	private UserInterface userInterface;
	public void setCU(CU cu){
		this.cu=cu;
		}
	public void setUserInterface(UserInterface userInterface){
		this.userInterface=userInterface;
	}
	public int calculateEA(int X,int I,int address){
	// -----------------------------------------------
    // The function to calculate the effective address
    // -----------------------------------------------
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
				EA=cu.memory.fetchFromMemory(address);
				break;
			case 1:
				EA=cu.memory.fetchFromMemory(cu.getX1Value()+address);
				break;
			case 2:
				EA=cu.memory.fetchFromMemory(cu.getX2Value()+address);
				break;
			case 3:
				EA=cu.memory.fetchFromMemory(cu.getX3Value()+address);
				break;
			default:
				break;
			}
			break;
		}
		return EA;
	}
	
	
	public void LDR(int R,int X,int I,int address) {
	// ------------------------------------
    // 01: LDR -> Load Register From Memory
    // ------------------------------------
		if(I==0) {
			//System.out.println(R);
			userInterface.setMARText(address);
			//txtFieldMAR.setText(Integer.toString(address));
			cu.setMARValue(address);
			userInterface.updateLogText("\n MAR : ",address);
			
			int data = cu.memory.fetchFromMemory(address);

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
			int data=cu.memory.fetchFromMemory(ADD);
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
	// ------------------------------------
    // 02: STR -> Store Register To Memory
    // ------------------------------------
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
		cu.memory.storeIntoMemory(address, Reg);
		//Memory[address] = Reg;
	}
	
	public void LDA(int R,int X,int I,int address) {
	// -------------------------------------
    // 03: LDA -> Load Register with Address
    // -------------------------------------
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
	// ------------------------------------------
    // 41: LDX -> Load Index Register from Memory
    // ------------------------------------------
		userInterface.setMARText(address);
		//txtFieldMAR.setText(Integer.toString(address));
		cu.setMARValue(address);
		
		userInterface.updateLogText("\nMAR: ",address);
		//logTextArea.append("\nMAR:"+ address);
		int data=cu.memory.fetchFromMemory(address);
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
	// ------------------------------------------
    // 42: STX -> Store Index Register to Memory
    // ------------------------------------------
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
		cu.memory.storeIntoMemory(address, DataIX);
		//cu.memory[address]= DataIX;
	}

	public void AMR(int R,int X,int I,int address){

	// ---------------------------------
    // 04: AMR -> Add Memory To Register
    // ---------------------------------
		int currentRegisterValue;
		
		int EAValue;
		switch(R){
		case 0:
			currentRegisterValue=cu.getR0Value();
			//System.out.println(currentRegisterValue);
			userInterface.setMARText(calculateEA(X,I,address));
			
			EAValue=cu.memory.fetchFromMemory(calculateEA(X,I,address));
			userInterface.setMBRText(EAValue);
			cu.setR0Value(currentRegisterValue+EAValue);
			//System.out.println(currentRegisterValue+EAValue);
			userInterface.setR0Text(currentRegisterValue+EAValue);
			break;
		case 1:
			currentRegisterValue=cu.getR1Value();
			userInterface.setMARText(calculateEA(X,I,address));
			EAValue=cu.memory.fetchFromMemory(calculateEA(X,I,address));
			userInterface.setMBRText(EAValue);
			cu.setR1Value(currentRegisterValue+EAValue);
			userInterface.setR1Text(currentRegisterValue+EAValue);
			break;
		case 2:
			currentRegisterValue=cu.getR2Value();
			userInterface.setMARText(calculateEA(X,I,address));
			EAValue=cu.memory.fetchFromMemory(calculateEA(X,I,address));
			userInterface.setMBRText(EAValue);
			cu.setR2Value(currentRegisterValue+EAValue);
			userInterface.setR2Text(currentRegisterValue+EAValue);
			break;
		case 3:
			currentRegisterValue=cu.getR3Value();
			userInterface.setMARText(calculateEA(X,I,address));
			EAValue=cu.memory.fetchFromMemory(calculateEA(X,I,address));
			userInterface.setMBRText(EAValue);
			cu.setR3Value(currentRegisterValue+EAValue);
			userInterface.setR3Text(currentRegisterValue+EAValue);
			break;
		default:
			break;
		}
	}

	public void JZ (int R, int X, int I, int address){

	// ----------------------
    // 10: JZ -> Jump If Zero
    // ----------------------

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
	// ----------------------------
    // 11: JNE -> Jump If Not Equal
    // ----------------------------
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
	// ----------------------------------------
    // 13:JMA -> Unconditional Jump To Address
    // ----------------------------------------
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
	// ----------------------------------------
    // 14:JSR -> Jump and Save Return Address
    // ----------------------------------------

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
	public void JCC(int CC,int X,int I,int address) {

	// ---------------------------------
    // 12:JCC -> Jump If Condition Code
    // ---------------------------------

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


	public void SMR(int R, int X, int I, int address) {
	// ---------------------------------------
    // 05:SMR -> Subtract Memory From Register
    // ---------------------------------------
		// TODO Auto-generated method stub
		int currentRegisterValue;
		int EAValue;
		switch(R){
		case 0:
			currentRegisterValue=cu.getR0Value();
			userInterface.setMARText(calculateEA(X,I,address));
			EAValue=cu.memory.fetchFromMemory(calculateEA(X,I,address));
			userInterface.setMBRText(EAValue);
			cu.setR0Value(currentRegisterValue-EAValue);
			userInterface.setR0Text(currentRegisterValue-EAValue);
			break;
		case 1:
			currentRegisterValue=cu.getR1Value();
			userInterface.setMARText(calculateEA(X,I,address));
			EAValue=cu.memory.fetchFromMemory(calculateEA(X,I,address));
			userInterface.setMBRText(EAValue);
			cu.setR1Value(currentRegisterValue-EAValue);
			userInterface.setR1Text(currentRegisterValue-EAValue);
			break;
		case 2:
			currentRegisterValue=cu.getR2Value();
			userInterface.setMARText(calculateEA(X,I,address));
			EAValue=cu.memory.fetchFromMemory(calculateEA(X,I,address));
			userInterface.setMBRText(EAValue);
			cu.setR2Value(currentRegisterValue-EAValue);
			userInterface.setR2Text(currentRegisterValue-EAValue);
			break;
		case 3:
			currentRegisterValue=cu.getR3Value();
			userInterface.setMARText(calculateEA(X,I,address));
			EAValue=cu.memory.fetchFromMemory(calculateEA(X,I,address));
			userInterface.setMBRText(EAValue);
			cu.setR3Value(currentRegisterValue-EAValue);
			userInterface.setR3Text(currentRegisterValue-EAValue);
			break;
		default:
			break;
		}
		
	}
	public void AIR(int R, int immed){


	// ------------------------------------
    // 06:AIR -> Add Immediate to Register
    // ------------------------------------

		if(immed!=0){
			int currentRegisterValue;
			switch(R){
				case 0:
					currentRegisterValue=cu.getR0Value();
					if(currentRegisterValue==0){
						cu.setR0Value(immed);
						userInterface.setR0Text(immed);
					}
					else{
					cu.setR0Value(currentRegisterValue+immed);
					userInterface.setR0Text(currentRegisterValue+immed);
					}
					break;
				case 1:
					currentRegisterValue=cu.getR1Value();
					if(currentRegisterValue==0){
						cu.setR1Value(immed);
						System.out.print(cu.getR1Value());
						userInterface.setR1Text(immed);
					}
					else{
					cu.setR1Value(currentRegisterValue+immed);
					userInterface.setR1Text(currentRegisterValue+immed);
					}
					break;
				case 2:
					currentRegisterValue=cu.getR2Value();
					if(currentRegisterValue==0){
						cu.setR2Value(immed);
						userInterface.setR2Text(immed);
					}
					else{
					cu.setR2Value(currentRegisterValue+immed);
					userInterface.setR2Text(currentRegisterValue+immed);
					}
					break;
				case 3:
					currentRegisterValue=cu.getR3Value();
					if(currentRegisterValue==0){
						cu.setR3Value(immed);
						userInterface.setR3Text(immed);
					}
					else{
					cu.setR3Value(currentRegisterValue+immed);
					userInterface.setR3Text(currentRegisterValue+immed);
					}
					break;
				default:
					break;
			}
		}
	}
	public void SIR(int R, int immed){

	// ------------------------------------------
    // 07:SIR -> Subtract Immediate from Register
    // ------------------------------------------

		if(immed!=0){
			int currentRegisterValue;
			switch(R){
				case 0:
					currentRegisterValue=cu.getR0Value();
					if(currentRegisterValue==0){
						cu.setR0Value(-immed);
						userInterface.setR0Text(-immed);
					}
					else{
					cu.setR0Value(currentRegisterValue-immed);
					userInterface.setR0Text(currentRegisterValue-immed);
					}
					break;
				case 1:
					currentRegisterValue=cu.getR1Value();
					if(currentRegisterValue==0){
						cu.setR1Value(-immed);
						userInterface.setR1Text(-immed);
					}
					else{
					cu.setR1Value(currentRegisterValue-immed);
					userInterface.setR1Text(currentRegisterValue-immed);
					}
					break;
				case 2:
					currentRegisterValue=cu.getR2Value();
					if(currentRegisterValue==0){
						cu.setR2Value(-immed);
						userInterface.setR2Text(-immed);
					}
					else{
					cu.setR2Value(currentRegisterValue-immed);
					userInterface.setR2Text(currentRegisterValue-immed);
					}
					break;
				case 3:
					currentRegisterValue=cu.getR3Value();
					if(currentRegisterValue==0){
						cu.setR3Value(-immed);
						userInterface.setR3Text(-immed);
					}
					else{
					cu.setR3Value(currentRegisterValue-immed);
					userInterface.setR3Text(currentRegisterValue-immed);
					}
					break;
				default:
					break;
			}
		}
	}

	public void MLT(int RX, int RY) throws Exception{

	// ---------------------------------------
    // 20:MLT -> Multiply Register by Register
    // ---------------------------------------

		boolean overflow=false;
		int RXValue=0;
		int RYValue=0;
		int RX1Value=0;
		String temp;
		switch(RX){
		case 0:
			RXValue=cu.getR0Value();
			System.out.println(RXValue);
			switch(RY){
			case 0:
				RYValue=cu.getR0Value();//can RX & RY both be R0 or R2?
				//RX contains the high order bits of the result while RX+1 contains the low order bits of the results
				
				temp=Integer.toBinaryString(RXValue*RYValue);



				System.out.println("result string is: "+temp);

				//Integer.toBinaryString(decInstruction)
				if(temp.length()>32){
					overflow=true;
					throw new Exception("Overflow!");
				}
				else{

					while(temp.length()<32){
						temp="0"+temp;
					}

					RXValue=Integer.parseInt(temp.substring(0, 16),2);
					cu.setR0Value(RXValue);
					System.out.println(RXValue);
					userInterface.setR0Text(RXValue);
					RX1Value=Integer.parseInt(temp.substring(16), 2);
					cu.setR1Value(RX1Value);
					System.out.println(RX1Value);
					userInterface.setR1Text(RX1Value);
				}
				//how many bits should be stored in RX and RX+1 respectively when there's overflow?
				break;
			case 2:
				RYValue=cu.getR2Value();
				temp=Integer.toBinaryString(RXValue*RYValue);
				if(temp.length()>32){
					overflow=true;
					throw new Exception("Overflow!");
				}
				else{


					while(temp.length()<32){
						temp="0"+temp;
					}

					RXValue=Integer.parseInt(temp.substring(0, 16),2);
					cu.setR0Value(RXValue);
					userInterface.setR0Text(RXValue);
					RX1Value=Integer.parseInt(temp.substring(16), 2);
					cu.setR1Value(RX1Value);
					userInterface.setR1Text(RX1Value);
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

				if(temp.length()>32){
					overflow=true;
					throw new Exception("Overflow!");
				}
				else{


					while(temp.length()<32){
						temp="0"+temp;
					}

					RXValue=Integer.parseInt(temp.substring(0, 16),2);
					cu.setR2Value(RXValue);
					userInterface.setR2Text(RXValue);
					RX1Value=Integer.parseInt(temp.substring(16), 2);
					cu.setR3Value(RX1Value);
					userInterface.setR3Text(RX1Value);
				}
				//how many bits should be stored in RX and RX+1 respectively when there's overflow?
				break;
			case 2:
				RYValue=cu.getR2Value();
				temp=Integer.toBinaryString(RXValue*RYValue);

				if(temp.length()>32){

					overflow=true;
					throw new Exception("Overflow!");
				}
				else{
					while(temp.length()<32){
						temp="0"+temp;
					}
					RXValue=Integer.parseInt(temp.substring(0, 16),2);
					cu.setR2Value(RXValue);
					userInterface.setR2Text(RXValue);
					RX1Value=Integer.parseInt(temp.substring(16), 2);
					cu.setR3Value(RX1Value);
					userInterface.setR3Text(RX1Value);
				}
				break;
			default:
				break;
			}
			
			break;
			
		default:
			break;
		}
	}
	public void DVD(int rx,int ry) {


	// -------------------------------------
    // 20:DVD -> Divide Register by Register
    // -------------------------------------

		int data=0;
		switch(rx) {
		case 0:
			data=cu.getR0Value();
			break;
		
		case 2:
			data=cu.getR2Value();
			break;


		}
		System.out.println("Data value is: "+data);

		userInterface.updateLogText("\nRx ", data);
		int temp=0;
		switch(ry){
		case 0:
			temp=cu.getR0Value();
			break;
		
		case 2:
			temp= cu.getR2Value();
			break;
	
		}
		System.out.println("temp value is: "+temp);
		userInterface.updateLogText("\nRy ", temp);
		int quotient = data/temp;
		System.out.println("quotient value is: "+quotient);
		int remainder = data%temp;
		System.out.println("remainder value is: "+remainder);

		if(rx==0){
			cu.setR0Value(quotient);
			cu.setR1Value(remainder);
			userInterface.setR0Text(quotient);
			userInterface.setR1Text(remainder);
		}
		else if(rx==2){
			if(rx==0){
				cu.setR2Value(quotient);
				cu.setR3Value(remainder);
				userInterface.setR2Text(quotient);
				userInterface.setR3Text(remainder);
			}
		}
		
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
			cu.setCCValue(1);
			userInterface.setCCText(1);
			userInterface.updateLogText("\nCC: True ");
		}
		else {
			cu.setCCValue(0);
			userInterface.setCCText(0);
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
		
		String temp_string="";
		for(int i=0;i<len;i++) {
			
			if(s1.charAt(i)=='1' || s2.charAt(i)=='1') {
				
				temp_string=temp_string+"1";
			}
			else
			temp_string=temp_string+"0";
		}
		
		int ans= Integer.parseInt(temp_string,2);
		if(rx==0){
		userInterface.setR0Text(ans);
		cu.setR0Value(ans);
		userInterface.updateLogText("\n R0 : ",ans);
		}
		else if(rx==1){
			userInterface.setR1Text(ans);
			cu.setR1Value(ans);
			userInterface.updateLogText("\n R1 : ",ans);
		}
		else if(rx==2){
			userInterface.setR2Text(ans);
			cu.setR2Value(ans);
			userInterface.updateLogText("\n R2 : ",ans);
		}
		else {
			userInterface.setR3Text(ans);
			cu.setR3Value(ans);
			userInterface.updateLogText("\n R3 : ",ans);
		}
	}
public void AND(int rx, int ry) {


// ----------------------------------------------------
// 22:TRR -> Test the Equality of Register and Register
// ----------------------------------------------------

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
		
		String temp_string="";
		for(int i=0;i<len;i++) {
			
			if(s1.charAt(i)=='0' || s2.charAt(i)=='0') {
				
				temp_string=temp_string+"0";
			}
			else
			temp_string=temp_string+"1";
		}
		int and= Integer.parseInt(temp_string);
		if(rx==0){
			userInterface.setR0Text(and);
			cu.setR0Value(and);
			userInterface.updateLogText("\n R0 : ",and);
			}
			else if(rx==1){
				userInterface.setR1Text(and);
				cu.setR1Value(and);
				userInterface.updateLogText("\n R1 : ",and);
			}
			else if(rx==2){
				userInterface.setR2Text(and);
				cu.setR2Value(and);
				userInterface.updateLogText("\n R2 : ",and);
			}
			else {
				userInterface.setR3Text(and);
				cu.setR3Value(and);
				userInterface.updateLogText("\n R3 : ",and);
			}
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
		String temp_string="";
		for(int i=0;i<len;i++) {

			if(s1.charAt(i)=='0') {
				temp_string=temp_string+"1";
			}
			else {
				temp_string=temp_string+"0";
			}		
		}
		int ans= Integer.parseInt(temp_string);
		if(rx==0){
			userInterface.setR0Text(ans);
			cu.setR0Value(ans);
			userInterface.updateLogText("\n R0 : ",ans);
			}
			else if(rx==1){
				userInterface.setR1Text(ans);
				cu.setR1Value(ans);
				userInterface.updateLogText("\n R1 : ",ans);
			}
			else if(rx==2){
				userInterface.setR2Text(ans);
				cu.setR2Value(ans);
				userInterface.updateLogText("\n R2 : ",ans);
			}
			else {
				userInterface.setR3Text(ans);
				cu.setR3Value(ans);
				userInterface.updateLogText("\n R3 : ",ans);
			}

}

/*
* The Transfer instructions change control of program execution. 
* Conditional transfer instructions test the value of a register.
*/
public void SOB(int R, int X, int I, int address) {
// -----------------------------------
// 016: SOB -> Subtract One and Branch
// -----------------------------------


    int effectiveAddress = calculateEA(X, I, address);
    int valueOfRn = userInterface.getRnByNum(R);
    userInterface.setRnByNum(R, userInterface.getRnByNum(R) - 1);
    userInterface.updateLogText(R+ ":" + valueOfRn);
    if (userInterface.getRnByNum(R)>0) {
        cu.setPCValue(effectiveAddress);
        userInterface.updateLogText("PC:", effectiveAddress);
    } else {
        cu.setPCValue(cu.getPCValue()+1);
        userInterface.updateLogText("PC:", cu.getPCValue());
    }
}

public void JGE(int R, int X, int I, int address) {


// -----------------------------------
// 017: JGE -> Jump Greater Than or Equal To
// -----------------------------------

    int effectiveAddress = calculateEA(X, I, address);
    if (userInterface.getRnByNum(R)>=0) {
        cu.setPCValue(effectiveAddress);
		userInterface.updateLogText("PC:", effectiveAddress);
    } else {
        cu.setPCValue(cu.getPCValue()+1);
		userInterface.updateLogText("PC:", cu.getPCValue());
    }
}

/*
* The IO instruction
* IN: Input Character To Register from Device, r = 0..3
* OUT: Output Character to Device from Register, r = 0..3
* */

public void IN(int R, int devId) {

    //This function is for IN instruction workflow
    //String inputValue = input;
// ------------------------------------------------
// 61:IN -> Input Character To Register from Device
// ------------------------------------------------
    //This function is for IN instruction workflow
    //String inputValue = input;
    if (devId == 00000) { //Console Keyboard input
        String inputValue = userInterface.getInput();
        //userInterface.setMBRText(inputValue);
        //txtFieldMBR.setText(Integer.toString(address));
        //cu.setMBRValue(inputValue);

        switch (R) {
            case 0:
                cu.setR0Value(Integer.valueOf(inputValue));
                userInterface.updateLogText("\n R0 : ",inputValue);
                userInterface.setR0Text(Integer.valueOf(inputValue));
                //txtFieldR0.setText(Integer.toString(address));
                break;
            case 1:
                cu.setR1Value(Integer.valueOf(inputValue));
                userInterface.updateLogText("\n R1 : ",inputValue);
                userInterface.setR1Text(Integer.valueOf(inputValue));
                //txtFieldR1.setText(Integer.toString(address));
                break;
            case 2:
                cu.setR2Value(Integer.valueOf(inputValue));
                userInterface.updateLogText("\n R2 : ",inputValue);
                userInterface.setR2Text(Integer.valueOf(inputValue));
                //txtFieldR2.setText(Integer.toString(address));
                break;
            case 3:
                cu.setR3Value(Integer.valueOf(inputValue));
                userInterface.updateLogText("\n R3 : ",inputValue);
                userInterface.setR3Text(Integer.valueOf(inputValue));
                //txtFieldR3.setText(Integer.toString(address));
                break;
//            default:
//                break;
        }
    }

}

public void OUT(int R, int devId) {


// --------------------------------------------------
// 62:OUT -> Output Character to Device from Register
// --------------------------------------------------

    int outputValue;

    if (devId == 00001){
        switch(R){ //Console Printer output
            case 0:
                outputValue = cu.getR0Value();
                userInterface.updateLogText("\n R0 : "+outputValue);
                break;
            case 1:
                outputValue = cu.getR1Value();
                userInterface.updateLogText("\n R1 : ",outputValue);
                break;
            case 2:
                outputValue = cu.getR2Value();
                userInterface.updateLogText("\n R2 : ",outputValue);
            case 3:
                outputValue = cu.getR3Value();
                userInterface.updateLogText("\n R3 : ",outputValue);
                break;

        }

    }
}

/* Shift and rotate instruction
 * The shift instruction include logic shift and arithmetic shift.
 * The rotate instruction is the logic instruction.
 */
public void SRC(int AL, int LR, int Count, int R) {


// ---------------------------------
// 31:SRC -> Shift Register by Count
// ---------------------------------

	int datum = userInterface.getRnByNum(R);
	switch (AL){
		case 0:
			if (LR == 0) {
				datum = datum >> Count;
			}
			if (LR == 1) {
				datum = datum << Count;
			}
        case 1:
            if (LR == 0) {
                if (datum >= 0)
                    datum = (datum >>> Count);
                else {
                    String x = Integer.toBinaryString(datum >>> Count);
                    x = x.replace("1111111111111111", "");
                    datum = Integer.parseInt(x, 2);
                }
            }
            if (LR == 1) {
                datum = datum << Count;
            }
	}
	userInterface.setRnByNum(R, datum);
	userInterface.updateLogText("output", datum);
	System.out.println(datum);
    //cu.increasePCByOne();
}

public void RRC(int AL, int LR, int Count, int R) {


// ----------------------------------
// 32:RRC -> Rotate Register by Count
// ----------------------------------


    String x = null; // first part of the content
    String y = null; // second part of the content
    String z = null; // string form of content of the register
    int datum = userInterface.getRnByNum(R);
    z = Integer.toBinaryString(datum);
    if (Count >= 0)
        z = z.replace("0000000000000000", "");
    if (Count < 0)
        z = z.replaceAll("1111111111111111", "");

    if (LR == 1) {
        x = z.substring(Count, z.length());
        y = z.substring(0, Count);
        z = x + y;
    }
    if (LR == 0) {
        x = z.substring(0, z.length() - Count);
        y = z.substring(z.length() - Count, z.length());
        z = y + x;
    }
    datum = Integer.parseInt(z, 2);
    userInterface.setRnByNum(R, datum);
    //cu.increasePCByOne();
}
}