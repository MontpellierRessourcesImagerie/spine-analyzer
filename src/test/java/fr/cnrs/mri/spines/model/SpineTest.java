package fr.cnrs.mri.spines.model;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import ij.ImagePlus;

public class SpineTest {

	
	@Test	
	public void constructorTest() {
		Spine spine = new Spine();
		assertNotNull(spine.getIncarnations());
		assertEquals(0, spine.getIncarnations().size());
		Spine spine2 = new Spine();
		assertNotEquals(spine.getEssence(), spine2.getEssence());
	}
	
	
	@Test
	public void addIncarnationTest() {
		Spine spine1 = new Spine();
		LabelMaskShape shape = new LabelMaskShape(new ImagePlus());
		SpineIncarnation spineIncarnation = new SpineIncarnation(shape, 1);
		spine1.addIncarnation(spineIncarnation);
		spineIncarnation = new SpineIncarnation(shape, 5);
		spine1.addIncarnation(spineIncarnation);
		spineIncarnation = new SpineIncarnation(shape, 3);
		spine1.addIncarnation(spineIncarnation);
		
		assertEquals(3, spine1.getIncarnations().size());
		assertEquals(1, spine1.getIncarnations().get(0).getFrame());
		assertEquals(3, spine1.getIncarnations().get(1).getFrame());
		assertEquals(5, spine1.getIncarnations().get(2).getFrame());
		assertEquals(spine1, spine1.getIncarnations().get(0).getSpine());
		assertEquals(spine1, spine1.getIncarnations().get(1).getSpine());
		assertEquals(spine1, spine1.getIncarnations().get(2).getSpine());	
		
		spineIncarnation = new SpineIncarnation(shape, 4);
		spine1.addIncarnation(spineIncarnation);
		assertEquals(4, spine1.getIncarnations().size());
		assertEquals(1, spine1.getIncarnations().get(0).getFrame());
		assertEquals(3, spine1.getIncarnations().get(1).getFrame());
		assertEquals(4, spine1.getIncarnations().get(2).getFrame());
		assertEquals(5, spine1.getIncarnations().get(3).getFrame());
	}
	
	
	@Test
	void testToString() {
		Spine spine = new Spine();
		String string = spine.toString();
		assertTrue(string.contains(Long.toString(spine.getEssence())));
	}
}
