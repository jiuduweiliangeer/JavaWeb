package com.cdxy.iodemo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TestOnew {
	public static void main(String[] args) throws Exception{
		/*FileInputStream fis = new FileInputStream("D:/data/407b63cb-3987-4ffe-acb7-6bef08ca7bfb.txt");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		System.out.println(br.readLine());*/
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("D:/data/407b63cb-3987-4ffe-acb7-6bef08ca7bfb.txt")));
		System.out.println(br.readLine());
		br.close();
	}

}
