import static org.junit.Assert.*;

import org.junit.Test;

public class RingueTest {
	
	@Test
	public void deveMoverRoboNoRingue() throws PosicaoNoRingueInvalidaException, RoboDesligadoException {
		Ringue ringue = new Ringue(6,6);
		
		Robo robo = new Robo();
		Robo robo2 = new Robo();
		robo.ligar();
		robo2.ligar();
		ringue.mover(robo, 2, 2);
		ringue.mover(robo2, 1, 1);
		
		assertEquals(1, ringue.getPosicao(2,2));
		assertEquals(2, ringue.getPosicao(1,1));
		assertEquals(2, robo.getPosicaoX());
		assertEquals(2, robo.getPosicaoY());
		assertEquals(1, robo2.getPosicaoX());
		assertEquals(1, robo2.getPosicaoY());
	}
	
	@Test(expected = PosicaoNoRingueInvalidaException.class)
	public void naoDeveMoverRoboNoRinguePorqueJaTemUmRoboNaPosicao() throws PosicaoNoRingueInvalidaException, RoboDesligadoException {
		Ringue ringue = new Ringue(6,6);
		
		Robo robo = new Robo();
		Robo robo2 = new Robo();
		robo.ligar();
		robo2.ligar();
		ringue.mover(robo, 2, 2);
		ringue.mover(robo2, 2, 2);
	}
	
	@Test(expected = PosicaoNoRingueInvalidaException.class)
	public void naoDeveMoverRoboPorqueAPosicaoXExcedeTamanhoDoRingue() throws PosicaoNoRingueInvalidaException, RoboDesligadoException {
		Ringue ringue = new Ringue(6,6);
		
		Robo robo = new Robo();
		Robo robo2 = new Robo();
		robo.ligar();
		robo2.ligar();
		ringue.mover(robo, 7, 2);
		ringue.mover(robo2, 2, 2);
		
		assertEquals(7, robo.getPosicaoX());
	}
	
	@Test(expected = PosicaoNoRingueInvalidaException.class)
	public void naoDeveMoverRoboPorqueAPosicaoYExcedeOTamanhoDoRingue() throws PosicaoNoRingueInvalidaException, RoboDesligadoException {
		Ringue ringue = new Ringue(6,6);
		
		Robo robo = new Robo();
		Robo robo2 = new Robo();
		robo.ligar();
		robo2.ligar();
		ringue.mover(robo, 2, 2);
		ringue.mover(robo2, 2, 7);
		
		assertEquals(7, robo.getPosicaoX());
	}
	
	@Test
	public void devePromoverALutaEmPosicoesXYIguaisEFinalizarIniciandoNovoRound() throws PosicaoNoRingueInvalidaException, RoboDesligadoException{
		Robo robo1 = new Robo();
		Robo robo2 = new Robo();
		Ringue ringue = new Ringue(5,5);
		
		robo1.ligar();
		robo2.ligar();
		
		ringue.mover(robo1, 2, 2);
		ringue.mover(robo2, 3, 3);
		ringue.lutar(robo1, robo2, 3, 1);
		
		assertEquals(0, robo1.getPosicaoX());
		assertEquals(0, robo1.getPosicaoY());
		assertEquals(0, robo2.getPosicaoX());
		assertEquals(0, robo2.getPosicaoY());
	}
	
	@Test
	public void devePromoverALutaEmPosicoesXYDiferentesEFinalizarIniciandoNovoRound() throws PosicaoNoRingueInvalidaException, RoboDesligadoException{
		Robo robo1 = new Robo();
		Robo robo2 = new Robo();
		Ringue ringue = new Ringue(5,5);
		
		robo1.ligar();
		robo2.ligar();
		
		ringue.mover(robo1, 1, 2);
		ringue.mover(robo2, 2, 3);
		ringue.lutar(robo1, robo2, 3, 1);
		
		assertEquals(0, robo1.getPosicaoX());
		assertEquals(0, robo1.getPosicaoY());
		assertEquals(0, robo2.getPosicaoX());
		assertEquals(0, robo2.getPosicaoY());
	}
	
	@Test
	public void devePromoverALutaEmPosicoesXYDiferentesEContinuarLutando() throws PosicaoNoRingueInvalidaException, RoboDesligadoException{
		Robo robo1 = new Robo();
		Robo robo2 = new Robo();
		Ringue ringue = new Ringue(5,5);
		
		robo1.ligar();
		robo2.ligar();
		
		ringue.mover(robo1, 1, 2);
		ringue.mover(robo2, 2, 3);
		ringue.lutar(robo1, robo2, 2, 1);
		
		assertEquals(1, robo1.getPosicaoX());
		assertEquals(2, robo1.getPosicaoY());
		assertEquals(2, robo2.getPosicaoX());
		assertEquals(3, robo2.getPosicaoY());
	}
	
	


}
