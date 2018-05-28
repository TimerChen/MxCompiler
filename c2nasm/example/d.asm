





default rel

global main


SECTION .text   

main:
        push    rbp
        mov     rbp, rsp
        mov     dword [rbp-8H], 1
        mov     dword [rbp-4H], 2
        mov     eax, dword [rbp-8H]
        cmp     eax, dword [rbp-4H]
        setl    al
        movzx   rax, al
        mov   	byte [rbp-8H], al
        mov     eax, 0
        pop     rbp
        ret



SECTION .data   


SECTION .bss    


