package genericCheckpointing.util;

public class MyAllTypesFirst extends SerializableObject {
	
	private int myInt = 0, myOtherInt = 0;
	private long myLong = 0, myOtherLong = 0;
	private String myString = "";
	private boolean myBool = false;
	
	public MyAllTypesFirst() {}
	public MyAllTypesFirst (int i, int oi, long l, long ol, String s, boolean b) {
		myInt = i;
		myOtherInt = oi;
		myLong = l;
		myOtherLong = ol;
		myString = s;
		myBool = b;
	}
	
	public void setmyInt (int myIntIn) {
		myInt = myIntIn;
	}
	
	public int getmyInt() {
		return myInt;
	}
	
	public void setmyOtherInt (int myOtherIntIn) {
		myOtherInt = myOtherIntIn;
	}
	
	public int getmyOtherInt() {
		return myOtherInt;
	}
	
	public void setmyLong (long myLongIn) {
		myLong = myLongIn;
	}
	
	public long getmyLong() {
		return myLong;
	}
	
	public void setmyOtherLong (long myOtherLongIn) {
		myOtherLong = myOtherLongIn;
	}
	
	public long getmyOtherLong() {
		return myOtherLong;
	}
	
	public void setmyString (String myStringIn) {
		myString = myStringIn;
	}
	
	public String getmyString() {
		return myString;
	}
	
	public void setmyBool (boolean myBoolIn) {
		myBool = myBoolIn;
	}
	
	public boolean getmyBool() {
		return myBool;
	}
	
	@Override
	public boolean equals (Object obj) {
		boolean returnValue = false;
		if (obj instanceof MyAllTypesFirst) {
			MyAllTypesFirst f = (MyAllTypesFirst) obj;
			returnValue = (myInt == f.getmyInt()) && (myOtherInt == f.getmyOtherInt()) && 
							(myLong == f.getmyLong()) && (myOtherLong == f.getmyOtherLong()) && 
							(myString.equals(f.getmyString())) && (myBool == f.getmyBool());
		}
		return returnValue;
	}
	
	@Override
	public int hashCode() {
		String s = String.valueOf(myInt) + String.valueOf(myOtherInt) + 
					String.valueOf(myLong) + String.valueOf(myOtherLong) +
					myString + String.valueOf(myBool);
		
		return s.hashCode();
	}
	
	@Override
	public String toString() {
		return "myInt: " + myInt + " myOtherInt: " + myOtherInt +
				" myLong: " + myLong + " myOtherLong: " + myOtherLong + 
				" myString: " + myString + " myBool: " + myBool;
	}
}