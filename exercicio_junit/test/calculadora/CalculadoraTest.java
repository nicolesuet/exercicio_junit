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
	
	
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
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
