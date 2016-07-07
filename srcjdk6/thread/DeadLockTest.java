package thread;

import java.math.BigDecimal;

public class DeadLockTest {

	static class Account{
		private BigDecimal amount=new BigDecimal(100);
		
		private synchronized BigDecimal getAmount(){
			return this.amount;
		}
		
		
		void  deposit(Account from){
			synchronized (from) {
				this.amount=this.amount.add(from.getAmount().divide(BigDecimal.TEN));	
			}
			
			
		}
		
		void  withdrow(Account from){
			synchronized (from) {
				
			}
			 
		}
		
	}
	
	static class TransferSerice{
		Account from;
		Account to;
		
		TransferSerice(Account from, Account to){
			this.from=from;
			this.to=to;
		}
		
		public  void withDrow(){
			System.out.println("#######withDrow" + Thread.currentThread().getName());
			System.out.println("------------------From Balence "  + this.from.getAmount());
			System.out.println("------------------To Balence "  + this.to.getAmount());
			synchronized (this.to) {
				this.to.withdrow(this.from);
			}
				
				
			System.out.println("------------------Transfer complete  withDrow" + Thread.currentThread().getName());
			System.out.println("------------------From Balence " + this.from.getAmount());
			System.out.println("------------------To Balence " + this.to.getAmount());				
				

			
		}
		

		public  void deposit(){
			System.out.println("#######deposit" + Thread.currentThread().getName());
			System.out.println("------------------From Balence "  + this.from.getAmount());
			System.out.println("------------------To Balence "  + this.to.amount);
			
			synchronized (from) {
				this.from.deposit(this.to);
				
			}

					
			System.out.println("------------------Transfer complete deposit " + Thread.currentThread().getName());
				System.out.println("------------------From Balence "  + this.from.getAmount());
				System.out.println("------------------To Balence "  + this.to.getAmount());
				
				

			
		}
	}
	
	static class DeadLockwithDrow implements Runnable{
		TransferSerice service;
		int amount;
		
		DeadLockwithDrow(TransferSerice service, int amt){
			this.service=service;
			this.amount=amt;
			
		}
		@Override
		public void run() {
//			pause(500);
			for(int i=0; i<3; i++){
				this.service.withDrow();
				
			}
			
		}
		private void pause(int time) {
			try {
				int rend = (int )(Math. random() * 100 + 1);
				System.out.println("Rendom number is " + rend);
				Thread.sleep( rend);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	static class DeadLockDiposit implements Runnable{
		TransferSerice service;
		int amount;
		
		DeadLockDiposit(TransferSerice service, int amt){
			this.service=service;
			this.amount=amt;
			
		}
		@Override
		public void run() {
//			pause(500);
			for(int i=0; i<3; i++){
				this.service.deposit();
			
			}
			
		}
		private void pause(int time) {
			try {
				int rend = (int )(Math.random() * 100 + 1);
				System.out.println("Rendom number is " + rend);
				Thread.sleep( rend);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		Account to = new Account();
		Account from = new Account();
		 TransferSerice ts = new TransferSerice(from, to);
		 TransferSerice ts2 = new TransferSerice(from, to);
		
		
		//for(int i=0; i< 3; i++){
			Thread t1 = new Thread(new DeadLockwithDrow(ts, 300));
			Thread t2 = new Thread(new DeadLockDiposit(ts2, 300));

			t2.start();
			t1.start();
		//}
		System.out.println("Thread end");
	}
}

