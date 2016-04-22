package asrsSystem;
/*
 * Authors: Steven
 */
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import shared.*;
public class Choosefile {
	
	private String path;
	private ArrayList<shared.Product> productlist;
	
	public void ChooseFile() {
		Console console = new Console();
		
		
	    JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("kies uw XML file");
	    chooser.addChoosableFileFilter(new FileNameExtensionFilter("xml Documents", "xml") );
	    chooser.setAcceptAllFileFilterUsed(false);
	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	    File selectedFile = chooser.getSelectedFile();
	      this.path = selectedFile.getAbsolutePath();
	      ParseXML order = new ParseXML(path);
	      productlist = order.getProductList();
	      System.out.println(productlist);
	      console.printLine("Document geselecteerd! path:" + path );
	      console.printLine("volgende producten zijn geselecteerd: " + productlist);
	    } else {
	    	console.printLine("geen of ongeldig document geselecteerd!");
	    }
	    console.printLine("Document geselecteerd! path:" + path );
	    
	    
	}  
	  
}
