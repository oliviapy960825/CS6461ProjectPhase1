package WorkFlow;
import CPU.CU;
import CPU.Registers;
import WorkFlow.Decoding;
import WorkFlow.Encoding;
import WorkFlow.EffectiveAddress;
import FrontPanel.Panel;
public class Execute {//This code is for executing the instruction only
	String instruction;
	Encoding encoder;
	Decoding decoder;
	Registers registers;
	EffectiveAddress effectiveAddress;
	Panel panel;
	public Execute(String instruction, Encoding encoder, Decoding decoder, Registers registers, EffectiveAddress effectiveAddress){
		this.instruction=instruction;
		this.encoder=encoder;
		this.decoder=decoder;
		this.registers=registers;
		this.effectiveAddress=effectiveAddress;
	}
	public void executing(String instruction) throws MachineException{
		panel=new Panel();
		encoder=new Encoding();
		decoder=new Decoding();
		registers=new Registers();
		effectiveAddress=new EffectiveAddress();
		CU cu = new CU();
		int decIns=encoder.insToDec(instruction);
		int[] binaryIns=decoder.decToBinary(decIns);
		int ins=binaryIns[0];
		int genRegister=binaryIns[1];
		int indRegister=binaryIns[2];
		int indAddressing=binaryIns[3];
		int address=binaryIns[4];
		int EA=effectiveAddress.calculateEffectiveAddress(indRegister, indAddressing, address, cu, registers);
		panel.txtrTtg.setText("Effective Address:"+Integer.toString(EA));
		
		if (ins==1){
			panel.txtrTtg.setText("Set MAR to :"+Integer.toString(EA)+", "+"set MBR to :"+Integer.toString(cu.fetchFromMemory(EA))+", "+"Set General Register"+Integer.toString(genRegister)+" to "+Integer.toString(cu.fetchFromMemory(EA)));
			registers.setGenralRegister(genRegister, cu.fetchFromMemory(EA));
			
		}
		else if(ins==2){
			panel.txtrTtg.setText("Get the value in general register"+Integer.toString(genRegister)+" : "+Integer.toString(registers.getGeneralRegister(genRegister))+" and store it into Memory Address"+ Integer.toString(EA));
			cu.storeInMemory(EA, registers.getGeneralRegister(genRegister));	
		}
		else if(ins==3){
			panel.txtrTtg.setText("Set General Register"+Integer.toString(genRegister)+" to "+Integer.toString(EA));
			registers.setGenralRegister(genRegister, EA);	
		}
		else if(ins==41){
			panel.txtrTtg.setText("Set MAR to :"+Integer.toString(EA)+", "+"set MBR to :"+Integer.toString(cu.fetchFromMemory(EA))+", "+"Set Index Register"+Integer.toString(indRegister)+" to "+Integer.toString(cu.fetchFromMemory(EA)));
			registers.setIndexRegister(indRegister, cu.fetchFromMemory(EA));
		}
		else if(ins==42){
			panel.txtrTtg.setText("Get the value in index register"+Integer.toString(indRegister)+" : "+Integer.toString(registers.getIndexRegister(indRegister))+" and store it into Memory Address"+ Integer.toString(EA));
			cu.storeInMemory(EA, registers.getIndexRegister(indRegister));
		}
		else if (ins==0){
			panel.txtrTtg.setText("STOP RUNNING");
		}
	}
}
