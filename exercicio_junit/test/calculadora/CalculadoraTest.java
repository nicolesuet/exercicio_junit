package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois números")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@DisplayName("Testa a subtração de dois números iguais")
	@Test
	public void testSubtraiDeDoisNumerosIguais() {
		int subtracao = calc.subtracao(4, 4);		
		Assertions.assertEquals(0, subtracao);		
	}
	
	@DisplayName("Testa subtrair um número menor de outro maior")
	@Test
	public void testSubtraiNumeroMenorDeNumeroMaior() {
		int subtracao = calc.subtracao(10, 4);		
		Assertions.assertEquals(6, subtracao);		
	}
	
	@DisplayName("Testa subtrair um número maior de outro menor")
	@Test
	public void testSubtraiNumeroMaiorDeNumeroMaior() {
		int subtracao = calc.subtracao(4, 10);		
		Assertions.assertEquals(-6, subtracao);		
	}
	
	
	@DisplayName("Testa multiplicação de dois números positivos")
	@Test
	public void testMultiplicacaoDoisNumerosPositivos() {
		int multiplicacao = calc.multiplicacao(4, 10);		
		Assertions.assertEquals(40, multiplicacao);		
	}
	
	@DisplayName("Testa multiplicação de dois números negativos")
	@Test
	public void testMultiplicacaoDoisNumerosNegativos() {
		int multiplicacao = calc.multiplicacao(-4, -10);		
		Assertions.assertEquals(40, multiplicacao);		
	}
	
	@DisplayName("Testa multiplicação de um número negativo por um positivo")
	@Test
	public void testMultiplicacaoDeUmNumeroNegativoPorUmPositivo() {
		int multiplicacao = calc.multiplicacao(-4, 10);		
		Assertions.assertEquals(-40, multiplicacao);		
	}
	
	@DisplayName("Testa multiplicação de de um número por zero")
	@Test
	public void testMultiplicacaoDeUmNumeroPorZero() {
		int multiplicacao = calc.multiplicacao(4, 0);		
		Assertions.assertEquals(0, multiplicacao);		
	}
	
	@Test
	public void testSomatoriaDeUmNumeroMaiorQueZero() {
		int somatoria = calc.somatoria(4);		
		Assertions.assertEquals(10, somatoria);		
	}
	
	@Test
	public void testSomatoriaDeUmNumeroMenorQueZero() {
		int somatoria = calc.somatoria(-4);		
		Assertions.assertEquals(0, somatoria);		
	}
	
	@Test
	public void testSomatoriaDeZero() {
		int somatoria = calc.somatoria(0);		
		Assertions.assertEquals(0, somatoria);		
	}
	
	@Test
	public void testComparaNumeroIguais() {
		int compara = calc.compara(3, 3);		
		Assertions.assertEquals(0, compara);		
	}
	
	@Test
	public void testComparaNumeroComUmMaior() {
		int compara = calc.compara(3, 9);		
		Assertions.assertEquals(-1, compara);		
	}
	
	@Test
	public void testComparaNumeroComUmMenor() {
		int compara = calc.compara(9, 3);		
		Assertions.assertEquals(1, compara);		
	}
	
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}

	@Test
	public void testNumeroEhPositivo() {
		Assertions.assertEquals(true, calc.ehPositivo(4));		
	}

	@Test
	public void testNumeroEhNegativo() {
		Assertions.assertEquals(false, calc.ehPositivo(-4));		
	}
	
	@Test
	public void testNumeroZeroEhPositivo() {
		Assertions.assertEquals(true, calc.ehPositivo(0));		
	}

	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exceção não lançada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}

}
