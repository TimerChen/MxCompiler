int main()
{
	unsigned char oStr[100]="0000_toString(12)";
	unsigned char *str = oStr + sizeof(int);
	((int*)str)[-1] = strlen(str);
	_println(_toString(__string_length(str)));
}
