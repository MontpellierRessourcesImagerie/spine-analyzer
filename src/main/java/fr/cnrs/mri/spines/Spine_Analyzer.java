package fr.cnrs.mri.spines;

import fr.cnrs.mri.spines.model.Dendrite;
import fr.cnrs.mri.spines.model.DendriteIncarnation;
import fr.cnrs.mri.spines.model.Shape;
import fr.cnrs.mri.spines.model.SpineAnalyzer;
import ij.IJ;
import ij.ImageJ;
import ij.plugin.PlugIn;

public class Spine_Analyzer implements PlugIn {
	
	public static void main(String[] args) {
		new ImageJ();
		IJ.open("/home/baecker/Documents/mri/in/enora/work_replace_label/clean_test_image.tif");
		Spine_Analyzer plugin = new Spine_Analyzer();
		plugin.run("");
	}

	@Override
	public void run(String arg) {
		ImageJ ij = IJ.getInstance();
		SpineAnalyzer spineAnalyzer = new SpineAnalyzer();
		Dendrite  dendrite1 = new Dendrite();
		dendrite1.addIncarnation(new DendriteIncarnation(new Shape(), 1));
		spineAnalyzer.getDendrites().addDendrite(dendrite1);
		spineAnalyzer.show();
		ij.addKeyListener(spineAnalyzer.getDendrites().getController());
		IJ.getImage().getCanvas().addKeyListener(spineAnalyzer.getDendrites().getController());
		spineAnalyzer.getDendrites().getView().addKeyListener(spineAnalyzer.getDendrites().getController());
	}
	
	
}
