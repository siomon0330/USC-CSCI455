//
// HEAVY IRON INTERN PROGRAMMING CHALLENGE
// 
// Thanks for your interest in interning as a programmer at Heavy Iron.
//
// Welcome to the challenge. We expect it will take under two hours to complete.
// Please attempt all questions below.
//
// - Read all the instructions and questions carefully.
// - You may use a compiler, or just use a text editor. Your choice.
// - All work should be done in this one file.
//
// - DO NOT use the internet or other reference material, unless specified.
// - DO NOT use STL or similar templated data structures.
// - DO NOT modify the function definitions.
//
// - DO NOT CHEAT. We're not trying to see if you can cheat.
// 
//
// When finished:
//
// 1) Fill in these details in this cpp file:
//
//		Name										: Your name here
//		Address										: etc
//		Email										:
//		Phone										:
//		Current College								:
//		Current Course								:
//		Expected graduation date					:
//		Previous bachelors (if appropriate)			:
//		Date you could start						:
//		Date you would end (if appropriate)			:
//		Are you available full time all summer		:
//		Are you interested in interning term time*	:
//			* Some of our local interns work full time during the summer, and part time 2..5 
//			  days during term time. This isn't required, but it's interesting to know.
//
// 2) Save your changes, and email just this file to HI-interns@heavy-iron.com
//	  If you have an up to date resume, include that too.
//
// As we receive applications, we’ll pick several for in-house interview, and will then 
// select who will be offered positions.
//
// Good luck, and have fun! :)
//
// Heavy Iron Studios, Inc.
// (c) Copyright 2013


#include "System.h"


////////////////////////////////////////////////
// QUESTION 0
//
// Change the string for your name and the date you todays date
char* YourNameAndTheDate()
{
	return "Your Name Here   4/1/2000";
}


////////////////////////////////////////////////
// QUESTION 1
//
// Write a function which sorts a list of numbers in ascending order, with odd numbers first.
// - E.g. if the input was 123456, the output would be 135246.
// - You are given a pointer to the beginning of an array, and the length of the array.
// - Your function should handle its input parameters robustly (i.e. not crash or misbehave with 'bad' parameters).
// - Correctness, performance and readability are important.
void SortOddEven( int* numbers, int count )
{
	// TODO
}


////////////////////////////////////////////////
// QUESTION 2
//
// 'FizzBuzz' is a game in which people take turns saying increasing numbers, but sometimes
// they have to say a word instead of a number.
// Write a function which:
// - Takes an integer. E.g. 2
// - Normally writes the integer as a string to the buffer pointed to by 'output'. E.g. "2"
// - If a multiple of 3 is passed, writes "Fizz" to the buffer pointed to by 'output', instead of printing the number.
// - If a multiple of 5 is passed, writes "Buzz" to the buffer pointed to by 'output', instead of printing the number.
// - If a multiple of both 3 and 5 is passed, writes "FizzBuzz" to the buffer pointed to by 'output', instead of printing the number.
// You may use strcpy and sprintf if you wish. You may look at the following two links for their definition if needed:
//    http://msdn.microsoft.com/en-us/library/kk6xf663(VS.90).aspx
//    http://msdn.microsoft.com/en-us/library/ybk95axf(VS.90).aspx
void FizzBuzz( int value, char* output )
{
	*output = NULL;
}


////////////////////////////////////////////////
// QUESTION 3
//
// Write a function which tests if two circles overlap.
// The circles are described by a position and radius.
// Return true if the circles exactly touch or are intersecting.
// Return false otherwise.
// Performance and accuracy are important.
bool CirclesIntersect( float x1, float y1, float r1, float x2, float y2, float r2 )
{
	return false;	// Todo
}


////////////////////////////////////////////////
// QUESTION 4
//
// In our game, we have a monster which is looking for apples. Implement a function which returns if a
// given apple position is in front of a monster with a given position and facing direction (unit vector).
// You may look at the VecMath.cpp/h files (and use the functions within), but may USE NO OTHER REFERENCE.
bool IsAppleInFrontOfMonster( vector3& monsterPos, vector3& monsterFacingDirection, vector3& applePos )
{
	return false;	// Todo
}


////////////////////////////////////////////////
// QUESTION 5
//
// Write a function which shuffles the order of the bytes in an unsigned int, to reverse order.
// E.g. If the input was 0x12345678, the output should be 0x78563412
// Correctness is important, as well as performing the operation in as few steps as possible.
unsigned int SwapBytes( unsigned int in )
{
	return 0;	// Todo
}


////////////////////////////////////////////////
// QUESTION 6
//
// Strip spaces
// Write a function which allocates a new string using HIMalloc, and copies
// the input string to the new string, while stripping out the spaces.
// To allocate the memory for the new string, use 'HIMalloc' (which works like malloc).
// E.g. the input "My word, a talking goat!" should return a new string "Myword,atalkinggoat!"
// You are not allowed to call string functions, such as strlen. Just use pointers.
char* StripSpaces(char* input)
{
	return NULL;	// Todo
}


////////////////////////////////////////////////
// QUESTION 7
//
// Many displays display numbers using a set of 7 bars (e.g. calculator, microwave, digital watch)
// The following ASCII art shows the numbers 0 to 9
//
//	 -			 -		-				 -				 -		 -		 -
//	| |		|	  |		 |		| |		|		|		  |		| |		| |
//	 			 -		-		 -		 -		 -				 -		 -
//	| |		|	|		 |		  |		  |		| |		  |		| |		  |
//	 -			 -		-				 -		 -				 -
//
// Write a function which returns how many LCD 'bars' are needed to display an unsigned int.
// Given an unsigned int as input, return how many 'bars' will make up that number when displayed
// on a calculator which uses this type of display. 
// E.g. 1 would return 2 bars, 12 would return 7 (2 bars for the 1, plus 5 for the 2), 90 would return 11 etc.
int BarsInDisplayedNumber( unsigned int num )
{
	return 0;	// TODO
}




// This is the 'test' function which calls your answers above.
// If you are using a compiler, you are welcome to use and modify this function 
// to help while developing your answers. This function should not do anything 
// important though. Your answers should be contained in the functions above.
void RunTest()
{
	// Question 0 - NAME AND DATE
	printf( "0) Name and date: %s\n\n", YourNameAndTheDate() );


	// Question 1 - SORT ODD EVEN
	int list1[] = {1, 2, 3, 4, 5, 6};
	SortOddEven( list1, sizeof(list1)/sizeof(int) );
	printf( "1) SORT ODD EVEN\n\n" );


	// Question 2 - FIZZ BUZZ
	printf( "2) FIZZ BUZZ\n" );
	char temp[16];
	FizzBuzz(1, temp);
	if( *temp )
		printf( "%s\n", temp );
	printf( "\n" );


	// Question 3 - CIRCLE INTERSECTION
	bool intersects = CirclesIntersect(0,	0,	5,	10,	0,	3);
	printf( "3) CIRCLE INTERSECTION : %s\n\n", intersects ? "Yes":"No" );


	// Question 4 - APPLE MONSTER
	vector3 monsterPos(100, 100, 0);
	vector3 monsterDir(1, 0, 0);
	vector3 applePos(150, 125, 0);
	bool infront = IsAppleInFrontOfMonster( monsterPos, monsterDir, applePos );
	printf( "4) APPLE IS %s MONSTER\n\n", infront?"IN FRONT OF":"BEHIND" );


	// Question 5 - SWAP BYTES
	unsigned int input = 0x12345678;
	unsigned int shuffled = SwapBytes( input );
	printf( "5) SWAP BYTES\n0x%x => 0x%x\n\n", input, shuffled );


	// Question 6 - STRIP SPACES
	char* withSpaces = "Oh My Word!";
	char* stripped = StripSpaces( withSpaces );
	printf( "6) STRIP SPACES\n%s => %s\n\n", withSpaces, stripped );


	// Question 7 - BARS IN DISPLAY
	int bars = BarsInDisplayedNumber( 123 );
	printf( "7) BARS IN DISPLAY = %d\n", bars );
}


