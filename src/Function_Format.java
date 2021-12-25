import java.awt.*;

import javax.swing.JOptionPane;

public class Function_Format {
	GUI gui;
	Font arial, comicSansMS, timesNewRoman;
	String selectedFont;
	
	public Function_Format(GUI gui) {
		this.gui = gui;
		
	}
	
	public void wordWrap() {
		if (gui.wordWrapOn==false) {
			gui.wordWrapOn=true;
			gui.textArea.setLineWrap(true);
			gui.textArea.setWrapStyleWord(true);
			gui.iWrap.setText("Word Wrap: On");
		}
		else if (gui.wordWrapOn==true) {
			gui.wordWrapOn=false;
			gui.textArea.setLineWrap(false);
			gui.textArea.setWrapStyleWord(false);
			gui.iWrap.setText("Word Wrap: Off");
		}
	}
	
	
	public void  createFont(int size) {

        String sizeOfFont = JOptionPane.showInputDialog(gui.window,"Enter Font Size",JOptionPane.OK_CANCEL_OPTION);
        if (sizeOfFont != null){
        	int convertSizeOfFont= size;
            convertSizeOfFont = Integer.parseInt(sizeOfFont);
            arial = new Font("Arial", Font.PLAIN, convertSizeOfFont);
    		comicSansMS = new Font("SansSerif", Font.PLAIN, convertSizeOfFont);
    		timesNewRoman = new Font("Times new roman", Font.PLAIN, convertSizeOfFont);
            setFont(selectedFont);
        }
		
		
	}
	
	
	public void setFont(String font) {
		selectedFont = font;
		
		switch (selectedFont){
		case "arial" : gui.textArea.setFont(arial); break;
		case "comicSansMS " : gui.textArea.setFont(comicSansMS); break;
		case "timesNewRoman" : gui.textArea.setFont(timesNewRoman); break;
		
		}
		
	}
}
