#include <assert.h>
/*
#include <string.h>
unsigned char* __string_string(int size)
{
	unsigned char *ret = malloc(size+1 + sizeof(int))+sizeof(int);
	((int*)ret)[-1] = size;
	ret[size]=0;
	return ret;
}
unsigned char* __string__plus(unsigned char* this, unsigned char* other)
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
*/
/*
void printString(unsigned char *name, unsigned char* str)
{
	printf("%s[%d]: %s\n", name, ((int*)str)[-1], str);
}
void test_string()
{
	printf("[test_string]\n" );
	unsigned char s0[] = "0000 b ", s1[] = "0000a";
	unsigned char *str0, *str1, *str2;
	str0 = s0 + sizeof(int);
	str1 = s1 + sizeof(int);
	((int*)s0)[0] = strlen(str0);
	((int*)s1)[0] = strlen(str1);
	unsigned char *addr;
	addr =  __string__plus(str0, str1);
	printString("str0+str1",addr);
}*/

#include<string.h>
//string < string
_Bool __string__less(unsigned char* this, unsigned char* other)
{
	return strcmp(this, other) == -1;
}
int main()
{
	// unsigned char oStr[100]="0000_toString(12)";
	// unsigned char *str = oStr + sizeof(int);
	// ((int*)str)[-1] = strlen(str);
	// _println(_toString(__string_length(str)));

	__string__less("DC", "BA");
}
