package org.gpoint.iofiles;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ConsoleWritter {

	public static void main(String[] args) {
		
		File file = new File("c://temp//neu.txt");
		
		try (
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			) {
			int data = 0;
			while((data=System.in.read()) != -1) {
				if(data=='x') {
					break;
				}
				else {
					bos.write(data);
				}
				bos.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
