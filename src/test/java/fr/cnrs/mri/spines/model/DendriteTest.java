package fr.cnrs.mri.spines.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ij.gui.PolygonRoi;
import ij.gui.Roi;



class DendriteTest {

	
	@Test
	void constructorTest() {
		Dendrite dendrite = new Dendrite();
		assertNotNull(dendrite.getIncarnations());
		assertNotNull(dendrite.getSpines());
		assertEquals(0, dendrite.getIncarnations().size());
		assertEquals(0, dendrite.getSpines().size());
	}
	
	
	@Test
	void addIncarnationTest() {
		Dendrite dendrite = new Dendrite();
		float[] xCoords = {1, 20, 30};
		float[] yCoords = {2, 15, 40};
		Roi dendriteShapeFrame1 = new PolygonRoi(xCoords, yCoords, Roi.POLYLINE);
		RoiProjectionShape shape = new RoiProjectionShape(dendriteShapeFrame1);
		
		DendriteIncarnation dendriteIncarnation = new DendriteIncarnation(shape, 1); 
		dendrite.addIncarnation(dendriteIncarnation);
		
		assertEquals(1, dendrite.getIncarnations().size());
		
		Roi dendriteShapeFrame5 = new PolygonRoi(xCoords, yCoords, Roi.POLYLINE);
		shape = new RoiProjectionShape(dendriteShapeFrame5);
		dendriteIncarnation = new DendriteIncarnation(shape, 5);
		dendrite.addIncarnation(dendriteIncarnation);
		
		Roi dendriteShapeFrame3 = new PolygonRoi(xCoords, yCoords, Roi.POLYLINE);
		shape = new RoiProjectionShape(dendriteShapeFrame3);
		dendriteIncarnation = new DendriteIncarnation(shape, 3);
		dendrite.addIncarnation(dendriteIncarnation);
		
		assertEquals(3, dendrite.getIncarnations().size());
		assertEquals(1, dendrite.getIncarnations().get(0).getFrame());
		assertEquals(3, dendrite.getIncarnations().get(1).getFrame());
		assertEquals(5, dendrite.getIncarnations().get(2).getFrame());
		assertEquals(dendrite, dendrite.getIncarnations().get(0).getDendrite());
		assertEquals(dendrite, dendrite.getIncarnations().get(1).getDendrite());
		assertEquals(dendrite, dendrite.getIncarnations().get(2).getDendrite());
	}


	@Test
	void addSpineTest() {
		Dendrite dendrite = new Dendrite();
		Spine spine1 = new Spine();
		dendrite.addSpine(spine1);
		assertEquals(1, dendrite.getSpines().size());
		
		Spine spine2 = new Spine();
		dendrite.addSpine(spine2);
		assertEquals(2, dendrite.getSpines().size());
		
		Spine spine3 = new Spine();
		dendrite.addSpine(spine3);
		assertEquals(3, dendrite.getSpines().size());
	}
	
	
	@Test
	void testToString() {
		Dendrite dendrite = new Dendrite();
		String string = dendrite.toString();
		assertTrue(string.contains("0"));
		Spine spine1 = new Spine();
		dendrite.addSpine(spine1);
		string = dendrite.toString();
		assertTrue(string.contains("1"));
		Spine spine2 = new Spine();
		dendrite.addSpine(spine2);
		string = dendrite.toString();
		assertTrue(string.contains("2"));
	}
	
	
	@Test
	void testGetEssence() {
		Dendrite dendrite1 = new Dendrite();
		Dendrite dendrite2 = new Dendrite();
		assertNotEquals(dendrite1.getEssence(), dendrite2.getEssence());
	}
}
