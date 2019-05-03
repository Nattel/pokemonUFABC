import java.util.Set;

public class Personagem {
	public double posX, posY, prevMovePosX, 
			      prevMovePosY, vx = 0, vy = 0, velocidadeBase = 100, passoX = 20, passoY = 16;
	public int iniX = 1, fimX = 15, iniY = 1, fimY = 20, sideX = 0, sideY = 1, passos = 0;
	public boolean inMovement;
	String image;
	public Hitbox box;
	
	
	public Personagem(String image, double posX, double posY) {
		this.image = image;
		this.posX = posX;
		this.posY = posY;
		this.prevMovePosX = posX;
		this.prevMovePosY = posY;
		this.box = new Hitbox(this.posX, this.posY+5, this.posX+15, this.posY+11);
	}

	public void setMovement(int x, int y) {
		this.vx = x*velocidadeBase;
		this.vy = y*velocidadeBase;
		this.inMovement = true;
	}
	
	public void changeSide(int newIniX, int newIniY, int newFimX, int newFimY, int newSideX, int newSideY) {
		this.iniX = newIniX;
		this.iniY = newIniY;
		this.fimX = newFimX;
		this.fimY = newFimY;
		this.sideX = newSideX;
		this.sideY = newSideY;
	}
	
	
	public void move(double dt, Set<String> keys) {
		
		if(((passoX == 0 && passoY == 0) || ((!(passoX < 0) || passoX > 0)) && (!(passoY < 0) || passoY > 0) && (vx != 0 || vy != 0))) {

			passoX -= Math.abs(vx)*dt;
			passoY -= Math.abs(vy)*dt;

			posX += vx*dt;
			posY += vy*dt;
			
		}else if (vy != 0 || vx != 0){
			passoX = 20;
			passoY = 16;
			
			if(vx != 0) posX = prevMovePosX + (passoX*(vx/Math.abs(vx)));
			if(vy != 0) posY = prevMovePosY + (passoY*(vy/Math.abs(vy)));

			vx = 0;
			vy = 0;
			
			inMovement = false;
			
			prevMovePosX = posX;
			prevMovePosY = posY;
			
			
			System.out.println("x:"+posX+" y:"+posY);
			if(sideX == 0) {
				//movimento vertical
				if(sideY == 1) 
					changeSide(1, 1, 15, 20, 0, 1);
				else
					changeSide(19, 1, 15, 20, 0, -1);
				
			}else {
				//movimento horizontal
				if(sideX == 1) 
					changeSide(35, 1, 15, 20, 1, 0);
				
				else 
					changeSide(52, 1, 15, 20, -1, 0);
			}
		}
	}
	
	
	public void desenhar(Tela tela) {
		tela.imagem(image, iniX, iniY, fimX, fimY, 0, posX, posY);
		
		
		tela.imagem("assets/arquivosUteis/uou.png", 5, 10, 3, 3, 0, posX, posY+5);
		tela.imagem("assets/arquivosUteis/uou.png", 5, 10, 3, 3, 0, posX+15, posY+5);
		tela.imagem("assets/arquivosUteis/uou.png", 5, 10, 3, 3, 0, posX, posY+15);
		tela.imagem("assets/arquivosUteis/uou.png", 5, 10, 3, 3, 0, posX+15, posY+15);
		
		
	}
	
}
