#include <iostream>
#include <vector>
using namespace std;

vector<int> readVals(){
  int val;
  vector<int> nums;
  cout << "Enter numbers:";
  while(cin >> val){
    nums.push_back(val);
  }
  return nums;
}


void printVals(vector<int> nums){
  for(int i = 0; i < nums.size();i++){
    cout << nums[i] << " ";
  }
  cout <<  endl;
}

int main(){
  vector<int> nums = readVals();
  printVals(nums);
  return 0;
}
