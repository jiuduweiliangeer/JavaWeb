package com.cdxy.iodemo;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * DataInputStream��DataOutputStream�����ࡣ��������������������з�����
 * @author  andyChen
 * @version 1.1, 13/11/10
 */
public class DataStreamTest {
	private final static byte[] byteArray = {0x61, 0x62, 0x63, 0x64, 0x65};
	private static byte[] buff = new byte[5];
	private static DataOutputStream dos;
	private static DataInputStream dis;
	
	/**
	 * DataOutputStream ���ԣ�����ͬ���͵�java��������д��out�С� 
	 */
	public static void testDataOutputStream() throws IOException{
		dos = new DataOutputStream(new FileOutputStream(new File("D:"+File.separator+"dos.txt")));
		dos.write(0x61);
		dos.write(byteArray, 0, 3);
		dos.write(byteArray);
		System.out.println(dos.size());
		dos.writeBoolean(false);
		System.out.println(dos.size());
		dos.writeByte(0x61);
		System.out.println(dos.size());
		dos.writeShort(65536);
		System.out.println(dos.size());
		dos.writeChar("c".charAt(0));
		dos.writeInt(214783647);
		System.out.println(dos.size());
		dos.writeFloat(5.12F);//һ��float��������ռ4���ֽ�
		dos.writeDouble(55.55);
		System.out.println(dos.size());
		dos.writeUTF("e");
		System.out.println(dos.size());
		dos.writeUTF("a�»�b");//�����һ������ռ3���ֽڡ����������ʾ�ַ������ȵ��ֽ�
		System.out.println(dos.size());
		dos.writeLong(1L);
 
		System.out.println("dos ���ֽ�����" + dos.size());
		dos.close();
	}
	/**
	 * 
	 * DataInputstream ���ԣ�����Ҫע�⣺��ô��DataOutputStreamд��ġ���Ҫ��ô������������ȡ���͵�˳��Ҫ��д�����͵�˳��һ�¡�
	 * ԭ����ΪDataoutputStream��java��������д��out��ʱ�����Ȱѻ�������ת����һ��˳����ֽ�д��ġ�
	 * DataInputStream��ȡ��Ҳ�Ǹ��ݲ�ͬ��ȡ������ȡ��ͬ�������ֽڡ���ת������Ӧ�����ͷ��ء�˳��һ��ת���ṹ�ͺܿ��ܲ���������Ҫ�ġ�
	 */
	public static void testDataInputStream() throws IOException{
		//������FileInputStreamΪ��������dis��
		dis = new DataInputStream(new FileInputStream(new File("D:\\dos.txt")));
		
       	System.out.println(byteToString((byte)dis.read()));
		//System.out.println(dis.readUnsignedByte());�����淽����ȡ���������Ƕ�ȡ�ֽڵ��޷�����ʽ��������ȡ��byte��ಹ�㷵��0 - 255 ֮���������
		System.out.println("��Ч�ֽ�����" + dis.available());
		dis.readFully(buff, 0, 3);
		printByteValue(buff);
		
		dis.readFully(buff);
		printByteValue(buff);
		
		System.out.println(dis.readBoolean());
		System.out.println(byteToString(dis.readByte()));
		System.out.println(dis.readShort());
//		System.out.println(dis.readUnsignedShort());��readUnsignedByte()��ͬ��ȡ�����޷��š����ҽ���ಹ�㡣
		System.out.println(dis.readChar());
		System.out.println(dis.readInt());
		System.out.println(dis.readFloat());
		System.out.println(dis.readDouble());
		System.out.println(dis.readUTF());
		System.out.println(dis.readUTF());
		System.out.println(dis.readLong());
	}
	
	public static void testDataInputStreamSkipByte() throws IOException{
		//ʹ���������֮ǰҪ��dosд��ÿ������ʱ�����������dosָ����Ŀ�ĵ���ռ���ٸ��ֽ�Ҫ���ա�������д���ַ���ʱ�����д�������ֽ�����ʾ�ַ����ĳ��ȣ�
		dis = new DataInputStream(new FileInputStream(new File("D:\\dos.txt")));
		dis.skip(1);//FileInputStream �����skip����
		System.out.println(dis.available());
		dis.read(buff, 0, 3);
		printByteValue(buff);
		dis.skipBytes(5);//DataInputStream�Լ������ĺ���
		System.out.println(dis.readBoolean());
		//�������ĳ���dos����Ч�ֽں󡢻�ȡ����ByteArrayInputStream���ص��ǷǸ��� count - pos;
		dis.skip(dos.size() + 1);
		System.out.println(dis.available());
	}
	
	public static void main(String[] args) throws IOException {
		testDataOutputStream();
		//testDataInputStream();
		testDataInputStreamSkipByte();
	}
	
	private static void printByteValue(byte[] buf) {
		for(byte b : buf){
			if(b != 0){
				System.out.print(byteToString(b) + " ");
			}
		}
		System.out.println();
	}
	private static String byteToString(byte b){
		byte[] bAray = {b};
		return new String (bAray);
	}
}