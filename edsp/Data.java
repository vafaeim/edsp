package edsp;

import java.io.File;
import java.io.IOException;

public class Data {
	
	String address;
	String fileFormat;
	
	public Data(String address, String fileFormat) {
		final int addresssize = address.length();
		if (!address.toLowerCase().substring((addresssize - (fileFormat.length() + 1)), addresssize).equals("." + fileFormat)) {
			if (!address.toLowerCase().substring((addresssize - 1), addresssize).equals("\\")) {
				address = address + "\\";
			}
		}
		this.fileFormat = fileFormat;
		this.address = address;
	}
	
	public void send(String str) throws IOException {
		new Send().send(address, str, fileFormat);
	}
	
	public void link(String str1, String str2, String middle) throws IOException {
		new Send().link(address, str1, str2, middle, fileFormat);
	}
	
	public boolean search(String str, boolean autoCheck) throws IOException {
		return new Search().search(address, str, autoCheck, fileFormat);
	}
	
	public boolean searchLink(String str, boolean autoCheck, String middle) throws IOException {
		return new SearchLink().searchLink(address, str, autoCheck, fileFormat, middle);
	}
	
	public String getLinked(String str, boolean autoCheck, String middle) throws IOException {
		return new GetLinked().getLinked(address, str, autoCheck, fileFormat, middle);
	}
	
	public String getContinue(String str, boolean autoCheck) throws IOException {
		return new GetContinue().getContinue(address, str, autoCheck, fileFormat);
	}
	
	public boolean sort(String file_address) throws IOException {
		return new Sort(file_address).sort();
	}
	
	public void sortAll() throws IOException {
		String Alphabet = "abcdefghijklmnopqrstuvwxyz";
		String word;
		for (int i = 0; i <= Alphabet.length() - 1; i++) {
			String address = this.address;
			word = Alphabet.substring(i, i + 1);
			File file = new File(address = address + word + "." + fileFormat);
			if (file.exists()) {
				new Sort(address).sort();
			}
		}
	}
}
