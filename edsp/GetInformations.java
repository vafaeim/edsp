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
        try {
            String line;
            while ((line = read.readLine()) != null) {
                n++;
            }
        } finally {
            read.close();
        }
        return n;
    }
    
    public long SizeByte() {
        return file.length();
    }
    
    public long SizeKB() {
        return file.length() / 1024;
    }
    
    public long SizeMB() {
        return file.length() / (1024 * 1024);
    }
    
    public long SizeGB() {
        return file.length() / (1024 * 1024 * 1024);
    }
}