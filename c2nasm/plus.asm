





default rel

global __string__less
global main

extern strcmp
extern _GLOBAL_OFFSET_TABLE_


SECTION .text   

__string__less:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rdx, qword [rbp-10H]
        mov     rax, qword [rbp-8H]
        mov     rsi, rdx
        mov     rdi, rax
        call    strcmp
        cmp     eax, -1
        sete    al
        leave
        ret


main:
        push    rbp
        mov     rbp, rsp
        lea     rsi, [rel L_001]
        lea     rdi, [rel L_002]
        call    __string__less
        mov     eax, 0
        pop     rbp
        ret



SECTION .data   


SECTION .bss    


SECTION .rodata 

L_001:
        db 42H, 41H, 00H

L_002:
        db 44H, 43H, 00H


