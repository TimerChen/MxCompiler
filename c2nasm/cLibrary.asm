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
global __string__lessEqual
global __string__equal
global __array_length

global _getInt
global _toString

extern strcmp
extern strtol
extern __stack_chk_fail
extern strcpy
extern getline
extern stdin
extern puts
extern _IO_putc
extern stdout
extern malloc
extern _GLOBA_L1_OFFSET_TABLE_

extern strlen
extern sprintf
extern malloc
extern __isoc99_scanf



SECTION .text

_getInt:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16


        mov     rax, qword [fs:abs 28H]
        mov     qword [rbp-8H], rax
        xor     eax, eax
        lea     rax, [rbp-0CH]
        mov     rsi, rax
        lea     rdi, [rel _L0_002]
        mov     eax, 0
        call    __isoc99_scanf
        mov     eax, dword [rbp-0CH]
        mov     rdx, qword [rbp-8H]


        xor     rdx, qword [fs:abs 28H]
        jz      _L0_001
        call    __stack_chk_fail
_L0_001:  leave
        ret


_toString:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 32
        mov     dword [rbp-14H], edi
        mov     edi, 19
        call    malloc
        add     rax, 4
        mov     qword [rbp-8H], rax
        mov     edx, dword [rbp-14H]
        mov     rax, qword [rbp-8H]
        lea     rsi, [rel _L0_002]
        mov     rdi, rax
        mov     eax, 0
        call    sprintf
        mov     rax, qword [rbp-8H]
        mov     rdi, rax
        call    strlen
        mov     dword [rbp-0CH], eax
        mov     rax, qword [rbp-8H]
        lea     rdx, [rax-4H]
        mov     eax, dword [rbp-0CH]
        mov     dword [rdx], eax
        mov     eax, dword [rbp-0CH]
        movsxd  rdx, eax
        mov     rax, qword [rbp-8H]
        add     rax, rdx
        mov     byte [rax], 0
        mov     rax, qword [rbp-8H]
        leave
        ret



SECTION .data


SECTION .bss


SECTION .rodata

_L0_002:
        db 25H, 64H, 00H


		SECTION .text   6

		__array_array:
		        push    rbx
		        movsxd  rdi, edi
		        mov     rbx, rdi
		        add     rdi, 4
		        call    malloc
		        mov     dword [rax], ebx
		        add     rax, 4
		        pop     rbx
		        ret






		ALIGN   16

		__array_new:
		        push    r15
		        push    r14
		        mov     r14, rdi
		        push    r13
		        push    r12
		        mov     r13d, edx
		        push    rbp
		        push    rbx
		        mov     r12d, esi
		        mov     rbp, rcx
		        sub     rsp, 24
		        mov     r15d, dword [rdi]
		        imul    r15d, edx
		        movsxd  rdi, r15d
		        add     rdi, 4
		        call    malloc
		        mov     rbx, rax
		        add     rax, 4
		        mov     qword [rsp], rax
		        mov     eax, dword [r14]
		        mov     dword [rbx], r15d
		        test    eax, eax
		        jle     L_003
		        movsxd  rax, r13d
		        mov     r15d, 1
		        mov     qword [rsp+8H], rax
		L_001:  cmp     r12d, 1
		        jg      L_004
		        test    rbp, rbp
		        jz      L_002
		        mov     rdi, qword [rsp+8H]
		        call    malloc
		        mov     qword [rbx+r15*8-4H], rax
		        mov     rdi, rax
		        call    rbp
		L_002:  mov     eax, r15d
		        add     r15, 1
		        cmp     dword [r14], eax
		        jg      L_001
		L_003:  mov     rax, qword [rsp]
		        add     rsp, 24
		        pop     rbx
		        pop     rbp
		        pop     r12
		        pop     r13
		        pop     r14
		        pop     r15
		        ret





		ALIGN   8
		L_004:  mov     rcx, rbp
		        mov     edx, r13d
		        mov     esi, r12d
		        mov     rdi, r14
		        call    __array_new
		        mov     qword [rbx+r15*8-4H], rax
		        jmp     L_002






		ALIGN   16

		__string_string:
		        push    rbx
		        movsxd  rbx, edi
		        lea     edi, [rbx+1H]
		        movsxd  rdi, edi
		        add     rdi, 4
		        call    malloc
		        mov     rdx, rax
		        lea     rax, [rax+4H]
		        mov     dword [rdx], ebx
		        mov     byte [rdx+rbx+4H], 0
		        pop     rbx
		        ret







		ALIGN   16

		_print:
		        push    rbx
		        mov     rbx, rdi
		        movzx   edi, byte [rdi]
		        test    dil, dil
		        jz      L_006




		ALIGN   8
		L_005:  mov     rsi, qword [rel stdout]
		        add     rbx, 1
		        call    _IO_putc
		        movzx   edi, byte [rbx]
		        test    dil, dil
		        jnz     L_005
		L_006:  pop     rbx
		        ret






		ALIGN   8

		_println:
		        jmp     puts


		        nop





		ALIGN   16

		_getString:
		        push    rbx
		        sub     rsp, 32
		        mov     rdx, qword [rel stdin]
		        lea     rsi, [rsp+0CH]
		        lea     rdi, [rsp+10H]
		        mov     qword [rsp+10H], 0


		        mov     rax, qword [fs:abs 28H]
		        mov     qword [rsp+18H], rax
		        xor     eax, eax
		        call    getline
		        movsxd  rbx, dword [rsp+0CH]
		        lea     edi, [rbx+1H]
		        movsxd  rdi, edi
		        add     rdi, 4
		        call    malloc
		        mov     rsi, qword [rsp+10H]
		        lea     rdx, [rax+4H]
		        mov     dword [rax], ebx
		        mov     byte [rax+rbx+4H], 0
		        mov     rdi, rdx
		        call    strcpy
		        mov     rcx, qword [rsp+18H]


		        xor     rcx, qword [fs:abs 28H]
		        jnz     L_007
		        add     rsp, 32
		        pop     rbx
		        ret

		L_007:  call    __stack_chk_fail




		ALIGN   8

		__string_length:
		        mov     eax, dword [rdi-4H]
		        ret







		ALIGN   16

		__string_substring:
		        push    r13
		        push    r12
		        mov     r13, rsi
		        push    rbp
		        push    rbx
		        mov     ebx, edx
		        sub     ebx, esi
		        mov     rbp, rdi
		        lea     edi, [rbx+2H]
		        lea     r12d, [rbx+1H]
		        sub     rsp, 8
		        movsxd  rdi, edi
		        add     rdi, 4
		        call    malloc
		        movsxd  rdx, r12d
		        mov     rdi, rax
		        add     rax, 4
		        test    r12d, r12d
		        mov     dword [rdi], r12d
		        mov     byte [rdi+rdx+4H], 0
		        jle     L_009
		        mov     ecx, ebx
		        lea     r8, [rbp+r13]
		        xor     edx, edx
		        add     rcx, 1




		ALIGN   8
		L_008:  movzx   esi, byte [r8+rdx]
		        mov     byte [rdi+rdx+4H], sil
		        add     rdx, 1
		        cmp     rdx, rcx
		        jnz     L_008
		L_009:  add     rsp, 8
		        pop     rbx
		        pop     rbp
		        pop     r12
		        pop     r13
		        ret






		ALIGN   8

		__string_parseInt:
		        sub     rsp, 8
		        mov     edx, 10
		        xor     esi, esi
		        call    strtol
		        add     rsp, 8
		        ret


		        nop





		ALIGN   16

		__string_ord:
		        movsxd  rsi, esi
		        movzx   eax, byte [rdi+rsi]
		        ret






		ALIGN   16

		__string__plus:
		        push    r14
		        push    r13
		        mov     r14, rdi
		        push    r12
		        push    rbp
		        mov     r13, rsi
		        push    rbx
		        mov     ebx, dword [rdi-4H]
		        mov     ebp, dword [rsi-4H]
		        add     ebp, ebx
		        lea     edi, [rbp+1H]
		        movsxd  rdi, edi
		        add     rdi, 4
		        call    malloc
		        lea     r12, [rax+4H]
		        mov     dword [rax], ebp
		        movsxd  rbp, ebp
		        mov     rsi, r14
		        mov     byte [rax+rbp+4H], 0
		        mov     rdi, r12
		        call    strcpy
		        movsxd  rdi, ebx
		        mov     rsi, r13
		        add     rdi, r12
		        call    strcpy
		        pop     rbx
		        mov     rax, r12
		        pop     rbp
		        pop     r12
		        pop     r13
		        pop     r14
		        ret






		ALIGN   16

		__string__less:
		        sub     rsp, 8
		        call    strcmp
		        cmp     eax, -1
		        sete    al
		        add     rsp, 8
		        ret







		ALIGN   16

		__string__lessEqual:
		        sub     rsp, 8
		        call    strcmp
		        test    eax, eax
		        setle   al
		        add     rsp, 8
		        ret







		ALIGN   16

		__string__equal:
		        sub     rsp, 8
		        call    strcmp
		        test    eax, eax
		        sete    al
		        add     rsp, 8
		        ret







		ALIGN   16

		__array_length:
		        mov     eax, dword [rdi-4H]
		        ret



		SECTION .data


		SECTION .bss
