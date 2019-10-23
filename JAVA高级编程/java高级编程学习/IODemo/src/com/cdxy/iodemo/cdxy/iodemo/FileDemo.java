package cdxy.iodemo;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileDemo {

	public static void main(String[] args) {
		System.out.println((18+3*8)/4%3);
	}
	
	
	
	public static void getFileInfo(File file){
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getPath());
		System.out.println(file.canRead());
		System.out.println(new Date(file.lastModified()));
	}
}


//System.out.println(file.getName());
//System.out.println(file.getPath());
//System.out.println(file.getAbsolutePath());
//System.out.println("is canRead:"+file.canRead());
//System.out.println(file.getParent());
//System.out.println(new Date(file.lastModified()));































