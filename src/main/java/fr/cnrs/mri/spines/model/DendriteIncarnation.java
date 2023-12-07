package fr.cnrs.mri.spines.model;


/**
 * The incarnation of a dendrite on a specific frame (i.e. for a specific time-point).
 */
public class DendriteIncarnation {
	
	
	protected Dendrite dendrite;
	protected Shape shape;
	protected int frame;
	
	
	public DendriteIncarnation(Shape aShape, int aFrame) {
		this.shape = aShape;
		this.frame = aFrame;
	}


	public int getFrame() {
		return this.frame;
	}
	
	
	@Override
	public String toString() {
		String dendriteStr = "null";
		if (this.dendrite != null)
			dendriteStr = this.dendrite.toString();	
	    return getClass().getSimpleName() + "[" + dendriteStr + ", " + this.shape.toString() + ", " + Integer.toString(this.frame) + "]";
	}


	public void setDendrite(Dendrite aDendrite) {
		this.dendrite = aDendrite;
	}


	public Dendrite getDendrite() {
		return this.dendrite;
	}
}
