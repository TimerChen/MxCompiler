





default rel

global add
global main


SECTION .text   

add:
        push    rbp
        mov     rbp, rsp
        mov     dword [rbp-14H], edi
        mov     dword [rbp-18H], esi
        mov     dword [rbp-1CH], edx
        mov     dword [rbp-20H], ecx
        mov     dword [rbp-24H], r8d
        mov     dword [rbp-28H], r9d
        mov     dword [rbp-4H], 1
        mov     eax, dword [rbp+10H]
        pop     rbp
        ret


main:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     dword [rbp-8H], 6
        mov     dword [rbp-4H], 7
        mov     edx, dword [rbp-8H]
        mov     eax, dword [rbp-4H]
        push    rax
        mov     r9d, edx
        mov     r8d, 5
        mov     ecx, 4
        mov     edx, 3
        mov     esi, 2
        mov     edi, 1
        call    add
        add     rsp, 8
        mov     eax, 0
        leave
        ret



SECTION .data   


SECTION .bss    


