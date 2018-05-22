#!/bin/sh
#path=$(cd `dirname $0`;pwd)
cd `dirname $0`
pwd
./c2nasm-O3.sh library.c
./c2nasm.sh library_noO3.c
nasm -felf64 library.asm
nasm -felf64 library_noO3.asm
#rm library.asm library_noO3.asm
