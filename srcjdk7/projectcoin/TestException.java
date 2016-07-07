package projectcoin;


/**
 * 
 * Language Changes – Multiple Exception Handling
 *
 */
public class TestException {

	public void testMultiCatchException() {
		try {
			test1();
			test2();
		} catch (Exception1 | Exception2 e) {
			System.out.println(" exception occured " + e.getMessage());
		}
	}

	class Exception1 extends Exception {
		Exception1(String message){
			super(message);
			
		}
		

	}

	class Exception2 extends Exception {

	}

	public void test1() throws Exception1 {
		throw new Exception1("my excepton");
	}

	public void test2() throws Exception2 {

	}
	
	public void test3() throws Exception1,Exception2  {
		try {
			test1();
			test2();
		} catch (Exception e) {
			throw e;
/*			if(e instanceof Exception1){
				throw new Exception1("BatterMessage");
			}
			if(e instanceof Exception2){
				throw new Exception2();
			}
*/		}

	}


}
