#!/bin/sh
#path=$(cd `dirname $0`;pwd)
cd `dirname $0`
pwd
gcc library*.o test.c -no-pie
./a.out
