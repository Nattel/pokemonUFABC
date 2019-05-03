
public class Objetos {
	public int imgX, imgY, imgLarg, imgAlt, posX, posY, larg, alt, boxX, boxY, boxLarg, boxAlt;
	boolean colidivel;
	public Hitbox box;
	String imagem;
				   //dimensões do objeto
	public Objetos(String imagem,  int imgX, int imgY, int imgLarg, int imgAlt,	//imagem no arquivo     
				   int posX, int posY,											//imagem no jogo 
				   boolean colidivel, int boxX, int boxY, int boxLarg, int boxAlt
				   ) {
		this.imagem = imagem;
		this.imgX = imgX;
		this.imgY = imgY;
		this.imgLarg = imgLarg;
		this.imgAlt = imgAlt;
		
		this.posX = posX;
		this.posY = posY;
		
		this.colidivel = colidivel;
		this.boxX = boxX;
		this.boxY = boxY;
		this.boxLarg = boxLarg;
		this.boxAlt  = boxAlt;
		
		box = new Hitbox(boxX, boxY, boxX + boxLarg, boxY + boxAlt);
	}
	
	
	
	public void desenhar(Tela tela) {
		if(imagem != "")tela.imagem(imagem, imgX, imgY, imgLarg, imgAlt, 0, posX, posY);
	}
}
