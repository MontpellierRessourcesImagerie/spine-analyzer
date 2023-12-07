package fr.cnrs.mri.spines.model;


/**
 * A spine-incarnation represents a spine in a given frame (i.e. at a given time-point). 
 * A spine-incarnation has a 3D volume.
 */
public class SpineIncarnation {

	
	protected int frame;
	protected Shape shape;
	protected Spine spine = null;
	
	
	public SpineIncarnation(Shape aShape, int aFrame) {
		this.shape = aShape;
		this.frame = aFrame;
	}
	
	
	public void setSpine(Spine aSpine) {
		this.spine = aSpine;
	}
	
	
	public int getFrame() {
		return frame;
	}


	public Spine getSpine() {
		return this.spine;
	}
	
	@Override
	public String toString() {
		String spineStr = "null";
		if (this.spine != null)
			spineStr = this.spine.toString();	
	    return getClass().getSimpleName() + "[" + spineStr + ", " + this.shape.toString() + ", " + Integer.toString(this.frame) + "]";
	}
}
