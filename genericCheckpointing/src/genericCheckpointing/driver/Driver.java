
package genericCheckpointing.driver;

import java.util.InputMismatchException;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;
import java.lang.RuntimeException;
import java.util.Vector;

import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;


public class Driver {

	public static void main(String[] args) {

		String mode = null;
		int N = -1;
		String ioFile = null;

		try {
			if (3 == args.length) {
				mode = args[0];
				if (!(mode.equals("serdeser") || mode.equals("deser"))) {
					throw new RuntimeException("mode can only be 'serdeser' or 'deser'!");
				}
				N = Integer.parseInt(args[1]);
				ioFile = args[2];
			} else {
				throw new RuntimeException("Invalid number of arguments. Please enter 3 arguments");
			}
		} catch (Exception e) {
			System.err.println("exception occurred while parsing arguments");
			e.printStackTrace();
			System.exit(1);
		}

		ProxyCreator pc = new ProxyCreator();
		StoreRestoreHandler srh = new StoreRestoreHandler();

		StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(new Class[] { StoreI.class, RestoreI.class }, srh);
		
		srh.setFile(ioFile);

		MyAllTypesFirst myFirst = null;
		MyAllTypesSecond mySecond = null;

		Vector<SerializableObject> serdeser = new Vector<>();
		Vector<SerializableObject> deser = new Vector<>();

		if (mode.equals("serdeser")) {
			
			try {
				srh.openWrite();
			} catch (FileNotFoundException e) {
				System.err.println("file not found\n" + e);
				e.printStackTrace();
				System.exit(1);
			}
			
			for (int i = 0; i < N; i++) {

				myFirst = new MyAllTypesFirst((i + 1) * 50, (i + 1) * 100, (long)((i + 1) * 50000), (long)((i + 1) * 100000), "design patterns" + String.valueOf((char)(i+68)), true);
				mySecond = new MyAllTypesSecond((double)((i + 1) * 50.0001), (double)((i + 1) * 100.0001), (float)((i + 1) * 10.5), (short)((i + 1) * 1000), (char)(i+68));

				serdeser.addElement(myFirst);
				serdeser.addElement(mySecond);

				((StoreI) cpointRef).writeObj(myFirst, "XML");
				((StoreI) cpointRef).writeObj(mySecond, "XML");
			}
			
			try {
				srh.closeFile();
			} catch (FileNotFoundException e) {
				System.err.println("file not found\n" + e);
				e.printStackTrace();
				System.exit(1);
			}
		}
		
		try {
			srh.openRead();
		} catch (FileNotFoundException e) {
			System.err.println("file not found\n" + e);
			e.printStackTrace();
			System.exit(1);
		}

		SerializableObject myRecordRet = null;
		
		for (int j = 0; j < 2 * N; j++) {

			myRecordRet = ((RestoreI) cpointRef).readObj("XML");
			deser.addElement(myRecordRet);
		}

		try {
			srh.closeFile();
		} catch (FileNotFoundException e) {
			System.err.println("file not found\n" + e);
			e.printStackTrace();
			System.exit(1);
		}
		
		if (mode.equals("serdeser")) {
			int counter = 0;
			for (int j = 0; j < 2 * N; j++) {
				if (!(serdeser.get(j).equals(deser.get(j)))) {counter++;}
			}
			System.out.println(String.valueOf(counter) + " mismatched objects");
		}
		
		if (mode.equals("deser")) {
			for (int j = 0; j < 2 * N; j++) {
				System.out.println("\nObject: " + String.valueOf(j + 1));
				try {
					System.out.println(deser.get(j).toString());
				} catch (NullPointerException e) {
					System.err.println("File may be empty\n" + e);
					e.printStackTrace();
					System.exit(1);
				}
			}
		}
	}
}
