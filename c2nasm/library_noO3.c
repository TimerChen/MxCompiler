#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int _getInt()
{
	int i;
	scanf("%d",&i);
	return i;
}
unsigned char* _toString(int i)
{
	unsigned char* str = malloc(15+sizeof(int))+sizeof(int);
	sprintf(str, "%d", i);
	int len = strlen(str);
	((int*)str)[-1] = len;
	str[len] = 0;
	return str;
}

unsigned char* __string_string(int size);
char buffer[256]={0};
unsigned char* _getString()
{
	unsigned char *ret;
	int len;
	scanf("%s", &buffer);
	len = strlen(buffer);
	ret = __string_string(len);
	strcpy(ret, buffer);
	return ret;
}
/*
	unsigned char* str = NULL, s[20];
	sprintf(s, "%d", i);
	int len = strlen(s);
	printf("len :%d\n",len);
	str = malloc(len+10+sizeof(int))+sizeof(int);
	((int*)str)[-1] = len;
	strcpy(str,s);
	str[len] = 0;

	printf("char: %c\n", str[0]);
	printf("%d\n",(int)str);
	return str;
*/
