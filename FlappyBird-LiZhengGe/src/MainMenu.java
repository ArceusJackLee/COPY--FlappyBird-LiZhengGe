import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends Panel implements GameState, ActionListener{
	MainGame mg;
	Image bg;																			//±³¾°Í¼Æ¬
	Image l;																			//×ÖÄ»Í¼Æ¬
	Image b1,q1;																		//StartºÍExit°´Å¥Í¼Æ¬
	int MouseFlag;																	//ÅÐ¶Ï Êó±êÊÇ·ñµã»÷Í¼Æ¬
	Button Start, Exit;																//ÉèÖÃ¿ªÊ¼ÍË³öÁ½¸ö°´Å¥
	AudioClip bgm;
	
	public MainMenu (MainGame mg){
		ClassLoader classLoader = this.getClass().getClassLoader();
		this.mg = mg;
		bgm = Applet.newAudioClip(classLoader.getResource("Sounds/DIN.wav"));
		bg = Toolkit.getDefaultToolkit().getImage("Images/background.png");
		l = Toolkit.getDefaultToolkit().getImage("Images/Letter.png");
		b1 = Toolkit.getDefaultToolkit().getImage("Images/Button.png");
		q1 = Toolkit.getDefaultToolkit().getImage("Images/Quit.png");	
		MouseFlag = 0;
		bgm.loop();
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(bg, 0, 0, mg.getWidth(), mg.getHeight(), null);
		g.drawImage(l, 600, 200, 900, 300, 0, 0, 300, 80, null);
		if(MouseFlag == 0){
			g.drawImage(b1, 661, 325, 839, 425, 0, 105, 178, 210, null);
		}
		if(MouseFlag == 1){
			g.drawImage(b1, 661, 325, 839, 425, 0, 210, 178,315, null);
		}
		g.drawImage(q1, 686, 450, 814, 578, 0, 0, 128, 128, null);
	}

	@Override
	public void transActionState() {
		// TODO Auto-generated method stub
		GamePlay gp = new GamePlay(mg);
		mg.ChangeStateTo(gp);
		mg.removeAll();
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
			if(my <= 425 && my >= 325){
				MouseFlag = 1;
				transActionState();
			}
			if(mx >= 686 && mx <= 814){
				if(my >= 450 && my <= 578){
					System.exit(0);
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = e.getActionCommand();
		if (s.equals(" Exit ! ")){
			System.exit(0);
		}
	}

}
