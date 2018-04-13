//Define a grammar called Hello
grammar Mx;

import Mx_Lex;

expr
	:	unaryExpr
	;

oneExpr
    :   Identifier
    |   Const
    |   StringLiteral+
    |   '(' expr ')'
	;
postfixExpr
	:	oneExpr
	|	postfixExpr '++'
	|	postfixExpr '--'
	|	postfixExpr '.'
	;
unaryExpr
	:	postfixExpr
	|	'++' unaryExpr
	|	'--' unaryExpr
	|	unaryOperator unaryExpr
	;
iddd
	:	Identifier
	;
fuckTest
	:	unaryOperator iddd
	;
unaryOperator
    :	'+'
    ;
castExpr
	:
	;
stat
	:	exprStat
	|	ifstat
	|	forstat
	;
exprStat
	:	expr? ';'
	;
assignOpt
	:	'='
	;
ifstat
	:
	;
forstat
	:
	;

