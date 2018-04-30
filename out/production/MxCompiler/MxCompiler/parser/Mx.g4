grammar Mx;

import Mx_Lex;

expr
    :   Identifier								#variableExpr
    |	'this'									#thisExpr
    |   Const									#constIntExpr
    |   StringLiteral+							#constStringExpr
    |	'new' creator							#newExpr
    |   '(' expr ')'							#subExpr
    |   <assoc=right>
    	expr	'[' expr ']'					#arefExpr
    |   <assoc=right>
    	expr	'(' argumentExprList? ')'		#funcallExpr
    |   <assoc=right>
    	expr	'.' Identifier					#memberExpr
    |   <assoc=right>
        	expr	(	'++'
        			|	'--')					#prefixExpr
    |   <assoc=right>
    	('++' | '--' | unaryOperator) expr		#suffixExpr
    |	expr ('/' | '*' | '%') expr				#binaryExpr
    |	expr ('+' | '-' ) expr					#binaryExpr
    |	expr ('<<' | '>>') expr					#binaryExpr
    |	expr ('>' | '>=' | '<' | '<=') expr		#binaryExpr
    |	expr ('==' | '!=') expr					#binaryExpr
    |	expr '&' expr							#binaryExpr
    |	expr '^' expr							#binaryExpr
    |	expr '|' expr							#binaryExpr
    |	expr '&&' expr							#binaryExpr
    |	expr '||' expr							#binaryExpr
    |	expr '|' expr							#binaryExpr
    |	expr '=' expr							#binaryExpr
    |	expr ',' expr							#binaryExpr
	;
creator
	:	typeSpecifier //'('parameterList?')'
	| 	typeSpecifier ('['expr']')+('['']')*
	;
argumentExprList
    :   expr
    |   argumentExprList ',' expr
    ;
unaryOperator
    :   '&' | '*' | '+' | '-' | '~' | '!'
    ;
declaration
    :   typeSpecifier initDeclaratorList? ';'
    ;


initDeclaratorList
    :   initDeclarator
    |   initDeclaratorList ',' initDeclarator
    ;

initDeclarator
    :   declarator
    |   declarator '=' expr
    ;

typeSpecifier
    :   'void'					#void
    |   'bool'					#bool
    |   'string'				#string
    |   'int'					#int
    |   className				#class
    |	typeSpecifier '[' ']'	#array
    ;

classSpecifier
    :   'class' className '{' classDeclaration* '}'
    ;

classDeclaration
    :   declaration
    |	functionDefinition
    |	constructedfunctionDefinition
    ;


declarator
    :   Identifier
    ;
className
	:	Identifier
	;
parameterList
    :   parameterDeclaration
    |   parameterList ',' parameterDeclaration
    ;

parameterDeclaration
    :   typeSpecifier declarator?
    ;

statement
    :   compoundStatement
    |   exprStatement
    |   selectionStatement
    |   iterationStatement
    |   jumpStatement
    ;


compoundStatement
    :   '{' blockItem* '}'
    ;

blockItem
    :   statement
    |   declaration
    ;

exprStatement
    :   expr? ';'
    ;

selectionStatement
    :   'if' '(' expr ')' statement ('else' statement)?
    ;

iterationStatement
    :   While '(' expr ')' statement		#while
    |   For '(' forCondition ')' statement	#for
    ;


forCondition
	:   expr? ';' expr? ';' expr?
//	|	forDeclaration ';' expr? ';' expr?
	;

forDeclaration
    :   typeSpecifier initDeclaratorList
    ;


jumpStatement
    :   'continue' ';'
    |   'break' ';'
    |   'return' expr? ';'
    ;

compilationUnit
    :   externalDeclaration* EOF
    ;

externalDeclaration
    :	classDefinition
    |	functionDefinition
    |   declaration
    ;
classDefinition
	:	classSpecifier initDeclaratorList? ';'
//    |	className '::' constructedfunctionDefinition
//    |	typeSpecifier className '::' declarator '(' parameterList? ')' compoundStatement
	;
functionDefinition
    :   typeSpecifier declarator '(' parameterList? ')' compoundStatement
    ;

constructedfunctionDefinition
	:	className '(' parameterList? ')' compoundStatement
	;