package br.ce.wcaquino.test;

import static br.ce.wcaquino.utils.DataUtils.obterDataFormatada;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.page.MenuPage;
import br.ce.wcaquino.page.MovimentacaoPage;
import br.ce.wcaquino.utils.DataUtils;

public class MovimentacaoTest extends BaseTest{

	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Test
	public void test1InserirMovimentacao(){
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.setDataMovimentacao(obterDataFormatada(new Date()));
		movPage.setDataPagamento(obterDataFormatada(new Date()));
		movPage.setDescricao("Movimenta??o do teste");
		movPage.setInteressado("Nome Qualquer");
		movPage.setValor("500.0");
		movPage.setConta("Conta para movimentacoes");
		movPage.setStatusPago();
		movPage.salvar();
		
		Assert.assertEquals("Movimenta??o adicionada com sucesso!", movPage.obterMensagemSucesso());
	}
	
	@Test
	public void test2CamposObrigatorios(){
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.salvar();
		List<String> erros = movPage.obterErros();
		//Assert.assertTrue(erros.contains("Data da Movimenta??o ? obrigat?rio"); //exemplo de como poderia validar, mas teria que repetir pra todas as mensagens
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimenta??o ? obrigat?rio", "Data do pagamento ? obrigat?rio",
				"Descri??o ? obrigat?rio", "Interessado ? obrigat?rio",
				"Valor ? obrigat?rio", "Valor deve ser um n?mero")));
		Assert.assertEquals(6, erros.size());
	}
	
	@Test
	public void test3InserirMovimentacaoFutura(){
		menuPage.acessarTelaInserirMovimentacao();
		
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
		
		movPage.setDataMovimentacao(obterDataFormatada(dataFutura));
		movPage.setDataPagamento(obterDataFormatada(dataFutura));
		movPage.setDescricao("Movimenta??o do teste");
		movPage.setInteressado("Nome Qualquer");
		movPage.setValor("500.0");
		movPage.setConta("Conta para movimentacoes");
		movPage.setStatusPago();
		movPage.salvar();
		
		List<String> erros = movPage.obterErros();
		Assert.assertTrue(
				erros.contains("Data da Movimenta??o deve ser menor ou igual ? data atual"));
		Assert.assertEquals(1, erros.size());
	}
}
