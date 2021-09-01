package br.ce.wcaquino.core;

import static br.ce.wcaquino.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class BaseTest {
		
	@Rule
	public TestName testName = new TestName();

	@After
	public void finaliza() throws IOException {
		TakesScreenshot screenShot = (TakesScreenshot) DriverFactory.getDriver();
		File arquivo = screenShot.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(arquivo, new File("target" + File.separator + "screenshot/" +
							File.separator + testName.getMethodName() + ".jpg"));
			
		if (Propriedades.FECHAR_BROWSE) {
			killDriver();
		}

	}

}