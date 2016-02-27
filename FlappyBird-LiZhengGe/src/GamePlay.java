import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class GamePlay implements GameState{
	MainGame mg;
	ArrayList<Sample> Brick = new ArrayList();						//用ArrayList来存放Sample类的东西
	ArrayList<Sample> BrickDown = new ArrayList();
	int BrickFlag;																	//记录哪一个砖块撞了
	int HighScore;																	//高分记录
	Ball b;																				//球
	Image background;															//背景
	AudioClip ad;
	public GamePlay(MainGame mg){
		ClassLoader classLoader = this.getClass().getClassLoader();
		this.mg = mg;
		ad = Applet.newAudioClip(classLoader.getResource("Sounds/Wing.wav"));
		background = Toolkit.getDefaultToolkit().getImage("Images/background.png");
		b = new Ball(200,200,100,100,0,0, "Sounds/bird_mid.png");
		int random = (int)(Math.random()*10) * 30 + 50;
		int random2 = 500 - random;
		Brick.add(new Brick(1500,0,100,random,-5,0, "Images/BrickUp.png"));
		BrickDown.add(new Brick(1500,800-random2,100,random2,-5,0, "Images/BrickDown.png"));
		BrickFlag = 0;
		ad.play();
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.DeadAndLive();
		b.Move();
		b.Collision(mg, this);
		for(int i = 0; i < Brick.size(); i++){
			Sample a = (Sample)Brick.get(i);
			a.Move();
			b.CollisionSample(a, this, mg);
				b.record = BrickFlag;
		}
		for(int i = 0; i < BrickDown.size(); i++){
			Sample aD = (Sample)BrickDown.get(i);
			aD.Move();
			b.CollisionSampleDown(aD, this, mg);
				b.record = BrickFlag;
		}
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(background, 0, 0, mg.getWidth(), mg.getHeight(), null);
		b.Draw(g);
		for(int i = 0; i < Brick.size(); i++){
			Sample a = (Sample)Brick.get(i);
			a.Draw(g);
		}
		for(int i = 0; i < BrickDown.size(); i++){
			Sample a = (Sample)BrickDown.get(i);
			a.Draw(g);
		}
	}

	@Override
	public void transActionState() {
		// TODO Auto-generated method stub
		GameEnd ge = new GameEnd(mg);
		ge.PointCounting(this);
		mg.ChangeStateTo(ge);
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		// TODO Auto-generated method stub
		int key = ke.getKeyCode();
		if(key == KeyEvent.VK_ESCAPE)
			transActionState();
		else{
			ad.play();
			b.KeyPressed(key);
		}
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	public void DeadAndLive(){
		int random = (int)(Math.random()*10) * 30 + 50;
		int random2 = 500 - random;
		for(int i = 0; i< Brick.size(); i ++){
			Sample s = (Sample)Brick.get(i);
			if(s.flag == 0 && s.px >= 1000 && s.px + s.vx <= 1000 && s.py == 0 ){
				Brick.add(new Brick(1500,0,100, random ,-5,0, "Images/BrickUp.png"));
				BrickFlag++;
				s.flag = 1;
			}
			if(s.px + s.w< 0){
				Brick.remove(i);
			}
		}
		for(int i = 0; i< BrickDown.size(); i ++){
			Sample s = (Sample)BrickDown.get(i);
			if(s.flag == 0 && s.px >= 1000 && s.px + s.vx <= 1000 && s.py != 0){
				BrickDown.add(new Brick(1500,800 - random2,100,random2,-5,0, "Images/BrickDown.png"));
				s.flag = 1;
			}
			if(s.px + s.w< 0){
				BrickDown.remove(i);
			}
		}
	}
}
