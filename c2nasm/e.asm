





default rel

global main


SECTION .text

main:
        push    rbp
        mov     rbp, rsp
        mov     qword [rbp-18H], 5
        mov     qword [rbp-10H], 2
        mov     rax, qword [rbp-18H]
        cqo
        idiv    qword [rbp-10H]
        mov     qword [rbp-8H], rax
        mov     rax, qword [rbp-18H]
		imul	10
        ; imul    rax, qword [rbp-10H]
        mov     qword [rbp-8H], rax
        mov     rax, qword [rbp-18H]
        cqo
        idiv    qword [rbp-10H]
        mov     qword [rbp-8H], rdx
        mov     eax, 0
        pop     rbp
        ret



SECTION .data


SECTION .bss
