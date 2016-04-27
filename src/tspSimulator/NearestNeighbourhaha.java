
package tspSimulator;

import java.util.ArrayList;

import shared.Algorithm;
import shared.Resultaat;
import shared.Route;

/**
 * Authors: Jan Willem en Henri Class: ICTM2A
 */

public class NearestNeighbourhaha implements Algorithm {

	private String name;
	private ArrayList<Location> picklist;
	private DrawPanel panel;
	private Resultaat resultaat;


	public NearestNeighbourhaha(String name, ArrayList<Location> picklist) {
		this.name = name;
		this.picklist = picklist;
		resultaat = new Resultaat(picklist, 0 , this.getAfstand());

		panel = new DrawPanel(name, resultaat);

	}
	
	public void updateResultaat(ArrayList<Location> picklist){
		resultaat = new Resultaat(picklist, 0, this.getAfstand());
		panel.updateResultaat(resultaat);
	}

	@Override
	public void calculateRoute() {
		
	}

	@Override
	public Resultaat getResultaat() {
		return this.resultaat;
	}
	
	private double getAfstand(){
		return 0;
	}

	@Override
	public String getAlgorithmName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public DrawPanel getPanel() {
		return panel;
	}
}
