import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI implements ActionListener{

	JFrame window;
	JTextArea textArea;
	JScrollPane scrollPane;
	boolean wordWrapOn = false;

	JMenuBar menuBar;
	JMenu menuFile, menuEdit, menuFormat, menuTheme;
	JMenuItem iNew, iOpen, iSave, iSaveAs, iExit ;
	JMenuItem iWrap, iFontSize, iFontArial, iFontCSMS, iFontTNR;
	JMenu menuFont;
	JMenuItem theme1, theme2, theme3;
	JMenuItem undo, redo;
	
	Function_File file = new Function_File(this);
	Function_Format format = new Function_Format(this);
	Function_Theme theme = new Function_Theme(this);

	Function_Edit edit = new Function_Edit(this);
	UndoManager um = new UndoManager();
	
	KeyHandlers kHandler= new KeyHandlers(this);
	
	public static void main(String[] args) {
		
		new GUI();
		
	}
	
	//this acts as main function for running whatever we want
	public GUI() {
		createWindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
		createFormatMenu();
		createEditMenu();
		format.selectedFont= "Arial";
//		format.createFont(16);
		format.wordWrap();
		createThemeMenu();
		theme.changeTheme("White");
		window.setVisible(true);
		
	}
	
	//this will create window
	public void createWindow() {
		window = new JFrame("Neha's Notepad");
		window.setSize(800, 600);
		//to close the window when cross is clicked
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		
	}
	
	public void createTextArea() {
		textArea = new JTextArea();
		textArea.setFont(format.arial);
		
		textArea.addKeyListener(kHandler);
		
		
		textArea.getDocument().addUndoableEditListener(
				new UndoableEditListener() {
			
			
			public void undoableEditHappened(UndoableEditEvent e) {
				um.addEdit(e.getEdit());
				
				
			}
		});
		
		//to add scroll bars horizontally and vertically
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
		
		//to remove the extra border scrollbar is creating 
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollPane);
		
		
	}
	
	
	public void createMenuBar() {
		menuBar = new JMenuBar();
		window.setJMenuBar(menuBar);
		
		menuFile = new JMenu("File");
		menuBar.add(menuFile);
		 
		menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);

		menuFormat = new JMenu("Format");
		menuBar.add(menuFormat);
		
		menuTheme = new JMenu("Theme");
		menuBar.add(menuTheme);
		
	}
	
	public void createFileMenu() {
		iNew = new JMenuItem("New");
		iNew.addActionListener(this);
		iNew.setActionCommand("New");
		menuFile.add(iNew);
		
		iOpen = new JMenuItem("Open");
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");
		menuFile.add(iOpen);
		
		iSave = new JMenuItem("Save");
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		menuFile.add(iSave);
		
		iSaveAs = new JMenuItem("Save As");
		iSaveAs.addActionListener(this);
		iSaveAs.setActionCommand("SaveAs");
		menuFile.add(iSaveAs);
		
		iExit = new JMenuItem("Exit");
		iExit.addActionListener(this);
		iExit.setActionCommand("Exit");
		menuFile.add(iExit);
	}
	
	public void createFormatMenu() {
		iWrap = new JMenuItem("Word warp: off");
		iWrap.addActionListener(this);
		iWrap.setActionCommand("WordWrap");
		menuFormat.add(iWrap);
		
		iFontSize = new JMenuItem("FontSize");
		iFontSize.addActionListener(this);
		iFontSize.setActionCommand("FontSize");
		menuFormat.add(iFontSize);
		
		menuFont = new JMenu("Font");
		menuFormat.add(menuFont);
		
		iFontArial = new JMenuItem("Arial");
		iFontArial.addActionListener(this);
		iFontArial.setActionCommand("Arial");
		menuFont.add(iFontArial);
		
		
		iFontCSMS = new JMenuItem("Sans serif");
		iFontCSMS.addActionListener(this);
		iFontCSMS.setActionCommand("Comic sans");
		menuFont.add(iFontCSMS);
		
		iFontTNR = new JMenuItem("Times new roman");
		iFontTNR.addActionListener(this);
		iFontTNR.setActionCommand("Times new roman");
		menuFont.add(iFontTNR);
		
		
		
	}
	
	public void createEditMenu() {
		undo = new JMenuItem("Undo");
		undo.addActionListener(this);
		undo.setActionCommand("Undo");
		menuEdit.add(undo);
		
		redo = new JMenuItem("Redo");
		redo.addActionListener(this);
		redo.setActionCommand("Redo");
		menuEdit.add(redo);
		
		
	}

	public void createThemeMenu() {
		theme1 = new JMenuItem("Default theme");
		theme1.addActionListener(this);
		theme1.setActionCommand("Default");
		menuTheme.add(theme1);
		
		theme2 = new JMenuItem("Dark theme");
		theme2.addActionListener(this);
		theme2.setActionCommand("Dark");
		menuTheme.add(theme2);
		
		theme3 = new JMenuItem("Moonlight theme");
		theme3.addActionListener(this);
		theme3.setActionCommand("Moonlight");
		menuTheme.add(theme3);
		
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
//		 if (e.getSource()==iFontSize){
//
//	            String sizeOfFont = JOptionPane.showInputDialog(window,"Enter Font Size",JOptionPane.OK_CANCEL_OPTION);
//	                if (sizeOfFont != null){
//	                    int convertSizeOfFont = Integer.parseInt(sizeOfFont);
//	                    Font font = new Font(Font.SANS_SERIF,Font.PLAIN,convertSizeOfFont);
//	                    textArea.setFont(selectedfont);
//	                }
//	        }
//		int fontSize = iFontSize;
		String command = e.getActionCommand();
		
		switch(command) {
		case "New" :file.newFile(); break;
		case "Open" :file.open(); break;
		case "Save" :file.save(); break;
		case "SaveAs" : file.saveAs(); break;
		case "Exit" : file.exit(); break;
		case "Undo" : edit.undo();break;
		case "Redo" : edit.redo();break;
		case "WordWrap" : format.wordWrap(); break;
		case "FontSize" : format.createFont(16); break;
		case "Arial" : format.setFont("arial"); break;
		case "Comic sans" : format.setFont("comicSansMS"); break;
		case "Times new roman" : format.setFont("timesNewRoman"); break;
		case "Default" : theme.changeTheme(command); break;
		case "Dark" : theme.changeTheme(command); break;
		case "Moonlight" : theme.changeTheme(command); break;

		}
		
		
		  
	} 
	
}
