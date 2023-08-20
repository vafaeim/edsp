package edsp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GetInformations {
	
	private File file;
	private BufferedReader read;
	
	String address;
	
	public GetInformations(String file_address) throws IOException {
		this.address = file_address;
		file = new File(address);
		read = new BufferedReader(new FileReader(file));
	}
	
	public int NumberOfLines() throws IOException {
		int n = 0;
		String line = "Empty";
		while (line != null) {
			line = read.readLine();
			n += 1;
		}
		read.close();
		return n;
	}
	
	public long SizeByte() {
		return file.length();
	}
	
	public Double SizeKB() {
		return (double) (file.length() / 1000);
	}
	
	public Double SizeMB() {
		return (double) file.length() / 1000000;
	}
	
	public long SizeGB() {
		return file.length() / 1000000000;
	}
}
