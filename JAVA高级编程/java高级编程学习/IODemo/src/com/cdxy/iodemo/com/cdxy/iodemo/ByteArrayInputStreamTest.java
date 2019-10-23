package com.cdxy.iodemo;

import java.io.ByteArrayInputStream;

public class ByteArrayInputStreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}

	private static byte[] byteArray = new byte[100];

	static {
		for (byte i = 0; i < 100; i++) {
			byteArray[i] = i;
		}
	}

	public static void test() {
		// ����һ�����ֽڻ��������bais��byteArrayͨ��bais�Ĺ��췽�����ݸ���ByteArrayInputStream�������顢���Դ��������ݾ���buteArray��

		ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);
		// ByteArrayInputStream bais = new ByteArrayInputStream(byteArray, 0,
		// byteArray.length);������Ч����ͬ��

		// �鿴���������ֽ������м�byteArray����Ч�ɹ���ȡ���ֽ����� result: 100
		int available = bais.available();
		System.out.println("befor skip: " + available);
		System.out.println("----------------------------------");

		// ���������Ļ����ֽ�����ǰ33������33��ʼ��ȡ����Ϊbyte�Ǵ�0��ʼ�ġ�
		bais.skip(33);

		// �鿴�鿴���������ֽ�������Ч�ɹ���ȡ���ֽ��� result: 67
		available = bais.available();
		System.out.println("after skip: " + bais.available());
		System.out.println("----------------------------------");

		// ����Ч�ɹ���ȡ���ֽ�������33��ʱ����ȡ��һ�������ҽ���ȡ֮�󡢵�ǰ�����ֽ���������Ч�ֽ������������available
		// result: 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 
		while (33 < available) {
			System.out.print(bais.read() + " ");
			available = bais.available();
		}
		System.out.println("\r\n" + "----------------------------------");

		// ���ByteArrayInputStream��֧��mark���˳���ʵ�������Ǵ�Դ�����Ѿ�֪��������markSupported()һֱ���صĶ���true
		if (!bais.markSupported()) {
			return;
		}

		// ��ʱ�����ֽ������л�ʣ90--99��Щ�ֽ�δ��ȡ����33����
		// result: 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86
		// 87 88 89 90 91 92 93 94 95 96 97 98 99
		// markB�д���ĳ�ʼ��Сֵbais.available() �� 33
		bais.mark(98);
		byte[] markB = new byte[bais.available()];
		while ((bais.read(markB, 0, markB.length)) != -1) {
			for (byte b : markB) {
				System.out.print(b + " ");
			}
		}
		System.out.println("\r\n" + "----------------------------------");

		// ���ñ��λ��
		// result:67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87
		// 88 89 90 91 92 93 94 95 96 97 98 99
		// resetB�д���ĳ�ʼ��Сֵbais.available() �� 33
		bais.reset();

		byte[] resetB = new byte[bais.available()];
		while ((bais.read(resetB, 0, resetB.length)) != -1) {
			for (byte b : resetB) {
				System.out.print(b + " ");
			}
		}
		System.out.println("\r\n" + "----------------------------------");
	}
	/**
	 * ���˵��: 
	 * 1��ǰ��Ķ�����⡢���ʾ���ÿ��һ���ֽڡ�ByteArrayInputStream�ļ������ͻ��һ�����в����Ϳ���Դ�롣
	 * 2��read() �ǽ��ӻ����ֽ������ж������ֽ���������ʽ���ء� 3��read(byte[] b, int off, int len)
	 * �ǽ������ֽ����������len���ֽڶ�ȡ�����ŵ�b��off�±굽off+len-1��ȥ �������Ƕ�b�Ĳ���Ҳ���ǶԶ�ȡ����Ĳ�����
	 * 3��mark�����Ĳ���98��û���κ�����ġ������㴫ʲô������һ�����������mark����ʱ�������ͻ�ѵ�ǰ�����ֽ���������һ��
	 * ��������ȡ���ֽڵ��±긳��mark����������о��� 67����Ӧ���ֽ�ֵҲ��67�����������ȡʣ�µĻ����ֽ������е��ֽ�ֵ���� ӡ�ľ��Ǵ�67 -
	 * 99 3������bais.reset()���� ������������������ֱ��ѭ����ӡ����û���κ�����������Ϊ��¼�ֽڻ���������±��ֵpos�Ѿ�����
	 * ����������ˡ���һ���Ѿ�û���ˡ����ǵ������ ��basi.reset()����֮�󡢾ͻ����67 - 99��ԭ����ǵ�����reset����ʱ����
	 * ������������mark����ʱmark����¼�ĵ�ʱ�Ļ����ֽ������±����¸���pos��������������Ȼ��67 - 99 ����ʲô��û�С�
	 * 
	 */

}
