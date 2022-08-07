/**
 * 
 */
package edsp;

import java.io.File;
import java.io.IOException;

/**
 * @author astro.avm
 *
 */
public class Data {
	
	String address;
	String fileFormat;
	
	/**
	 * 
	 * @param address
	 */
	public Data(String address, String fileFormat) {
		
		final int addresssize = address.length();
		if(!address.toLowerCase().substring((addresssize-(fileFormat.length()+1)), addresssize).equals("."+fileFormat))
		{
			if(!address.toLowerCase().substring((addresssize-1), addresssize).equals("\\")) {address = address+"\\";}
		}
		
		this.fileFormat = fileFormat;
		this.address = address;
		
		
	}
	
	/**
	 * 
	 * @param str
	 * @throws IOException
	 */
	public void send(String str) throws IOException
	{
		
		new Send().send(address, str, fileFormat);
		
	}
	
	/**
	 * 
	 * @param str1
	 * @param str2
	 * @param middle
	 * @throws IOException
	 */
	public void link(String str1, String str2, String middle) throws IOException
	{
		
		new Send().link(address, str1, str2, middle, fileFormat);
		
	}
	
	/**
	 * 
	 * @param str
	 * @param autoCheck
	 * @throws IOException
	 */
	public boolean search(String str, boolean autoCheck) throws IOException
	{
		
		return new Search().search(address, str, autoCheck, fileFormat);
		
	}
	
	/**
	 * 
	 * @param str
	 * @param autoCheck
	 * @param middle
	 * @return
	 * @throws IOException
	 */
	public boolean searchLink(String str, boolean autoCheck, String middle) throws IOException
	{
		
		return new SearchLink().searchLink(address, str, autoCheck, fileFormat, middle);
		
	}
	
	/**
	 * 
	 * @param str
	 * @param autoCheck
	 * @return
	 * @throws IOException
	 */
	public String getLinked(String str, boolean autoCheck, String middle) throws IOException
	{
		
		return new GetLinked().getLinked(address, str, autoCheck, fileFormat, middle);
		
	}
	
	/**
	 * 
	 * @param str
	 * @param autoCheck
	 * @return
	 * @throws IOException
	 */
	public String getContinue(String str, boolean autoCheck) throws IOException
	{
		
		return new GetContinue().getContinue(address, str, autoCheck, fileFormat);
		
	}
	
	/**
	 * 
	 * @param file_address
	 * @return
	 * @throws IOException
	 */
	public boolean sort(String file_address) throws IOException
	{
		
		return new Sort(file_address).sort();
		
	}
	
	/**
	 * 
	 * @throws IOException
	 */
	public void sortAll() throws IOException
	{
		
		String Alphabet = "abcdefghijklmnopqrstuvwxyz";
		String word;
		
		for(int i = 0; i <= Alphabet.length()-1; i++) {
			String address = this.address;
			word = Alphabet.substring(i, i+1);
			File file = new File(address = address + word + "."+fileFormat);
			
			if(file.exists())
			{
				new Sort(address).sort();
			}
			
		}
		
		
	}
	
}
