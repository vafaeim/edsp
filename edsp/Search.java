package edsp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Search {
	
	private BufferedReader read;
	private File file;

	public boolean search(String address, String str, boolean autoCheck, String fileFormat) throws IOException {
		final int addresssize = address.length();
		
		if (!address.toLowerCase().substring((addresssize - (fileFormat.length() + 1)), addresssize).equals("." + fileFormat)) {
			if (!address.toLowerCase().substring((addresssize - 1), addresssize).equals("\\")) {
				address = address + "\\";
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
		}
		
		file = new File(address);
		if (file.exists() == false) {
			return false;
		}
		read = new BufferedReader(new FileReader(file));
		
		int n = 0;
		String line = read.readLine();
		while (line != null) {
			line = read.readLine();
			n += 1;
		}
		
		read.close();
		read = new BufferedReader(new FileReader(file));
		ArrayList<String> list = new ArrayList<String>();
		int i;
		for (i = 0; i <= n - 1; i++) {
			list.add(i, read.readLine());
		}
		read.close();
		
		String secondWord = "";
		for (i = 1; i <= str.length(); i++) {
			if (str.length() != 1) {
				if (!str.substring(i, i + 1).equals(" ")) {
					secondWord = str.substring(i, i + 1);
					break;
				}
			}
		}
		String F = "abcdefghijklm";
		String E = "nopqrstuvwxyz";
		String word;
		for (i = 0; i <= F.length() - 1; i++) {
			word = F.substring(i, i + 1);
			if (secondWord.toLowerCase().equals(word) || autoCheck == false || secondWord.equals("")) {
				while (true) {
					try {
						if (str.toLowerCase().equals(list.get(0).toLowerCase())) {
							return true;
						}
						list.remove(0);
					} catch (Exception e) {
						list.clear();
						break;
					}
				}
			}
			word = E.substring(i, i + 1);
			if (secondWord.toLowerCase().equals(word) && autoCheck == true) {
				for (i = n - 1; i >= 0; i--) {
					if (str.toLowerCase().equals(list.get(i).toLowerCase())) {
						return true;
					}
				}
				list.clear();
				break;
			}
			read.close();
		}
		return false;
	}
}
