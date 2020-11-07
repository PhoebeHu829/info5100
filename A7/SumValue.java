import java.util.Random;

public class SumValue {
	private static long cnt = 0;
	
	/*generate array of random numbers*/
	 static void generateRandomArray(int[] arr){
		 Random rand = new Random();
		 for(int i = 0; i < arr.length; i++) {
			 arr[i] = rand.nextInt();
		 }
		
	 }

	 /*get sum of an array using 4 threads*/
	 static long sum(int[] arr){
		 Thread t1 = new Thread(new Runnable() {
			 
			 @Override
			 public void run() {
				 for(int i = 0; i < 1000000; i++) {
					 cnt += arr[i];
				 }
			 }
		 });
		 
		 Thread t2 = new Thread(new Runnable() {
			 
			 @Override
			 public void run() {
				 for(int i = 1000000; i < 2000000; i++) {
					 cnt += arr[i];
				 }
			 }
		 });
		 
		 Thread t3 = new Thread(new Runnable() {
			 
			 @Override
			 public void run() {
				 for(int i = 2000000; i < 3000000; i++) {
					 cnt += arr[i];
				 }
			 }
		 });
		 
		 Thread t4 = new Thread(new Runnable() {
			 
			 @Override
			 public void run() {
				 for(int i = 3000000; i < 4000000; i++) {
					 cnt += arr[i];
				 }
			 }
		 });
		 
		 t1.start();
		 t2.start();
		 t3.start();
		 t4.start();
		 
		 try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return cnt;
	 }
	 
	 public static void main(String[] args){
		 int[] arr = new int[4000000];
		 generateRandomArray(arr);
		 long sum = sum(arr);
		 System.out.println("Sum: " + sum);
	 }
}
