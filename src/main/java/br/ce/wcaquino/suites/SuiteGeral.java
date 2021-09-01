package br.ce.wcaquino.suites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.wcaquino.core.DriverFactory;
import br.ce.wcaquino.page.LoginPage;
import br.ce.wcaquino.test.ContaTest;
import br.ce.wcaquino.test.MovimentacaoTest;
import br.ce.wcaquino.test.RemoverMovimentacaoContaTest;
import br.ce.wcaquino.test.ResumoTest;
import br.ce.wcaquino.test.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})
public class SuiteGeral {
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void reset() {
		page.acessarTelaInicial();
		
		page.setEmail("alana@santos");
		page.setSenha("654321");
		page.entrar();
		
		page.resetar();
	}
	
	@AfterClass
	public static void finaliza() {
		DriverFactory.killDriver();
	}
}
