import java.awt.Graphics;


abstract public class Sample {
	int px,py,w,h,vx,vy;
	int flag = 0;
	public Sample(int px, int py, int w, int h, int vx, int vy){
		this.px = px;
		this.py = py;
		this.w = w;
		this.h = h;
		this.vx = vx;
		this.vy = vy;
	}
	abstract public void Draw(Graphics g);
	abstract public void Move();
	abstract public void Collision(MainGame mg, GamePlay gp);
	abstract public void MouseTyped(int mx, int my);
	abstract public void KeyPressed(int key);
	public void CollisionSample(Sample s, GamePlay gp, MainGame mg){
		if((px + w >= s.px && px <= s.px + s.w) && 
				((py + h >= s.py && py <= s.py + s.h))){
			gp.transActionState();
		}
		if((py + h >= s.py && py <= s.py + s.h) && 
				((px + w >= s.px && px <= s.px + s.w))){
			gp.transActionState();
		}
	}
	public void CollisionSampleDown(Sample s, GamePlay gp, MainGame mg){
		if((px + w >= s.px && px <= s.px + s.w) && 
				((py + h >= s.py && py <= s.py + s.h))){
			gp.transActionState();
		}
		if((py + h >= s.py && py <= s.py + s.h) && 
				((px + w >= s.px && px <= s.px + s.w))){
			gp.transActionState();
		}
	}
}
