





default rel

global add
global main


SECTION .text   

add:
        push    rbp
        mov     rbp, rsp
        mov     dword [rbp-14H], edi
        lea     rax, [rel L_001]
        mov     qword [rbp-10H], rax
        lea     rax, [rel L_002]
        mov     qword [rbp-8H], rax
        nop
        pop     rbp
        ret


main:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 32
        mov     dword [rbp-18H], 6
        mov     dword [rbp-14H], 7
        lea     rax, [rel L_003]
        mov     qword [rbp-10H], rax
        lea     rax, [rel L_004]
        mov     qword [rbp-8H], rax
        mov     eax, dword [rbp-18H]
        mov     edi, eax
        call    add
        mov     eax, 0
        leave
        ret



SECTION .data   


SECTION .bss    


SECTION .rodata 

L_001:
        db 61H, 64H, 64H, 30H, 00H

L_002:
        db 61H, 64H, 64H, 31H, 00H

L_003:
        db 6DH, 61H, 69H, 6EH, 30H, 00H

L_004:
        db 6DH, 61H, 69H, 6EH, 31H, 00H


