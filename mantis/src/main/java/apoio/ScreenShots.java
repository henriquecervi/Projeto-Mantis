package apoio;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShots {
	protected static WebDriver print;
	
	public static void printDaTela (WebDriver print) {
		
		File foto = ((TakesScreenshot)print).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(foto, new File
					("C:/Users/henrique.cutri/Documents/WorkSpace Eclipse/mantis/src/main/resources/"
					+ System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
