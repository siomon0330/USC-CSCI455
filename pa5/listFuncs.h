// Name:Chuanli Wei
// Loginid:6222006323
// CSCI 455 PA5
// Spring 2017


//*************************************************************************
// Node class definition 
// and declarations for functions on ListType

// Note: we don't need Node in Table.h
// because it's used by the Table class; not by any Table client code.


#ifndef LIST_FUNCS_H
#define LIST_FUNCS_H
  
using namespace std;

struct Node {
  string key;
  int value;

  Node *next;

  Node(const string &theKey, int theValue);

  Node(const string &theKey, int theValue, Node *n);
};


typedef Node * ListType;

//*************************************************************************
//add function headers (aka, function prototypes) for your functions
//that operate on a list here (i.e., each includes a parameter of type
//ListType or ListType&).  No function definitions go in this file.


/**Insert the key and value in front of the list, if the key-value pair already exists, then nothing changes.
 *@param list: the list to insert the entry
 *@param target: the key of the entry
 *@param value: the value of the entry
 *@return true if the insertion is successful
 */
bool insertFront(ListType & list, const string & target, int value);


/**Check whether the key exist in the list
 *@param list: the list to be checked
 *@param target: the key of the entry
 *@return true if the key exist
 */
bool contains(ListType & list, const string & target);


/**Remove the key-associated entry in the list
 *@param list: the list to remove the entry
 *@param target: the key of the entry
 *@return true if the removement is successful
 */
bool listRemove(ListType & list, const string & target);


/**Return the number of entries in the list
 *@param list: the list to return the number
 *@return the number of entries in the list
 */
int numberOfList(ListType & list);


/**Search the key-associated value in the list
 *@param list: the list to search the value
 *@param target: the key of the entry
 *@return the value, if the key doesn't exist, return NULL
 */
int * listLookUp(ListType & list, const string & target);


/**Print every entry in the list
 *@param list: the list to print the entry
 */
void listPrint(ListType & list);


/**Append a key-value pair at the end of the list
 *@param list: the list to append the entry
 *@param target: the key of the entry
 *@param value: the value of the entry
 *@return true if the append is successful
 */
bool listAppend(ListType & list, const string & target, int value);


/**Append a key-value pair at the end of the list
 *@param list: the list to append the entry
 *@param target: the key of the entry
 *@param value: the value of the entry
 *@return true if the append is successful
 */
bool updateValue(ListType & list, const string & target, int value);


// keep the following line at the end of the file
#endif
