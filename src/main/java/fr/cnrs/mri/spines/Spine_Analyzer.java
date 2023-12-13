package fr.cnrs.mri.spines;

import fr.cnrs.mri.spines.model.SpineAnalyzer;
import ij.IJ;
import ij.ImageJ;
import ij.plugin.PlugIn;

public class Spine_Analyzer implements PlugIn {
	
	public static void main(String[] args) {
		new ImageJ();
		Spine_Analyzer plugin = new Spine_Analyzer();
		plugin.run("");
	}

	@Override
	public void run(String arg) {
		IJ.log("Hello from plugin!");
		SpineAnalyzer spineAnalyzer = new SpineAnalyzer();
		spineAnalyzer.show();
	}
	
	
}
