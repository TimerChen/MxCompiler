grammar test;
iddd
	:	Nondigit
	;
fuckTest
	:	unaryOperator iddd
	;
unaryOperator
    :	'+'
    ;
Plus: '+';

Identifier:
	Nondigit (Digit|Nondigit)*
	;


fragment
Nondigit
    :   [a-zA-Z_]
    ;

fragment
NonzeroDigit
    :   [1-9]
    ;
fragment
Digit
    :   [0-9]
    ;

LINE_COMMENT  : '//' .*? '\n' -> skip;
BLOCK_COMMENT : '/*' .*? '*/' -> skip;

//------ Whitespace
WS : [ \t\n\r]+ -> skip