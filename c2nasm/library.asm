





default rel

global __array_array
global __array_new
global __string_string
global _print
global _println
global _getString
global __string_length
global __string_substring
global __string_parseInt
global __string_ord
global __string__plus
global __string__less
global __string__equal
global __array_length

extern strcmp
extern atoi
extern __stack_chk_fail
extern strcpy
extern getline
extern stdin
extern puts
extern putchar
extern malloc
extern _GLOBAL_OFFSET_TABLE_


SECTION .text   

__array_array:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 32
        mov     dword [rbp-14H], edi
        mov     eax, dword [rbp-14H]
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
        mov     rax, qword [rbp-8H]
        leave
        ret


__array_new:
        push    rbp
        mov     rbp, rsp
        push    rbx
        sub     rsp, 56
        mov     qword [rbp-28H], rdi
        mov     dword [rbp-2CH], esi
        mov     dword [rbp-30H], edx
        mov     qword [rbp-38H], rcx
        mov     rax, qword [rbp-28H]
        mov     eax, dword [rax]
        imul    eax, dword [rbp-30H]
        mov     edi, eax
        call    __array_array
        mov     qword [rbp-18H], rax
        mov     dword [rbp-1CH], 0
        jmp     L_004

L_001:  cmp     dword [rbp-2CH], 1
        jle     L_002
        mov     eax, dword [rbp-1CH]
        cdqe
        lea     rdx, [rax*8]
        mov     rax, qword [rbp-18H]
        lea     rbx, [rdx+rax]
        mov     rcx, qword [rbp-38H]
        mov     edx, dword [rbp-30H]
        mov     esi, dword [rbp-2CH]
        mov     rax, qword [rbp-28H]
        mov     rdi, rax
        call    __array_new
        mov     qword [rbx], rax
        jmp     L_003

L_002:  cmp     qword [rbp-38H], 0
        jz      L_003
        mov     eax, dword [rbp-30H]
        cdqe
        mov     edx, dword [rbp-1CH]
        movsxd  rdx, edx
        lea     rcx, [rdx*8]
        mov     rdx, qword [rbp-18H]
        lea     rbx, [rcx+rdx]
        mov     rdi, rax
        call    malloc
        mov     qword [rbx], rax
        mov     eax, dword [rbp-1CH]
        cdqe
        lea     rdx, [rax*8]
        mov     rax, qword [rbp-18H]
        add     rax, rdx
        mov     rdx, qword [rax]
        mov     rax, qword [rbp-38H]
        mov     rdi, rdx
        call    rax
L_003:  add     dword [rbp-1CH], 1
L_004:  mov     rax, qword [rbp-28H]
        mov     eax, dword [rax]
        cmp     dword [rbp-1CH], eax
        jl      L_001
        mov     rax, qword [rbp-18H]
        add     rsp, 56
        pop     rbx
        pop     rbp
        ret


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


_print:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        jmp     L_006

L_005:  mov     rax, qword [rbp-8H]
        lea     rdx, [rax+1H]
        mov     qword [rbp-8H], rdx
        movzx   eax, byte [rax]
        movzx   eax, al
        mov     edi, eax
        call    putchar
L_006:  mov     rax, qword [rbp-8H]
        movzx   eax, byte [rax]
        test    al, al
        jnz     L_005
        nop
        leave
        ret


_println:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     rax, qword [rbp-8H]
        mov     rdi, rax
        call    puts
        nop
        leave
        ret


_getString:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 32


        mov     rax, qword [fs:abs 28H]
        mov     qword [rbp-8H], rax
        xor     eax, eax
        mov     qword [rbp-18H], 0
        mov     rdx, qword [rel stdin]
        lea     rcx, [rbp-1CH]
        lea     rax, [rbp-18H]
        mov     rsi, rcx
        mov     rdi, rax
        call    getline
        mov     eax, dword [rbp-1CH]
        mov     edi, eax
        call    __string_string
        mov     qword [rbp-10H], rax
        mov     rdx, qword [rbp-18H]
        mov     rax, qword [rbp-10H]
        mov     rsi, rdx
        mov     rdi, rax
        call    strcpy
        mov     rax, qword [rbp-10H]
        mov     rcx, qword [rbp-8H]


        xor     rcx, qword [fs:abs 28H]
        jz      L_007
        call    __stack_chk_fail
L_007:  leave
        ret


__string_length:
        push    rbp
        mov     rbp, rsp
        mov     qword [rbp-8H], rdi
        mov     rax, qword [rbp-8H]
        mov     eax, dword [rax-4H]
        pop     rbp
        ret


__string_substring:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 48
        mov     qword [rbp-18H], rdi
        mov     qword [rbp-20H], rsi
        mov     qword [rbp-28H], rdx
        mov     rax, qword [rbp-28H]
        mov     edx, eax
        mov     rax, qword [rbp-20H]
        sub     edx, eax
        mov     eax, edx
        add     eax, 1
        mov     dword [rbp-0CH], eax
        mov     eax, dword [rbp-0CH]
        mov     edi, eax
        call    __string_string
        mov     qword [rbp-8H], rax
        mov     rax, qword [rbp-20H]
        add     qword [rbp-18H], rax
        mov     dword [rbp-10H], 0
        jmp     L_009

L_008:  mov     eax, dword [rbp-10H]
        movsxd  rdx, eax
        mov     rax, qword [rbp-18H]
        add     rax, rdx
        mov     edx, dword [rbp-10H]
        movsxd  rcx, edx
        mov     rdx, qword [rbp-8H]
        add     rdx, rcx
        movzx   eax, byte [rax]
        mov     byte [rdx], al
        add     dword [rbp-10H], 1
L_009:  mov     eax, dword [rbp-10H]
        cmp     eax, dword [rbp-0CH]
        jl      L_008
        mov     rax, qword [rbp-8H]
        leave
        ret


__string_parseInt:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     rax, qword [rbp-8H]
        mov     rdi, rax
        call    atoi
        leave
        ret


__string_ord:
        push    rbp
        mov     rbp, rsp
        mov     qword [rbp-8H], rdi
        mov     dword [rbp-0CH], esi
        mov     eax, dword [rbp-0CH]
        movsxd  rdx, eax
        mov     rax, qword [rbp-8H]
        add     rax, rdx
        movzx   eax, byte [rax]
        movzx   eax, al
        pop     rbp
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


__string__equal:
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
        test    eax, eax
        sete    al
        leave
        ret


__array_length:
        push    rbp
        mov     rbp, rsp
        mov     qword [rbp-8H], rdi
        mov     rax, qword [rbp-8H]
        mov     eax, dword [rax-4H]
        pop     rbp
        ret



SECTION .data   


SECTION .bss    


