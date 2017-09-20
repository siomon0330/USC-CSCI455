# Makefile for CS 455 PA5
#
#     gmake getfiles
#        Copies or links assignment files to current directory
#
#     gmake concord
#        Makes concord executable
#
#     gmake grades
#        Makes grades executable
#
#     gmake pa5list
#	 Makes pa5list executable.  (This is a test driver for your list functions)
#
#     gmake submitpa5
#        Submits the assignment.
#
#     gmake submitlab13
#        For DEN students to submit lab13
#

# need to use gmake

HOME = /auto/home-scf-06/csci455/
ASSGTS = $(HOME)/assgts
ASSGTDIR = $(HOME)/assgts/pa5


getfiles:
	-ln -s $(ASSGTDIR)/melville.txt .
	-ln -s $(ASSGTDIR)/poe.txt .
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/README
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/concord.cpp
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/grades.cpp
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/Table.h
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/Table.cpp
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/listFuncs.h
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/listFuncs.cpp
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/pa5list.cpp
	-$(ASSGTS)/bin/safecopy $(ASSGTDIR)/Makefile


concord: concord.o Table.o listFuncs.o
	g++ -ggdb -Wall -Wno-sign-compare -o concord concord.o Table.o listFuncs.o

grades: grades.o Table.o listFuncs.o
	g++ -ggdb -Wall -Wno-sign-compare -o grades grades.o Table.o listFuncs.o

pa5list: pa5list.cpp listFuncs.o listFuncs.h
	g++ -ggdb -Wall pa5list.cpp listFuncs.o -o pa5list

concord.o: concord.cpp Table.h
	g++ -ggdb -Wall -Wno-sign-compare -c concord.cpp

Table.o: Table.cpp Table.h listFuncs.h
	g++ -ggdb -Wall -Wno-sign-compare -c Table.cpp

grades.o: grades.cpp Table.h
	g++ -ggdb -Wall -Wno-sign-compare -c grades.cpp

listFuncs.o: listFuncs.cpp listFuncs.h
	g++ -ggdb -Wall -Wno-sign-compare -c listFuncs.cpp

submitpa5:
	submit -user csci455 -tag pa5 README Table.h Table.cpp grades.cpp listFuncs.h listFuncs.cpp

#for DEN students:
submitlab13:
	submit -user csci455 -tag lab13 listFuncs.h listFuncs.cpp pa5list.cpp
