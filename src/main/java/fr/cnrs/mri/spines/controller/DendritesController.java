package fr.cnrs.mri.spines.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import fr.cnrs.mri.spines.model.Dendrite;
import fr.cnrs.mri.spines.model.Dendrites;
import ij.IJ;

public class DendritesController implements KeyListener, ActionListener {
	
	private Dendrites model;


	public DendritesController(Dendrites dendrites) {
		this.model = dendrites;
	}


	public MouseAdapter getMainMouseAdapter() {
		MouseAdapter adapter = new MouseAdapter() {
			private void handlePopupEvent(MouseEvent e) {
	            int x = e.getX();
	            int y = e.getY();
	            JTree tree = (JTree)e.getSource();
	            TreePath path = tree.getPathForLocation(x, y);
	            JPopupMenu popup;
				if (path == null) {
	            	popup = DendritesController.this.getMainPopupMenu();
	            	popup.show(tree, x, y);
	                return; 
				}
				tree.setSelectionPath(path);
	            Object obj = path.getLastPathComponent();	            
	            Class<? extends Object> aClass = ((DefaultMutableTreeNode)obj).getUserObject().getClass();
	            if (aClass == Dendrite.class) {
					popup = DendritesController.this.getDendritePopupMenu();
		            popup.show(tree, x, y);	
		            return; 
	            }
			}
			
			public void mousePressed(MouseEvent e) {
	            if (e.isPopupTrigger()) handlePopupEvent(e);
	        }
			
			public void mouseReleased(MouseEvent e) {
	            if (e.isPopupTrigger()) handlePopupEvent(e);
	        }
			
		};
		return adapter;
	}
	
	
	public JPopupMenu getMainPopupMenu() {
		JPopupMenu popup = new JPopupMenu();	
		JMenuItem newDendriteMenuItem = new JMenuItem("new dendrite");
		newDendriteMenuItem.addActionListener(this);
		popup.add(newDendriteMenuItem);
		 
		return popup;
	}


	public JPopupMenu getDendritePopupMenu() {
		JPopupMenu popup = new JPopupMenu();	
		JMenuItem addDendriteIncarnationMenuItem = new JMenuItem("add incarnation");
		addDendriteIncarnationMenuItem.addActionListener(this);
		popup.add(addDendriteIncarnationMenuItem);
		popup.addSeparator();
		JMenuItem deleteDendriteMenuItem = new JMenuItem("delete dendrite");
		deleteDendriteMenuItem.addActionListener(this);
		popup.add(deleteDendriteMenuItem);

		return popup;
	}
	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		IJ.log("key pressed "  + arg0);
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		IJ.log(actionEvent.getSource().toString());
		IJ.log(actionEvent.getActionCommand());
		if (actionEvent.getActionCommand()=="new dendrite") {
			this.model.addDendrite(new Dendrite());
		}
		if (actionEvent.getActionCommand()=="delete dendrite") {
			
			DefaultMutableTreeNode node = (DefaultMutableTreeNode)this.model.getView().getSelectionPath().getLastPathComponent();
			this.model.deleteDendrite((Dendrite)node.getUserObject());
		}
	}
}
