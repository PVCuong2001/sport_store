package validate;

public class Myexception extends Exception {
	private String mess;
	public Myexception(String messx) {
		mess=messx;
	}
	@Override
	public String toString() {
		return mess;
	}
	
}
