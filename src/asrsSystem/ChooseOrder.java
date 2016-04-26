package asrsSystem;
/*
 * Authors: Steven
 */
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import shared.*;
public class ChooseOrder {
	
	private String path;
	private ArrayList<shared.Product> productlist;
	public static boolean selected = false;
	ParseXML order;
	
	public void ChooseFile() {
		Console console = new Console();
		Pakbon pakbon = new Pakbon();
		
		
		
	    JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("kies uw XML file");
	    chooser.addChoosableFileFilter(new FileNameExtensionFilter("xml Documents", "xml") );
	    chooser.setAcceptAllFileFilterUsed(false);
	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	    File selectedFile = chooser.getSelectedFile();
	      this.path = selectedFile.getAbsolutePath();
	      console.printLine("xml bestand geselecteerd. path: "+path);
	      console.printLine("parsing xml file...");
	      order = new ParseXML(path);
	      this.productlist = order.getProductList();
	      System.out.println(productlist);
	      console.printLine("parsing compleet! geselecteerde producten:" + productlist);
	      selected = true;
	      
	      
	    } else {
	    	console.printLine("geen order geselecteerd! selecteer een order om het programma te gebruiken!");
	    }
	    
	    
	}
	
	public static boolean returnSelected() {
		return selected;
	}
	
	public String getKlantInfo() {
		return ""+order.getBestelling().getKlant().getVoorNaam()+" "+order.getBestelling().getKlant().getAchterNaam();
	}
	
	public String getAdres() {
		return ""+order.getBestelling().getKlant().getAdres();
	}
	
	public String getOrderNr() {
		return ""+order.getBestelling().getOrdernr();
	}
	
	public ArrayList<shared.Product> getProductList() {
		return productlist;
	}
	  
}	
