package br.ce.wcaquino.test;

import static br.ce.wcaquino.core.DriverFactory.getDriver;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.core.DriverFactory;
import br.ce.wcaquino.page.MenuPage;
import br.ce.wcaquino.page.ResumoPage;

public class ResumoTest extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();

	@Test
	public void test1ExcluirMovimentacao() {
		menuPage.acessarTelaResumo();

		resumoPage.excluirMovimentacao();

		Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());

	}

	@Test
	public void test2ResumoMensal() {
		menuPage.acessarTelaResumo();

		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
				
		resumoPage.selecionarAno("2020");
		resumoPage.buscar();

		List<WebElement> elementosEncontrados = DriverFactory.getDriver()
				.findElements(By.xpath(".//*[@id='tabelaExtrato']/tbody/tr"));

		Assert.assertEquals(0, elementosEncontrados.size());

		/*
		 * try {
		 * 	DriverFactory.getDriver().findElement(By.xpath(* ".//*[@id='tabelaExtrato']/tbody/tr"));
		 *	 Assert.fail();
		 * } catch* (NoSuchElementException e) {
		 * 
		 * }
		 */
	}

}
