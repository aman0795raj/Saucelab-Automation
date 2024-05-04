package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenshot {

	public static String takesScreenshot(WebDriver driver,String filename) {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String desLoc = utils.Constants.SCREESHOT_FOLDER + filename+".png";
		File desFile = new File(desLoc);
		try {
			desFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileHandler.copy(src, desFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return desLoc;
	}
}
