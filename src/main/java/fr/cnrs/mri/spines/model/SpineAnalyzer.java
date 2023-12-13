package fr.cnrs.mri.spines.model;

import fr.cnrs.mri.spines.view.SpineAnalyzerView;

public class SpineAnalyzer {
	
	
	private Dendrites dendrites;
	private SpineAnalyzerView view;

	
	public SpineAnalyzer() {
		this.dendrites = new Dendrites();
	}

	
	public Dendrites getDendrites() {
		return dendrites;
	}
	
	
	public SpineAnalyzerView getView() {
		if (this.view == null) {
			this.view = new SpineAnalyzerView(this);
		}
		return this.view;
	}
	
	
	public void show() {
		this.getView().setVisible(true);
	}
}
