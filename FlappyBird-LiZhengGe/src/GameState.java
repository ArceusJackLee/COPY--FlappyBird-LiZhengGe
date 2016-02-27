import java.awt.*;
import java.awt.event.*;

public interface GameState {
	public void update();
	public void draw(Graphics g);
	public void transActionState();							//�ı���Ϸ��ǰ״̬
	public void keyPressed(KeyEvent ke);
	public void mouseClicked(MouseEvent me);
}
