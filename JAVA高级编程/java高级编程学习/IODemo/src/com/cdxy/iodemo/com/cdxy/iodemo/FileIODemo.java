package com.cdxy.iodemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.Writer;

public class FileIODemo {
	public static void main(String[] args) throws Exception{
		
		File f = new File("C:/Users/my/Desktop/login.jsp");
		File f1 = new File("C:/Users/my/Desktop/login1.jsp");
		if (f.exists()) {
			FileInputStream fin = new FileInputStream(f);
			BufferedReader bReader = new BufferedReader(new InputStreamReader(fin,"utf-8"));
			StringBuffer sbuff = new StringBuffer();
			String str;
			while((str=bReader.readLine())!=null){
				//System.out.println(str);
				sbuff.append(str);
				sbuff.append("\n");
			}
			System.out.println(sbuff.toString());
			String alls = sbuff.toString();
			long startindex = alls.indexOf("<table");
			long endindex = alls.indexOf("</table>");
			
			System.out.println(alls.substring((int)startindex,(int)endindex));
			
			
			
			FileOutputStream fos = new FileOutputStream(f1);
			fos.write(sbuff.toString().getBytes("utf-8"));
		   
		}
	}
	
	
	
	
}
