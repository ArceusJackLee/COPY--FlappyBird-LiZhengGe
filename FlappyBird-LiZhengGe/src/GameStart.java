import java.awt.*;
import java.awt.event.*;
import java.util.*;

/*
 * ��Ϸһ��ʼ�ͽ��뱾״̬��������ʾһ��ͼƬ��
 * ��һ��ʱ��󣬻���������������ʾ����һ��ͼƬ��
 * ֱ��ͼƬ��ʵ��ϣ�������һ����Ϸ״̬�����˵�״̬
 */

public class GameStart implements GameState{
	MainGame mg;																//���������ಢ����
	Vector<Image>images;													//���濪������ͼƬ
	int index;																		//��ʾ��ǰ�Ķ���ͼƬ�����
	int startTime;																//��ǰͼƬ��ʼ��ʱ��
	int currentTime;															//��ǰʱ��
	int life;																			//ͼƬ���ʱ��
	
	public GameStart(MainGame mg){
		this.mg = mg;
		images = new Vector<Image>();
		//����ͼƬ
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
		if(index < images.size() - 1){									//������滹��ͼƬ
			index ++;
			startTime = currentTime;
		}
		else{																		//���ͼƬ�Ѿ���ʾ��ϣ���ת����һ����Ϸ״̬
			MainMenu mm = new MainMenu(mg);
			mg.ChangeStateTo(mm);
		}
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		//��Ⱦ��Index��ͼƬ
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
