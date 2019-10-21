package CPUAttributes;

import FrontPanel.UserInterface;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import InstructionProcessing.Decoding;
import InstructionProcessing.Encoding;
import InstructionProcessing.MachineFaultException;
import Memory.Memory;

public class CU {
	private  UserInterface userInterface;
	private  ALU alu;
	private  Cache cache;
	public  Memory memory;
	private  Encoding encode ;
	private  Decoding decode;
	private  ProgramCounter PC;
	private  MemoryAccessRegister MAR;
	private  MemoryBufferRegister MBR ;
	private InstructionRegister IR;
	private IndexRegister X1;
	private  IndexRegister X2;
	private  IndexRegister X3 ;
	private  GeneralPurposeRegister R0;
	private  GeneralPurposeRegister R1;
	private  GeneralPurposeRegister R2;
	private  GeneralPurposeRegister R3  ;
	private  ConditionCodeRegister CC;
	
	public CU(ALU alu, Cache cache, Memory memory, ProgramCounter PC, MemoryAccessRegister MAR, MemoryBufferRegister MBR,InstructionRegister IR,IndexRegister X1, IndexRegister X2, IndexRegister X3,  GeneralPurposeRegister R0,  GeneralPurposeRegister R1,  GeneralPurposeRegister R2,  GeneralPurposeRegister R3, ConditionCodeRegister CC, Encoding encode, Decoding decode){
		this.alu=alu;
		this.cache=cache;
		this.memory=memory;
		this.PC=PC;
		this.MAR=MAR;
		this.MBR=MBR;
		this.IR=IR;
		this.R0=R0;
		this.R1=R1;
		this.R2=R2;
		this.R3=R3;
		this.X1=X1;
		this.X2=X2;
		this.X3=X3;
		this.CC=CC;
		this.encode=encode;
		this.decode=decode;
		alu.setCU(this);
		/*alu=new ALU(this);
		cache=new Cache();
		memory=new Memory();
		PC=new ProgramCounter();
		MAR=new MemoryAccessRegister();
		MBR =new MemoryBufferRegister();
		IR=new InstructionRegister();
		X1= new IndexRegister();
		X2= new IndexRegister();
		X3= new IndexRegister();
		R0= new  GeneralPurposeRegister();
		R1= new  GeneralPurposeRegister();
		R2= new  GeneralPurposeRegister();
		R3= new  GeneralPurposeRegister();
		CC= new ConditionCodeRegister();
		alu.setCU(this);
		cache.setCU(this);
		memory.setCU(this);
		PC.setCU(this);
		MAR.setCU(this);
		MBR.setCU(this);
		IR.setCU(this);
		X1.setCU(this);
		X2.setCU(this);
		X3.setCU(this);
		R0.setCU(this);
		R1.setCU(this);
		R2.setCU(this);
		R3.setCU(this);
		CC.setCU(this);*/
	}
	public void setUserInterface(UserInterface userInterface){
		this.userInterface=userInterface;
	}
	
	
	public void strInsToMemory(String a) {
		//This is to get String stored in memory
		int pc = getPCValue();
		String[] lines = a.split("\n");
		for (String line : lines) {
			int decIns = encode.insToDec(line);
			//memory[pc]=decIns;
			memory.storeIntoMemory(pc, decIns);
			System.out.println("The "+pc+" th instruction in binary form is : "+memory.fetchFromMemory(pc));
			pc= pc+1;
		}

	}
	
	public int getCurrentMemorySize() {
		return memory.getCurrentMemorySize();
	}
	public int fetchFromMemory(int address) {
		return memory.fetchFromMemory(address);
	}
	public void storeIntoMemory(int address, int value) {
		memory.storeIntoMemory(address, value);
	}
	public int[] decToBinary(int decInstruction){
		return decode.decToBinary(decInstruction);
	}
	public int insToDec(String instruction){
		return encode.insToDec(instruction);
	}
	public void setMARValue(int address){
		MAR.setValue(address);
		userInterface.setMARText(address);
	}
	public int getMARValue(){
		return MAR.getValue();
	}
	public void setMBRValue(int address){
		MBR.setValue(address);
		userInterface.setMBRText(address);
	}
	public int getMBRValue(){
		return MBR.getValue();
	}
	public void setR0Value(int address){
		R0.setValue(address);
		userInterface.setR0Text(address);
		//userInterface.getR0Text();
	}
	public int getR0Value(){
		return R0.getValue();
	}
	public void setR1Value(int address){
		R1.setValue(address);
		userInterface.setR1Text(address);
	}
	public int getR1Value(){
		return R1.getValue();
	}
	public void setR2Value(int address){
		R2.setValue(address);
		userInterface.setR2Text(address);
	}
	public int getR2Value(){
		return R2.getValue();
	}
	public void setR3Value(int address){
		R3.setValue(address);
		userInterface.setR3Text(address);
	}
	public int getR3Value(){
		return R3.getValue();
	}
	public void setX1Value(int address){
		X1.setValue(address);
		userInterface.setX1Text(address);
	}
	public int getX1Value(){
		return X1.getValue();
	}
	public void setX2Value(int address){
		X2.setValue(address);
		userInterface.setX2Text(address);
	}
	public int getX2Value(){
		return X2.getValue();
	}
	public void setX3Value(int address){
		X3.setValue(address);
		userInterface.setX3Text(address);
	}
	public int getX3Value(){
		return X3.getValue();
	}
	public void setIRValue(int address){
		IR.setValue(address);
		userInterface.setIRText(address);
	}
	public int getIRValue(){
		return IR.getValue();
	}
	public void setPCValue(int address){
		PC.setValue(address);
		userInterface.setPCText(address);
	}
	public int getPCValue(){
		return PC.getValue();
	}

	public void setCCValue(int address) {
		CC.setccValue(address);
		userInterface.setCCText(address);
	}
	public int getCCValue(){
		return CC.getccValue();
	}
	public Boolean iExec(int Address) throws MachineFaultException {
		//This function is for executing the instructions of user input
		//System.out.print(Address);
		Boolean status = true;
		//String addString = Integer.toBinaryString(Address);
		
		int add = Address;//why are we converting it to binaryString then covert it back to decimal?
		int value=memory.fetchFromMemory(add);
		int[] instructionDec =decToBinary(value);
		userInterface.setMARText(add);
		setMARValue(add);
		userInterface.updateLogText("\n PC --> MAR");
		userInterface.setMBRText(value);
		setMBRValue(value);
		userInterface.updateLogText("\n MBR gets loaded with the value");
		userInterface.setIRText(value);
		setIRValue(Address);
		userInterface.setIRText(Address);
		userInterface.updateLogText("\n MBR --> IR");
		//PC.setValue(PC.getValue() + 1);
		userInterface.setPCText(getPCValue()+1);
		//txtFieldPC.setText(String.valueOf(PC.getValue()));
		setPCValue(getPCValue()+1);
		userInterface.updateLogText("\n PC incremented by 1");
		int R,X,I,address,RX,RY,immed;
		switch (instructionDec[0]) {
		case 1:
			R = instructionDec[1];
			X = instructionDec[2];
			I = instructionDec[3];
			address = instructionDec[4];
			alu.LDR(R,X,I,address);
			break;
		case 2:
			R = instructionDec[1];
			X = instructionDec[2];
			I = instructionDec[3];
			address = instructionDec[4];
			alu.STR(R,X,I,address);
			break;
		case 3:
			R = instructionDec[1];
			X = instructionDec[2];
			I = instructionDec[3];
			address = instructionDec[4];
			alu.LDA(R,X,I,address);
			break;
		case 41:
			X = instructionDec[1];
			I = instructionDec[2];
			address = instructionDec[3];
			alu.LDX(X,I,address);
			break;
		case 42:
			X = instructionDec[1];
			I = instructionDec[2];
			address = instructionDec[3];
			alu.STX(X,I,address);
			break;
		case 10:
			R = instructionDec[1];
			X = instructionDec[2];
			I = instructionDec[3];
			address = instructionDec[4];
			alu.JZ(R,X,I,address);
			break;
		case 11:
			R = instructionDec[1];
			X = instructionDec[2];
			I = instructionDec[3];
			address = instructionDec[4];
			alu.JNE(R,X,I,address);
			break;
		case 12:
			R = instructionDec[1];
			X = instructionDec[2];
			I = instructionDec[3];
			address = instructionDec[4];
			alu.JCC(R,X,I,address);
			break;
		case 13:
			X = instructionDec[1];
			I = instructionDec[2];
			address = instructionDec[3];
			alu.JMA(X,I,address);
			break;
		case 14:
			X = instructionDec[1];
			I = instructionDec[2];
			address = instructionDec[3];
			alu.JSR(X,I,address);
			break;
		case 15:
			break;
		case 0:
			status = false;
			return status;
		case 4:
			R = instructionDec[1];
			X = instructionDec[2];
			I = instructionDec[3];
			address = instructionDec[4];
			alu.AMR(R,X,I,address);
			break;
		case 5:
			R = instructionDec[1];
			X = instructionDec[2];
			I = instructionDec[3];
			address = instructionDec[4];
			alu.SMR(R,X,I,address);
			break;
		case 6:
			R = instructionDec[1];
			immed = instructionDec[2];
			alu.AIR(R,immed);
			break;
		case 7:
			R = instructionDec[1];
			immed = instructionDec[2];
			alu.SIR(R,immed);
			break;
		case 20:
			RX = instructionDec[1];
			RY = instructionDec[2];
			alu.MLT(RX,RY);
			break;
		case 21:
			RX = instructionDec[1];
			RY = instructionDec[2];
			alu.DVD(RX,RY);
			break;
		case 22:
			RX = instructionDec[1];
			RY = instructionDec[2];
			alu.TRR(RX,RY);
			break;
		case 23:
			RX = instructionDec[1];
			RY = instructionDec[2];
			alu.AND(RX,RY);
			break;
		case 24:
			RX = instructionDec[1];
			RY = instructionDec[2];
			alu.ORR(RX,RY);
			break;
		case 25:
			RX = instructionDec[1];
			alu.NOT(RX);
			break;	
		default:
			break;
		}
		return status;
	}
	
}
