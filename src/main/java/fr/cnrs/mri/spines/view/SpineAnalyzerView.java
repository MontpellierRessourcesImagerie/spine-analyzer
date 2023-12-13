package fr.cnrs.mri.spines.view;

import javax.swing.JFrame;
import fr.cnrs.mri.spines.model.SpineAnalyzer;
import ij.WindowManager;

public class SpineAnalyzerView extends JFrame {

	private static final long serialVersionUID = 7274871279637574933L;
	private SpineAnalyzer model;



	public SpineAnalyzerView(SpineAnalyzer spineAnalyzer) {
		this.model = spineAnalyzer;
		this.add(model.getDendrites().getView());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Spine Analyzer");
		// WindowManager.addWindow(this); // @TODO: reactivate when it can be removed in the closing event
		this.pack();
	}
	
	
}
