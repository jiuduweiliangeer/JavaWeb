package com.cdxy.iodemo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamTest {
	public static void main(String[] args) throws IOException {
		test();
	}
	//��ӦString "abcdefghijklmnopqrstuvwxyz";
		private static final byte[] byteArray = {
	       		0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A, 0x6B, 0x6C, 0x6D, 0x6E, 0x6F,
	        	0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A
	        };
		public static void test() throws IOException{
			
			//һ�㴴��һ������Ĭ�ϴ�С�Ļ����ֽ�����  buf ���ֽ�������Ϳ����ˡ�
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			//�ֽ�����������е� buf ����Ч���ֽ����������ֽ������Ǵ��ڳ����ڴ��еġ�
			System.out.println(baos.size());
			
			/**
			 * ���int��97ǿת��byte����д�� buf �С�baos.toString()�ǰ���ϵͳĬ�ϵı��뽫�ֽ�ת�����ַ���
			 * toString()���ڲ�ʵ�ֹؼ�������ǣ�return new String(buf, 0, count);
			 * result: a
			 */
			baos.write(97);
			System.out.println(baos.toString());//new String(buf, 0, count)
			
			/**
			 * ��byteArray��ǰ�ĸ��ֽ���ӵ������ֽ�������
			 * result: aabcd
			 */
			
			baos.write(byteArray, 0, 4);
			System.out.println(baos.toString());
			
			//�������ֽ�������ӵ������ֽ�������ȥ
			baos.write(byteArray);
			System.out.println(baos.toString());
			
			//��baos��buf���ֽ�ת�뵽һ���µ�byte[]��ȥ�����Ĵ��룺Arrays.copyOf(buf, count);
			byte[] newByteArray = baos.toByteArray();
			for(byte b : newByteArray){
				System.out.println(String.valueOf(b));
			}
			
			/**
			  * baos.writeTo()�����ı����ǵ��ô����OutputStreamʵ�����write(byte[] b, 0, len);������
			  * ��baos���е�buf�ֽ�д�뵽ʵ����ָ����Ŀ�ĵ��С�
			  * result: ��D���и���Ϊ bytearrayoutputstream.txt���ļ��С�������һ��Ϊ��aabcdabcdefghijklmnopqrstuvwxyz�������ݡ�
			  * ����Ϊʲô�����ֽ��͡�����FileOutputStream��write(byte[] b, 0, len);�йء��������ۡ�
			  * 
			 */
			baos.writeTo(new FileOutputStream(new File("D:" + File.separator + "bytearrayoutputstream.txt")));
			
			/**
			 * ��������������
			 *	result: �����ֽ���������ǰ��31
			 *	result: �����ֽ����������0
			 */
			
			System.out.println("�����ֽ���������ǰ��" + baos.size());
			baos.reset();
			System.out.println("�����ֽ����������" + baos.size());
		}
		
}
