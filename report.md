# 中期报告
中期检查为止主要完成了编译器的语法检查部分。

## 语法检查部分概述
### 主要构成
语法检查主要由四个部分构成：
1. Parse Tree构建
2. AST构建
3. 符号表建立
4. 类型检查
### Parse Tree构建
构建Parse Tree的部分使用Antlr v4库完成，参考了[C语言的语法生成方法][1]。

由于新版Antlr支持非左递归的语法，因此进行了许多简化。
一个比较有趣的地方是使用new生成数组部分的代码，可以通过精妙的写法直接在parse阶段过滤掉不合法的形式。
### AST构建
AST的构建在遍历ParseTree的过程中完成。

AST的建立主要是为了方便后面IR的生成，将源代码进一步进行抽象化。
### 符号表建立
AST完成后，就可以通过其建立符号表。

一方面为的是将各个类型、变量、函数的信息收集统合到一起，另一方在符号表建立的过程中可以判断变量、函数、类型的引用是否合法。
### 语法检查
在AST和符号表建立完成后后，就可以利用这两个工具进行语法检查。

语法检查分为两部分：类型检查和语句规范检查

类型检查主要是检查各个运算及参数传递的类型是否正确，占代码的主要部分。

语句规范检查主要是检查continue、break一类语句位置是否合适，函数调用是否合法等。

## 其它
对于现阶段的代码的一些想法

* 代码的一些部分构思不够细致，存在结构上不太合理的问题
* 部分实现没有考虑效率问题，需要后期修改优化
* 报错提示信息需要进一步完善
* 可以增加一些面向用户的提示信息或帮助手册

[1]: https://github.com/antlr/grammars-v4/blob/master/c/C.g4