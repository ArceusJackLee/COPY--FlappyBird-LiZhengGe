import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;

public class GameEnd extends Panel implements GameState, ActionListener {
	GamePlay gp;
	MainGame mg;
	int j,k,record,t,tj,tk;															//用一个数组来表示最后分数
	int hj,hk,HighScore,ht,htj,htk;											//用另外一个数组来表示最高分
	Image bg;																			//背景图片
	Image l, r, tr;
	Image b1,q1;																			//Start和Exit按钮图片
	Image Num;																		//分数
	int MouseFlag;																	//判断 鼠标是否点击图片
	Button Restart, Exit;
	AudioClip ad;
	public GameEnd(MainGame mg){
		ClassLoader classLoader = this.getClass().getClassLoader();
		this.mg = mg;
		ad = Applet.newAudioClip(classLoader.getResource("Sounds/Point.wav"));
		bg = Toolkit.getDefaultToolkit().getImage("Images/background.png");							//背景图片
		l = Toolkit.getDefaultToolkit().getImage("Images/Letter.png");										//文字图片GameOver
		b1 = Toolkit.getDefaultToolkit().getImage("Images/Button.png");									//Start按钮图片
		q1 = Toolkit.getDefaultToolkit().getImage("Images/Quit.png");										//Quit图标
		r = Toolkit.getDefaultToolkit().getImage("Images/Record.png");									//结果框架图片
		Num = Toolkit.getDefaultToolkit().getImage("Images/Number1.png");							//分数表示
		tr = Toolkit.getDefaultToolkit().getImage("Images/Number1.png");	
		MouseFlag = 0;
		ad.play();
	}
	
	public void PointCounting(GamePlay gp){
		record = (gp.b.record - 2) % 10;
		if(record < 0)
			record = 0;
		j = record / 5;
		k = record - (5 * j);
		t = (gp.b.record - 2) / 10;
		tj = t / 5;
		tk = t - (t * tj);
		if(gp.b.record - 2 >= HighScore){
			HighScore = (gp.b.record - 2) % 10;
		}
		hj = HighScore / 5;
		hk = HighScore - (5 * hj);
		ht = (gp.b.record - 2) / 10;
		htj = ht / 5;
		htk = ht - (5 * htj);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(bg, 0, 0, mg.getWidth(), mg.getHeight(), null);
		g.drawImage(l, 600, 100, 900, 200, 0, 90, 300, 170, null);
		g.drawImage(r, 586, 250, 935, 435, 0, 0, 389, 180, null);
		if(MouseFlag == 0){
			g.drawImage(b1, 661, 500, 839, 600, 0, 105, 178, 210, null);
		}
		if(MouseFlag == 1){
			g.drawImage(b1, 661, 500, 839, 600, 0, 210, 178,315, null);
		}
		System.out.println("The record is " +record);
		g.drawImage(Num, 750, 304, 775, 336, k * 25, j * 32, (k + 1)* 25, (j + 1)* 32, null);
		g.drawImage(tr, 725, 304, 750, 336, tk * 25, tj * 32, (tk + 1)* 25, (tj + 1)* 32, null);
		System.out.println("The HighScore is " +HighScore);
		g.drawImage(Num, 750, 368, 775, 400, hk * 25, hj * 32, (hk + 1)* 25, (hj + 1)* 32, null);
		g.drawImage(tr, 725, 368, 750, 400, htk * 25, htj * 32, (htk + 1)* 25, (htj + 1)* 32, null);
		g.drawImage(q1, 686, 610, 814, 738, 0, 0, 128, 128, null);
	}

	@Override
	public void transActionState() {
		// TODO Auto-generated method stub
		mg.removeAll();
		MainMenu mm = new MainMenu(mg);
		mg.ChangeStateTo(mm);
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		// TODO Auto-generated method stub
		int mx = me.getX();
		int my = me.getY();
		if(mx >= 661 && mx <= 839){
			if(my <= 600 && my >= 500){
				MouseFlag = 1;
				transActionState();
			}
		}
		if(mx >= 686 && mx <= 814){
			if(my >= 610 && my <= 738){
				System.exit(0);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

}
