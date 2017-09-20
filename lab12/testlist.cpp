// some linked list routines and a test program for CS 455 lab

#include <iostream>
#include <cctype>
#include <cassert>
#include <string>

using namespace std;


//*************************************************************************
struct Node {
  int data;
  Node *next;

  Node(int item);
  Node(int item, Node *n);

};

Node::Node(int item) {
  data = item;
  next = NULL;
}

Node::Node(int item, Node *n) {
  data = item;
  next = n;
}

//*************************************************************************
// utility functions used by this code
// these functions are defined at the bottom of the file

// inserts val at the front of list
// PRE: list is a well-formed list
void insertFront(Node *&list, int val);

// makes list into an empty list
//   reclaiming memory used by nodes 
// PRE: list is a well-formed list
// POST: list is NULL
void clearList(Node * &list);

// prints list elements, space separated, ending with '\n'
// prints emty list as "<empty>"
// PRE: list is a well-formed list
void printList(Node *list);


//*************************************************************************

// BUGGY sumList
// PRE: list is a well-formed list
// POST: returns sum of elements in list
int sumList (Node *list)
{
  Node *p = list;
  int sum = 0;

  while (p!=NULL) {
    sum += p->data;
    p = p->next;
  }
  return sum;
}


// BUGGY append routine
// PRE: list is a well-formed list
// POST: list' is same as list, but with item appended
void append (Node * &list, int item)
{
  Node *p = list;

  if (p == NULL) {
    insertFront(list, item);
    return;
  }

  while (p->next != NULL) {
    p = p->next;
  }

  p->next = new Node(item);
}


// printEveryOther: prints 1st, 3rd, 5th, ... elements in a list
// PRE: list is a well-formed linked list
void printEveryOther(Node * list)
{
  if(list == NULL){
    cout << "Empty List.";

 }

  while (list != NULL) {
    cout << list->data << " ";
    if(list->next != NULL){
      list = list->next->next;
    }else{
      list = list->next;
    }    
  }
  cout << endl;

}


/*
 * promptForInt: Prompts for and reads an integer.
 * param prompt is the prompt to use.
 */
int promptForInt (string prompt)
{
    int value;

    cout << prompt << ": ";
    cin >> value;
    return value;
}

// skips over non-digits, non eoln in input stream
void skip()
{
  int ch = cin.peek();
  while ((ch != '\n') && (!isdigit(ch))) {
    cin.get();
    ch = cin.peek();
  }  
}

void printCmdSummary() {
      cout<< "Valid commands are b(build new list), i(insert), a(append), " 
	  << endl;
      cout << "         s(sum of elmts) , p(print every other), h(help), q(quit)." 
	   << endl;

}

// buildList: reads numbers from one line, prepends them to the list
// in reverse order.
// User must enter at least one number, and terminate sequence of
// numbers with a newline.
// PRE: theList is a well-formed list
void buildList(Node * & theList)
{
  int i;

  do {
    cin >> i;
    insertFront(theList, i);
    skip();
  } while (cin.peek() != '\n');
  cin.get();     // consume the newline
}

/* a little test program */

int main ()
{

  char c;
  bool keepgoing = true;
  int  v;
  Node *thelist = NULL;

  printCmdSummary();

  do {
    cout << "\nPlease enter a command [b, i, a, s, p, h, q]: ";
    cin >> c;

    if (cin.fail()) {
      cout << "ERROR: input stream failed." << endl;
      keepgoing = false;
    }
    else {
      switch (c) {
      case 'b':
	clearList(thelist);
	cout << "Please enter a sequence of ints followed by <nl> (e.g:1 2 3): ";
	buildList(thelist);
	break;
      case 'i':
	v = promptForInt ("Value to insert");
	insertFront (thelist, v);
	break;
      case 'a':
	v = promptForInt ("Value to append");
	append (thelist, v);
	break;
      case 's':
	cout << "Sum of elements in list is " << sumList(thelist) << endl;
	break;
      case 'p':
	cout << "Print every other: " << endl;
	printEveryOther(thelist); cout << endl;
	break;
      case 'q':
	keepgoing = false;
	break;
      default:
	printCmdSummary();
	break;
      }
      cout << "The list: ";
      printList (thelist);

    }
    
    
  } while (keepgoing);

  return 0;
}


void insertFront(Node *&list, int val) {
  list = new Node(val, list);
}


void printList(Node *list) {

  if (list == NULL) {
    cout << "<empty>";
  }

  Node *p = list;
  while (p != NULL) {
    cout << p->data << " ";
    p = p->next;
  }
  cout << endl;
}


void clearList(Node *&list) {
  Node *rest = list;

  while (list != NULL) {
    rest = list->next;  // rest is all but the first element
    delete list;  // reclaims one node only
    list = rest;
  }
}
