package WorkFlow;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import CPU;

public class WorkFlow {
	public int PC=0;
	public int MAR;
	public int MBR;
	public int IR;
	public int IX1, IX2, IX3;
	public int R0,R1,R2,R3;
	/*Divide it into two cases, 
	 * 1.one case is for the user to read in the pre-programmed file directly 
	 * from the computer (divide it further into step-by-step running or running 
	 * the whole process by one click)
	 * 2. the second case is for the user to type in instructions to be run 
	 * */
	boolean isReadFile;//connect to the "IPL" button on the user panel. If the "IPL" button is clicked, set this to True, otherwise it's false
	boolean isStep;//connect to the "
	public CPU cpu;
	private Scanner input;
	private PrintWriter output;
	public WorkFlow(CPU cpu,InputStream memInputStream, OutputStream memOutputStream){
		this.cpu=cpu;
		this.input = new Scanner(memInputStream);
		this.output = new PrintWriter(memOutputStream);
	}
	public void checkOption(){
	if(isReadFile){
		if(isStep){
			//in this case user chose to read in pre-programmed machine code file
			//to run and the running option is step by step 
	
		}
		else{
			//in this case the user chose to read in pre-programmed machine code file
			//and run the whole file with one click
		}
	}
	else{
		//in this case the user is typing in the instruction to be run
		
		}
	}
	public void assignAddressToPC(){
		PC++;
	}
	public void AssignMAR(){
		MAR=PC;
	} 
	public void FetchFromMemory(int address){
		//fetch the content stored at the address of the MAR from memory
		output.println("r:" + address + ",-1");
		output.flush();
	}
	public void PCincrement(){
		PC+=0001;
	}
	public int effectiveAddress(){
		
	}
	public static void main(String[] args)
	{
	}
}
