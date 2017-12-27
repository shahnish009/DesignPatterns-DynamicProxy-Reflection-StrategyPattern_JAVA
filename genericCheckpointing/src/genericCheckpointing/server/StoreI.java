package genericCheckpointing.server;

import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;

public interface StoreI extends StoreRestoreI {
    void writeObj(MyAllTypesFirst aRecord, String wireFormat);
    void writeObj(MyAllTypesSecond bRecord, String wireFormat);
}
