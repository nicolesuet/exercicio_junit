package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {
	
	Carrinho carrinho;
	
	@BeforeEach
	public void inicializa() {
		carrinho = new Carrinho();
	}

	@Test
	public void testCriaCarrinho() {
		Assertions.assertEquals(0, carrinho.getQtdeItems());
	}
	
	@Test
	public void testQuantidadeDeItemsEmUmCarrinhoVazio() {
		Assertions.assertEquals(0, carrinho.getQtdeItems());
	}

	@Test
	public void testQuantidadeDeItemsEmUmCarrinhoNaoVazio() {
		carrinho.addItem(new Produto("Produto 1", 10.00));
		carrinho.addItem(new Produto("Produto 2", 10.00));
		carrinho.addItem(new Produto("Produto 3", 10.00));
		Assertions.assertEquals(3, carrinho.getQtdeItems());
	}
	
	@Test
	public void testValorTotalEmUmCarrinhoVazio() {
		Assertions.assertEquals(0, carrinho.getValorTotal());
	}

	@Test
	public void testValorTotalEmUmCarrinhoNaoVazio() {
		carrinho.addItem(new Produto("Produto 1", 10.00));
		carrinho.addItem(new Produto("Produto 2", 10.00));
		carrinho.addItem(new Produto("Produto 3", 10.00));
		Assertions.assertEquals(30, carrinho.getValorTotal());
	}
	
	@Test
	public void testAdicionaUmItem() {
		int qtd = carrinho.getQtdeItems();
		Produto p = new Produto("Produto 1", 10.00);
		carrinho.addItem(p);
		int novaQtd = qtd + 1;
		Assertions.assertEquals(novaQtd, carrinho.getQtdeItems());
	}
	
	@Test
	public void testRemoveItemComSucesso() throws ProdutoNaoEncontradoException {
		Produto p = new Produto("Produto 1", 10.00);
		carrinho.addItem(p);
		int qtd = carrinho.getQtdeItems();
		carrinho.removeItem(p);
		int novaQtd = qtd - 1;
		Assertions.assertEquals(novaQtd, carrinho.getQtdeItems());
	}
	
	@Test
	public void testRemoveItemComErro() {
		Produto p = new Produto("Produto 1", 10.00);
		Assertions.assertThrows(ProdutoNaoEncontradoException.class, () -> { carrinho.removeItem(p); });
	}
	
	@Test
	public void testEsvaziaCarrinhoComItens() {
		Produto p = new Produto("Produto 1", 10.00);
		carrinho.addItem(p);
		carrinho.esvazia();
		Assertions.assertEquals(0, carrinho.getQtdeItems());
	}
	
	@Test
	public void testEsvaziaCarrinhoVazio() {
		carrinho.esvazia();
		Assertions.assertEquals(0, carrinho.getQtdeItems());
	}
	
}
