package WorkFlow;

import CPU.CU;
import CPU.Register;

public class EffectiveAddress {
	int r;
	int ix;
	int i;
	int address;
	Register register;
	CU cu;
	
	public EffectiveAddress(int r, int ix, int i, int address, Register register, CU cu){
		this.r=r;
		this.ix=ix;
		this.i=i;
		this.address=address;
		this.register=register;
		this.cu=cu;
	}
	public int calculateEffectiveAddress(int r, int ix, int i, int address, Register register, CU cu){
		if(i==0){//no indirect addressing
			if(ix==0){
				return address;
			}
			else{
				if(checkAddress((address+register.getValue(ix)),cu)==1){
					return (address+register.getValue(ix));
				}
				
			}
		}
		else{
			if(ix==0){
				if(checkAddress(address,cu)==1){
					register.setMAR(address);
					register.setMBR(register.getValue(register.getMAR()));
					return (register.getMBR());
				}
			}
			else{
				if(checkAddress((address+register.getValue(ix)),cu)==1){
					int inner=register.getValue(ix)+address;
					register.setMAR(inner);
					register.setMBR(register.getValue(register.getMAR()));
					return (register.getMBR());
				}
			}
		}
	}
	public static int checkAddress(int address, CU cu) throws MachineException{//this is to check if the 
		if(register.getValue(address)==null){//in this case there's no value in the address so we throw exceptions
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
