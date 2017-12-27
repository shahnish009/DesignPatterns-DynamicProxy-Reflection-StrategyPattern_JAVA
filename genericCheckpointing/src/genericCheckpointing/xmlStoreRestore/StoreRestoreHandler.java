package genericCheckpointing.xmlStoreRestore;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationHandler;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;

public class StoreRestoreHandler implements InvocationHandler {
	
	private FileProcessor fp = null;
	
	@Override
	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable{
		
		String meth = m.getName();

		if(meth.equals("writeObj")) {
			args[0].getClass();
			String format = args[1].toString();
			if(format.equals("XML")) {
				serializeData((SerializableObject)args[0], new XMLSerialization(fp));
			}
			return null;
		} else if(meth.equals("readObj")) {
			Object obj = null;
			String format = args[0].toString();
			if(format.equals("XML")) {
				obj = deserializeData(new XMLDeserialization(fp));
			}
			return obj;
		}
		return null;
	}

	public void serializeData(SerializableObject sObject, SerStrategy sStrategy) {
		sStrategy.processInput(sObject);
    }
	
	public Object deserializeData(DeserStrategy dStrategy) {
		return dStrategy.processInput();
	}
	
	public void setFile(String fname) {
		fp = new FileProcessor (fname);
	}
	
	public void openRead() throws FileNotFoundException {
		fp.openRead();
	}
	
	public void openWrite() throws FileNotFoundException {
		fp.openWrite();
	}
	
	public void closeFile() throws FileNotFoundException {
		fp.closeFile();
	}
}
