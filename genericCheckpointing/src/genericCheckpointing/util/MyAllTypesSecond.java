package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject {
	
	private double myDoubleT = 0, myOtherDoubleT = 0;
	private float myFloatT = 0;
	private short myShortT = 0;
	private char myCharT = 'z';
	
	public MyAllTypesSecond() {}
	public MyAllTypesSecond (double d, double od, float f, short s, char c) {
		myDoubleT = d;
		myOtherDoubleT = od;
		myFloatT = f;
		myShortT = s;
		myCharT = c;
	}
	
	public void setmyDoubleT (double myDoubleTIn) {
		myDoubleT = myDoubleTIn;
	}
	
	public double getmyDoubleT() {
		return myDoubleT;
	}
	
	public void setmyOtherDoubleT (double myOtherDoubleTIn) {
		myOtherDoubleT = myOtherDoubleTIn;
	}
	
	public double getmyOtherDoubleT() {
		return myOtherDoubleT;
	}
	
	public void setmyFloatT (float myFloatTIn) {
		myFloatT = myFloatTIn;
	}
	
	public float getmyFloatT() {
		return myFloatT;
	}
	
	public void setmyShortT (short myShortTIn) {
		myShortT = myShortTIn;
	}
	
	public short getmyShortT() {
		return myShortT;
	}
	
	public void setmyCharT (char myCharTIn) {
		myCharT = myCharTIn;
	}
	
	public char getmyCharT() {
		return myCharT;
	}
	
	@Override
	public boolean equals (Object obj) {
		boolean returnValue = false;
		if (obj instanceof MyAllTypesSecond) {
			MyAllTypesSecond f = (MyAllTypesSecond) obj;
			returnValue = (myDoubleT == f.getmyDoubleT()) && (myOtherDoubleT == f.getmyOtherDoubleT()) && 
							(myFloatT == f.getmyFloatT()) && (myShortT == f.getmyShortT()) && 
							(myCharT == f.getmyCharT());
		}
		return returnValue;
	}
	
	@Override
	public int hashCode() {
		String s = String.valueOf(myDoubleT) + String.valueOf(myOtherDoubleT) + 
					String.valueOf(myFloatT) + String.valueOf(myShortT) +
					String.valueOf(myCharT);
		
		return s.hashCode();
	}
	
	@Override
	public String toString() {
		return "myDoubleT: " + myDoubleT + " myOtherDoubleT: " + myOtherDoubleT +
				" myFloatT: " + myFloatT + " myShortT: " + myShortT + " myCharT: " + myCharT;
	}
}