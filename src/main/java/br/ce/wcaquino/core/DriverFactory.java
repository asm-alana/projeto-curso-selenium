package br.ce.wcaquino.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * Classe DriverFactory é para configurar os métodos usados para gerenciar o driver
 * Os métodos dessa classe são utilizados em outras através dos métodos quando se dá um import
 *dessa classe.
 * Os métodos não são instanciados nas outras classes porque são estáticos.
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
			driver.manage().window().maximize(); // método pra iniciar um driver que ainda não está instanciado
		}
		return driver;
	}

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null; // método pra matar um driver sem o NullPointer
		}
	}
}
