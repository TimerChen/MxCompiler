default rel
global main
SECTION .text
main:
_main:
	push	rbp
	mov	rbp,	rsp
	add	rbp,	8
	push	rbx
	push	r12
	push	r13
	push	r14
	push	r15
	sub	rsp,	24
	mov	r13,	15
	push	r13
	mov	r13,	14
	push	r13
	mov	r13,	13
	push	r13
	mov	r13,	12
	push	r13
	mov	r13,	11
	push	r13
	mov	r13,	10
	push	r13
	mov	r13,	9
	push	r13
	mov	r13,	8
	push	r13
	mov	r13,	7
	push	r13
	mov	rdi,	1
	mov	rsi,	2
	mov	rdx,	3
	mov	rcx,	4
	mov	r8,	5
	mov	r9,	6
	call	_a
	add	rsp,	72
	mov	qword [rbp + -56],	rax
	mov	r13,	qword [rbp + -56]
	mov	rdi,	r13
	call	_toString
	mov	qword [rbp + -64],	rax
	mov	r13,	qword [rbp + -64]
	mov	rdi,	r13
	call	_println
	mov	qword [rbp + -72],	rax
	mov	rax,	0
	jmp	___exit_main
___exit_main:
	add	rsp,	24
	pop	r15
	pop	r14
	pop	r13
	pop	r12
	pop	rbx
	pop	rbp
	ret
_a:
	push	rbp
	mov	rbp,	rsp
	add	rbp,	8
	push	rbx
	push	r12
	push	r13
	push	r14
	push	r15
	sub	rsp,	232
	mov	qword [rbp + -56],	rdi
	mov	qword [rbp + -64],	rsi
	mov	qword [rbp + -72],	rdx
	mov	qword [rbp + -80],	rcx
	mov	qword [rbp + -88],	r8
	mov	qword [rbp + -96],	r9
	mov	r13,	qword [rbp + 8]
	mov	qword [rbp + -104],	r13
	mov	r13,	qword [rbp + 16]
	mov	qword [rbp + -112],	r13
	mov	r13,	qword [rbp + 24]
	mov	qword [rbp + -120],	r13
	mov	r13,	qword [rbp + 32]
	mov	qword [rbp + -128],	r13
	mov	r13,	qword [rbp + 40]
	mov	qword [rbp + -136],	r13
	mov	r13,	qword [rbp + 48]
	mov	qword [rbp + -144],	r13
	mov	r13,	qword [rbp + 56]
	mov	qword [rbp + -152],	r13
	mov	r13,	qword [rbp + 64]
	mov	qword [rbp + -160],	r13
	mov	r13,	qword [rbp + 72]
	mov	qword [rbp + -168],	r13
	mov	r13,	qword [rbp + -56]
	mov	qword [rbp + -176],	r13
	mov	r13,	qword [rbp + -64]
	mov	r14,	qword [rbp + -176]
	add	r14,	r13
	mov	qword [rbp + -176],	r14
	mov	r13,	qword [rbp + -176]
	mov	qword [rbp + -184],	r13
	mov	r13,	qword [rbp + -72]
	mov	r14,	qword [rbp + -184]
	add	r14,	r13
	mov	qword [rbp + -184],	r14
	mov	r13,	qword [rbp + -184]
	mov	qword [rbp + -192],	r13
	mov	r13,	qword [rbp + -80]
	mov	r14,	qword [rbp + -192]
	add	r14,	r13
	mov	qword [rbp + -192],	r14
	mov	r13,	qword [rbp + -192]
	mov	qword [rbp + -200],	r13
	mov	r13,	qword [rbp + -88]
	mov	r14,	qword [rbp + -200]
	add	r14,	r13
	mov	qword [rbp + -200],	r14
	mov	r13,	qword [rbp + -200]
	mov	qword [rbp + -208],	r13
	mov	r13,	qword [rbp + -96]
	mov	r14,	qword [rbp + -208]
	add	r14,	r13
	mov	qword [rbp + -208],	r14
	mov	r13,	qword [rbp + -208]
	mov	qword [rbp + -216],	r13
	mov	r13,	qword [rbp + -104]
	mov	r14,	qword [rbp + -216]
	add	r14,	r13
	mov	qword [rbp + -216],	r14
	mov	r13,	qword [rbp + -216]
	mov	qword [rbp + -224],	r13
	mov	r13,	qword [rbp + -112]
	mov	r14,	qword [rbp + -224]
	add	r14,	r13
	mov	qword [rbp + -224],	r14
	mov	r13,	qword [rbp + -224]
	mov	qword [rbp + -232],	r13
	mov	r13,	qword [rbp + -120]
	mov	r14,	qword [rbp + -232]
	add	r14,	r13
	mov	qword [rbp + -232],	r14
	mov	r13,	qword [rbp + -232]
	mov	qword [rbp + -240],	r13
	mov	r13,	qword [rbp + -128]
	mov	r14,	qword [rbp + -240]
	add	r14,	r13
	mov	qword [rbp + -240],	r14
	mov	r13,	qword [rbp + -240]
	mov	qword [rbp + -248],	r13
	mov	r13,	qword [rbp + -136]
	mov	r14,	qword [rbp + -248]
	add	r14,	r13
	mov	qword [rbp + -248],	r14
	mov	r13,	qword [rbp + -248]
	mov	qword [rbp + -256],	r13
	mov	r13,	qword [rbp + -144]
	mov	r14,	qword [rbp + -256]
	add	r14,	r13
	mov	qword [rbp + -256],	r14
	mov	r13,	qword [rbp + -256]
	mov	qword [rbp + -264],	r13
	mov	r13,	qword [rbp + -152]
	mov	r14,	qword [rbp + -264]
	add	r14,	r13
	mov	qword [rbp + -264],	r14
	mov	r13,	qword [rbp + -264]
	mov	qword [rbp + -272],	r13
	mov	r13,	qword [rbp + -160]
	mov	r14,	qword [rbp + -272]
	add	r14,	r13
	mov	qword [rbp + -272],	r14
	mov	r13,	qword [rbp + -272]
	mov	qword [rbp + -280],	r13
	mov	r13,	qword [rbp + -168]
	mov	r14,	qword [rbp + -280]
	add	r14,	r13
	mov	qword [rbp + -280],	r14
	mov	r13,	qword [rbp + -280]
	mov	rax,	r13
	jmp	___exit_a
___exit_a:
	add	rsp,	232
	pop	r15
	pop	r14
	pop	r13
	pop	r12
	pop	rbx
	pop	rbp
	ret
SECTION .rodata
; ============Library============

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
		        jle     _L1_003
		        movsxd  rax, r13d
		        mov     r15d, 1
		        mov     qword [rsp+8H], rax
		_L1_001:  cmp     r12d, 1
		        jg      _L1_004
		        test    rbp, rbp
		        jz      _L1_002
		        mov     rdi, qword [rsp+8H]
		        call    malloc
		        mov     qword [rbx+r15*8-4H], rax
		        mov     rdi, rax
		        call    rbp
		_L1_002:  mov     eax, r15d
		        add     r15, 1
		        cmp     dword [r14], eax
		        jg      _L1_001
		_L1_003:  mov     rax, qword [rsp]
		        add     rsp, 24
		        pop     rbx
		        pop     rbp
		        pop     r12
		        pop     r13
		        pop     r14
		        pop     r15
		        ret





		ALIGN   8
		_L1_004:  mov     rcx, rbp
		        mov     edx, r13d
		        mov     esi, r12d
		        mov     rdi, r14
		        call    __array_new
		        mov     qword [rbx+r15*8-4H], rax
		        jmp     _L1_002






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
		        jz      _L1_006




		ALIGN   8
		_L1_005:  mov     rsi, qword [rel stdout]
		        add     rbx, 1
		        call    _IO_putc
		        movzx   edi, byte [rbx]
		        test    dil, dil
		        jnz     _L1_005
		_L1_006:  pop     rbx
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
		        jnz     _L1_007
		        add     rsp, 32
		        pop     rbx
		        ret

		_L1_007:  call    __stack_chk_fail




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
		        jle     _L1_009
		        mov     ecx, ebx
		        lea     r8, [rbp+r13]
		        xor     edx, edx
		        add     rcx, 1




		ALIGN   8
		_L1_008:  movzx   esi, byte [r8+rdx]
		        mov     byte [rdi+rdx+4H], sil
		        add     rdx, 1
		        cmp     rdx, rcx
		        jnz     _L1_008
		_L1_009:  add     rsp, 8
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
		        mov     r14, rdi
		        push    r13
		        push    r12
		        push    rbp
		        mov     r13, rsi
		        push    rbx
		        mov     ebx, dword [rsi-4H]
		        mov     edi, dword [rdi-4H]
		        add     edi, ebx
		        lea     ebp, [rdi+1H]
		        add     edi, 2
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






		ALIGN   8

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
