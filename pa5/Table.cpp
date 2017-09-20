// Name:Chuanli Wei
// Loginid:6222006323
// CSCI 455 PA5
// Spring 2017

// Table.cpp  Table class implementation


/*
 * Modified 11/22/11 by CMB
 * changed name of constructor formal parameter to match .h file
 */

#include "Table.h"

#include <iostream>
#include <string>
#include <cassert>


// listFuncs.h has the definition of Node and its methods.  -- when
// you complete it it will also have the function prototypes for your
// list functions.  With this #include, you can use Node type (and
// Node*, and ListType), and call those list functions from inside
// your Table methods, below.

#include "listFuncs.h"


//*************************************************************************

/**Constructor of table class using default table size
 */
Table::Table() {
    hashTable = new ListType[HASH_SIZE];
    hashSize = HASH_SIZE;
    for(int i = 0; i < hashSize; i++){
        hashTable[i] = NULL;
    }
}

/**Constructor of table class using client input table size
 */

Table::Table(unsigned int hSize) {
    hashTable = new ListType[hSize];
    hashSize = hSize;
    for(int i = 0; i < hashSize; i++){
        hashTable[i] = NULL;
    }

}

/**Lookup the value of a given key in the table
 *@param key: the key of the entry
 *@return the pointer to the value of the key
 */

int * Table::lookup(const string &key) {
    
    Node * & bucket = hashTable[hashCode(key)];
    return listLookUp(bucket, key);
}


/**Remove a certain key-value pair in the table
 *@param key: the key of the entry
 *@return true if the removement is successful
 */
bool Table::remove(const string &key) {
   
    Node * & bucket = hashTable[hashCode(key)];
    return listRemove(bucket, key);
}


/**Insert a key-value pair in the table
 *@param key: the key of the entry
 *@return true if the insertion is successful
 */
bool Table::insert(const string &key, int value) {
    
    Node * & bucket = hashTable[hashCode(key)];
    return insertFront(bucket, key, value);
}


/**Return the number of entries in the table
 *@return the number of entries in the table
 */
int Table::numEntries() const {
    int sum = 0;
    for(int i = 0 ; i < hashSize; i++){
        sum += numberOfList(hashTable[i]);
    }
    return sum;
  
}


/**Print all the entries in the table
 */

void Table::printAll() const {
    for(int i = 0; i < hashSize; i++){
        listPrint(hashTable[i]);
    }

}


/** Print out the hash table statistics 
 * The number of buckets, the number of entries, the number of non-empty buckets, and the longest chain
 */

void Table::hashStats(ostream &out) const {
    cout << "number of buckets: " << hashSize << endl;
    cout << "number of entries: " << numEntries() << endl;
    cout << "number of non-empty buckets: " << numberOfNonEmptyBuckets() << endl;
    cout << "longest chain: " << longestNumber() << endl;
  
}


// add definitions for your private methods here



/**Return the number of non-empty buckets in the table
 *@return the number of non=empty buckets in the table
 */
int Table::numberOfNonEmptyBuckets() const{
    int number = 0;
    for(int i = 0 ; i < hashSize; i++){
        if(hashTable[i] != NULL){
            number++;
        }
    }
    return number;

}


/**Return the number of longest chain in the table
 *@return the number of longest chain in the table
 */
int Table::longestNumber() const{
    int longest = 0;
    for(int i = 0 ; i < hashSize; i++){
        if(numberOfList(hashTable[i]) > longest){
            longest = numberOfList(hashTable[i]);
        }
    }
    return longest;
}


















































































