package jpl.ch23.ex01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamConector {

	public static void main(String[] args) {
		try {
			userProg("ls").waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static Process userProg(String cmd) throws IOException {
		Process proc = Runtime.getRuntime().exec(cmd);
		plugTogether(System.in, proc.getOutputStream());
		plugTogether(System.out, proc.getInputStream());
		plugTogether(System.err, proc.getErrorStream());
		return proc;
	}

	public static void plugTogether(InputStream in, OutputStream out) {

		new Thread(new Runnable() {

			@Override
			public void run() {

				int readData = 0;
				try {
					while ((readData = in.read()) != -1) {
						out.write(readData);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();

	}

	public static void plugTogether(OutputStream out, InputStream in) {

		new Thread(new Runnable() {

			@Override
			public void run() {
				int readData = 0;
				try {
					while ((readData = in.read()) != -1) {
						out.write(readData);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();

	}
}
