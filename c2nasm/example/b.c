#include <stdio.h>
int add(int a)
{
	int h = 1;
	if(h+a)
	{
		return h;
	}
	h = 0;
	return h;
}
int main()
{
	int i,j;
	i = 6;
	j = 7;
	
	add(i);

	return 0;
}
