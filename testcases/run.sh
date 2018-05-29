#!/bin/sh
#path=$(cd `dirname $0`;pwd)
cd `dirname $0`
pwd
nasm -felf64 program.asm
gcc program.o -no-pie
./a.out
