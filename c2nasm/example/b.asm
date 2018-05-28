





default rel

global add
global main


SECTION .text   

add:
        push    rbp
        mov     rbp, rsp
        mov     dword [rbp-14H], edi
        mov     dword [rbp-4H], 1
        mov     edx, dword [rbp-4H]
        mov     eax, dword [rbp-14H]
        add     eax, edx
        test    eax, eax
        jz      L_001
        mov     eax, dword [rbp-4H]
        jmp     L_002

L_001:  mov     dword [rbp-4H], 0
        mov     eax, dword [rbp-4H]
L_002:  pop     rbp
        ret


main:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     dword [rbp-8H], 6
        mov     dword [rbp-4H], 7
        mov     eax, dword [rbp-8H]
        mov     edi, eax
        call    add
        mov     eax, 0
        leave
        ret



SECTION .data   


SECTION .bss    


