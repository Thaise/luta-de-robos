import java.util.ArrayList;

public class Ringue {

	//private double tempoInicio;
	//private Barreira barreira;
	//ArrayList<Robo> robos = new ArrayList<Robo>();
	private double largura;
	private double comprimento;
	private int entradaX = 0;
	private int entradaY = 0;
	Integer[][] tatame;
	
	public Ringue(int largura, int comprimento){
		if(largura > 0 && comprimento > 0){
			tatame = new Integer[largura][comprimento];
		}
	}

	public void mover(Robo robo, int x, int y) throws PosicaoNoRingueInvalidaException, RoboDesligadoException {
		if(x >= tatame.length || y >= tatame.length  || tatame[x][y] != null){
			throw new PosicaoNoRingueInvalidaException("Não é possível mover o robô nessa posição!");
		}else{
			tatame[x][y] = robo.getIdentificador();
			robo.mover(x,y);
		}
	}
	
	public void lutar(Robo robo1, Robo robo2, int golpe1, int golpe2) throws RoboDesligadoException{
		int x1 = robo1.getPosicaoX();
		int y1 = robo1.getPosicaoY();
		int x2 = robo2.getPosicaoX();
		int y2 = robo2.getPosicaoY();
		
		tatame[x1][y1] = robo1.getIdentificador();
		tatame[x2][y2] = robo2.getIdentificador();
		
		if(tatame[x1][y1] == tatame[x2][y2 + 1] || tatame[x1][y1] == tatame[x2 + 1][y2] ||
			tatame[x1][y1] == tatame[x2 + 1][y2 + 1]|| tatame[x2][y2] == tatame[x1 + 1][y1] ||
			tatame[x2][y2] == tatame[x1 + 1][y1 + 1] || tatame[x2][y2] == tatame[x1 + 1][y1 + 1]){
			
			System.out.println("Nova luta!!!"); 
			robo1.lutar(golpe1);
			robo2.lutar(golpe2);
			
			if(robo1.getLife() <= 0 || robo2.getLife() <= 0){
				if(robo1.getLife() > 0){
					System.out.println("O robô "+robo1.getNome()+" venceu!!!");
				}else{
					System.out.println("O robô "+robo2.getNome()+" venceu!!!");
				}
				System.out.println("Fim de luta!!!");
				novoRound(robo1, robo2);
			}else if(robo1.getLife() > 0 && robo2.getLife() > 0){
				System.out.println( "Lutando...");
			}
			System.out.println("life "+robo1.getNome()+" : "+robo1.getLife()+"\nlife "+robo2.getNome()+" : "+ robo2.getLife());
		}else{
			System.out.println("Os robôs não podem lutar por excesso de distância!");
		}
	}

	public void novoRound(Robo robo1, Robo robo2) throws RoboDesligadoException{
		robo1.mover(entradaX, entradaY);
		robo2.mover(entradaX, entradaY);	
	}

	public int getPosicao(int x, int y) {
		return tatame[x][y];
	}
}
