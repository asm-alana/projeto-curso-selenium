package br.ce.wcaquino.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.page.ContasPage;
import br.ce.wcaquino.page.MenuPage;

public class RemoverMovimentacaoContaTest extends BaseTest {

	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void testExcluirContaComMovimentacao() {
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarExcluirConta("Conta com movimentacao");
		
		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
	}
	
}
