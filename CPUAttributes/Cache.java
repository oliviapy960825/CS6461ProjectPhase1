package CPUAttributes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;
import CPUAttributes.CU;
import FrontPanel.UserInterface;
import InstructionProcessing.MachineFaultException;

public class Cache {
//This class is for Cache, which is the intermediary part between memory and registers and/or other components in CPU
//some attributes of Cache: it's implemented with FIFO (or queue algorithm, and in order to save both the "tag" (or address)
//and the value of the value extracted/to be extracted from memory, we decided that we would use array (with the first element
//being the address and the second element being the value) to implement the queue,since our memory is expanded to 4096 words, 
//we decided to have 32 cache lines
//
	private static CU cu;
	PrintWriter writer;
	private static UserInterface userInterface;
//how to demonstrate cache works--save the work flow of cache to a file
	public void setUserInterface(UserInterface userInterface){
		Cache.userInterface=userInterface;
	}
	public Cache(){
		Queue<int[]> cache = new LinkedList<>();
		File newTextFile = new File("cache_work_flow.txt");
	}
	public void setCU(CU cu){
		Cache.cu=cu;
	}
	public void addToCache(int address, Queue<int[]> cache){
		
		
		
		cu.setMARValue(address);
		userInterface.setMARText(address);
		String str="SET MAR TO: "+Integer.toString(address);
		try {
			FileWriter fw=new FileWriter("cache_work_flow.txt");
			fw.write(str);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int value=cu.memory.fetchFromMemory(address);
		cu.setMBRValue(value);
		str="SET MBR TO: "+Integer.toString(value);
		try {
			FileWriter fw=new FileWriter("cache_work_flow.txt");
			fw.write(str);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userInterface.setMBRText(value);
		int[] cacheLine=new int[2];
		cacheLine[0]=address;
		cacheLine[1]=value;
		if(cache.size()==32){
			popFromCache(cache);
			cache.add(cacheLine);
			str="Pop the first cache line:"+Integer.toString(cache.remove()[0])+" : "+Integer.toString(cache.remove()[1])+" and add new cache line: "+Integer.toString(cacheLine[0])+" : "+Integer.toString(cacheLine[1]);
			try {
				FileWriter fw=new FileWriter("cache_work_flow.txt");
				fw.write(str);
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			cache.add(cacheLine);
			str="Add new cache line: "+Integer.toString(cacheLine[0])+" : "+Integer.toString(cacheLine[1]);
			try {
				FileWriter fw=new FileWriter("cache_work_flow.txt");
				fw.write(str);
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}//we check the cache to see if there are already 32 cache lines, and if so, we pop the first cache line and
	//add the new cache line in the end of the queue
	
	public void popFromCache(Queue<int[]> cache){
		int [] removable=cache.remove();
		System.out.print("The address of the just removed element is: "+ removable[0]+" ,and the value is: "+removable[1]);
		String str="Pop the first cache line:"+Integer.toString(removable[0])+" : "+Integer.toString(removable[1]);
		try {
			FileWriter fw=new FileWriter("cache_work_flow.txt");
			fw.write(str);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getSize(Queue<int[]> cache){
		String str="get current size of the cache which is : "+Integer.toString(cache.size());
		try {
			FileWriter fw=new FileWriter("cache_work_flow.txt");
			fw.write(str);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cache.size();
	}
	public void peekFromCache(Queue<int[]> cache){
		int [] peek =cache.remove();
		System.out.print("The address of the first element is: "+ peek[0]+" ,and the value is: "+peek[1]);
		String str="get the first cache line which is : "+Integer.toString(peek[0])+" : "+Integer.toString(peek[1]);
		try {
			FileWriter fw=new FileWriter("cache_work_flow.txt");
			fw.write(str);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
