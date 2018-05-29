





default rel

global __string_string
global __string__plus
global main

extern strcpy
extern malloc
extern _GLOBAL_OFFSET_TABLE_


SECTION .text   

__string_string:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 32
        mov     dword [rbp-14H], edi
        mov     eax, dword [rbp-14H]
        add     eax, 1
        cdqe
        add     rax, 4
        mov     rdi, rax
        call    malloc
        add     rax, 4
        mov     qword [rbp-8H], rax
        mov     rax, qword [rbp-8H]
        lea     rdx, [rax-4H]
        mov     eax, dword [rbp-14H]
        mov     dword [rdx], eax
        mov     eax, dword [rbp-14H]
        movsxd  rdx, eax
        mov     rax, qword [rbp-8H]
        add     rax, rdx
        mov     byte [rax], 0
        mov     rax, qword [rbp-8H]
        leave
        ret


__string__plus:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 32
        mov     qword [rbp-18H], rdi
        mov     qword [rbp-20H], rsi
        mov     rax, qword [rbp-18H]
        mov     eax, dword [rax-4H]
        mov     dword [rbp-10H], eax
        mov     rax, qword [rbp-20H]
        mov     eax, dword [rax-4H]
        mov     dword [rbp-0CH], eax
        mov     edx, dword [rbp-10H]
        mov     eax, dword [rbp-0CH]
        add     eax, edx
        add     eax, 1
        mov     edi, eax
        call    __string_string
        mov     qword [rbp-8H], rax
        mov     rdx, qword [rbp-18H]
        mov     rax, qword [rbp-8H]
        mov     rsi, rdx
        mov     rdi, rax
        call    strcpy
        mov     eax, dword [rbp-0CH]
        movsxd  rdx, eax
        mov     rax, qword [rbp-8H]
        add     rdx, rax
        mov     rax, qword [rbp-20H]
        mov     rsi, rax
        mov     rdi, rdx
        call    strcpy
        mov     rax, qword [rbp-8H]
        leave
        ret


main:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        lea     rsi, [rel L_001]
        lea     rdi, [rel L_002]
        call    __string__plus
        mov     qword [rbp-8H], rax
        mov     eax, 0
        leave
        ret



SECTION .data   


SECTION .bss    


SECTION .rodata 

L_001:
        db 20H, 62H, 00H

L_002:
        db 61H, 00H


