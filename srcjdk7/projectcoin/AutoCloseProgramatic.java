package projectcoin;

public class AutoCloseProgramatic {
	public static void main(String[] args) throws Exception {
//		testTryWithResource();
		testTryCatch();
	}

	private static void testTryWithResource() throws Exception {
		try (NaughtyResource naughty = new NaughtyResource()){
			naughty.doNothingGood();
		}
	}

	private static void testTryCatch() throws Exception {
		NaughtyResource naughty=null;
		try {
			naughty = new NaughtyResource();
			naughty.doNothingGood();
			
		}catch(Exception e){
		}finally{
			naughty.close();
			
		}
		
	}

}

class NaughtyResource implements AutoCloseable {

	@Override
	public void close() throws Exception {
		throw new UnsupportedOperationException("Not supported yet.");

	}

	public void doNothingGood() {
		throw new RuntimeException("Nothing good can come of this.");
	}

}