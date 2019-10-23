package com.cdxy.iodemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RandomFileTestTwo {
	public static void main(String[] args) {
		// 定义读取的文件
		String src = "d:/testone.txt";
		// 定义输出文件夹
		String base = "d:/data/";
		// 判断文件后缀名(.txt)
		String substring = src.substring(src.lastIndexOf("."));
		// 每次读5*1024个字节
		int block = 5*1024;
		// 获取文件内容的长度
		long length = new File(src).length();
		// 分割文件的数量
		int times = (int) Math.ceil(length / (float) block);
		// 定义每次执行3个线程
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		// 创建输出的文件夹
		new File(base).mkdirs();
		// 循环分割文件
		for (int i = 0; i < times; i++) {
			final int j = i;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						// 用RandomAccessFile读取文件
						RandomAccessFile in = new RandomAccessFile(src, "r");
						// 每次读取从j*block开始
						in.seek(j * block);
						// 读取block个字节
						byte[] box = new byte[block];
						// 把文件读取放到size
						int read = in.read(box);
						// 定义分割后的文件名
						String fileName = UUID.randomUUID().toString();
						// 用FileOutputStream创建文件,拼接路径
						FileOutputStream out = new FileOutputStream(base + fileName + substring);
						// 用write方法写入size个字节
						//System.out.println(box);
						// write方法写入字节，box是长度，从0开始，把read
						out.write(box, 0, read);
						// 关闭流
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
