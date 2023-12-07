package fr.cnrs.mri.spines.model;

import java.text.DecimalFormat;

import ij.ImagePlus;
import ij.ImageStack;

/**
 * A 3D shape in the form of a label mask.
 */
public class LabelMaskShape extends Shape {
	protected ImagePlus mask;
	
	
	public LabelMaskShape(ImagePlus mask) {
		this.mask = mask;
	}
	
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		ImageStack stack = this.mask.getStack();
		String string = getClass().getSimpleName() + 
						"[" + stack.getWidth()+ ", " +  stack.getHeight() + ", " +  stack.getSize() + "]";  
		return string;
	}
}
