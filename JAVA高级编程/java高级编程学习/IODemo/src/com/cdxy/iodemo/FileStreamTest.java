package com.cdxy.iodemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamTest {

	private static final byte[] byteArray = { 0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A, 0x6B, 0x6C,
			0x6D, 0x6E, 0x6F, 0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A };

	public static void testFileOutputStream() throws IOException {

		// ����һ��ģʽΪ�滻������д��ǰ�Ὣ�ļ��е�����������ա�����ļ����ڵĻ������ļ��ֽ��������
		FileOutputStream fosAppendFalse = new FileOutputStream(new File("D:\\fosAppendFalse.txt"));
		/**
		 * ����˵���� 1��д��һ���ֽڣ� 2��д��һ�����з��� 3��д��byteArray��ǰ����ֽڣ� 4��д�뻻�з���
		 * 5��д������byteArray�� 6���ر����ͷ���Դ�� ע�⣺��д���ļ����ֽڶ��ᱻ�ײ㰴��ϵͳĬ�ϱ���ת�����ַ��浽�ļ��С�
		 * ��ʹ���ļ��ֽ��������ʱ��ᱻ��ת���ֽڣ������Լ����Զ������ԣ�
		 */
		fosAppendFalse.write(byteArray[0]);
		fosAppendFalse.write("\r\n".getBytes());
		fosAppendFalse.write(byteArray, 0, 5);
		fosAppendFalse.write("\r\n".getBytes());
		fosAppendFalse.write(byteArray);
		fosAppendFalse.close();
		/**
		 * ���н��: ��D��������һ����ΪfosAppendFalse.txt���ı��ļ� �������ж��ٴ�fosAppendFalse.txtֻ�У�
		 * a abcde abcdefghijklmnopqrstuvwxyz ��Щ���ݡ�
		 */

		// ����һ��ģʽΪ׷�ӵ��ļ��ֽ������
		FileOutputStream fosAppendTure = new FileOutputStream("D:\\fosAppendTure.txt", true);
		/**
		 * ����˵���� 1����ָ���ļ�׷��һ���ֽڣ� 2����ָ���ļ�׷��һ�����з��� 3����ָ���ļ�׷��byteArray��ǰ����ֽڣ�
		 * 4����ָ���ļ�׷�ӻ��з��� 5����ָ���ļ�׷������byteArray�� 6���ر����ͷ���Դ��
		 */
		fosAppendTure.write(byteArray[0]);
		fosAppendTure.write("\r\n".getBytes());
		fosAppendTure.write(byteArray, 0, 5);
		fosAppendTure.write("\r\n".getBytes());
		fosAppendTure.write(byteArray);
		fosAppendTure.write("\r\n".getBytes());
		fosAppendTure.close();
		/**
		 * ���н��: ��D��������һ����ΪfosAppendFalse.txt���ı��ļ�
		 * ÿ����һ��fosAppendFalse.txt�ж���׷���������ݣ� a abcde abcdefghijklmnopqrstuvwxyz
		 * ��Щ���ݡ�ע�⻻�з��Խṹ��Ӱ�졣
		 */

	}

	public static void testFileInputSteram() throws IOException {
		// �����FileOutputStreamΪ�˲��ԡ�д���ļ��Ķ����Ƚ����ҡ�����Ϊ�˷���۲���������Ūһ������a-zд���ļ�fis.txt�С���fis.txt��Ϊ�ļ��ֽ���������Դ��
		FileOutputStream fos = new FileOutputStream("D:\\fis.txt");
		fos.write(byteArray);

		// ����fis.txt��������
		FileInputStream fis = new FileInputStream(new File("D:\\fis.txt"));

		/**
		 * ��˵���� ��Ҫ���ǲ���available()��read()��read(byte[] b ,int off, int
		 * len)��read(byte[] b) �ĸ�������ʹ�á��Լ�����ͬһ�����ĺ������������ж�ȡ����ʲôЧ����
		 */
		int availableCount = fis.available();
		System.out.println(availableCount);

		int n = 0;
		byte[] buf = new byte[availableCount];

		n = fis.read();
		System.out.print("read()��ȡ���ֽ� : " + byteToString((byte) n));
		System.out.println("\r\n----------------------------------");

		fis.skip(5);
		availableCount = fis.available();
		System.out.println(availableCount);
		n = fis.read(buf, 0, availableCount - 1);
		System.out.println("read(byte[] b,int off, int len)��ȡ���ֽ����� " + n);
		printByteValue(buf);
		System.out.println("\r\n----------------------------------");

		availableCount = fis.available();
		System.out.println(availableCount);
		byte[] buf2 = new byte[1024];
		n = fis.read(buf2);
		System.out.println("read(byte[] b)��ȡ���ֽ����� " + n);
		printByteValue(buf2);
		System.out.println("\r\n----------------------------------");

		availableCount = fis.available();
		System.out.println(availableCount);
		byte[] buf3 = new byte[1024];
		n = fis.read(buf3, 0, 5);
		System.out.println("read(byte[] b,int off, int len)�� " + n);
		printByteValue(buf3);
		System.out.println("\r\n----------------------------------");

		System.out.println("�Ƿ�֧��mark��" + fis.markSupported());
		/*
		 * System.out.println(fis.available()); fis.reset();
		 */

		/**
		 * ���˵���� 1��result : 26 //��ʵ���ļ�D:\fis.txt���ж�����Ч�Ŀɶ�ȡ���ֽ���; 2��result :
		 * read()��ȡ���ֽ� : a
		 * //ʵ���ļ�D:\fis.txt�е�һ���ֽڡ����ұ�Ƕ�ȡλ�õ�ƫ����+1��ƫ����ָ������һ������ȡ���ֽ�λ��; 3��result :
		 * 20
		 * //ʵ���ļ�D:\fis.txt��ʣ����Ч�ɶ�ȡ�ֽ�����ԭ��1��read()��ȡһ���ֽڡ�ƫ����+1��2��fis.skip(5)ʹ��ƫ����
		 * +5 ���Ǵӵ��߸���ʼ��ȡ�� 4��result : read(byte[] b,int off, int len)��ȡ���ֽ����� 19
		 * //��ȡ���ֽ���ȡ�����������棺1������Ĳ����е�len��2���ļ���ʣ�����Ч�ֽ���������ȡ��С���Ǹ�; 5��result : g h i
		 * j k l m n o p q r s t u v w x y //��ȡ����24���ֽڴ�ӡ���������ұ�Ƕ�ȡλ�õ� ƫ���� =
		 * ƫ����+ʵ�ʶ�ȡ�ֽ���; 6��result : read(byte[] b)��ȡ���ֽ����� 1 //ͬ���4��˵�� 7��result :
		 * z //ͬ���5��˵�� 8��result : 0 //ʵ���ļ�����Ч�ɶ�ȡ�ֽ�Ϊ0 ������ȡ���ļ�����ˡ�ƫ���� = available;
		 * 9��result : read(byte[] b,int off, int len)�� -1 //��ȡ���ļ���β������-1��Ϊ��־;
		 * 10�� result : �Ƿ�֧��mark��false //��ʾ�ļ���������֧��mark
		 * ���Ժ����mark(10)�������κ�Ч��������������ø���� reset()�ᱨ�� ��mark/reset not supported
		 */
	}

	private static void printByteValue(byte[] buf) {
		for (byte b : buf) {
			if (b != 0) {
				System.out.print(byteToString(b) + " ");
			}
		}
	}

	private static String byteToString(byte b) {
		byte[] bAray = { b };
		return new String(bAray);
	}

	public static void copyFile() throws IOException {
		// ���ʹ�á�ʵ�ָ����ļ�������û�ж������κ�װ�Ρ�������˵��
		FileInputStream fis = new FileInputStream(new File("D:\\fosAppendFalse.txt"));
		FileOutputStream fosAppendFalse = new FileOutputStream(new File("D:\\CopeOfFosAppendFalse.txt"));
		byte[] b = new byte[1024];
		int n = 0;
		while ((n = fis.read(b)) != -1) {
			fosAppendFalse.write(b, 0, n);
		}
	}

	/**
	 * ���Ե�ʱ�����һ��һ�������Ĳ��ԡ��ڶ����Լ��޸ġ������Լ���Ľ���Ƿ�һ���� ���ԡ�������⣡
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		// testFileOutputStream();
		testFileInputSteram();
		// copyFile();
	}
}
