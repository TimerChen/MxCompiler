grammar Mx;

import Mx_Lex;

compilationUnit
    :   externalDeclaration* EOF
    ;

externalDeclaration
    :	classDefinition
    |	functionDefinition
    |   declaration
    ;
classDefinition
	:   'class' className '{' classDeclaration* '}'
//    |	className '::' constructedfunctionDefinition
//    |	typeSpecifier className '::' declarator '(' parameterList? ')' compoundStatement
	;
functionDefinition
    :   typeSpecifier declarator '(' parameterList? ')' compoundStatement
    ;

constructorDefinition
	:	className '(' parameterList? ')' compoundStatement
	;



expr
    :   Identifier								#variableExpr
    |	'this'									#thisExpr
    |	(True|False)							#constBoolExpr
    |   Const									#constIntExpr
    |   StringLiteral							#constStringExpr
    |	'new' creator							#newExpr
    |   '(' expr ')'							#subExpr
    |   <assoc=right>
    	expr	'[' expr ']'					#arefExpr
    |   <assoc=right>
    	expr	'(' argumentExprList? ')'		#funcallExpr
    |   <assoc=right>
    	expr	'.' Identifier					#memberExpr
    |   <assoc=right>
        	expr	op=(	'++'
        				|	'--')					#suffixExpr
    |   <assoc=right>
    	op=('++' | '--' | '+' | '-' | '~' | '!' )
    	expr										#prefixExpr
    |	expr op=('/' | '*' | '%') expr				#binaryExpr
    |	expr op=('+' | '-' ) expr					#binaryExpr
    |	expr op=('<<' | '>>') expr					#binaryExpr
    |	expr op=('>' | '>=' | '<' | '<=') expr		#binaryExpr
    |	expr op=('==' | '!=') expr					#binaryExpr
    |	expr op='&' expr							#binaryExpr
    |	expr op='^' expr							#binaryExpr
    |	expr op='|' expr							#binaryExpr
    |	expr op='&&' expr							#binaryExpr
    |	expr op='||' expr							#binaryExpr
    |	expr op='|' expr							#binaryExpr
    |	expr op='=' expr							#binaryExpr
    //|	expr ',' expr							#binaryExpr
	;
creator
	:	typeSpecifier //'('parameterList?')'
	| 	typeSpecifier ('['expr']')+(arraySpecifier)*
	;
argumentExprList
    :   expr
    |   argumentExprList ',' expr
    ;
declaration
    :   typeSpecifier initDeclaratorList ';'
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
    |	typeSpecifier arraySpecifier	#array
    ;


classDeclaration
    :   declaration
    |	functionDefinition
    |	constructorDefinition
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
    :   typeSpecifier declarator
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
	:   forInit=expr? ';' forCondi=expr? ';' forStep=expr?
//	|	forDeclaration ';' expr? ';' expr?
	;
/*
forDeclaration
    :   typeSpecifier initDeclaratorList
    ;
*/

jumpStatement
    :   'continue' ';'			#continueStmt
    |   'break' ';'				#breakStmt
    |   'return' expr? ';'		#returnStmt
    ;

arraySpecifier : '['']';
