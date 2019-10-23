package com.cdxy.iodemo.piped;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class TestPiped {
	
	public static void main(String[] args) throws IOException {
		PipedOutputStream out = new PipedOutputStream();
		PipedInputStream in = new PipedInputStream();
		out.connect(in);
		Sender sender = new Sender(out);
		Receiver receiver = new Receiver(in);
		sender.start();
		receiver.start();
	}

}
