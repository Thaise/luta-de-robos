import static org.junit.Assert.*;

import org.junit.Test;

public class RoboTest {
	
	@Test
	public void deveMoverRoboParaX() throws RoboDesligadoException{
		Robo robo = new Robo();
		Robo robo2 = new Robo();
		robo.mover(0, 0);
		robo2.mover(0, 0);
		
		assertEquals(0, robo.getPosicaoX());
		assertEquals(0, robo2.getPosicaoX());
	}

	@Test
	public void deveMoverRoboParaY() throws RoboDesligadoException{
		Robo robo = new Robo();
		Robo robo2 = new Robo();
		robo.mover(0, 0);
		robo2.mover(0, 0);
		
		assertEquals(0, robo.getPosicaoY());
		assertEquals(0, robo2.getPosicaoY());
	}
	
}
