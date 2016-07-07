package projectcoin;

public class BinaryLiterals {
	public static void main(String[] args) {
		int mask = 0b101010101010; //2730
		if(mask==2730){
			System.out.println("they both are same");
		}
		System.out.println(mask);
		
		long aLong = 0b1010000101000101101000010100010110100001010001011010000101000101L;//
		System.out.println(aLong);
		
		short[] HAPPY_FACE = {
				(short)0b0000011111100000,
				(short)0b0000100000010000,
				(short)0b0001000000001000,
				(short)0b0010000000000100,
				(short)0b0100000000000010,
				(short)0b1000011001100001,
				(short)0b1000011001100001,
				(short)0b1000000000000001,
				(short)0b1000000000000001,
				(short)0b1001000000001001,
				(short)0b1000100000010001,
				(short)0b0100011111100010,
				(short)0b0010000000000100,
				(short)0b0001000000001000,
				(short)0b0000100000010000,
				(short)0b0000011111100000, 
			};
		
		for(int i=0;i<HAPPY_FACE.length;i++){
			System.out.println(HAPPY_FACE[i]);	
		}
		
	}

}
