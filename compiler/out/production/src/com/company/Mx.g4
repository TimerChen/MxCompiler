//Define a grammar called Hello
grammar Mx;

import Mx_Lex;

expr
	:
	;

oneExpr
	:	Const
	|	Identifer
	;
unaryExpr
	:	oneExpr
	|	'++' oneExpr
	|	'--' oneExpr
	|	oneExpr '++'
	|	oneExpr '--'
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

