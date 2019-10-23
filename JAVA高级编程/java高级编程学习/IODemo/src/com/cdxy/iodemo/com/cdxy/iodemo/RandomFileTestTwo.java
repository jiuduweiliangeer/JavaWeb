package com.cdxy.iodemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RandomFileTestTwo {
	public static void main(String[] args) {
		// �����ȡ���ļ�
		String src = "d:/testone.txt";
		// ��������ļ���
		String base = "d:/data/";
		// �ж��ļ���׺��(.txt)
		String substring = src.substring(src.lastIndexOf("."));
		// ÿ�ζ�5*1024���ֽ�
		int block = 5*1024;
		// ��ȡ�ļ����ݵĳ���
		long length = new File(src).length();
		// �ָ��ļ�������
		int times = (int) Math.ceil(length / (float) block);
		// ����ÿ��ִ��3���߳�
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		// ����������ļ���
		new File(base).mkdirs();
		// ѭ���ָ��ļ�
		for (int i = 0; i < times; i++) {
			final int j = i;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						// ��RandomAccessFile��ȡ�ļ�
						RandomAccessFile in = new RandomAccessFile(src, "r");
						// ÿ�ζ�ȡ��j*block��ʼ
						in.seek(j * block);
						// ��ȡblock���ֽ�
						byte[] box = new byte[block];
						// ���ļ���ȡ�ŵ�size
						int read = in.read(box);
						// ����ָ����ļ���
						String fileName = UUID.randomUUID().toString();
						// ��FileOutputStream�����ļ�,ƴ��·��
						FileOutputStream out = new FileOutputStream(base + fileName + substring);
						// ��write����д��size���ֽ�
						//System.out.println(box);
						// write����д���ֽڣ�box�ǳ��ȣ���0��ʼ����read
						out.write(box, 0, read);
						// �ر���
						out.close();
						in.close();
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
					}
				}
			});
		}
		threadPool.shutdown();
	}
}
