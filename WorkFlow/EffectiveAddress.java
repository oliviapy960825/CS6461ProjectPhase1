package WorkFlow;

import CPU.CU;
import CPU.Registers;

public class EffectiveAddress {//still working on this class. Need to be changed 
	//to only include ix,i, and address from the instruction
	int ix;
	int i;
	int address;
	Registers registers;
	CU cu;
	
	public EffectiveAddress(int ix, int i, int address, CU cu, Registers registers){
		this.ix=ix;
		this.i=i;
		this.address=address;
		this.cu=cu;
		this.registers=registers;
	}
	public int calculateEffectiveAddress(int ix, int i, int address, CU cu, Registers registers) throws MachineException{
		if(i==0){//no indirect addressing
			if(ix==0){
				return address;
			}
			else{
				if(checkAddress((address+(registers.getIndexRegister(ix))),cu)==1){
					return (address+registers.getIndexRegister(ix));
				}
				
			}
		}
		else{
			if(ix==0){
				if(checkAddress(address,cu)==1){
					registers.setMAR(address);
					registers.setMBR(cu.fetchFromMemory(registers.getMAR()));
					return (registers.getMBR());
				}
			}
			else{
				if(checkAddress((address+registers.getIndexRegister(ix)),cu)==1){
					int inner=registers.getIndexRegister(ix)+address;
					registers.setMAR(inner);
					registers.setMBR(cu.fetchFromMemory(registers.getMAR()));
					return (registers.getMBR());
				}
			}
		}
		return 0;
	}
	public static int checkAddress(int address, CU cu) throws MachineException{//this is to check if the 
		if(cu.fetchFromMemory(address)==-999){//in this case the address is invalid so we throw illegal memory reservation error
			throw new MachineException(Constants.MemoryErrorCode.ILL_MEM_RSV.getErrorID(),
					Constants.MemoryErrorCode.ILL_MEM_RSV.getErrorMessage());
		}
		else if(address>cu.getCurrentMemory()){//in this case the address is beyond current memory
			throw new MachineException(Constants.MemoryErrorCode.ILL_MEM_BYD.getErrorID(),
					Constants.MemoryErrorCode.ILL_MEM_BYD.getErrorMessage());
		}
		else{//in this case there's no error regarding memory so we return 1
			return 1;
		}
	}
}
