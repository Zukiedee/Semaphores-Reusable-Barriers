//package molecule;

public class Carbon extends Thread {
	
	private static int carbonCounter =0;
	private int id;
	private Methane sharedMethane;
	
	public Carbon(Methane methane_obj) {
		Carbon.carbonCounter+=1;
		id=carbonCounter;
		this.sharedMethane = methane_obj;
	}
	
	public void run() {
	    try {	 
	    	sharedMethane.mutex.acquire();  		//mutex ensures mutual exclusion 
	    	
	    	/* critical section */
	    	sharedMethane.addCarbon();				//increment carbon count
	    	
	    	if (sharedMethane.getHydrogen() >= 4){ 	//check if there are 4 hydrogen atoms already waiting
				System.out.println("---Group ready for bonding---");
				sharedMethane.hydrogensQ.release(4);//release the hydrogens
				sharedMethane.carbonQ.release();	//release carbons
				sharedMethane.removeHydrogen(4);	//set Hydrogen count to 0
				sharedMethane.removeCarbon(1);		//set Carbon count to 0
			}
			
			/* end of critical section */
			
			else
				sharedMethane.mutex.release();		//if there aren't 4 hydrogen atoms already waiting, release the mutex and wait for more hydrogens
			
			sharedMethane.carbonQ.acquire();	
	    	sharedMethane.bond("C"+ this.id);  		//bond the carbon atom to methane molecule
	    	
	    	sharedMethane.barrier.b_wait();			//implement reusable barrier
	    	sharedMethane.mutex.release();  		//carbon releases the methane molecule	 	 
	    }
	    catch (InterruptedException ex) { /* not handling this  */}
	   // System.out.println(" ");
	}

}
