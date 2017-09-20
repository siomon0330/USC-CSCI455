// concord.cpp
// CS 455  PA5

// You do not need to modify or submit this file.

/*
 * concordance program using our Table class
 * Get text from keyboard until eof.
 * Prints output to console.
 *
 * Run the program as follows:
 *
 *       concord [-s]
 *
 *  The optional -s flag prints statistics about the hash table to cerr.
 *  If we run the program with output redirection, e.g.:
        concord -s < infile > outfile
 *  the cerr output still goes to the monitor (not to outfile)
 */

#include <string>

using namespace std;

// for isalnum and tolower (used in filter)
#include <cctype>
// some STL algorithms used in filter
#include <algorithm>

// defined below
void filter(string &word);

#include "Table.h"


// build a concordance from data from cin
// terminated by eof
void buildTable(Table &concord) {
  
  string word;

  while (cin >> word) {
    filter(word);
    int *val = concord.lookup(word);
    if (val == NULL) {
      concord.insert(word, 1);
    }
    else {
      (*val)++;
    }
  }

}


int main(int argc, char * argv[]) {

  bool doHashStats = false;

  // string(c_string_var) below converts the c-string to a string object

  if ((argc > 1) && (string(argv[1]) == "-s")) {
    doHashStats = true;
  }

  Table concord;

  buildTable(concord);

  //  cout << "Concord in no particular order: " << endl;
  concord.printAll();

  if (doHashStats) {
    cerr << "Hash stats: " << endl;
    concord.hashStats(cerr);
  }

  return 0;
}



// the rest of the code here is for the filter function below
struct IsAlphaNum {
  bool operator()(char ch) {
    return isalnum(ch);
  }
};

struct ConvertLowerCase {

  void operator()(char &ch) {
    ch = tolower(ch);
  }
};


// filters word in place
// strips off leading and trailing punctuation
//   keeps internal, such as hyphen in "co-op"
// and converts to all lower case
// allows digits to be a word or part of a word

void filter(string &word) {
  // find first non punctuation char
  string::iterator firstLetterLoc = 
    find_if(word.begin(), word.end(), IsAlphaNum());

  if ( firstLetterLoc == word.end()) {  // ALL punctuation
    word = string();    // change to empty string
    return;
  }

  // find last non punctuation char
  string::reverse_iterator RlastLetter = 
    find_if(word.rbegin(), word.rend(), IsAlphaNum());

  // convert reverse iterator to a forward iterator (gross)
  string::iterator lastLetterLoc = RlastLetter.base()-1;  

  // convert non-punctuation part of string to lower case
  for_each(firstLetterLoc, lastLetterLoc+1, ConvertLowerCase());

  // only shift chars if there was leading punctuation
  if (firstLetterLoc != word.begin()) {
    // shift letters over to start of string
    copy(firstLetterLoc, lastLetterLoc+1, word.begin());

  }

  // only resize if changed size
  if (lastLetterLoc-firstLetterLoc+1 != word.size()) {
    // chop off end of string
    word.resize(lastLetterLoc-firstLetterLoc+1);
  }

}

