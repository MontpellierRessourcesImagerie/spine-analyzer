package fr.cnrs.mri.spines.view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import fr.cnrs.mri.spines.model.Dendrite;
import fr.cnrs.mri.spines.model.DendriteIncarnation;
import fr.cnrs.mri.spines.model.Dendrites;
import ij.IJ;

public class DendritesView extends JTree implements Observer {

	private static final long serialVersionUID = -6748624776800138513L;
	
	DefaultMutableTreeNode rootNode = null;
	Dendrites dendrites = null;
	
	
	public DendritesView(Dendrites dendrites) {
		super(createTree(dendrites));
		dendrites.addObserver(this);
		this.setRootVisible(false);
		this.dendrites = dendrites;
		this.rootNode = (DefaultMutableTreeNode) this.getModel().getRoot();
		this.addMouseListener(dendrites.getController().getMainMouseAdapter());
	}

	
	protected static DefaultMutableTreeNode createTree(Dendrites dendrites) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(dendrites);
		for(Dendrite dendrite: dendrites.getDendrites()) {
			DefaultMutableTreeNode currentDendriteNode = new DefaultMutableTreeNode(dendrite);
			node.add(currentDendriteNode);
			for (DendriteIncarnation incarnation: dendrite.getIncarnations()) {
				currentDendriteNode.add(new DefaultMutableTreeNode(incarnation));
			}
		}
		return node;
	}


	@Override
	public void update(Observable o, Object arg) {
		IJ.log("update, source = " + o.toString());
		IJ.log("update, arg = " + arg.toString());
		ModelChange change = (ModelChange) arg;
		if (change.getAction() == ModelChange.Action.DENDRITE_ADDED) {
			this.handleDendriteAdded((Dendrite)change.getObject());
		}
	}


	private void handleDendriteAdded(Dendrite dendrite) {
		IJ.log("added new dendrite");
		this.rootNode.add(new DefaultMutableTreeNode(dendrite));	
		this.updateUI();
	}
}
