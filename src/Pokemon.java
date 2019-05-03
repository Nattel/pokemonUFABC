import java.util.Set;


import java.util.ArrayList;

public class Pokemon implements Jogo{
	Personagem heroi = new Personagem("assets/imagens/greenHero.png", 225, 376);
	ArrayList<Objetos> objetos = new ArrayList<Objetos>();
	ArrayList<Portal> portal = new ArrayList<Portal>();
	ArrayList<Personagem> personagem = new ArrayList<Personagem>();

	public Hitbox inEstacionamentoCima = new Hitbox(604, 100, 604+20, 100+16);
	public Hitbox inEstacionamentoCima2 = new Hitbox(590, 80, 580+3, 80+16);
	public Hitbox inEstacionamentoCima3 = new Hitbox(630, 80, 620+10, 80+16);
	public Hitbox outEstacionamentoCima = new Hitbox(610, 90, 600+20, 18+20);
	
	public Hitbox inEstacionamentoBaixo = new Hitbox(640, 260, 640+133, 260+8);
	public Hitbox outEstacionamentoBaixo = new Hitbox(640, 268, 640+133, 280+5);
	
	boolean isInEstacionamento = false;
	
	int passos = 0;
	
	String music = "/home/nattel/eclipse-wokspace/pokemonUFABC/assets/audio/hino-da-uniao-sovietica-urss.wav", musicPlaying = "";
	
	public void criarObjetos() {
		portal.add(new Portal("No bloco A!", 225, 300, 19, 60));
		
		objetos.add(new Objetos("assets/imagens/estacionamentoDireita.png", 0, 0, 346, 270, 346, 0, false, 0, 0, 0, 0));
		objetos.add(new Objetos("assets/imagens/estacionamentoEsquerda.png", 0, 0, 310, 96, 0, 57, false, 0, 0, 0, 0));
		
		
		objetos.add(new Objetos("assets/imagens/chao.png", 0, 0, 774, 560, 0, 0, false, 271, 0, 300, 690));
		
		
		/*Praça do RU*/{
			objetos.add(new Objetos("assets/imagens/gramaRU.png", 0, 8, 203, 56, 444, 0, false, 0, 0, 0, 0));
			objetos.add(new Objetos("assets/imagens/arvore.png", 0, 5, 32, 45, 464, 0, true, 470, 0, 0, 0));
				objetos.add(new Objetos("", 0, 0, 0, 0, 0, 0, true, 450, 40, 25, 5));
			
			objetos.add(new Objetos("assets/imagens/arvore.png", 0, 5, 32, 45, 564, 0, true, 570, 0, 0, 0));
				objetos.add(new Objetos("", 0, 0, 0, 0, 0, 0, true, 550, 40, 25, 5));
		
			objetos.add(new Objetos("assets/imagens/escadaRU.png", 0, 0, 26, 52, 623, 17, false, 0, 0, 0, 0));
		}
		
		
		objetos.add(new Objetos("assets/imagens/gradeDireita.png", 0, 0, 320, 296, 340, 10, true, 345, 264, 325, 0));
		objetos.add(new Objetos("assets/imagens/gradeDireita.png", 0, 164, 3, 26, 647, 0, true, 633, 0, 3, 94));		
		
		
		objetos.add(new Objetos("assets/imagens/gradeEsquerda.png", 0, 0, 324, 112, 0, 45, false, 0, 0, 0, 0));


		
		objetos.add(new Objetos("assets/imagens/espelhoDagua.png", 0, 0, 386, 107, 266, 302, false, 266, 302, 360, 105));
		
		
		objetos.add(new Objetos("assets/imagens/gradeRampa.png", 0, 0, 365, 60, 263, 363, true, 0, 0, 0, 0));
			objetos.add(new Objetos("", 0, 0, 365, 199, 268, 363, true, 263, 363, 370, 45));
		objetos.add(new Objetos("assets/imagens/gradeRampa.png", 0, 74, 365, 30, 263, 437, true, 268, 434, 354, 1));
		objetos.add(new Objetos("assets/imagens/gradeRampa.png", 0, 186, 365, 156, 267, 549, true, 268, 555, 364, 3));
		
		
		objetos.add(new Objetos("assets/imagens/blocoB.png", 0, 0, 121, 230, 579, 150, true, 565, 308, 100, 66));
		objetos.add(new Objetos("assets/imagens/blocoA.png", 0, 0, 518, 214, 41, 166, true, 0, 310, 0, 50));
			objetos.add(new Objetos("", 0, 0, 518, 214, 41, 166, true, 61, 308, 150, 50));
			objetos.add(new Objetos("", 0, 0, 518, 214, 41, 166, true, 250, 308, 305, 50));
		
		
		
		/*Estacionamento esquerdo*/{
			objetos.add(new Objetos("", 0, 0, 0, 0, 0, 0, true, 0, 160, 210, 2));
			objetos.add(new Objetos("", 0, 0, 0, 0, 0, 0, true, 0, 140, 235, 2));
			objetos.add(new Objetos("", 0, 0, 0, 0, 0, 0, true, 0, 130, 260, 2));
			objetos.add(new Objetos("", 0, 0, 0, 0, 0, 0, true, 10, 110, 265, 2));
			objetos.add(new Objetos("", 0, 0, 0, 0, 0, 0, true, 30, 95, 250, 2));
			objetos.add(new Objetos("", 0, 0, 0, 0, 0, 0, true, 50, 80, 250, 2));
		}
		
		/*Estacionamento direito*/{
			objetos.add(new Objetos("", 0, 0, 0, 0, 0, 0, true, 345, 160, 2, 95));
			objetos.add(new Objetos("", 0, 0, 0, 0, 0, 0, true, 365, 135, 15, 15));
			objetos.add(new Objetos("", 0, 0, 0, 0, 0, 0, true, 385, 120, 15, 15));
			objetos.add(new Objetos("", 0, 0, 0, 0, 0, 0, true, 405, 105, 15, 15));
			objetos.add(new Objetos("", 0, 0, 0, 0, 0, 0, true, 420, 90, 15, 15));
			objetos.add(new Objetos("", 0, 0, 0, 0, 0, 0, true, 420, 80, 15, 15));
		}
		
		/*grades de cima (ambos estacionamentos)*/{
			objetos.add(new Objetos("", 0, 0, 0, 0, 0, 0, true, 55, 70, 250, 2));
			
			objetos.add(new Objetos("", 0, 0, 0, 0, 0, 0, true, 440, 70, 150, 5));
			objetos.add(new Objetos("", 5, 10, 3, 34, 620, 10, true, 603, 30, 1, 34));
		}
			
		objetos.add(new Objetos("assets/imagens/arbusto.png", 0, 0, 15, 15, 207, 437, true, 210, 438, 6, 1));
		objetos.add(new Objetos("assets/imagens/arbusto.png", 0, 0, 15, 15, 147, 437, true, 150, 438, 6, 1));
		objetos.add(new Objetos("assets/imagens/arbusto.png", 0, 0, 15, 15, 87, 437, true, 90, 438, 6, 1));
		objetos.add(new Objetos("assets/imagens/arbusto.png", 0, 0, 15, 15, 27, 437, true, 35, 438, 6, 1));
		
		objetos.add(new Objetos("assets/arquivosUteis/uou.png", 5, 10, 3, 34, 223, 376, true, 223, 376, 1, 34));
		
		/*limites da tela*/{
			objetos.add(new Objetos("", 0, 0, 0, 0, 0, 0, true, 0, 0, -1, getAltura()));
			objetos.add(new Objetos("", 0, 0, 0, 0, 0, 0, true, 0, 0, getLargura(), 15));
			objetos.add(new Objetos("", 0, 0, 0, 0, 0, 0, true, 0, getAltura(), getLargura(), -15));
			objetos.add(new Objetos("", 0, 0, 0, 0, 0, 0, true, getLargura(), 0, -15, getAltura()));
		}
		
	}

	public void criarPersonagens() {
		personagem.add(new Personagem("assets/imagens/lollyVomito.png", 666, 370));
	}
	
	public Pokemon(){
		criarObjetos();
		criarPersonagens();
		if(musicPlaying == "") {
			Motor.tocar(music);
			musicPlaying = music;
		}
	}
	
	private boolean notColiding(int i, int j) {
		double passo;
		if(i != 0) passo = heroi.passoX;
		else	   passo = heroi.passoY;
		for(int k = 1; k < passo; k++) {
			heroi.box.mover(i, j);
			
			for(Objetos obj: objetos) {
				if(obj.colidivel == true && heroi.box.intersecao(obj.box) != 0) {
					heroi.box.mover(-i*k, -j*k);
					System.out.println("col");
					return false;
				}
			}
			
			for(Personagem p: personagem) {
				if(heroi.box.intersecao(p.box) != 0) {
					heroi.box.mover(-i*k, -j*k);
					System.out.println("col");
					return false;
				}
					
			}
		}
		return true;
	}

	//há um bug quando se vira o heroi sem andar 
	//quando ele está parado e o jogador aperta para um lado que o heroi não está virado
	//o heroi deve virar e então no próximo movimento andar
	//porém há algo no tempo de clique que mesmo quando o jogador dá o clique o mais rápido possível
	//o clique é contado mais de uma vez e ele já se coloca em movimento 
	
	//fazer de outro modo pois assim diminui a velocidade dos outros objetos moviveis
	public void enrolarUmPouco(long tempoDeEnrolacao) {
		long inicioTempo = System.nanoTime();
		while((System.nanoTime() - inicioTempo) < tempoDeEnrolacao);
	}
	public String getTitulo(){
		return "Pokémon - UFABC Simutalor";
	}

	public int getLargura(){
		return 774;
	}
	
	public int getAltura(){
		return 560;
	}
	
	public void tique(Set<String> keys, double dt){
		heroi.move(dt, keys);
		
		
		if(isInEstacionamento == true) {
			objetos.get(9).box.mover(345, 273, 345+325, 273+3);
		}else {
			objetos.get(9).box.mover(345, 263, 345+325, 263+3);
		}
		
		for(Objetos obj: objetos)
			if(obj.colidivel == true && heroi.box.intersecao(obj.box) != 0)
				System.out.println("Colisão");
		
		for(Portal p: portal)
			if(heroi.box.intersecao(p.box) != 0) {
				System.out.println(p.local);
			}
		
		if(heroi.box.intersecao(inEstacionamentoCima3) != 0 || heroi.box.intersecao(inEstacionamentoCima2) != 0 || heroi.box.intersecao(inEstacionamentoCima) != 0 || heroi.box.intersecao(inEstacionamentoBaixo) != 0) {
			System.out.println("No estacionamento");
			isInEstacionamento = true; 
		}
		if(heroi.box.intersecao(outEstacionamentoCima) != 0 || heroi.box.intersecao(outEstacionamentoBaixo) != 0) {
			System.out.println("Fora do estacionamento");
			isInEstacionamento = false; 
		}
		
		if(heroi.inMovement == false && !keys.isEmpty()) {
			if(heroi.passos == 100) heroi.passos -= 90;
			
			switch(keys.iterator().next()){
				case "a":{
					if(heroi.sideX == -1 && heroi.sideY == 0 && notColiding(-1, 0)) {
						heroi.passos += 1;
						heroi.setMovement(-1, 0);
	
						//modifica a imagem para fazer uma ilusão de estar movendo as pernas
						if(heroi.passos % 2 == 0)
							heroi.changeSide(52, 21, 15, 20, -1, 0);
						else
							heroi.changeSide(52, 41, 15, 20, -1, 0);
							
					}else {
						heroi.changeSide(52, 1, 15, 20, -1, 0);
						enrolarUmPouco(150000000);
					}
						
					break;
				}
				case "s":{
					if(heroi.sideX == 0 && heroi.sideY == 1 && notColiding(0, 1)) {
						heroi.setMovement(0, 1);
						heroi.passos += 1;
						
						if(heroi.passos % 2 == 0)
							heroi.changeSide(1, 21, 15, 20, 0, 1);
						else 
							heroi.changeSide(1, 41, 15, 20, 0, 1);
							
					}else {
						heroi.changeSide(1, 1, 15, 20, 0, 1);
						enrolarUmPouco(150000000);
					}
					break;
				}
				case "d":{
					if(heroi.sideX == 1 && heroi.sideY == 0 && notColiding(1, 0)) { 
						heroi.setMovement(1, 0);
						heroi.passos += 1;
						
						if(heroi.passos % 2 == 0)
							heroi.changeSide(35, 21, 15, 20, 1, 0);
						else
							heroi.changeSide(35, 41, 15, 20, 1, 0);
							
					}else { 
						heroi.changeSide(35, 1, 15, 20, 1, 0);
						enrolarUmPouco(150000000);
					}
					
					break;
				}
				case "w":{		
					if(heroi.sideX == 0 && heroi.sideY == -1 && notColiding(0, -1)) {
						heroi.setMovement(0, -1);
						heroi.passos += 1;
						
						if(heroi.passos % 2 == 0)
							heroi.changeSide(19, 21, 15, 20, 0, -1);
						else
							heroi.changeSide(19, 41, 15, 20, 0, -1);
							
					}else { 
						heroi.changeSide(19, 1, 15, 20, 0, -1);
						enrolarUmPouco(150000000);
					}
					break;
				}
				default:
					passos = 0;
			}
		}
	}
	
	public void tecla(String tecla){
		System.out.println(tecla);
	}

	public void desenhar(Tela tela){
		//tela.imagem(cidade, 0, 0, 774, 560, 0, 0, 0);
		//tela.imagem("pewter.png", 203, 153, 112, 78, 0, 113, 63);
		for(Objetos obj: objetos) 
			if(obj.colidivel == false || obj.boxY + obj.boxAlt <= heroi.posY)
				obj.desenhar(tela);
		
		heroi.desenhar(tela);
		for(Objetos obj: objetos) 
			if(obj.colidivel == true && obj.boxY + obj.boxAlt > heroi.posY)
				obj.desenhar(tela);
		
		if(isInEstacionamento == true) {
			for(int i = 2; i <= 19; i++)
				objetos.get(i).desenhar(tela);
			
			for(int i = 20; i<= 31; i++)
				objetos.get(i).colidivel = false;
		}else {
			for(int i = 20; i<= 31; i++)
				objetos.get(i).colidivel = true;
		}
		for(Personagem p: personagem) {
			p.desenhar(tela);
		}
	}
	
	public static void main(String[] args) {
        roda();
    }
    
    private static void roda() {
    	new Motor(new Pokemon());
    }


	
}
