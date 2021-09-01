package br.ce.wcaquino.page;

import org.openqa.selenium.By;

import br.ce.wcaquino.core.BasePage;

public class ResumoPage extends BasePage {

	public void excluirMovimentacao() {
		clicarBotao(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
	}
	
	public String obterMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public void selecionarAno(String ano) {
		selecionarCombo("ano", "2020");
	}
	
	public void buscar() {
		clicarBotao(By.xpath("//input[@value='Buscar']"));
	}
}
