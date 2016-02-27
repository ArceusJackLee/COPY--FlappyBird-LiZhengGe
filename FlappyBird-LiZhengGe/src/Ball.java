
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;



public class Ball extends Sample {
	int a;
	Image i;
	String name;
	int record;
	public Ball(int px, int py, int w, int h, int vx, int vy, String name){
		super(px,py,w,h,vx,vy);
		a = 0;
		record = 0;
		this.name = name;
		i = Toolkit.getDefaultToolkit().getImage("" +name);
	}
	public void Move(){
		vy += a; 
		py += vy;
		px += vx;
	}
	public void Collision(MainGame mg, GamePlay gp){
		int mh = mg.getHeight();
		if(py + w >= mh){
			gp.transActionState();
		}
	}
	public void Draw(Graphics g){
		g.drawImage(i, px, py, w, h, null);
	}
	public void MouseTyped(int mx, int my){
	}
	public void KeyPressed(int key){
		if(key == KeyEvent.VK_SPACE){
			vy = -10;
			a = 1;
		}
	}

}
