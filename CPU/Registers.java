package CPU;

public class Registers{//This Class is for the whole Registers category containing multiple different registers
	int r0;
	int r1;
	int r2;
	int r3;
	int x1;
	int x2;
	int x3;
	int pc;
	int ir;
	int mar;
	int mbr;
	public Registers(int r0, int r1, int r2, int r3, int x1, int x2, int x3, int pc, int ir, int mar, int mbr){
		//constructor for all the registers we need to initialize, could have more constructors not initializing
		//all the registers at once as well
		this.r0=r0;
		this.r1=r1;
		this.r2=r2;
		this.r3=r3;
		this.x1=x1;
		this.x2=x2;
		this.x3=x3;
		this.pc=pc;
		this.ir=ir;
		this.mar=mar;
		this.mbr=mbr;
	}
	//Register class should have functions getValue(), getMAR(), getMBR(), setMAR(), setMBR() 
	public int getR0(){//get the content stored in register r0
		return this.r0;
	}
	public int getR1(){
		return this.r1;
	}
	public int getR2(){
		return this.r2;
	}
	public int getR3(){
		return this.r3;
	}
	public int getX1(){
		return this.x1;
	}
	public int getX2(){
		return this.x2;
	}
	public int getX3(){
		return this.x3;
	}
	public int getPC(){
		return this.pc;
	}
	public int getIR(){
		return this.ir;
	}
	public int getMAR(){
		return this.mar;
	}
	public int getMBR(){
		return this.mbr;
	}
	public void setR0(int newR0){
		this.r0=newR0;
	}
	public void setR1(int newR1){
		this.r1=newR1;
	}
	public void setR2(int newR2){
		this.r2=newR2;
	}
	public void setR3(int newR3){
		this.r3=newR3;
	}
	public void setX1(int newX1){
		this.x1=newX1;
	}
	public void setX2(int newX2){
		this.x2=newX2;
	}
	public void setX3(int newX3){
		this.x3=newX3;
	}
	public void setPC(int newPC){
		this.pc=newPC;
	}
	public void setIR(int newIR){
		this.ir=newIR;
	}
	public void setMAR(int newMAR){
		this.mar=newMAR;
	}
	public void setMBR(int newMBR){
		this.mbr=newMBR;
	}
	public int getIndexRegister(int address){
		if(address==1){
			return this.x1;
		}
		else if(address==2){
			return this.x2;
		}
		else if(address==3){
			return this.x3;
		}
		return 0;
	}
	public int getGeneralRegister(int address){
		if(address==0){
			return this.r0;
		}
		else if(address==1){
			return this.r1;
		}
		else if(address==2){
			return this.r2;
		}
		else if(address==3){
			return this.r3;
		}
		return 0;
	}
}
