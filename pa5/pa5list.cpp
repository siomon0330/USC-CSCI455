// Name:
// loginid:
// CS 455 PA5

// pa5list.cpp
// a program to test the linked list code necessary for a hash table chain

// You are not required to submit this program for pa5.

// We gave you this starter file for it so you don't have to figure
// out the #include stuff.  The code that's being tested will be in
// listFuncs.cpp, which uses the header file listFuncs.h

// The pa5 Makefile includes a rule that compiles these two modules
// into one executable.

#include <iostream>
#include <string>
#include <cassert>

using namespace std;

#include "listFuncs.h"


int main() {

    char c;
    bool keepgoing = true;
    string str;
    int  v;
    Node *thelist = NULL;
    
    do {
        cout << "\nPlease enter a command [i, r,a, p, q, n, l, u]: ";
        cin >> c;
        
        if (cin.fail()) {
            cout << "ERROR: input stream failed." << endl;
            keepgoing = false;
        }
        else {
            switch (c) {
                
                case 'i':
                    cout << "Key to insert";
                    cin >> str;
                    cout <<"Value to insert";
                    cin>> v;
                    insertFront (thelist, str, v);
                    break;
                case 'a':
                    cout << "Key to insert";
                    cin >> str;
                    cout <<"Value to insert";
                    cin>> v;
                    append (thelist, str, v);
                    break;
                case 'r':
                    cout << "Key to remove";
                    cin >> str;
                    listRemove(thelist, str);
                    break;
                case 'l':
                    cout << "Key to lookup";
                    cin >> str;
                    int * look;
                    look = lookUp(thelist, str);
                    if(look ==  NULL){
		      cout << "key doesn't exist!";
                    }else{
                    cout << "value is: " << (*look) << endl;
                    }
                    break;
                case 'n':
                    v = numberOfList(thelist);
                    cout << "number is: " << v <<endl;
                    break;
                
                case 'p':
                    cout << "The list is:  " << endl;
                    print(thelist);
                    cout << endl;
                    break;
                case 'q':
                    keepgoing = false;
                    break;
                case 'u':
                    cout << "Key to update:";
                    cin >> str;
                    cout <<"New Value is:";
                    cin>> v;
                    updateValue(thelist, str, v);
                    break;

                           }
	     cout << "The list: " << endl;
	     print(thelist);
            
        }
        
        
    } while (keepgoing);
    
    return 0;
}


  
