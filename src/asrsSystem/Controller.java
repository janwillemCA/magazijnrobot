package asrsSystem;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import shared.Product;
/*
 * Authors: Richard en Steven, ICTM2A
 */

//Controller regelt algemene verbinding tussen de robot klasse, en de rest van de klasses.
public class Controller {
	private ArrayList<Location> initialTour;
	private ArrayList<Location> optimizedTour;
	private ArrayList<Doos> doosList;
	private ArrayList<Product> prodlist;
	private DrawPanel drawer;
	private Robot robot;
	private ImageIcon image;
	private boolean pressedGenerateRoute;
	private Warningfunctions warning = new Warningfunctions();
	
	
	//geef productlijst en een panel mee, deze methode zal dan de nodige methodes aanroepen die nodig zijn
	//om een route te genereren. panel word meegegeven omdat de doosinfo sectie een panel nodig heeft om images
	//weer te geven
	public void startRoute(ArrayList<Product> productlist, JPanel panel) {
		this.prodlist = productlist;
		Location location = new Location();
		initialTour = location.generateLocationlist(productlist);
		System.out.println("inittour"+initialTour);
		Route route = new Route();
		route.calculateRoute(initialTour);
		optimizedTour = route.getOptimizedTour();
		Console.printLine("Route gevonden!");
		drawer.setResult(optimizedTour, initialTour, productlist);
		drawer.repaint();
		doosList = Doos.generateDoosList(productlist);
		
		updateDoosinfo(panel);

	}
	
	
	public ArrayList<Location> getOptimizedTour() {
		return optimizedTour;
	}
	
	//default constructor voor controller, geef jpanel mee omdat drawpanel een panel nodig heeft.
	public Controller(JPanel container) {
		drawer = new DrawPanel();
		container.add(drawer, "cell 1 0,grow");
	}
	
	//deze methode aanroepen om naar een arduino op een COM poort te zoeken, werkt alleen op windows.
	public void Connect() {
		if(optimizedTour == null) {
			warning.showNullpointerWarning(null);
		}else{
		robot = new Robot();
		robot.openConnection(optimizedTour, doosList, this);
		}
	}
	
	//wanneer er een connectie is startrobot aanroepen, wanneer robot == null, warning laten zien
	public void StartRobot() {
		if(robot == null) {
			warning.showNoRobotMessage(null);
		}else{
		robot.start();
		}
	}
	
	//robotlocatie voor visuele weergave updaten, aanroepen in robotklasse als de arduino commando "C" terugstuurt.
	public void updateRobotLocation() {
		drawer.setRobotCounter();
	}

	

	// onderstaande code regelt weergave van aantal pakketten in de gui
	public void updateDoosinfo(JPanel panel) {
		
		image = new ImageIcon("src/img/smallCrate.png");
		
		int counter = 1;
		int index = 0;
		if(pressedGenerateRoute == true) {
			panel.removeAll();
	        JLabel lblDoosinfo = new JLabel("Doosinfo:");
	        panel.add(lblDoosinfo, "cell 1 1");
	        
	        JLabel lblDoosEen = new JLabel("Doos 1:");
	        panel.add(lblDoosEen, "cell 0 2");
	        
	        JLabel lblDoosTwee = new JLabel("Doos 2:");
	        panel.add(lblDoosTwee, "cell 0 3");
			panel.revalidate();
			panel.repaint();
		}
		for(Doos l:doosList) {
			
			if(l.doosId == 1) {
				for(Product p : l.getProductList()){
					JLabel imageIcon = new JLabel(image);
					JLabel pInfo = new JLabel(p.getProductName());
					panel.add(imageIcon,"cell "+counter+" 2");
					panel.add(pInfo,"cell "+counter+" 2");
					System.out.println(l.doosId);
					index++;
				}
			}
			
		}
		counter = 1;
		for(Doos l1:doosList) 
			if(l1.doosId == 2) {
				for(Product p : l1.getProductList()){
					JLabel imageIcon = new JLabel(image);
					JLabel pInfo = new JLabel(p.getProductName());
					panel.add(imageIcon, "cell "+counter+" 3");
					panel.add(pInfo,"cell "+counter+" 3");
					System.out.println(l1.doosId);
					index++;
				}
			}
		
		counter++;
		pressedGenerateRoute = true;
		}
	
	}


