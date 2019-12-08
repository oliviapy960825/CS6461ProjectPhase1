package Pipelining;

import java.util.concurrent.SynchronousQueue;

public class Fetch implements Runnable{
    
SynchronousQueue<Integer> IF_ID;
    
    public Fetch (SynchronousQueue<Integer> IF_ID){
        this.IF_ID = IF_ID;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("Thread ID is: " + Thread.currentThread().getId() + " - Stage Fetch Starts");
        try {
            this.IF_ID.put(99);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Thread ID is: " + Thread.currentThread().getId() + " - Stage Fetch Ends");
    }

}
