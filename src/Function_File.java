import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Function_File {
	
	GUI gui;
	String filename;
	String fileaddress;
	
	
	public Function_File(GUI gui) {
		this.gui = gui;
		
	}
	
	public void newFile() {
		gui.textArea.setText("");
		gui.window.setTitle("New");
		filename = null;
		fileaddress = null;
	}
	
	public void open() {
		FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
		fd.setVisible(true);
		
		if(fd.getFile()!=null) {
			filename = fd.getFile();
			fileaddress = fd.getDirectory();
			gui.window.setTitle(filename);
		}
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileaddress + filename));
			
			gui.textArea.setText(" ");
			
			String line = null;
			
			while((line = br.readLine()) != null) {
				gui.textArea.append(line + "\n");
			}
			
			br.close();
			
		}
		catch(Exception e) {
			System.out.print("FILE NOT OPENED");
		}
	}
	
	public void save() {
		if (filename==null) {
			saveAs();
		}
		else {
			try {
				FileWriter fw = new FileWriter(fileaddress + filename);
				fw.write(gui.textArea.getText());
				gui.window.setTitle(filename);
				fw.close();
			}
			catch(Exception e){
				
			}
		}
	}
	
	public void saveAs() {
		FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE);
		fd.setVisible(true);
		
		if (fd.getFile()!=null) {
			filename = fd.getFile();
			fileaddress = fd.getDirectory();
			gui.window.setTitle(filename);
		}
		
		try {
			FileWriter fw = new FileWriter(fileaddress + filename);
			fw.write(gui.textArea.getText());
			fw.close();
			
		}
	    catch(Exception e) {
	    	System.out.println("Something Wrong");
	    }
	}
	
	
	public void exit() {
		System.exit(0);
	}
	
}
