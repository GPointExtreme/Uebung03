package org.gpoint.iofiles;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {

	public static void main(String[] args) {
		File fileIn = new File("C://temp//CopyFileIn.txt");
		File fileOut = new File("C://temp//CopyFileOut.txt");
		
		try (
			FileInputStream fis = new FileInputStream(fileIn);
			BufferedInputStream bis = new BufferedInputStream(fis);
			FileOutputStream fos = new FileOutputStream(fileOut);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			) {
			int data = 0;
			while((data=bis.read()) != -1) {
				bos.write(data);
			}
			bos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
