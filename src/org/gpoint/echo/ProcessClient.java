package org.gpoint.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ProcessClient implements Runnable{
	
	private Socket client;
	private Object lock = new Object();

	public ProcessClient(Socket client) {
		super();
		this.client = client;
	}

	@Override
	public void run() {
		synchronized (lock) {
			try (
					InputStreamReader isr = new InputStreamReader(client.getInputStream());
					BufferedReader br = new BufferedReader(isr);
					OutputStreamWriter osw = new OutputStreamWriter(client.getOutputStream());
					PrintWriter pw = new PrintWriter(osw);
				) {
					String line;
					int i = 0;
					
					while((line=br.readLine()) != null) {
						if(line.equals("quit")) {
							break;
						}
						else if(i < 3) {
							pw.println(line);
							pw.flush();
							i++;
						}
						else {
							break;
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}

}
