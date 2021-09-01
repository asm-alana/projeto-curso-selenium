package br.ce.wcaquino.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * Classe DriverFactory � para configurar os m�todos usados para gerenciar o driver
 * Os m�todos dessa classe s�o utilizados em outras atrav�s dos m�todos quando se d� um import
 *dessa classe.
 * Os m�todos n�o s�o instanciados nas outras classes porque s�o est�ticos.
 */

public class DriverFactory {

	private static WebDriver driver;

	private DriverFactory() {
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			switch (Propriedades.browser) {
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
			case CHROME:
				driver = new ChromeDriver();
				break;
			}
			driver.manage().window().maximize(); // m�todo pra iniciar um driver que ainda n�o est� instanciado
		}
		return driver;
	}

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null; // m�todo pra matar um driver sem o NullPointer
		}
	}
}
