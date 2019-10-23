package com.cdxy.iodemo.piped;

import java.io.IOException;
import java.io.PipedInputStream;

public class Receiver extends Thread{
	
	private PipedInputStream in;
	public Receiver(PipedInputStream in) {
		this.in = in;
	}
	@Override
	public void run() {
		try {
			do {
				System.out.println("in.read():"+in.read());
			} while (in.available()>0);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
