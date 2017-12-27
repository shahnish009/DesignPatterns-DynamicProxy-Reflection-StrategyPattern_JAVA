package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.SerializableObject;

public interface SerStrategy {
	public void processInput (SerializableObject obj);
}