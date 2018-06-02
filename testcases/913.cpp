#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "library.h"

int hex2int(char* x)
{
	int i;
	int result = 0;
	for(i=0;i<__string_length(x);i++)
	{
		int digit = __string_ord(x, i);
		if(digit >= 48 && digit <= 57)
			result = result * 16 + digit - 48;
		else if(digit >= 65 && digit <= 70)
			result = result * 16 + digit - 65 + 10;
		else if(digit >= 97 && digit <= 102)
			result = result * 16 + digit - 97 + 10;
		else
			return 0;
	}
	return result;
}

char* asciiTable = " !\"#$%%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
int rotate_left(int x, int shift)
{
	if(shift == 1)
		return ((x & 2147483647) << 1) | ((x >> 31) & 1);
	if(shift == 31)
		return ((x & 1) << 31) | ((x >> 1) & 2147483647);
	return ((x & ((1 << (32-shift)) - 1)) << shift) | ((x >> (32-shift)) & ((1 << shift) - 1));
}
int add(int x, int y)	//to avoid possible undefined behaviour when overflow
{
	int low = (x & 65535) + (y & 65535);
	int high = (((x >> 16) & 65535) + ((y >> 16) & 65535) + (low >> 16)) & 65535;
	return (high << 16) | (low & 65535);
}
int lohi(int lo, int hi)
{
	return lo | (hi << 16);
}
const int MAXCHUNK = 100;
const int MAXLENGTH = (MAXCHUNK-1) * 64 - 16;
int chunks[MAXCHUNK][80];
int* inputBuffer = new int[MAXLENGTH];
int* outputBuffer = new int[5];
int* sha1(int* input, int length)
{
	int nChunk = (length + 64 - 56) / 64 + 1;
	if(nChunk > MAXCHUNK)
	{
		_println("nChunk > MAXCHUNK!");
		return NULL;
	}
	int i;
	int j;
	for(i=0;i<nChunk;i++)
		for(j=0;j<80;j++)
			chunks[i][j] = 0;
	for(i=0;i<length;i++)
		chunks[i/64][i%64/4] = chunks[i/64][i%64/4] | (input[i] << ((3-i%4)*8));
	chunks[i/64][i%64/4] = chunks[i/64][i%64/4] | (128 << ((3-i%4)*8));
	chunks[nChunk-1][15] = length << 3;
	chunks[nChunk-1][14] = (length >> 29) & 7;

	int h0 = 1732584193;  //0x67452301
	int h1 = lohi(43913, 61389);  //0xEFCDAB89
	int h2 = lohi(56574, 39098); //0x98BADCFE
	int h3 = 271733878;   //0x10325476
	int h4 = lohi(57840, 50130); //0xC3D2E1F0
	for(i=0;i<nChunk;i++)
	{
		for(j=16;j<80;j++)
			chunks[i][j] = rotate_left(chunks[i][j-3] ^ chunks[i][j-8] ^ chunks[i][j-14] ^ chunks[i][j-16], 1);

		int a = h0;
		int b = h1;
		int c = h2;
		int d = h3;
		int e = h4;
		//printf("%d, %d, %d, %d, %d\n",a,b,c,d,e);
		for(j=0;j<80;j++)
		{
			//printf("%d, %d, %d, %d, %d\n",a,b,c,d,e);
			int f;
			int k;
			if(j<20)
			{
				f = (b & c) | ((~b) & d);
				k = 1518500249; //0x5A827999
			}
			else if(j<40)
			{
				f = b ^ c ^ d;
				k = 1859775393; //0x6ED9EBA1
			}
			else if(j<60)
			{
				f = (b & c) | (b & d) | (c & d);
				k = lohi(48348, 36635); //0x8F1BBCDC
			}
			else
			{
				f = b ^ c ^ d;
				k = lohi(49622, 51810); //0xCA62C1D6
			}
			int temp = add(add(add(rotate_left(a, 5), e), add(f, k)), chunks[i][j]);
			if(j==6)
			{
				printf("%d\n",temp);
				printf("%d, %d, %d, %d, %d\n",a,e,f,k,chunks[i][j]);
			}

			e = d;
			d = c;
			c = rotate_left(b, 30);
			b = a;
			a = temp;
		}
		h0 = add(h0, a);
		h1 = add(h1, b);
		h2 = add(h2, c);
		h3 = add(h3, d);
		h4 = add(h4, e);
	}
	outputBuffer[0] = h0;
	outputBuffer[1] = h1;
	outputBuffer[2] = h2;
	outputBuffer[3] = h3;
	outputBuffer[4] = h4;
	return outputBuffer;
}
char* int2chr(int x)
{
	if(x >= 32 && x <= 126)
		//return asciiTable.substring(x-32, x-32);
		return __string_substring(asciiTable, x-32, x-32);
	return "";
}
char* toStringHex(int x)
{
	char* ret = __string_string(0);
	int i;
	for(i=28;i>=0;i=i-4)
	{
		int digit = (x >> i) & 15;
		if(digit < 10)
			//ret = ret + int2chr(48+digit);
			ret = __string__plus(ret, int2chr(48+digit));
		else
			ret = __string__plus(ret, int2chr(65+digit-10));
			//ret = ret + int2chr(65+digit-10);
	}
	return ret;
}
void computeSHA1(char* input)
{
	int i;
	for(i=0; i<strlen(input); i++)
	{
		inputBuffer[i] = __string_ord(input, i);
		//print(tochar*(inputBuffer[i])+", ");
	}
	//print("\n");
	int* result = sha1(inputBuffer, __string_length(input));

	for(i=0; i<5; i++)
	{
		//_print(toStringHex(result[i]));
		printf("%08X",result[i]);
	}

	printf("\n");
}
int main()
{
	int op;
	char input[100];
	while(true)
	{
		op = _getInt();
		if(op == 0)
			break;
		if(op == 1)
		{
			scanf("%s", &input);
			//printf("%s\n",&input);
			computeSHA1(input);
		}
		else if(op == 2)
		{

		}
	}
	return 0;
}

/*
int rotate_left(int x, int shift)
{
	if(shift == 1)
		return ((x & 2147483647) << 1) | ((x >> 31) & 1);
	if(shift == 31)
		return ((x & 1) << 31) | ((x >> 1) & 2147483647);
	return ((x & ((1 << (32-shift)) - 1)) << shift) | ((x >> (32-shift)) & ((1 << shift) - 1));
}
int main()
{
	int a,b;
	a = 1;
	b = 32;
	printf("%d\n", rotate_left(a,b));

}
*/
