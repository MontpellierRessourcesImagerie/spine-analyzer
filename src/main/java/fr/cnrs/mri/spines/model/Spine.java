package fr.cnrs.mri.spines.model;

import java.util.ArrayList;

/**
 * A spine represents the incarnations of a spine over time. 
 */
public class Spine {

	
	public static long nextEssence = 1;
	
	
	protected long essence;
	protected ArrayList<SpineIncarnation> incarnations; 
	
	
	public Spine() {
		this.essence = nextEssence++;
		this.incarnations = new ArrayList<SpineIncarnation>();
	}
	
	
	public void addIncarnation(SpineIncarnation spineIncarnation) {
		int index = 0;
		int frame = spineIncarnation.getFrame();
		for (SpineIncarnation incarnation: this.incarnations) { 	
			if (frame >= incarnation.getFrame()) {			
				index++;
				continue;
			} else {
				break;
			}
		}
		this.incarnations.add(index, spineIncarnation);		
		spineIncarnation.setSpine(this);
	}


	public long getEssence() {
		return this.essence;
	}


	public ArrayList<SpineIncarnation> getIncarnations() {
		return this.incarnations;
	}
	
	
	@Override
	public String toString() {
		String string = getClass().getSimpleName() + "@" + this.getEssence();
		return string;
	}
}
