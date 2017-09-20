// Name:Chuanli Wei
// Loginid:6222006323
// CSCI 455 PA5
// Spring 2017

// Note: [11/26/13 CMB] modified insert comment

#ifndef TABLE_H
#define TABLE_H

// Table class
//    stores a collection of (string, int) entries
//    such that each key (the string) is unique
//    with efficient (O(1)) lookup, insert, and removal
//

#include <iostream>
#include <string>

// the following include is for string hash function
// NOTE: You will need the following #include to compile the hash function used
//  below on aludra.  See the call to tr1::hash later in this file for more 
//  information.
#include <tr1/functional>



using namespace std;

// the following line of code is a forward declaration of Node struct.
// allows us to use Node* (or ListType because of typedef) in private 
// section of Table below. (Complete Node definition is in listFuncs.h)
class Node;
typedef Node * ListType;

class Table {
public:

  static const int HASH_SIZE = 9973;  // a prime number

   // create an empty table, i.e., one where numEntries() is 0
   // (Underlying hash table is HASH_SIZE.)
   Table();

   // create an empty table, i.e., one where numEntries() is 0
   // such that the underlying hash table is hSize
   Table(unsigned int hSize);

   // insert a new pair into the table
   // return false iff this key was already present 
   //         (and no change made to table)
   bool insert(const string &key, int value);

   // returns the address of the value or NULL if key is not present
   //   Thus, this method can be used to either lookup the value or
   //   update the value that goes with this key.
   int *lookup(const string &key);

   // remove an element
   // false iff element wasn't present
   bool remove(const string &key);

   // print out all the entries in the table, one per line.
   // Sample output:
   //   joe 32
   //   sam 273
   //   bob 84
   void printAll() const;

   int numEntries() const;      // number of entries in the table

   // hashStats: for diagnostic purposes only
   // prints out info to let us know if we're getting a good distribution
   // of values in the hash table.
   // Sample output from this function
   //   number of buckets: 997
   //   number of entries: 10
   //   number of non-empty buckets: 9
   //   longest chain: 2
   void hashStats(ostream &out) const;

private:

   //***********do not change the following two lines of code*************
   // making these private disallows copying of tables  
   // (do not implement these two functions)
   Table &operator =(const Table &);
   Table(const Table &);

   // hash function for a string
   // (we defined it for you)
   // returns a value in the range [0, hashSize)
  unsigned int hashCode(const string &word) const {

    // tr1 is a version of a newer C++ library that contains hashing support.
    // calls a library-defined hash function for string (it uses the good hash
    //   algorithm for strings that we discussed in lecture).
    // if the statement given below doesn't compile on your local environment, 
    //   you can try subsituting:
    //     return std::hash<string>()(word) % hashSize;
    // WARNING: However, the alternate statement given above will NOT compile on
    //     aludra.  You will need the following version on aludra.

    return tr1::hash<string>()(word) % hashSize;
  }

// add private data and methods here

  unsigned int hashSize;      // size of the hash table
                              // (used in hashCode method above)
 
    
  ListType * hashTable;     // The hash table we are implementing

    
    
    /**Return the number of non-empty buckets in the table
     *@return the number of non=empty buckets in the table
     */
  int numberOfNonEmptyBuckets() const;
    
    
    /**Return the number of longest chain in the table
     *@return the number of longest chain in the table
     */
  int longestNumber() const;



};

#endif
