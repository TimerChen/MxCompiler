





default rel

global gc
global main


SECTION .text   

main:
        push    rbp
        mov     rbp, rsp
        mov     qword [rel gc], 1
        mov     eax, 0
        pop     rbp
        ret



SECTION .data   


SECTION .bss    


