package fr.cnrs.mri.spines.view;

public class ModelChange {
	
	private Object object;
	private Action action;

	public enum Action {
		UNKNOWN, DENDRITE_ADDED
	}
	
	public ModelChange(Object object, Action action) {
		this.object = object;
		this.action = action;
	}
	
	public Object getObject() {
		return this.object;
	}
	
	public Action getAction() {
		return this.action;
	}
	
}
