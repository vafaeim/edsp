package edsp;
/**
 * 
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author astro.avm
 *
 */
public class GetInformations {
		
	private File file;
	private BufferedReader read;
	
	String address;
	
	/**
	 * 
	 * @param address
	 * @throws IOException
	 */
	public GetInformations(String file_address) throws IOException {
		
		this.address = file_address;
		file = new File(address);
		read = new BufferedReader(new FileReader(file));
		
	}
	
	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public int NumberOfLines() throws IOException
	{
		
		int n = 0;
		String line = "Empty";
		while (line != null) {
			line = read.readLine();
			n+=1;
		}
		read.close();
		
		return n;
	}
	
	/**
	 * 
	 * @return
	 */
	public long SizeByte()
	{
		
		return file.length();
		
	}
	
	/**
	 * 
	 * @return
	 */
	public Double SizeKB()
	{
		
		return (double) (file.length()/1000);
		
	}
	
	/**
	 * 
	 * @return
	 */
	public Double SizeMB()
	{
		
		return (double) file.length()/1000000;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public long SizeGB()
	{
		
		return file.length()/1000000000;
		
	}
	
}
