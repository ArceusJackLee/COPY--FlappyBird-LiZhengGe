import java.awt.*;
import java.awt.event.*;
import java.util.*;

/*
 * 游戏一开始就进入本状态，首先显示一张图片；
 * 过一段时间后，或者鼠标点击画面后，显示另外一张图片；
 * 直到图片现实完毕，进入下一个游戏状态：主菜单状态
 */

public class GameStart implements GameState{
	MainGame mg;																//反引用主类并储存
	Vector<Image>images;													//保存开场动画图片
	int index;																		//表示当前的动画图片的序号
	int startTime;																//当前图片开始的时间
	int currentTime;															//当前时间
	int life;																			//图片存活时间
	
	public GameStart(MainGame mg){
		this.mg = mg;
		images = new Vector<Image>();
		//导入图片
		Image i1 = Toolkit.getDefaultToolkit().getImage("Images/Begin.png");
		images.add(i1);
		Image i2 = Toolkit.getDefaultToolkit().getImage("Images/background.png");
		images.add(i2);
		index = 0;
		life = 1000;
		startTime = 0;
		currentTime = 0;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(currentTime - startTime > life){
			transActionState();
		}
		else{
			currentTime ++;
		}
	}

	@Override
	public void transActionState() {
		// TODO Auto-generated method stub
		if(index < images.size() - 1){									//如果后面还有图片
			index ++;
			startTime = currentTime;
		}
		else{																		//如果图片已经显示完毕，则转向下一个游戏状态
			MainMenu mm = new MainMenu(mg);
			mg.ChangeStateTo(mm);
		}
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		//渲染第Index张图片
		Image i = images.get(index);
		g.drawImage(i, 0, 0, mg.getWidth(), mg.getHeight(), 0, 0, 1600, 900, null);
	}
	
	@Override
	public void keyPressed(KeyEvent ke) {
		// TODO Auto-generated method stub
		MainMenu mm = new MainMenu(mg);
		mg.ChangeStateTo(mm);
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		// TODO Auto-generated method stub
		MainMenu mm = new MainMenu(mg);
		mg.ChangeStateTo(mm);
	}

	}
