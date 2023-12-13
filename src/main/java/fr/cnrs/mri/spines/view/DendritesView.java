package fr.cnrs.mri.spines.view;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import fr.cnrs.mri.spines.model.Dendrite;
import fr.cnrs.mri.spines.model.Dendrites;

public class DendritesView extends JTree {

	private static final long serialVersionUID = -6748624776800138513L;
	
	DefaultMutableTreeNode rootNode = null;
	Dendrites dendrites = null;
	
	
	public DendritesView(Dendrites dendrites) {
		super(createTree(dendrites));
		this.dendrites = dendrites;
	}

	
	protected static DefaultMutableTreeNode createTree(Dendrites dendrites) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(dendrites);
		for(Dendrite dendrite: dendrites.getDendrites()) {
			node.add(new DefaultMutableTreeNode(dendrite));
		}
		return node;
	}
}
