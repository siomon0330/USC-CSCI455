#include "System.h"
#include <malloc.h>

int lastMallocSize = -1;

// Allocates some memory, using malloc.
void* HIMalloc( int size )
{
	lastMallocSize = size;
	return malloc( size );
}

// Frees some memory.
void HIFree( void* ptr )
{
	free( ptr );
}

// Returns the size of the last memory allocation.
int HILastMallocSize()
{
	int temp = lastMallocSize;
	lastMallocSize = -1;
	return temp;
}