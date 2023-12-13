package fr.cnrs.mri.spines.model;

import java.util.ArrayList;
import fr.cnrs.mri.spines.view.DendritesView;

/**
 * A list of dendrites, present in one 3D+t image.
 * 
 */
public class Dendrites {
	
	protected ArrayList<Dendrite> dendrites;
	private DendritesView view;
	
	
	public Dendrites() {
		this.dendrites = new ArrayList<Dendrite>();
	}
	
	
	public void addDendrite(Dendrite aDendrite) {
		this.dendrites.add(aDendrite);
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
}



