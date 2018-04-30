#!/bin/bash
# this script is called when the judge is building your compiler.
# no argument will be passed in.
set -e
cd "$(dirname "$0")"
mkdir -p bin
find ./src/MxCompiler -name *.java | /usr/lib/jvm/java-1.8.0-openjdk-amd64/bin/javac -d bin -classpath "lib/antlr-4.7.1-complete.jar" @/dev/stdin
