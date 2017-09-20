# Makefile for CS455 Lab 10
#
#     gmake getfiles
#        Copies or links assignment files to current directory
#
#

# need to use gmake

HOME = /auto/home-scf-06/csci455/
ASSGTS = $(HOME)/assgts
ASSGTDIR = $(HOME)/labs/lab10

getfiles:
	-ln -s $(ASSGTDIR)/melville.txt .
	-ln -s $(ASSGTDIR)/poe.txt .
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/Concord.java	
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/ConcordDriver.java
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/ConcordDriver3.java
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/Predicate.java
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/Makefile

submit:
	submit -user csci455 -tag lab10 Concord.java ConcordDriver3.java poe.out melville.out README
