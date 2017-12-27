package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.Method;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;

public class XMLDeserialization implements DeserStrategy {

	private FileProcessor fp = null;

	public XMLDeserialization(FileProcessor fpI) {
		fp = fpI;
	}

	public Object processInput() {

		String line = fp.readLine();
		Object retObj = null;
		Class<?> cl = null;
		Method m = null;

		while (line != null) {

			if (line.equals("<DPSerialization>")) {

			} else if (line.contains("<complexType xsi")) {
				String clName = line.substring(line.indexOf("=") + 2, line.indexOf(">") - 1);
				try {
					cl = Class.forName(clName);
					retObj = cl.newInstance();
				} catch (Exception e) {
					System.err.println("class cannot be called\n" + e);
					e.printStackTrace();
					System.exit(1);
				}
			} else if (line.contains("xsi:type=\"xsd:")) {
				String type = line.substring(1, line.indexOf("x") - 1);
				String value = line.substring(line.indexOf(">") + 1, line.indexOf("/") - 1);

				String mName = "set" + type;

				Object[] params = new Object[1];

				try {
					if (type.toLowerCase().contains("int")) {
						params[0] = Integer.parseInt(value);
						m = cl.getMethod(mName, int.class);
					} else if (type.toLowerCase().contains("long")) {
						params[0] = Long.parseLong(value);
						m = cl.getMethod(mName, long.class);
					} else if (type.toLowerCase().contains("string")) {
						params[0] = value;
						m = cl.getMethod(mName, String.class);
					} else if (type.toLowerCase().contains("bool")) {
						params[0] = Boolean.valueOf(value);
						m = cl.getMethod(mName, boolean.class);
					} else if (type.toLowerCase().contains("double")) {
						params[0] = Double.parseDouble(value);
						m = cl.getMethod(mName, double.class);
					} else if (type.toLowerCase().contains("float")) {
						params[0] = Float.parseFloat(value);
						m = cl.getMethod(mName, float.class);
					} else if (type.toLowerCase().contains("short")) {
						params[0] = Short.parseShort(value);
						m = cl.getMethod(mName, short.class);
					} else if (type.toLowerCase().contains("char")) {
						params[0] = value.charAt(0);
						m = cl.getMethod(mName, char.class);
					}

					m.invoke(retObj, params);
				} catch (Exception e) {
					System.err.println("method cannot be called\n" + e);
					e.printStackTrace();
					System.exit(1);
				}

			} else if (line.equals("</complexType>")) {

			} else if (line.equals("</DPSerialization>")) {
				return (SerializableObject) retObj;
			}

			line = fp.readLine();
		}

		return null;
	}

}
