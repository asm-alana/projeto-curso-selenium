package br.ce.wcaquino.core;

/*
 * Classe com as propriedades dos browsers
 */

public class Propriedades {

	public static boolean FECHAR_BROWSE = false;

	public static Browsers browser = Browsers.CHROME; 
	
	public enum Browsers {
		CHROME,
		FIREFOX
	}
}
