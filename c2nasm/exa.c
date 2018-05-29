#include <stdio.h>
#include <stdlib.h>
#include <string.h>
unsigned char* __string_string(int size)
{
	unsigned char *ret = malloc(size+1 + sizeof(int))+sizeof(int);
	((int*)ret)[-1] = size;
	ret[size]=0;
	return ret;
}
//string + string
unsigned char* __string__plus(unsigned char* this, unsigned char* other)
{
	unsigned char* str;
	int n0, n1;
	n0 = ((int*)this)[-1];
	n1 = ((int*)other)[-1];
	str = __string_string(n0+n1+1);
	strcpy(str, this);
	strcpy(str+n1, other);
	return str;
}

int main()
{
	unsigned char* a = __string__plus("a", " b");
}
