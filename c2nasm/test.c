#include <assert.h>
void test_output()
{
	printf("[test_output]");

	_print("_print("");");
	_println("_println("");");
}
void test_input()
{
	printf("[test_input]");
	printf("_getString();");
	char *str = _getString();
	printf("%s\n",str);
	printf("_getInt();");
	int num = _getInt();
	printf("%d\n",num);
}
void printString(char *name, unsigned char* str)
{
	printf("%s[%d]: %s\n", name, ((int*)str)[-1], str);
}
void test_string()
{
	printf("[test_string]\n" );
	unsigned char s0[] = "0000111", s1[] = "00002222";
	unsigned char *str0, *str1, *str2;
	str0 = s0 + sizeof(int);
	str1 = s1 + sizeof(int);
	((int*)s0)[0] = strlen(str0);
	((int*)s1)[0] = strlen(str1);

	printf("__string_string\n");
	int len = 3;
	str2 = __string_string(len);
	for(int i=0;i<len;++i)
		str2[i] = '1';

	printf("__string__equal\n");
	assert( __string__equal(str0, str2));
	printf("__string__less\n");
	assert(__string__less(str0, str1));
	assert(!__string__less(str1, str2));
	printf("string plus\n",((int*)str0)[-1],str0);

	printString("str0", str0);
	printString("str1", str1);
	printString("str2", str2);
	printString("str0+str1", __string__plus(str0, str1));

	printf("__string_ord\n");
	printf("");
	assert( __string_ord(str1, 0) == '2');
	assert( __string_ord(str1, len-1) == '2');
	assert( __string_ord(str2, 0) == '1');
	assert( __string_ord(str2, len-1) == '1');

	printf("__string_length\n");
	assert(__string_length(str0)==3);
	assert(__string_length(str1)==4);
	assert(__string_length(str2)==3);

	printf("__string_length\n");
	assert(__string_parseInt(str0) == 111);
	assert(__string_parseInt(str1) == 2222);

	printf("__string_substring\n");
	printString("str0+str1", __string_substring( __string__plus(str0, str1), 2, 4));

	printf("Pass.\n");
}
void test_array()
{

	printf("__array_array\n");
	long int* array = __array_array(2), *a0;
	((long int*)array)[0] = 10;
	((long int*)array)[1] = 20;
	printf("__string_new\n");
	a0 = __array_new(array, 2, 8, 0);
	printf("__string_length\n");
	printf("%d\n", __array_size(a0));
	assert(__array_size(a0) == 10);
	printf("%d\n", __array_size(a0[0]));
	assert(__array_size(a0[0]) == 20);
}
int main()
{
	// unsigned char oStr[100]="0000_toString(12)";
	// unsigned char *str = oStr + sizeof(int);
	// ((int*)str)[-1] = strlen(str);
	// _println(_toString(__string_length(str)));
	// test_output();
	// test_input();
	// test_string();
	test_array();
}
