#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef void (*FUNC)(void*);
//change _array to _._array
//change _string to _.string

void* __array_array(int size)
{
	void *ret = malloc(size*8 + sizeof(int))+sizeof(int);
	((int*)ret)[-1] = size;
	return ret;
}

void** __array_new(long int *aSize, int dim, int eSize, FUNC func)
{
	void** array = (void**)__array_array(aSize[0]);
	for(int i=0;i<aSize[0];++i)
	{
		if(dim > 1)
		{
			array[i] = __array_new(aSize+1, dim-1, eSize, func);
		}else
		{
			if(func!=NULL)
			{
				array[i] = malloc(eSize);
				func(array[i]);
			}
		}
	}
	return array;
}


unsigned char* __string_string(int size)
{
	unsigned char *ret = malloc(size+1 + sizeof(int))+sizeof(int);
	((int*)ret)[-1] = size;
	ret[size]=0;
	return ret;
}


void _print(unsigned char* str)
{
	while(*str)
		putchar(*(str++));
}
void _println(unsigned char* str)
{
	puts(str);
}
/*
unsigned char* _getString()
{
	unsigned char* str = NULL, *ret;
	int len;
	getline(&str, &len, stdin);
	ret = __string_string(len);
	strcpy(ret, str);
	return ret;
}*/

//string
int __string_length(unsigned char* this)
{
	return ((int*)this)[-1];
}
unsigned char* __string_substring(unsigned char *a, long low, long high)
{
	int l = high - low + 1;
	unsigned char *ret = __string_string(l);
	a += low;
	for (int i = 0; i < l; ++i)
		ret[i] = a[i];
	return ret;
}
int __string_parseInt(unsigned char* this)
{
	return atoi(this);
}
int __string_ord(unsigned char* this, int pos)
{
	return (int)this[pos];
}

//string + string
char* __string__plus(unsigned char* this, unsigned char* other)
{
	unsigned char* str;
	int n0, n1;
	n0 = ((int*)this)[-1];
	n1 = ((int*)other)[-1];
	str = __string_string(n0+n1);
	strcpy(str, this);
	strcpy(str+n0, other);
	return str;
}
//string < string
_Bool __string__less(unsigned char* this, unsigned char* other)
{
	return strcmp(this, other) == -1;
}
//string <= string
_Bool __string__lessEqual(unsigned char* this, unsigned char* other)
{
	return strcmp(this, other) <= 0;
}

//string == string
_Bool __string__equal(unsigned char* this, unsigned char* other)
{
	return strcmp(this, other) == 0;
}
int __array_size(void *this)
{
	return ((int*)this)[-1];
}
