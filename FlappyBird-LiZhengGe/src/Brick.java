import java.awt.*;


public class Brick extends Sample{
	int flag = 0;
	String name;
	Image i;
	public Brick(int px, int py, int w, int h, int vx, int vy, String name){
		super(px,py,w,h,vx,vy);
		this.name = name;
		i = Toolkit.getDefaultToolkit().getImage("" + name);
	}
	public void Move(){
		vx = -5;
		vy = 0;
		px += vx;
		py += vy;
	}
	public void Draw(Graphics g){
		g.drawImage(i, px, py, w, h, null);
		
	}
	@Override
	public void Collision(MainGame mg, GamePlay gp) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void MouseTyped(int mx, int my) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void KeyPressed(int key) {
		// TODO Auto-generated method stub
		
	}



}
