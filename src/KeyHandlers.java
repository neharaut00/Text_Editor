import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class KeyHandlers implements KeyListener {
	GUI gui;
	public KeyHandlers (GUI gui) {
		this.gui = gui;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S) {
			gui.file.save();
		}
		
		if(e.isControlDown() && e.isShiftDown() && e.getKeyCode()==KeyEvent.VK_S) {
			gui.file.saveAs();
		}
		
		if(e.isAltDown() && e.getKeyCode()==KeyEvent.VK_F) {
			gui.menuFile.doClick();
		}
		
		if(e.isAltDown() && e.getKeyCode()==KeyEvent.VK_O) {
			gui.menuFormat.doClick();
		}
		
		
		if(e.isAltDown() && e.getKeyCode()==KeyEvent.VK_E) {
			gui.menuEdit.doClick();
		}
		
		if(e.isAltDown() && e.getKeyCode()==KeyEvent.VK_T) {
			gui.menuTheme.doClick();
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}
	
}
