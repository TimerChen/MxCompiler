





default rel

global gc
global add
global val
global main
global ga
global gb


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


val:
        push    rbp
        mov     rbp, rsp
        mov     eax, 233
        pop     rbp
        ret


main:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 32
        mov     dword [rbp-18H], 6
        mov     dword [rbp-14H], 7
        mov     eax, dword [rbp-18H]
        not     eax
        mov     dword [rel gc], eax
        mov     eax, dword [rbp-18H]
        neg     eax
        mov     dword [rel gc], eax
        lea     rax, [rel L_003]
        mov     qword [rbp-10H], rax
        lea     rax, [rel L_004]
        mov     qword [rbp-8H], rax
        mov     eax, dword [rbp-18H]
        mov     edi, eax
        call    add
        mov     dword [rel ga], 233
        mov     dword [rel gb], 244
        mov     eax, 0
        leave
        ret



SECTION .data   align=4

ga:
        dd 000000E9H

gb:     dd 000000F4H


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


