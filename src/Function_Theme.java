import java.awt.Color;
public class Function_Theme {
	GUI gui;
	
	public Function_Theme(GUI gui) {
		this.gui = gui;
		
	}
	
	public void changeTheme(String theme) {
		switch (theme) {
		case "Default" : 
			gui.window.getContentPane().setBackground(Color.white);
			gui.textArea.setBackground(Color.white);
			gui.textArea.setForeground(Color.black);
			break;
		
		case "Dark" : 
			gui.window.getContentPane().setBackground(Color.black);
			gui.textArea.setBackground(Color.black);
			gui.textArea.setForeground(Color.white);
			break;
		
		case "Moonlight" : 
			gui.window.getContentPane().setBackground(new Color(165, 207, 255));
			gui.textArea.setBackground(new Color(165, 207, 255));
			gui.textArea.setForeground(Color.white);
			break;
		}
	}
	
}
