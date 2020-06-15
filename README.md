# Operating Systems Assignment 2: Synchronization
# Part3: Making Methane with Semaphores

This Application is designed to run using command line terminal on the UNIX operating system. 

## Program explanation of execution:
The program takes in the number hydrogen and carbon atoms and uses reusable barriers in semaphores to bond the atoms to form methane molecules i.e. 1 carbon atom bonds with 4 hydrogen atoms.

The reusable barrier ensures that the atoms(threads) form a complete methane molecule before they are released by the barrier. 
	
* Note: the program only works for the cases when the atoms form perfect molecules i.e. the number of carbon atoms are coordinated and can be shared/allocated to the number of hydrogen atoms with no atoms leftover.

## Compilation procedure:

Run the keyword "make" from your terminal in the directory containing the 
program makefile as well as bin and src folders:

This execution compiles all files with the aid of makefile in the program and redirects them in the bin folder and needs to be executed before the program can run. 

### An example of how to compile the program:
```
  --> make
```

## How to run the program:

Run: ' make run h="arg0" c="arg1" '
	- Where the arguments arg0 and arg1 represent the number of hydrogens and carbon atoms respectively. 
	
### An example of how to run the program:
```
  --> make run h="6" c="3"
```

## Other commands:
	use "make clean" to remove all the class files from the bin directory before 
	compiling the application.
```
	--> make clean
```
