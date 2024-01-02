package fr.cnrs.mri.spines.model;

import java.util.ArrayList;
import java.util.Observable;

import fr.cnrs.mri.spines.controller.DendritesController;
import fr.cnrs.mri.spines.view.DendritesView;
import fr.cnrs.mri.spines.view.ModelChange;

/**
 * A list of dendrites, present in one 3D+t image.
 * 
 */
public class Dendrites extends Observable {
	
	protected ArrayList<Dendrite> dendrites;
	private DendritesView view;
	private DendritesController controller;
	
	
	public Dendrites() {
		this.dendrites = new ArrayList<Dendrite>();
	}
	
	
	public void addDendrite(Dendrite aDendrite) {
		this.dendrites.add(aDendrite);
		this.changed(new ModelChange(aDendrite, ModelChange.Action.DENDRITE_ADDED));
	}
	
	
	private void changed(ModelChange aChange) {
		this.setChanged();
		this.notifyObservers(aChange);		
	}


	public ArrayList<Dendrite> getDendrites() {
		return this.dendrites;
	}


	public DendritesView getView() {
		if (this.view == null) {
			this.view = new DendritesView(this);
		}
		return this.view;
	}
	
	
	public DendritesController getController() {
		if (this.controller == null) {
			this.controller = new DendritesController(this);	
		}
		return this.controller; 
	}


	public void deleteDendrite(Dendrite userObject) {
		// TODO Auto-generated method stub
		
	}
}



