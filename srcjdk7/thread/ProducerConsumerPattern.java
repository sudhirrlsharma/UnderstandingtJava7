package thread;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumerPattern {

    public static void main(String args[]){
  
     //Creating shared object
     TransferQueue<Integer> sharedQueue = new LinkedTransferQueue<Integer>();
 
     //Creating Producer and Consumer Thread
     Thread prodThread = new Thread(new Producer(sharedQueue));
     Thread consThread = new Thread(new Consumer(sharedQueue));

     //Starting producer and Consumer thread
     prodThread.start();
     consThread.start();
    }


}

//Producer Class in java
class Producer implements Runnable {

  private final TransferQueue<Integer> sharedQueue;

  public Producer(TransferQueue<Integer> sharedQueue) {
      this.sharedQueue = sharedQueue;
  }

  @Override
  public void run() {
      for(int i=0; i<10; i++){
          try {
              System.out.println("Produced: " + i);
              sharedQueue.transfer(i);
              Thread.sleep(1000);
          } catch (InterruptedException ex) {
              Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
  }

}


//Consumer Class in Java
class Consumer implements Runnable{

  private final TransferQueue<Integer> sharedQueue;

  public Consumer (TransferQueue<Integer> sharedQueue) {
      this.sharedQueue = sharedQueue;
  }

  @Override
  public void run() {
      while(true){
          try {
/*              synchronized (this) {
        	  if(sharedQueue.isEmpty()){
        	  this.wait(400);
        	  }
*/ 
        	  System.out.println("Consumed: "+ sharedQueue.take());
         } catch (InterruptedException ex) {
              Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
  }
}


