package core.utilities;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CSVReaderUtility {

	CSVReader reader ; 
	
	public void readCSVWithName(String fileName) throws IOException {
		// Initialize the reader with the CSV file
		String CSV_file = System.getProperty("user.dir") + "/src/test/java/data/CSVs/" + fileName;
		reader = new CSVReader(new FileReader(CSV_file)); 
	}
	
	public String[] nextRecord() throws CsvValidationException, IOException {
		// Reading the next record from the reader
		return reader.readNext();
	}
}
