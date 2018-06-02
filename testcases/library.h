#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef void (*FUNC)(void*);
//change _array to _._array
//change _string to _.string

int _getInt()
{
	int i;
	scanf("%d",&i);
	return i;
}
char* _toString(int i)
{
	char* str = (char*)malloc(15+sizeof(int))+sizeof(int);
	sprintf(str, "%d", i);
	int len = strlen(str);
	((int*)str)[-1] = len;
	str[len] = 0;
	return str;
}

char* __string_string(int size);
char buffer[256]={0};
char* _getString()
{
	char *ret;
	int len;
	scanf("%s", buffer);
	len = strlen(buffer);
	ret = __string_string(len);
	strcpy(ret, buffer);
	return ret;
}

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


char* __string_string(int size)
{
	char *ret = (char*)malloc(size+1 + sizeof(int))+sizeof(int);
	((int*)ret)[-1] = size;
	ret[size]=0;
	return ret;
}


void _print(char* str)
{
	while(*str)
		putchar(*(str++));
}
void _println(char* str)
{
	puts(str);
}
/*
char* _getString()
{
	char* str = NULL, *ret;
	int len;
	getline(&str, &len, stdin);
	ret = __string_string(len);
	strcpy(ret, str);
	return ret;
}*/

//string
int __string_length(char* tthis)
{
	//return ((int*)tthis)[-1];
	return strlen(tthis);
}
char* __string_substring(char *a, long low, long high)
{
	int l = high - low + 1;
	char *ret = __string_string(l);
	a += low;
	for (int i = 0; i < l; ++i)
		ret[i] = a[i];
	return ret;
}
int __string_parseInt(char* tthis)
{
	return atoi(tthis);
}
int __string_ord(char* tthis, int pos)
{
	return (int)tthis[pos];
}

//string + string
char* __string__plus(char* tthis, char* other)
{
	char* str;
	int n0, n1;
	n0 = ((int*)tthis)[-1];
	n1 = ((int*)other)[-1];
	str = __string_string(n0+n1);
	strcpy(str, tthis);
	strcpy(str+n0, other);
	return str;
}
//string < string
bool __string__less(char* tthis, char* other)
{
	return strcmp(tthis, other) == -1;
}
//string <= string
bool __string__lessEqual(char* tthis, char* other)
{
	return strcmp(tthis, other) <= 0;
}

//string == string
bool __string__equal(char* tthis, char* other)
{
	return strcmp(tthis, other) == 0;
}
int __array_size(void *tthis)
{
	return ((int*)tthis)[-1];
}
