package fr.cnrs.mri.spines;

import ij.IJ;
import ij.ImageJ;
import ij.plugin.PlugIn;

public class Spine_Analyzer implements PlugIn {
	
	public static void main(String[] args) {
		new ImageJ();
		IJ.log("Hello from main!");		
	}

	@Override
	public void run(String arg) {
		IJ.log("Hello from plugin!");		
	}
	
	
}
