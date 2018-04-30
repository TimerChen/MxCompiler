lexer grammar Mx_Lex;


Break : 'break';
Continue : 'continue';
Else : 'else';
For : 'for';
If : 'if';
Int : 'int';
Return : 'return';
Void : 'void';
While : 'while';
Class : 'class';
True : 'true';
False : 'false';


LeftParen : '(';
RightParen : ')';
LeftBracket : '[';
RightBracket : ']';
LeftBrace : '{';
RightBrace : '}';

Less : '<';
LessEqual : '<=';
Greater : '>';
GreaterEqual : '>=';
LeftShift : '<<';
RightShift : '>>';

Plus : '+';
PlusPlus : '++';
Minus : '-';
MinusMinus : '--';
Star : '*';
Div : '/';
Mod : '%';

And : '&';
Or : '|';
AndAnd : '&&';
OrOr : '||';
Caret : '^';
Not : '!';
Tilde : '~';

Question : '?';
Colon : ':';
ColonColon : '::';
Semi : ';';
Comma : ',';

Assign : '=';
// '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|='
StarAssign : '*=';
DivAssign : '/=';
ModAssign : '%=';
PlusAssign : '+=';
MinusAssign : '-=';
LeftShiftAssign : '<<=';
RightShiftAssign : '>>=';
AndAssign : '&=';
XorAssign : '^=';
OrAssign : '|=';

Equal : '==';
NotEqual : '!=';

Dot : '.';

Identifier:
	Nondigit (Digit|Nondigit)*
	;


fragment
Nondigit
    :   [a-zA-Z_]
    ;

fragment
Digit
    :   [0-9]
    ;

Const
	:	IntConst
	|	CharacterConstant
	;
fragment
IntConst
	:	NonzeroDigit Digit*
	;

fragment
NonzeroDigit
    :   [1-9]
    ;
fragment
Sign
    :   '+' | '-'
    ;

DigitSequence
    :   Digit+
    ;


fragment
CharacterConstant
    :   '\'' CCharSequence '\''
    ;

fragment
CCharSequence
    :   CChar+
    ;

fragment
CChar
    :   ~['\\\r\n]
    |   EscapeSequence
    ;
fragment
EscapeSequence
	:	SimpleEscapeSequence
	;
fragment
SimpleEscapeSequence
   :   '\\' ['"?abfnrtv\\]
   ;
StringLiteral
   :   '"' SCharSequence? '"'
   ;
fragment
SCharSequence
	:
	SChar+
	;
fragment
SChar
    :   ~["\\\r\n]
    |   EscapeSequence
    |   '\\\n'   // Added line
    |   '\\\r\n' // Added line
    ;
Whitespace
    :   [ \t]+
        -> skip
    ;

Newline
    :   (   '\r' '\n'?
        |   '\n'
        )
        -> skip
    ;

BlockComment
    :   '/*' .*? '*/'
        -> skip
    ;

LineComment
    :   '//' ~[\r\n]*
        -> skip
    ;