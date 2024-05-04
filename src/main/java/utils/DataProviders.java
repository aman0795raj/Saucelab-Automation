package utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataProviders {
	
	@DataProvider(name="data")
	public Object[][] get() {
		List<HashMap<String, String>> data = DataProviders.readJson();
		return new Object[][] {{data.get(0)}};
	}

	public static List<HashMap<String, String>> readJson() {
		File dataFile = new File(utils.Constants.TEST_DATA_FILE);
		String data = null;
		try {
			data = FileUtils.readFileToString(dataFile, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(dataFile,new TypeReference<List<HashMap<String,String>>>(){});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
