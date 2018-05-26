#!/bin/bash
# this script is called when the judge wants our compiler to compile a source file.
# print the compiled source, i.e. asm code, directly to stdout.
# don't print anything other to stdout.
# if you would like to print some debug information, please go to stderr.

set -e
cd "$(dirname "$0")"
export CCHK="/usr/lib/jvm/java-1.8.0-openjdk-amd64/bin/java -classpath ./lib/*:./bin Main -i program.txt -o program.out"
#cat > ./testcases/program.mx   # save everything in stdin to program.txt
#$CCHK
/usr/lib/jvm/java-1.8.0-openjdk-amd64/bin/java -classpath ./lib/*:./bin MxCompiler.Main 
