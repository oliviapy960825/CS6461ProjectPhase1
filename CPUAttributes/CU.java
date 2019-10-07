package CPUAttributes;

import FrontPanel.UserInterface;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import InstructionProcessing.Decoding;
import InstructionProcessing.Encoding;
import Memory.Memory;

public class CU {
	private static UserInterface userInterface=new UserInterface();
	private static ALU alu=new ALU();
	private static Memory memory=new Memory();
	private static Encoding encode = new Encoding();
	private static Decoding decode =  new Decoding();
	private static ProgramCounter PC = new ProgramCounter();
	private static MemoryAccessRegister MAR = new MemoryAccessRegister();
	private static MemoryBufferRegister MBR = new MemoryBufferRegister();
	private static InstructionRegister IR = new InstructionRegister();
	private static IndexRegister X1 = new IndexRegister();
	private static IndexRegister X2 = new IndexRegister();
	private static IndexRegister X3 = new IndexRegister();
	private static GeneralPurposeRegister R0 = new GeneralPurposeRegister();
	private static GeneralPurposeRegister R1 = new GeneralPurposeRegister();
	private static GeneralPurposeRegister R2 = new GeneralPurposeRegister();
	private static GeneralPurposeRegister R3 = new GeneralPurposeRegister();
	private static ConditionCodeRegister CC = new ConditionCodeRegister();
	
	public void setUserInterface(UserInterface userInterface){
		this.userInterface=userInterface;
	}
	public void strInsToMemory(String a) {
		//This is to get String stored in memory
		int pc = PC.getValue();
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
		this.MAR.setValue(address);
	}
	public int getMARValue(){
		return this.MAR.getValue();
	}
	public void setMBRValue(int address){
		this.MBR.setValue(address);
	}
	public int getMBRValue(){
		return this.MBR.getValue();
	}
	public void setR0Value(int address){
		this.R0.setValue(address);
	}
	public int getR0Value(){
		return this.R0.getValue();
	}
	public void setR1Value(int address){
		this.R1.setValue(address);
	}
	public int getR1Value(){
		return this.R1.getValue();
	}
	public void setR2Value(int address){
		this.R2.setValue(address);
	}
	public int getR2Value(){
		return this.R2.getValue();
	}
	public void setR3Value(int address){
		this.R3.setValue(address);
	}
	public int getR3Value(){
		return this.R3.getValue();
	}
	public void setX1Value(int address){
		this.X1.setValue(address);
	}
	public int getX1Value(){
		return this.X1.getValue();
	}
	public void setX2Value(int address){
		this.X2.setValue(address);
	}
	public int getX2Value(){
		return this.X2.getValue();
	}
	public void setX3Value(int address){
		this.X3.setValue(address);
	}
	public int getX3Value(){
		return this.X3.getValue();
	}
	public void setIRValue(int address){
		this.IR.setValue(address);
	}
	public int getIRValue(){
		return this.IR.getValue();
	}
	public void setPCValue(int address){
		this.PC.setValue(address);;
	}
	public int getPCValue(){
		return this.PC.getValue();
	}
}
