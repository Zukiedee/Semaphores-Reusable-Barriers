# OS Assignment 2 - Part 3 Makefile
# Zukiswa Lobola
# April 2019

JAVAC=/usr/bin/javac
.SUFFIXES: .java .class

SRCDIR=src
BINDIR=bin

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES= BarrierReusable.class Methane.class Carbon.class Hydrogen.class RunSimulation.class

CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

clean:
	rm $(BINDIR)/molecule/*.class

run: 
	java -cp bin molecule.RunSimulation $(h) $(c)
