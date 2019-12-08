package Pipelining;

import java.util.concurrent.SynchronousQueue;

public class WriteBack implements Runnable{
    
    SynchronousQueue<Integer> MEM_WB;
    
    public WriteBack(SynchronousQueue<Integer> MEM_WB){
        this.MEM_WB = MEM_WB;
    }
    
    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("Thread ID is: " + Thread.currentThread().getId() + " - Stage Writeback Starts");
        try {
            int data = this.MEM_WB.take();
            System.out.println("Thread ID is: " + Thread.currentThread().getId() + " - get data: " + data);
            
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Thread ID is: " + Thread.currentThread().getId() + " - Stage Writeback Ends");
    }

}
