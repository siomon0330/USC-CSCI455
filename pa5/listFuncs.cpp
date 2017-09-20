// Name:Chuanli Wei
// Loginid:6222006323
// CSCI 455 PA5
// Spring 2017


#include <iostream>

#include <cassert>

#include "listFuncs.h"

using namespace std;

Node::Node(const string &theKey, int theValue) {
  key = theKey;
  value = theValue;
  next = NULL;
}

Node::Node(const string &theKey, int theValue, Node *n) {
  key = theKey;
  value = theValue;
  next = n;
}




//*************************************************************************
// put the function definitions for your list functions below


/**Insert the key and value in front of the list, if the key-value pair already exists, then nothing changes.
 *@param list: the list to insert the entry
 *@param target: the key of the entry
 *@param value: the value of the entry
 *@return true if the insertion is successful
 */

bool insertFront(ListType & list, const string & target, int value){
    
    if(contains(list, target)){
      cout << "key already exist, insertion failed."<< endl;
        return false;
    }
    
    
    Node * node = new Node(target, value);
    node -> next = list;
    list = node;
    return true;
}

/**Check whether the key exist in the list
 *@param list: the list to be checked
 *@param target: the key of the entry
 *@return true if the key exist
 */

bool contains(ListType & list, const string & target){
    Node * node = list;
    while(node != NULL){
        if(node -> key == target){
            return true;
        }
        node = node -> next;
    }

    return false;
}

/**Remove the key-associated entry in the list
 *@param list: the list to remove the entry
 *@param target: the key of the entry
 *@return true if the removement is successful
 */
bool listRemove(ListType & list, const string & target){
    
    if(list == NULL){
        cout << "It's an empty list!" << endl;
        return false;
    }
    
    Node * node = list;
    Node * pre = NULL;
    if(node -> key == target){
        Node * temp = list;
        list = temp -> next;
        delete temp;
        return true;
    
    }
    while(node != NULL){
        if(node -> key == target){
            pre -> next = node -> next;
            delete node;
            return true;
        }
        pre = node;
        node = node -> next;
    }

    return false;

}

/**Return the number of entries in the list
 *@param list: the list to return the number
 *@return the number of entries in the list
 */
int numberOfList(ListType & list){
    Node * node = list;
    int num = 0;
   
    while(node != NULL){
        num++;
        node = node -> next;
    
    }
    return num;

}

/**Search the key-associated value in the list
 *@param list: the list to search the value
 *@param target: the key of the entry
 *@return the value, if the key doesn't exist, return NULL
 */
int * listLookUp(ListType & list, const string & target){
    
    Node * node = list;
    while(node != NULL){
        string str = node -> key;
        if(str == target){
            return &(node -> value);
        }
        node = node -> next;
    }

    return NULL;
}

/**Print every entry in the list
 *@param list: the list to print the entry
 */
void listPrint(ListType & list){

    Node * node = list;
    while(node != NULL){
        cout << node -> key << " " << node -> value << endl;
        node = node -> next;
    }

}

/**Append a key-value pair at the end of the list
 *@param list: the list to append the entry
 *@param target: the key of the entry
 *@param value: the value of the entry
 *@return true if the append is successful
 */
bool listAppend(ListType & list, const string & target, int value){
    if(contains(list, target)){
      cout <<"Key already exist, append failed.";
      return false;
    }
    Node * node = list;
    Node * newNode = new Node(target, value);
    if(node == NULL){
        list = newNode;
        return true;
    }
    while(node -> next != NULL){
        node = node -> next;
    }
    node -> next = newNode;
    return true;
}


/**Append a key-value pair at the end of the list
 *@param list: the list to append the entry
 *@param target: the key of the entry
 *@param value: the value of the entry
 *@return true if the append is successful
 */
bool updateValue(ListType & list, const string & target, int value){

    int * oldValue = listLookUp(list, target);
    if(oldValue != NULL){
        *oldValue = value;
        return true;
    }else{
      cout << "Key doesn't exist, update failed!" << endl;
        return false;
    }

}











