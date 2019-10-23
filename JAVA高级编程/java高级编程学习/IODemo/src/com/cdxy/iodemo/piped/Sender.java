package com.cdxy.iodemo.piped;

import java.io.IOException;
import java.io.PipedOutputStream;

public class Sender extends Thread{
	
	private PipedOutputStream out;
	private int i;
	
	public Sender(PipedOutputStream out){
		this.out = out;
	}
	
	@Override
	public void run() {
		while(i<5){
			try {
				System.out.println("out.write("+i+")");
				out.write(i);
				i++;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		try {
			out.close();
			System.out.println("out over!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
