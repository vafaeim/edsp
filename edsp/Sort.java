package edsp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

class Sort {
	
	private File file;
	private BufferedReader read;
	private PrintWriter write;
	
	String address;
	
	public Sort(String address) throws IOException {
		this.address = address;
	}
	
	public boolean sort() throws IOException {
		file = new File(address);
		read = new BufferedReader(new FileReader(file));
		
		ArrayList<String> list = new ArrayList<String>();
		String line = "Empty";
		while (line != null) {
			line = read.readLine();
			if (line != null) {
				list.add(line);
			}
		}
		
		list.sort(null);
		read.close();
		
		boolean OK = file.delete();
		file = new File(address);
		file.createNewFile();
		write = new PrintWriter(new BufferedWriter(new FileWriter(file, true)), true);
		
		while (true) {
			try {
				write.printf("%s", list.get(0) + "\n");
				list.remove(0);
			} catch (Exception e) {
				break;
			}
		}
		write.close();
		read.close();
		list.clear();
		
		return OK;
	}
}
