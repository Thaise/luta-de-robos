import java.util.Scanner;

public class RoboNoRingue {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		String continuar = "S";
		while(continuar.equalsIgnoreCase("S")){
			Robo robo1 = new Robo();
			Robo robo2 = new Robo();
		
			try{
				robo1.ligar();
				robo2.ligar();
				
				System.out.print("Nome do robô 1: ");
				String nome1 = entrada.nextLine();
			
				robo1.setNome(nome1);
				
				System.out.print("Nome do robô 2: ");
				String nome2 = entrada.nextLine();
				
				robo2.setNome(nome2);
				
				System.out.print("Tamanho do ringue - largura e comprimento: ");
				String tamanhoRingueString = entrada.nextLine();
				String[] tamanhoRingueSplit = tamanhoRingueString.split(" ");
				int largura = Integer.parseInt(tamanhoRingueSplit[0]);
				int comprimento = Integer.parseInt(tamanhoRingueSplit[1]);
				
				Ringue ringue = new Ringue(largura,comprimento);
				
				System.out.print("Posição X do robô 1: ");
				String posicaox1String = entrada.nextLine();
				int posicaox1 = Integer.parseInt(posicaox1String);
				
				System.out.print("Posição Y do robô 1: ");
				String posicaoy1String = entrada.nextLine();
				int posicaoy1 = Integer.parseInt(posicaoy1String);
				
				ringue.mover(robo1, posicaox1, posicaoy1);
				
				System.out.print("Posição X do robô 2: ");
				String posicaox2String = entrada.nextLine();
				int posicaox2 = Integer.parseInt(posicaox2String);
				
				System.out.print("Posição Y do robô 2: ");
				String posicaoy2String = entrada.nextLine();
				int posicaoy2 = Integer.parseInt(posicaoy2String);	
				
				ringue.mover(robo2, posicaox2, posicaoy2);
				
				while(robo1.getLife() > 0 && robo2.getLife() > 0){
					System.out.print("Golpe do robo1 [1-empurrão / 2-pontapé / 3-soco]: ");
					String golpeString1 = entrada.nextLine();
					int golpe1Para2 = Integer.parseInt(golpeString1);
				
					System.out.print("Golpe do robo2 [1-empurrão / 2-pontapé / 3-soco]: ");
					String golpeString2 = entrada.nextLine();
					int golpe2Para1 = Integer.parseInt(golpeString2);
				
					ringue.lutar(robo1, robo2, golpe2Para1, golpe1Para2);
				}
				System.out.print("Deseja lutar novamente? [S - sim / N - não]: ");
				continuar = entrada.nextLine();
			
			}catch(PosicaoNoRingueInvalidaException e){
				System.out.println("Não é possível mover o robô nessa posição!");
			}catch(RoboDesligadoException e){
				System.out.println("O robô precisa estar ligado!");
			}
		}
	}
}
