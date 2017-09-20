
#include <stdio.h>
#include <stdlib.h>
#include <tchar.h>
#include <string.h>
#include <math.h>
#include "conio.h"
#include "VecMath.h"

void* HIMalloc( int size );	// Allocate
void HIFree( void* ptr );	// Free
int HILastMallocSize();		// Get size of last allocation
