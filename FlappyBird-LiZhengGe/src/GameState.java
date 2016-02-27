import java.awt.*;
import java.awt.event.*;

public interface GameState {
	public void update();
	public void draw(Graphics g);
	public void transActionState();							//改变游戏当前状态
	public void keyPressed(KeyEvent ke);
	public void mouseClicked(MouseEvent me);
}
