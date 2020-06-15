//package molecule;

public class Hydrogen extends Thread {

	private static int carbonCounter =0;
	private int id;
	private Methane sharedMethane;
	
	
	public Hydrogen(Methane methane_obj) {
		Hydrogen.carbonCounter+=1;
		id=carbonCounter;
		this.sharedMethane = methane_obj;
		
	}
	
	public void run() {
	    try {
	    	sharedMethane.mutex.acquire();  			//mutex ensures mutual exclusion 
	    	
	    	/* critical section */
	    	sharedMethane.addHydrogen();				//increment hydrogen count
	    	
	    	if (sharedMethane.getHydrogen() >= 4 && sharedMethane.getCarbon() >= 1) { 	//check if there are 4 hydrogens already waiting
				System.out.println("---Group ready for bonding---");
				sharedMethane.hydrogensQ.release(4);	//release the hydrogens
				sharedMethane.removeHydrogen(4);		//set Hydrogen count to 0
				sharedMethane.carbonQ.release();		//release carbons
				sharedMethane.removeCarbon(1);			//set Carbon count to 0
			}
			
			/* end of critical section */
			
			else
				sharedMethane.mutex.release();			//otherwise release the mutex and wait for more hydrogens and carbon atom
			
			sharedMethane.hydrogensQ.acquire();			 
	    	sharedMethane.bond("H"+ this.id);			//bond the carbon atom to methane molecule
	    	
	    	sharedMethane.barrier.b_wait();				//implement reusable barrier
	    }
	   catch (InterruptedException ex) { /* not handling this  */}
	    //System.out.println(" ");
	}

}
