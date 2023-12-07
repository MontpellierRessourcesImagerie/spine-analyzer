package fr.cnrs.mri.spines.model;

import java.text.DecimalFormat;

import ij.gui.Roi;

/**
 * A 3D shape in the form of a 2D-line roi. 
 * The same 2D-roi is used on every 2D slice of the stack. 
 */
public class RoiProjectionShape extends Shape {
	
	
	protected Roi roi;
	
	
	public RoiProjectionShape(Roi aRoi) {
		this.roi = aRoi;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		String string = getClass().getSimpleName() + 
						"[points=" + this.roi.size() + 
						", length=" + df.format(this.roi.getLength()) + "]";  
		return string;
	}
}
