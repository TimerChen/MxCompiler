#!/bin/sh
#path=$(cd `dirname $0`;pwd)
cd `dirname $0`
pwd
gcc library*.o main.c -no-pie
./a.out
