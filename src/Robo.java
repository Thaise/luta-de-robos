
public class Robo {
	
	private static int quantidade;
	
	private boolean ligado;
	private int posicaoX;
	private int posicaoY;
	private String nome;
	private int identificador;
	Ringue ringuePosicao;
	int golpe;
	private int life = 10;
	
	public Robo(){
		quantidade++;
		identificador = quantidade;
	}
	
	public void ligar(){
		this.ligado = true;
	}
	
	public void desligar(){
		this.ligado = false;
	}
	
	public void mover(int x, int y) throws RoboDesligadoException{
		if(ligado == true){
			this.posicaoX = x;
			this.posicaoY = y;
		}else{
			throw new RoboDesligadoException("O robô precisa estar ligado!");
		}
	}

	public int getPosicaoX() {
		return posicaoX;
	}

	public int getPosicaoY() {
		return posicaoY;
	}

	public int getIdentificador() {
		return identificador;
	}
	
	public void lutar(int golpe){
		this.golpe = golpe;	
		if(golpe == 1){
			this.life -= 2;
		}else if(golpe == 2){
			this.life -=  3;
		}else if(golpe == 3){
			this.life -=  10;
		}
	}

	public int getLife(){
		return life;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}	
}
