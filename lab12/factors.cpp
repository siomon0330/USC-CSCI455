#include <iostream>

using namespace std;

// finds all of n's factors
// not including 1 and itself
void factors (int n)
{
  //int k = 2;
  int k = 0;

  while (k < n) {
    if (n % k == 0) {
      cout << k << endl;
    }
    // k++;
  }
  
}

int main()
{
  int n;
  cout << "Find factors of what number? ";
  cin >> n;
  cout << "Factors of n are: " << endl;
  factors (n);
  cout << endl;
}
