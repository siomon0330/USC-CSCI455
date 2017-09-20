// Name:Chuanli Wei
// Loginid:6222006323
// CSCI 455 PA5
// Spring 2017

/*
 * grades.cpp
 * A program to test the Table class.
 * How to run it:
 *      grades [hashSize]
 * 
 * the optional argument hashSize is the size of hash table to use.
 * if it's not given, the program uses default size (Table::HASH_SIZE)
 *
 */

#include "Table.h"

// cstdlib needed for call to atoi
#include <cstdlib>

void printCommand();


int main(int argc, char * argv[]) {

  // gets the hash table size from the command line

  int hashSize = Table::HASH_SIZE;

  Table * grades;  // Table is dynamically allocated below, so we can call
                   // different constructors depending on input from the user.

  if (argc > 1) {
    hashSize = atoi(argv[1]);  // atoi converts c-string to int

    if (hashSize < 1) {
      cout << "Command line argument (hashSize) must be a positive number" 
	   << endl;
      return 1;
    }

    grades = new Table(hashSize);

  }
  else {   // no command line args given -- use default table size
    grades = new Table();
  }


  grades->hashStats(cout);

  // add more code here
  // Reminder: use -> when calling Table methods, since grades is type Table*
    
    string command = "";
    bool keepgoing = true;
    string name = "";
    int score = -1;
    
    while(keepgoing){
        cout << "cmd>" << endl;
        cin >> command;
        
        if(command == "insert"){
            
            cin >> name;  //read in the key
            cin >> score; //read in the value
            grades->insert(name, score);
            
        }else if(command == "change"){
            
            cin >> name;  //read in the key
            cin >> score; //read in the value
            
            if(grades->lookup(name) == NULL){
                cout << "Name doesn't exist." << endl;
            }else{
                *(grades->lookup(name)) = score;
            }
        }else if(command == "lookup"){
            
            cin >> name;  //read in the key
            if(grades->lookup(name) == NULL){
                cout << "Name doesn't exist." << endl;
            }else{
                cout << name << ": "<< *(grades->lookup(name)) << endl;
            }
            
        }else if(command == "remove"){
            
            cin >> name;  //read in the key
            grades->remove(name);
            
        }else if(command == "print"){
            grades->printAll();
            
        }else if(command == "size"){
            cout << grades->numEntries() << endl;
            
        }else if(command == "stats"){
            grades->hashStats(cout);
            
        }else if(command == "help"){
            
            printCommand();
        
        }else if(command == "quit"){  //Exit
            keepgoing = false;
        }else{
            cout << "ERROR: invalid command, please type help to see the command summary" << endl;
        }
    }


  return 0;
}

//Print out the commad summary
void printCommand(){

    cout << "The valid command are as follows: " << endl;
    cout << "insert name score: Insert this name and score in the grade table." << endl;
    cout << "change name newscore: Change the score for name." << endl;
    cout << "lookup name: Lookup the name, and print out his or her score, or a message indicating that student is not in the table." << endl;
    cout << "remove name: Remove this student." << endl;
    cout << "print: Prints out all names and scores in the table." << endl;
    cout << "size: Prints out the number of entries in the table." << endl;
    cout << "stats: Prints out statistics about the hash table at this point. (Calls hashStats() method)" << endl;
    cout << "help: Prints out a brief command summary." << endl;
    cout << "quit: Exits the program." << endl;

}





























