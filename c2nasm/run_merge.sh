#!/bin/sh
#path=$(cd `dirname $0`;pwd)
cd `dirname $0`
pwd
gcc cLibrary.o test.c -no-pie
./a.out
