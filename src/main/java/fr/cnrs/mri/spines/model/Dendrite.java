package fr.cnrs.mri.spines.model;

import java.util.ArrayList;

/**
 * A Dendrite consists of the incarnations of the same dendrite over time. 
 * Each dendrite has a list of spines.
 */
public class Dendrite {

		protected long essence;
		protected ArrayList<DendriteIncarnation> incarnations;
		protected ArrayList<Spine> spines;
		public static long nextEssence = 1;
		
		
		/**
		 * Create a new dendrite.
		 * <p>
		 * Create a new dendrite with an empty list of incarnations and spines.
		 */
		public Dendrite() {
			this.incarnations = new ArrayList<DendriteIncarnation>();
			this.spines = new ArrayList<Spine>();
			this.essence = nextEssence++;
		}


		public ArrayList<DendriteIncarnation>  getIncarnations() {
			return this.incarnations;
		}


		public ArrayList<Spine> getSpines() {
			return this.spines;
		}

	
		public void addIncarnation(DendriteIncarnation dendriteIncarnation) {
			int index = 0;
			int frame = dendriteIncarnation.getFrame();
			for (DendriteIncarnation incarnation: this.incarnations) { 	
				if (frame >= incarnation.getFrame()) {			
					index++;
					continue;
				} else {
					break;
				}
			}
			this.incarnations.add(index, dendriteIncarnation);		
			dendriteIncarnation.setDendrite(this);
		}
		
		
		@Override
		public String toString() {
			String string = getClass().getSimpleName() + "@" + this.getEssence() + "[spines=" + this.spines.size() + "]";
 			return string;
		}


		public long getEssence() {
			return this.essence;
		}


		public void addSpine(Spine spine) {
			this.spines.add(spine);
		}
}
