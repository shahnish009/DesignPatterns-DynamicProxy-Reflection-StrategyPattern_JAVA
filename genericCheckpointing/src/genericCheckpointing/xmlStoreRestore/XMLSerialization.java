package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.Field;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class XMLSerialization implements SerStrategy {

	private FileProcessor fp = null;

	public XMLSerialization(FileProcessor fpI) {
		fp = fpI;
	}

	public void processInput(SerializableObject obj) {
		
		Class<?> cls = obj.getClass();
		
		fp.writeLine("<DPSerialization>\n");
		fp.writeLine(" <complexType xsi:type=\"" + cls.getCanonicalName().toString() + "\">\n");
		
		Field[] fieldlist = cls.getDeclaredFields();
		
		for (int i = 0; i < fieldlist.length; i++) {

	       Field fld = fieldlist[i];
	       Class fieldType = fld.getType();
	       String fieldName = fld.getName();
	       String methodName = "get" + fieldName;
	       Method getterMethod = null;
	       Object invokeRet = null;
	       try {
	    	   getterMethod = cls.getMethod(methodName);
	    	   invokeRet = getterMethod.invoke(obj);
	       } catch (Exception e) {
	    	   System.err.println(e + "\noccurred while invoking method");
	    	   e.printStackTrace();
	    	   System.exit(1);
	       }
	      
	       if (fieldType == int.class) {
	    	   if((int)invokeRet >= 10) {
	    		   fp.writeLine("  <" + fieldName + " xsi:type=\"xsd:" + "int" + "\">" + invokeRet.toString() + "</"+ fieldName + ">\n");
	    	   }
	       }
	       else if (fieldType == long.class) {
	    	   if((long)invokeRet >= (long)10) {
	    		   fp.writeLine("  <" + fieldName + " xsi:type=\"xsd:" + "long" + "\">" + invokeRet.toString() + "</"+ fieldName + ">\n");
	    	   }
	       }
	       else if (fieldType == String.class) {
	    	   if(!(String.valueOf(invokeRet).equals(""))) {
	    		   fp.writeLine("  <" + fieldName + " xsi:type=\"xsd:" + "string" + "\">" + invokeRet.toString() + "</"+ fieldName + ">\n");
	    	   }
	       }
	       else if (fieldType == boolean.class) {
	    	   if(Boolean.valueOf(invokeRet.toString()) == true) {
	    		   fp.writeLine("  <" + fieldName + " xsi:type=\"xsd:" + "boolean" + "\">" + invokeRet.toString() + "</"+ fieldName + ">\n");
	    	   }
	       }
	       else if (fieldType == double.class) {
	    	   if((double)invokeRet >= (double)10) {
	    		   fp.writeLine("  <" + fieldName + " xsi:type=\"xsd:" + "double" + "\">" + invokeRet.toString() + "</"+ fieldName + ">\n");
	    	   }
	       }
	       else if (fieldType == float.class) {
	    	   fp.writeLine("  <" + fieldName + " xsi:type=\"xsd:" + "float" + "\">" + invokeRet.toString() + "</"+ fieldName + ">\n");
	       }
	       else if (fieldType == short.class) {
	    	   fp.writeLine("  <" + fieldName + " xsi:type=\"xsd:" + "short" + "\">" + invokeRet.toString() + "</"+ fieldName + ">\n");
	       }
	       else if (fieldType == char.class) {
	    	   if(!((char)invokeRet == 'z')) {
	    		   fp.writeLine("  <" + fieldName + " xsi:type=\"xsd:" + "float" + "\">" + invokeRet.toString() + "</"+ fieldName + ">\n");
	    	   }
	       }
		}
		fp.writeLine(" </complexType>\n");
	    fp.writeLine("</DPSerialization>\n");
	}
}
