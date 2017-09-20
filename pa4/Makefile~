# Makefile for cs 455 PA4 
#
#  Modified 3/27/17 to fix sowpods.txt directory
# 
# If your design involved additional classes you will need to modify
# the submit command below so you can submit those extra .java files:
# just add the new file names to the end of the command.  Do not
# insert newlines in the middle of the command, just keep typing
# (after ScoreTable.java) and let the text wrap around.  Then save the
# updated Makefile, and run "gmake submit"
#
#-----------------------------------------------------------------------
#  Unix commands you can use when this file is in the current directory:
#
#     gmake getfiles
#        Copies and/or links data files and this Makefile to current directory.
#
#     gmake submit
#        Submits the assignment.
#
#-----------------------------------------------------------------------
#
# Variable definitions:

HOME = /home/scf-06/csci455
ASSGTS = $(HOME)/assgts
ASSGTDIR = $(ASSGTS)/pa4

#-----------------------------------------------------------------------

getfiles:
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/Makefile .
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/README .
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/Rack.java .
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/AnagramDictionary.java .
	-ln -s $(ASSGTDIR)/sowpods.txt
	-cp -r $(ASSGTDIR)/testFiles .

#-----------------------------------------------------------------------
# you will need to change the submit rule if you want to submit
# additional files.

submit:
	submit -user csci455 -tag pa4 README WordFinder.java AnagramDictionary.java Rack.java ScoreTable.java
