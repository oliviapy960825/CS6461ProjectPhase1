package CPUAttributes;

import java.util.LinkedList;
import java.util.Queue;
import CPUAttributes.CU;
import InstructionProcessing.MachineFaultException;

public class Cache {
//This class is for Cache, which is the intermediary part between memory and registers and/or other components in CPU
//some attributes of Cache: it's implemented with FIFO (or queue algorithm, and in order to save both the "tag" (or address)
//and the value of the value extracted/to be extracted from memory, we decided that we would use array (with the first element
//being the address and the second element being the value) to implement the queue,since our memory is expanded to 4096 words, 
//we decided to have 32 cache lines
//
	CU cu;
//how to demonstrate cache works--save the work flow of cache to a file
	public Cache(){
		Queue<int[]> cache = new LinkedList<>();
		CU cu = new CU();
	}
	public void addToCache(int address, Queue<int[]> cache){
		int value=cu.fetchFromMemory(address);
		int[] cacheLine=new int[2];
		cacheLine[0]=address;
		cacheLine[1]=value;
		if(cache.size()==32){
			popFromCache(cache);
			cache.add(cacheLine);
		}
		else{
			cache.add(cacheLine);
		}
	}//we check the cache to see if there are already 32 cache lines, and if so, we pop the first cache line and
	//add the new cache line in the end of the queue
	
	public void popFromCache(Queue<int[]> cache){
		int [] removable=cache.remove();
		System.out.print("The address of the just removed element is: "+ removable[0]+" ,and the value is: "+removable[1]);
	}
	public int getSize(Queue<int[]> cache){
		return cache.size();
	}
	public void peekFromCache(Queue<int[]> cache){
		int [] peek =cache.remove();
		System.out.print("The address of the first element is: "+ peek[0]+" ,and the value is: "+peek[1]);
	}
}
