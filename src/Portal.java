
public class Portal {
	public Hitbox box;
	String local;
	Portal(String local, int boxX, int boxY, int largX, int largY){
		box = new Hitbox(boxX, boxY, boxX+largX, boxY+largY);
		this.local = local;
	}
}
