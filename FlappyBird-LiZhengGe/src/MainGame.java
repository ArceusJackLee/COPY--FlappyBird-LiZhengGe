import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class MainGame extends Applet implements Runnable, KeyListener, MouseListener {
	Image OffScreen;																	//后备缓冲图像
	Graphics OffScreenGraphics;												//后备缓冲区层
	Thread newThread;																//Game线程
	GameState currentState;														//当前游戏状态
	
	public void init(){
		this.setSize(1500, 800);
		addKeyListener(this);														//添加键盘监听
		addMouseListener(this);													//添加鼠标监听
		currentState = new GameStart(this);
		this.setVisible(true);
		newThread = new Thread(this);
		newThread.start();
	}
	
	public void run(){
		while(newThread != null){
			currentState.update();													//催动当前状态更新
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repaint();
		}
	}
	
	public void Paint(Graphics g){
		if(currentState == null) 
			return;
		if(OffScreen == null){
			OffScreen = createImage(this.getWidth(), this.getHeight());
			OffScreenGraphics = OffScreen.getGraphics();
		}
		OffScreenGraphics.setColor(Color.WHITE);
		OffScreenGraphics.fillRect(0, 0, 1500, 800);
		//将当前游戏状态渲染到游戏次画面上
		currentState.draw(OffScreenGraphics);
		g.drawImage(OffScreen, 0, 0, this);									//将次画面渲染到主画面
	}
	
	public void update(Graphics g){
		Paint(g);
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		// TODO Auto-generated method stub
		currentState.keyPressed(ke);
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		// TODO Auto-generated method stub
		currentState.mouseClicked(me);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void ChangeStateTo(GameState NextState){
		this.currentState = NextState;
		validate();
	}

}
