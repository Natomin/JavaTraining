package jpl.ch20.ex07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Attr {
	private final String name;
	private Object value;
	private String valueType;

	public Attr(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	public Attr(String file) throws IOException {
		InputStream fin = new FileInputStream(file);
		DataInputStream in = new DataInputStream(fin);
		name = in.readUTF();
		valueType = in.readUTF();
		if (valueType.equals("Integer")) {
			value = in.readInt();
		} else if (valueType.equals("Double")) {
			value = in.readDouble();
		} else if (valueType.equals("Byte")) {
			value = in.readByte();
		} else if (valueType.equals("Long")) {
			value = in.readLong();
		} else if (valueType.equals("Float")) {
			value = in.readFloat();
		} else if (valueType.equals("Short")) {
			value = in.readShort();
		} else if (valueType.equals("Character")) {
			value = in.readChar();
		} else if (valueType.equals("Boolean")) {
			value = in.readBoolean();
		} else {
			System.out.println("サポートされていないデータ型です");
		}
		in.close();
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String toString() {
		return name + "='" + value + "'";
	}

	public void outputData(String file) throws IOException {
		OutputStream fout = new FileOutputStream(file);
		DataOutputStream out = new DataOutputStream(fout);
		valueType = value.getClass().getSimpleName().toString();
		out.writeUTF(getName());
		out.writeUTF(valueType);
		if (valueType.equals("Integer")) {
			out.writeInt((int) getValue());
		} else if (valueType.equals("Double")) {
			out.writeDouble((double) getValue());
		} else if (valueType.equals("Byte")) {
			out.writeByte((byte) getValue());
		} else if (valueType.equals("Long")) {
			out.writeLong((long) getValue());
		} else if (valueType.equals("Float")) {
			out.writeFloat((float) getValue());
		} else if (valueType.equals("Short")) {
			out.writeShort((short) getValue());
		} else if (valueType.equals("Character")) {
			out.writeChar((char) getValue());
		} else if (valueType.equals("Boolean")) {
			out.writeBoolean((boolean) getValue());
		} else {
			System.out.println("サポートされていないデータ型です");
		}
		out.close();
	}

}
