1.1 
Implementing a class and testing it early help us find the bug early and make it easier for us to debug. 

2.1
nums.in numbers are 3 -7 10 17 9 -17  17 21 18 7
expected result of minVal is -17

test1.in numbers are -1 0 1 2 4 8 16 32
expected results for minVal are -1

test2.in numbers are -10 -5 0 10 20 100
expected results for minVal are -10

2.2
A non-empty object that is full of non-integers will return the same value as an empty Nums object.  
A non-empty object that is full of Integer.MAX_VALUE will return the same value as an empty Nums object.  

3.1
For nums.in:
testFilter(nums, 10) will return values (17 17 21 18)
testFilter(nums, -20) will return values (3 -7 10 17 9 -17 21 18 7)
testFilter(nums, -17) will return values (3 -7 10 17 9 21 18 7)
testFilter(nums, 21) will return ()

For test1.in 
testFilter(nums, 10) will return values (16 32)
testFilter(nums, -20) will return values (-1 0 1 2 4 8 16 32)
testFilter(nums, -17) will return values (-1 0 1 2 4 8 16 32)
testFilter(nums, 21) will return (32)

For test2.in
testFilter(nums, 10) will return values (20 100)
testFilter(nums, -20) will return values (-10 -5 0 10 20 100)
testFilter(nums, -17) will return values (-10 -5 0 10 20 100)
testFilter(nums, 21) will return (100)



4.1
Entering a non-integer such as a char or a string will signal to the program that there are no more integers to read.

4.2
(nums.valuesGT(threshold)).printVals();

4.3
Nums

4.4
Nums nums1 = nums.valuesGT(threshold);
nums1.printVals();


4.5) When you are trying to get some element, the time complicity of ArrayList is higher than Array.

4.6) When you are trying to add new elements, the time complicity of ArrayList is lower than Array.

4.7)
1.We don’t need to save the numbers.  We can just print them as we read them.
2.We don’t need to save the numbers, we only need to save the minimum value of the sequence. 
3.We don’t need to save the numbers, we only need to save the minimum value of the sequence. 
4.We only need to save the threshold value. There is no need to save all the values. 
5.We need to save the input data to produce the output by NumTester.


