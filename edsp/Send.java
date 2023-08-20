package edsp;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;

class Send {
	
	private String address, str, fileFormat;
	
	private File file;
	private PrintWriter write;
	
	public void send(String address, String str, String fileFormat) throws IOException {
		this.address = address;
		this.str = str;
		this.fileFormat = fileFormat;
		
		ok();
		
		write = new PrintWriter(new BufferedWriter(new FileWriter(file, true)), true);
		if (file.canWrite()) {
			write.printf("%s\n", str);
		}
		
		write.close();
	}
	
	public void link(String address, String str1, String str2, String middle, String fileFormat) throws IOException {
		this.address = address;
		this.str = str1;
		this.fileFormat = fileFormat;
		
		ok();
		
		write = new PrintWriter(new BufferedWriter(new FileWriter(file, true)), true);
		if (file.canWrite()) {
			write.printf("%s", str1 + middle + str2 + "\n");
		}
		
		write.close();
	}
	
	private void ok() throws IOException {
		
		int addresssize = address.length();
		
		if (!address.toLowerCase().substring((addresssize - (fileFormat.length() + 1)), addresssize).equals("." + fileFormat)) {
			String firstWord = "Empty";
			for (int i = 0; i < str.length(); i++) {
				if (!str.substring(i, i + 1).equals(" ")) {
					firstWord = str.substring(i, i + 1);
					break;
				}
			}
			String filename = (firstWord + "." + fileFormat).toLowerCase();
			address = address + filename;
		}
		
		addresssize = address.length();
		
		String f = "";
		
		for (int i = 0; i <= addresssize; i++) {
			if (address.substring(addresssize - i - 1, addresssize - i).equals("\\")) {
				f = address.substring(0, addresssize - i);
				break;
			}
		}
		
		file = new File(f);
		if (!file.isDirectory()) {
			file.mkdirs();
		}
		
		file = new File(address);
		if (!file.exists()) {
			file.createNewFile();
		}
	}
}
