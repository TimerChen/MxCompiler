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
	sub	rsp,	480
	mov	qword [_#N# + 0],	100000
	push	rcx
	push	r9
	mov	rdi,	1
	call	__.array_.array
	pop	r9
	pop	rcx
	mov	rbx,	rax
	mov	rsi,	qword [_#N# + 0]
	mov	qword [rbx + 0],	rsi
	push	rcx
	push	r9
	mov	rdi,	rbx
	mov	rsi,	1
	mov	rdx,	8
	mov	rcx,	0
	call	__.array_new
	pop	r9
	pop	rcx
	mov	rbx,	rax
	mov	qword [_#a# + 0],	rbx
	push	rcx
	push	r9
	mov	rdi,	1
	call	__.array_.array
	pop	r9
	pop	rcx
	mov	rbx,	rax
	mov	rsi,	qword [_#N# + 0]
	mov	qword [rbx + 0],	rsi
	push	rcx
	push	r9
	mov	rdi,	rbx
	mov	rsi,	1
	mov	rdx,	8
	mov	rcx,	0
	call	__.array_new
	pop	r9
	pop	rcx
	mov	rbx,	rax
	mov	qword [_#bak# + 0],	rbx
	push	rcx
	push	r9
	mov	rdi,	1
	call	__.array_.array
	pop	r9
	pop	rcx
	mov	rbx,	rax
	mov	rsi,	qword [_#N# + 0]
	mov	qword [rbx + 0],	rsi
	push	rcx
	push	r9
	mov	rdi,	rbx
	mov	rsi,	1
	mov	rdx,	8
	mov	rcx,	0
	call	__.array_new
	pop	r9
	pop	rcx
	mov	rbx,	rax
	mov	qword [_#a_left# + 0],	rbx
	push	rcx
	push	r9
	mov	rdi,	1
	call	__.array_.array
	pop	r9
	pop	rcx
	mov	rbx,	rax
	mov	rsi,	qword [_#N# + 0]
	mov	qword [rbx + 0],	rsi
	push	rcx
	push	r9
	mov	rdi,	rbx
	mov	rsi,	1
	mov	rdx,	8
	mov	rcx,	0
	call	__.array_new
	pop	r9
	pop	rcx
	mov	rbx,	rax
	mov	qword [_#a_right# + 0],	rbx
	push	rcx
	push	r9
	mov	rdi,	1
	call	__.array_.array
	pop	r9
	pop	rcx
	mov	rbx,	rax
	mov	rsi,	qword [_#N# + 0]
	mov	qword [rbx + 0],	rsi
	push	rcx
	push	r9
	mov	rdi,	rbx
	mov	rsi,	1
	mov	rdx,	8
	mov	rcx,	0
	call	__.array_new
	pop	r9
	pop	rcx
	mov	rbx,	rax
	mov	qword [_#heap# + 0],	rbx
	push	rcx
	push	r9
	call	_getInt
	pop	r9
	pop	rcx
	mov	rbx,	rax
	mov	qword [_#n# + 0],	rbx
	push	rcx
	push	r9
	call	_getInt
	pop	r9
	pop	rcx
	mov	rbx,	rax
	mov	r12,	rbx
	mov	rbx,	1
_L1_0:
	mov	r11,	qword [_#n# + 0]
	cmp	rbx,	r11
	setle	al
	movzx	rsi,	al
	mov	r13,	rsi
	cmp	r13,	0
	je	_L1_1
	mov	r10,	qword [_#a# + 0]
	mov	qword [r10 + rbx*8],	rbx
	cmp	rbx,	r12
	setle	al
	movzx	rsi,	al
	mov	r13,	rsi
	cmp	r13,	0
	je	_L9_2
	mov	r13,	r12
	add	r13,	1
	mov	r13,	r13
	sub	r13,	rbx
	mov	r10,	qword [_#a# + 0]
	mov	qword [r10 + rbx*8],	r13
_L9_2:
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	r13,	r10
	mov	r10,	qword [_#bak# + 0]
	mov	qword [r10 + rbx*8],	r13
	add	rbx,	1
	jmp	_L1_0
_L1_1:
	mov	r10,	qword [_#n# + 0]
	mov	rbx,	r10
	add	rbx,	1
	push	rcx
	push	r9
	mov	rdi,	1
	mov	rsi,	rbx
	call	_quicksort
	pop	r9
	pop	rcx
	mov	rbx,	rax
	mov	r14,	rbx
	push	rcx
	push	r9
	call	_restore
	pop	r9
	pop	rcx
	push	rcx
	push	r9
	call	_calc
	pop	r9
	pop	rcx
	mov	rbx,	rax
	mov	r13,	rbx
	push	rcx
	push	r9
	call	_restore
	pop	r9
	pop	rcx
	mov	r10,	qword [_#n# + 0]
	mov	rbx,	r10
	add	rbx,	1
	push	rcx
	push	r9
	mov	rdi,	1
	mov	rsi,	rbx
	call	_mergesort
	pop	r9
	pop	rcx
	mov	rbx,	rax
	mov	r12,	rbx
	push	rcx
	push	r9
	call	_restore
	pop	r9
	pop	rcx
	push	rcx
	push	r9
	call	_heapsort
	pop	r9
	pop	rcx
	mov	rbx,	rax
	mov	rbx,	rbx
	push	rcx
	push	r9
	mov	rdi,	r14
	call	_toString
	pop	r9
	pop	rcx
	mov	r14,	rax
	push	rcx
	push	r9
	mov	rdi,	r14
	call	_println
	pop	r9
	pop	rcx
	push	rcx
	push	r9
	mov	rdi,	r13
	call	_toString
	pop	r9
	pop	rcx
	mov	r13,	rax
	push	rcx
	push	r9
	mov	rdi,	r13
	call	_println
	pop	r9
	pop	rcx
	push	rcx
	push	r9
	mov	rdi,	r12
	call	_toString
	pop	r9
	pop	rcx
	mov	r12,	rax
	push	rcx
	push	r9
	mov	rdi,	r12
	call	_println
	pop	r9
	pop	rcx
	push	rcx
	push	r9
	mov	rdi,	rbx
	call	_toString
	pop	r9
	pop	rcx
	mov	rbx,	rax
	push	rcx
	push	r9
	mov	rdi,	rbx
	call	_println
	pop	r9
	pop	rcx
	push	rcx
	push	r9
	mov	rdi,	16
	call	malloc
	pop	r9
	pop	rcx
	mov	rbx,	rax
	push	rcx
	push	r9
	mov	rdi,	rbx
	call	__A_A
	pop	r9
	pop	rcx
	mov	rbx,	rbx
	push	rcx
	push	r9
	mov	rdi,	rbx
	call	__A_Optimizer
	pop	r9
	pop	rcx
	mov	rax,	0
	jmp	___exit_main
___exit_main:
	add	rsp,	480
	pop	r14
	pop	r13
	pop	r12
	pop	rbx
	pop	rbp
	ret
__A_Optimizer:
	push	rbp
	mov	rbp,	rsp
	add	rbp,	8
	push	rbx
	push	r12
	push	r13
	push	r14
	push	r15
	sub	rsp,	504
	push	rcx
	push	r9
	mov	rdi,	10
	call	__.array_.array
	pop	r9
	pop	rcx
	mov	rbx,	rax
	mov	qword [rbx + 0],	2
	mov	qword [rbx + 8],	2
	mov	qword [rbx + 16],	2
	mov	qword [rbx + 24],	2
	mov	qword [rbx + 32],	2
	mov	qword [rbx + 40],	2
	mov	qword [rbx + 48],	2
	mov	qword [rbx + 56],	2
	mov	qword [rbx + 64],	2
	mov	qword [rbx + 72],	2
	push	rcx
	push	r9
	mov	rdi,	rbx
	mov	rsi,	10
	mov	rdx,	8
	mov	rcx,	0
	call	__.array_new
	pop	r9
	pop	rcx
	mov	rbx,	rax
	mov	r13,	rbx
	mov	r12,	0
	mov	rbx,	1
_L13_4:
	cmp	rbx,	1000
	setle	al
	movzx	rsi,	al
	mov	r14,	rsi
	cmp	r14,	0
	je	_L13_5
	mov	r10,	qword [r13 + 0]
	mov	r14,	r10
	mov	r10,	qword [r14 + 8]
	mov	r14,	r10
	mov	r10,	qword [r14 + 0]
	mov	r14,	r10
	mov	r10,	qword [r14 + 8]
	mov	r14,	r10
	mov	r10,	qword [r14 + 0]
	mov	r14,	r10
	mov	r10,	qword [r14 + 8]
	mov	r14,	r10
	mov	r10,	qword [r14 + 0]
	mov	r14,	r10
	mov	r10,	qword [r14 + 8]
	mov	r14,	r10
	mov	r10,	qword [r14 + 0]
	mov	r15,	r10
	mov	r14,	123
	add	r14,	rbx
	mov	qword [r15 + 8],	r14
	mov	r10,	qword [r13 + 0]
	mov	r14,	r10
	mov	r10,	qword [r14 + 8]
	mov	r14,	r10
	mov	r10,	qword [r14 + 0]
	mov	r14,	r10
	mov	r10,	qword [r14 + 8]
	mov	r14,	r10
	mov	r10,	qword [r14 + 0]
	mov	r14,	r10
	mov	r10,	qword [r14 + 8]
	mov	r14,	r10
	mov	r10,	qword [r14 + 0]
	mov	r14,	r10
	mov	r10,	qword [r14 + 8]
	mov	r14,	r10
	mov	r10,	qword [r14 + 0]
	mov	r14,	r10
	mov	r10,	qword [r14 + 8]
	mov	r14,	r10
	mov	r12,	r12
	add	r12,	r14
	mov	r12,	r12
	add	rbx,	1
	jmp	_L13_4
_L13_5:
	push	rcx
	push	r9
	mov	rdi,	r12
	call	_toString
	pop	r9
	pop	rcx
	mov	rbx,	rax
	push	rcx
	push	r9
	mov	rdi,	rbx
	call	_println
	pop	r9
	pop	rcx
	mov	rbx,	1
_L20_6:
	cmp	rbx,	1000000
	setle	al
	movzx	rsi,	al
	mov	r13,	rsi
	cmp	r13,	0
	je	_L20_7
	mov	r12,	r12
	add	r12,	8
	mov	r12,	r12
	add	rbx,	1
	jmp	_L20_6
_L20_7:
	push	rcx
	push	r9
	mov	rdi,	r12
	call	_toString
	pop	r9
	pop	rcx
	mov	rbx,	rax
	push	rcx
	push	r9
	mov	rdi,	rbx
	call	_println
	pop	r9
	pop	rcx
	mov	rbx,	1
_L25_8:
	cmp	rbx,	200000000
	setle	al
	movzx	rsi,	al
	mov	r12,	rsi
	cmp	r12,	0
	je	_L25_9
	add	rbx,	1
	jmp	_L25_8
_L25_9:
___exit__A_Optimizer:
	add	rsp,	504
	pop	r15
	pop	r14
	pop	r13
	pop	r12
	pop	rbx
	pop	rbp
	ret
__A_A:
	push	rbp
	mov	rbp,	rsp
	add	rbp,	8
	push	rbx
	push	r12
	sub	rsp,	144
	mov	rbx,	rdi
	push	rcx
	push	r9
	mov	rdi,	10
	call	__.array_.array
	pop	r9
	pop	rcx
	mov	r12,	rax
	mov	qword [r12 + 0],	2
	mov	qword [r12 + 8],	2
	mov	qword [r12 + 16],	3
	mov	qword [r12 + 24],	2
	mov	qword [r12 + 32],	3
	mov	qword [r12 + 40],	2
	mov	qword [r12 + 48],	2
	mov	qword [r12 + 56],	3
	mov	qword [r12 + 64],	2
	mov	qword [r12 + 72],	2
	push	rcx
	push	r9
	mov	rdi,	r12
	mov	rsi,	10
	mov	rdx,	8
	mov	rcx,	0
	call	__.array_new
	pop	r9
	pop	rcx
	mov	r12,	rax
	mov	qword [rbx + 8],	r12
___exit__A_A:
	add	rsp,	144
	pop	r12
	pop	rbx
	pop	rbp
	ret
_restore:
	push	rbp
	mov	rbp,	rsp
	add	rbp,	8
	push	rbx
	push	r12
	sub	rsp,	144
	mov	r12,	1
_L29_10:
	mov	r11,	qword [_#n# + 0]
	cmp	r12,	r11
	setle	al
	movzx	rsi,	al
	mov	rbx,	rsi
	cmp	rbx,	0
	je	_L29_11
	mov	r10,	qword [_#bak# + 0]
	mov	r10,	qword [r10 + r12*8]
	mov	rbx,	r10
	mov	r10,	qword [_#a# + 0]
	mov	qword [r10 + r12*8],	rbx
	add	r12,	1
	jmp	_L29_10
_L29_11:
___exit_restore:
	add	rsp,	144
	pop	r12
	pop	rbx
	pop	rbp
	ret
_quicksort:
	push	rbp
	mov	rbp,	rsp
	add	rbp,	8
	push	rbx
	push	r12
	push	r13
	push	r14
	push	r15
	sub	rsp,	488
	mov	qword [rbp + -136],	rdi
	mov	qword [rbp + -144],	rsi
	mov	r9,	0
	mov	r10,	qword [_#a# + 0]
	mov	r11,	qword [rbp + -136]
	mov	r10,	qword [r10 + r11*8]
	mov	rbx,	r10
	mov	qword [rbp + -280],	rbx
	mov	r14,	0
	mov	rcx,	0
	mov	r10,	qword [rbp + -136]
	mov	rbx,	r10
	add	rbx,	1
	mov	rbx,	rbx
_L33_12:
	mov	r11,	qword [rbp + -144]
	cmp	rbx,	r11
	setl	al
	movzx	rsi,	al
	mov	r12,	rsi
	cmp	r12,	0
	je	_L33_13
	add	r9,	1
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	r12,	r10
	mov	r11,	qword [rbp + -280]
	cmp	r12,	r11
	setl	al
	movzx	rsi,	al
	mov	r12,	rsi
	cmp	r12,	0
	je	_L40_14
	mov	r13,	r14
	add	r14,	1
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	r12,	r10
	mov	r10,	qword [_#a_left# + 0]
	mov	qword [r10 + r13*8],	r12
	jmp	_L40_15
_L40_14:
	mov	r13,	rcx
	add	rcx,	1
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	r12,	r10
	mov	r10,	qword [_#a_right# + 0]
	mov	qword [r10 + r13*8],	r12
_L40_15:
	add	rbx,	1
	jmp	_L33_12
_L33_13:
	mov	r10,	qword [rbp + -136]
	mov	r12,	r10
	mov	rbx,	0
_L41_16:
	cmp	rbx,	r14
	setl	al
	movzx	rsi,	al
	mov	r13,	rsi
	cmp	r13,	0
	je	_L41_17
	mov	r15,	r12
	add	r12,	1
	mov	r10,	qword [_#a_left# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	r13,	r10
	mov	r10,	qword [_#a# + 0]
	mov	qword [r10 + r15*8],	r13
	add	rbx,	1
	jmp	_L41_16
_L41_17:
	mov	rbx,	r12
	add	r12,	1
	mov	rsi,	qword [rbp + -280]
	mov	r10,	qword [_#a# + 0]
	mov	qword [r10 + rbx*8],	rsi
	mov	rbx,	0
_L46_18:
	cmp	rbx,	rcx
	setl	al
	movzx	rsi,	al
	mov	r13,	rsi
	cmp	r13,	0
	je	_L46_19
	mov	r15,	r12
	add	r12,	1
	mov	r10,	qword [_#a_right# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	r13,	r10
	mov	r10,	qword [_#a# + 0]
	mov	qword [r10 + r15*8],	r13
	add	rbx,	1
	jmp	_L46_18
_L46_19:
	cmp	r14,	1
	setg	al
	movzx	rsi,	al
	mov	rbx,	rsi
	cmp	rbx,	0
	je	_L54_20
	mov	r10,	qword [rbp + -136]
	mov	rbx,	r10
	add	rbx,	r14
	push	rcx
	push	r9
	mov	r10,	qword [rbp + -136]
	mov	rdi,	r10
	mov	rsi,	rbx
	call	_quicksort
	pop	r9
	pop	rcx
	mov	r12,	rax
	mov	rbx,	r9
	add	rbx,	r12
	mov	r9,	rbx
_L54_20:
	cmp	rcx,	1
	setg	al
	movzx	rsi,	al
	mov	rbx,	rsi
	cmp	rbx,	0
	je	_L59_22
	mov	r10,	qword [rbp + -144]
	mov	rbx,	r10
	sub	rbx,	rcx
	push	rcx
	push	r9
	mov	rdi,	rbx
	mov	r10,	qword [rbp + -144]
	mov	rsi,	r10
	call	_quicksort
	pop	r9
	pop	rcx
	mov	r12,	rax
	mov	rbx,	r9
	add	rbx,	r12
	mov	r9,	rbx
_L59_22:
	mov	rax,	r9
	jmp	___exit_quicksort
___exit_quicksort:
	add	rsp,	488
	pop	r15
	pop	r14
	pop	r13
	pop	r12
	pop	rbx
	pop	rbp
	ret
_calc:
	push	rbp
	mov	rbp,	rsp
	add	rbp,	8
	push	rbx
	push	r12
	push	r13
	push	r14
	sub	rsp,	352
	mov	rbx,	1
_L60_24:
	mov	r11,	qword [_#n# + 0]
	cmp	rbx,	r11
	setle	al
	movzx	rsi,	al
	mov	r12,	rsi
	cmp	r12,	0
	je	_L60_25
	mov	r12,	rbx
	sub	r12,	1
	mov	r10,	qword [_#a_left# + 0]
	mov	qword [r10 + rbx*8],	r12
	mov	r12,	rbx
	add	r12,	1
	mov	r10,	qword [_#a_right# + 0]
	mov	qword [r10 + rbx*8],	r12
	add	rbx,	1
	jmp	_L60_24
_L60_25:
	mov	r13,	0
	mov	r10,	qword [_#n# + 0]
	mov	rbx,	r10
_L67_26:
	cmp	rbx,	1
	setge	al
	movzx	rsi,	al
	mov	r12,	rsi
	cmp	r12,	0
	je	_L67_27
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	r12,	r10
	mov	r10,	qword [_#a_left# + 0]
	mov	r10,	qword [r10 + r12*8]
	mov	r12,	r10
	mov	r12,	r12
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	r14,	r10
	mov	r10,	qword [_#a_right# + 0]
	mov	r10,	qword [r10 + r14*8]
	mov	r14,	r10
	mov	r14,	r14
	mov	r10,	qword [_#a_right# + 0]
	mov	qword [r10 + r12*8],	r14
	mov	r10,	qword [_#a_left# + 0]
	mov	qword [r10 + r14*8],	r12
	mov	r13,	r13
	add	r13,	r14
	mov	r13,	r13
	sub	r13,	r12
	mov	r12,	r13
	sub	r12,	2
	mov	r13,	r12
	sub	rbx,	1
	jmp	_L67_26
_L67_27:
	mov	rax,	r13
	jmp	___exit_calc
___exit_calc:
	add	rsp,	352
	pop	r14
	pop	r13
	pop	r12
	pop	rbx
	pop	rbp
	ret
_mergesort:
	push	rbp
	mov	rbp,	rsp
	add	rbp,	8
	push	rbx
	push	r12
	push	r13
	push	r14
	push	r15
	sub	rsp,	584
	mov	qword [rbp + -136],	rdi
	mov	r15,	rsi
	mov	r10,	qword [rbp + -136]
	mov	rbx,	r10
	add	rbx,	1
	cmp	rbx,	r15
	sete	al
	movzx	rsi,	al
	mov	rbx,	rsi
	cmp	rbx,	0
	je	_L78_28
	mov	rax,	0
	jmp	___exit_mergesort
_L78_28:
	mov	r10,	qword [rbp + -136]
	mov	rbx,	r10
	add	rbx,	r15
	mov	rbx,	rbx
	shr	rbx,	1
	mov	r13,	rbx
	mov	qword [rbp + -304],	0
	push	rcx
	push	r9
	mov	r10,	qword [rbp + -136]
	mov	rdi,	r10
	mov	rsi,	r13
	call	_mergesort
	pop	r9
	pop	rcx
	mov	r12,	rax
	mov	r10,	qword [rbp + -304]
	mov	rbx,	r10
	add	rbx,	r12
	mov	qword [rbp + -304],	rbx
	push	rcx
	push	r9
	mov	rdi,	r13
	mov	rsi,	r15
	call	_mergesort
	pop	r9
	pop	rcx
	mov	r12,	rax
	mov	r10,	qword [rbp + -304]
	mov	rbx,	r10
	add	rbx,	r12
	mov	qword [rbp + -304],	rbx
	mov	rcx,	0
	mov	r9,	0
	mov	r10,	qword [rbp + -136]
	mov	rbx,	r10
_L85_30:
	cmp	rbx,	r13
	setl	al
	movzx	rsi,	al
	mov	r12,	rsi
	cmp	r12,	0
	je	_L85_31
	mov	r14,	rcx
	add	rcx,	1
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	r12,	r10
	mov	r10,	qword [_#a_left# + 0]
	mov	qword [r10 + r14*8],	r12
	add	rbx,	1
	jmp	_L85_30
_L85_31:
	mov	rbx,	r13
_L89_32:
	cmp	rbx,	r15
	setl	al
	movzx	rsi,	al
	mov	r12,	rsi
	cmp	r12,	0
	je	_L89_33
	mov	r13,	r9
	add	r9,	1
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	r12,	r10
	mov	r10,	qword [_#a_right# + 0]
	mov	qword [r10 + r13*8],	r12
	add	rbx,	1
	jmp	_L89_32
_L89_33:
	mov	r12,	0
	mov	r14,	0
	mov	r10,	qword [rbp + -136]
	mov	rbx,	r10
_L93_34:
	cmp	r12,	rcx
	setl	al
	movzx	rsi,	al
	mov	r15,	rsi
	mov	r13,	0
	cmp	r15,	0
	je	_L96_36
	cmp	r14,	r9
	setl	al
	movzx	rsi,	al
	mov	r13,	rsi
	mov	r13,	r13
_L96_36:
	and	r13,	r15
	cmp	r13,	0
	je	_L93_35
	mov	r10,	qword [rbp + -304]
	mov	r11,	qword [rbp + -304]
	add	r11,	1
	mov	qword [rbp + -304],	r11
	mov	r10,	qword [_#a_left# + 0]
	mov	r10,	qword [r10 + r12*8]
	mov	r15,	r10
	mov	r10,	qword [_#a_right# + 0]
	mov	r10,	qword [r10 + r14*8]
	mov	r13,	r10
	cmp	r15,	r13
	setl	al
	movzx	rsi,	al
	mov	r13,	rsi
	cmp	r13,	0
	je	_L100_37
	mov	r15,	rbx
	add	rbx,	1
	mov	r13,	r12
	add	r12,	1
	mov	r10,	qword [_#a_left# + 0]
	mov	r10,	qword [r10 + r13*8]
	mov	r13,	r10
	mov	r10,	qword [_#a# + 0]
	mov	qword [r10 + r15*8],	r13
	jmp	_L100_38
_L100_37:
	mov	r15,	rbx
	add	rbx,	1
	mov	r13,	r14
	add	r14,	1
	mov	r10,	qword [_#a_right# + 0]
	mov	r10,	qword [r10 + r13*8]
	mov	r13,	r10
	mov	r10,	qword [_#a# + 0]
	mov	qword [r10 + r15*8],	r13
_L100_38:
	jmp	_L93_34
_L93_35:
_L101_39:
	cmp	r12,	rcx
	setl	al
	movzx	rsi,	al
	mov	r13,	rsi
	cmp	r13,	0
	je	_L101_40
	mov	r15,	rbx
	add	rbx,	1
	mov	r13,	r12
	add	r12,	1
	mov	r10,	qword [_#a_left# + 0]
	mov	r10,	qword [r10 + r13*8]
	mov	r13,	r10
	mov	r10,	qword [_#a# + 0]
	mov	qword [r10 + r15*8],	r13
	jmp	_L101_39
_L101_40:
_L104_41:
	cmp	r14,	r9
	setl	al
	movzx	rsi,	al
	mov	r12,	rsi
	cmp	r12,	0
	je	_L104_42
	mov	r13,	rbx
	add	rbx,	1
	mov	r12,	r14
	add	r14,	1
	mov	r10,	qword [_#a_right# + 0]
	mov	r10,	qword [r10 + r12*8]
	mov	r12,	r10
	mov	r10,	qword [_#a# + 0]
	mov	qword [r10 + r13*8],	r12
	jmp	_L104_41
_L104_42:
	mov	r10,	qword [rbp + -304]
	mov	rax,	r10
	jmp	___exit_mergesort
___exit_mergesort:
	add	rsp,	584
	pop	r15
	pop	r14
	pop	r13
	pop	r12
	pop	rbx
	pop	rbp
	ret
_heapsort:
	push	rbp
	mov	rbp,	rsp
	add	rbp,	8
	push	rbx
	push	r12
	push	r13
	push	r14
	push	r15
	sub	rsp,	552
	mov	r15,	0
	mov	qword [rbp + -256],	1
_L107_43:
	mov	r10,	qword [rbp + -256]
	mov	r11,	qword [_#n# + 0]
	cmp	r10,	r11
	setle	al
	movzx	rsi,	al
	mov	rbx,	rsi
	cmp	rbx,	0
	je	_L107_44
	mov	r10,	qword [_#a# + 0]
	mov	r11,	qword [rbp + -256]
	mov	r10,	qword [r10 + r11*8]
	mov	rbx,	r10
	mov	r10,	qword [_#heap# + 0]
	mov	r11,	qword [rbp + -256]
	mov	qword [r10 + r11*8],	rbx
	mov	r10,	qword [rbp + -256]
	mov	rbx,	r10
_L111_45:
	cmp	rbx,	1
	setne	al
	movzx	rsi,	al
	mov	r12,	rsi
	cmp	r12,	0
	je	_L111_46
	add	r15,	1
	mov	r10,	qword [_#heap# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	r13,	r10
	mov	r12,	rbx
	shr	r12,	1
	mov	r10,	qword [_#heap# + 0]
	mov	r10,	qword [r10 + r12*8]
	mov	r12,	r10
	cmp	r13,	r12
	setg	al
	movzx	rsi,	al
	mov	r12,	rsi
	cmp	r12,	0
	je	_L115_47
	jmp	_L111_46
_L115_47:
	mov	r10,	qword [_#heap# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	r12,	r10
	mov	r12,	r12
	mov	r13,	rbx
	shr	r13,	1
	mov	r10,	qword [_#heap# + 0]
	mov	r10,	qword [r10 + r13*8]
	mov	r13,	r10
	mov	r10,	qword [_#heap# + 0]
	mov	qword [r10 + rbx*8],	r13
	mov	r13,	rbx
	shr	r13,	1
	mov	r10,	qword [_#heap# + 0]
	mov	qword [r10 + r13*8],	r12
	mov	rbx,	rbx
	shr	rbx,	1
	mov	rbx,	rbx
	jmp	_L111_45
_L111_46:
	mov	r10,	qword [rbp + -256]
	mov	r11,	qword [rbp + -256]
	add	r11,	1
	mov	qword [rbp + -256],	r11
	jmp	_L107_43
_L107_44:
	mov	r10,	qword [_#n# + 0]
	mov	r9,	r10
	mov	qword [rbp + -256],	1
_L123_49:
	mov	r10,	qword [rbp + -256]
	mov	r11,	qword [_#n# + 0]
	cmp	r10,	r11
	setle	al
	movzx	rsi,	al
	mov	rbx,	rsi
	cmp	rbx,	0
	je	_L123_50
	mov	r10,	qword [_#heap# + 0]
	mov	r10,	qword [r10 + 8]
	mov	rbx,	r10
	mov	r10,	qword [_#a# + 0]
	mov	r11,	qword [rbp + -256]
	mov	qword [r10 + r11*8],	rbx
	mov	rbx,	r9
	sub	r9,	1
	mov	r10,	qword [_#heap# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	rbx,	r10
	mov	r10,	qword [_#heap# + 0]
	mov	qword [r10 + 8],	rbx
	mov	r13,	1
_L128_51:
	mov	rbx,	r13
	shl	rbx,	1
	cmp	rbx,	r9
	setle	al
	movzx	rsi,	al
	mov	rbx,	rsi
	cmp	rbx,	0
	je	_L128_52
	mov	rbx,	r13
	shl	rbx,	1
	mov	rbx,	rbx
	mov	r12,	rbx
	add	r12,	1
	mov	r12,	r12
	mov	r14,	rbx
	cmp	r12,	r9
	setle	al
	movzx	rsi,	al
	mov	rcx,	rsi
	cmp	rcx,	0
	je	_L137_55
	add	r15,	1
	mov	r10,	qword [_#heap# + 0]
	mov	r10,	qword [r10 + r12*8]
	mov	rcx,	r10
	mov	r10,	qword [_#heap# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	rbx,	r10
	cmp	rcx,	rbx
	setl	al
	movzx	rsi,	al
	mov	rbx,	rsi
	cmp	rbx,	0
	je	_L136_53
	mov	r14,	r12
_L136_53:
_L137_55:
	add	r15,	1
	mov	r10,	qword [_#heap# + 0]
	mov	r10,	qword [r10 + r13*8]
	mov	r12,	r10
	mov	r10,	qword [_#heap# + 0]
	mov	r10,	qword [r10 + r14*8]
	mov	rbx,	r10
	cmp	r12,	rbx
	setl	al
	movzx	rsi,	al
	mov	rbx,	rsi
	cmp	rbx,	0
	je	_L139_57
	jmp	_L128_52
_L139_57:
	mov	r10,	qword [_#heap# + 0]
	mov	r10,	qword [r10 + r13*8]
	mov	rbx,	r10
	mov	r12,	rbx
	mov	r10,	qword [_#heap# + 0]
	mov	r10,	qword [r10 + r14*8]
	mov	rbx,	r10
	mov	r10,	qword [_#heap# + 0]
	mov	qword [r10 + r13*8],	rbx
	mov	r10,	qword [_#heap# + 0]
	mov	qword [r10 + r14*8],	r12
	mov	r12,	r13
	mov	r13,	r14
	jmp	_L128_51
_L128_52:
	mov	r10,	qword [rbp + -256]
	mov	r11,	qword [rbp + -256]
	add	r11,	1
	mov	qword [rbp + -256],	r11
	jmp	_L123_49
_L123_50:
	mov	rax,	r15
	jmp	___exit_heapsort
___exit_heapsort:
	add	rsp,	552
	pop	r15
	pop	r14
	pop	r13
	pop	r12
	pop	rbx
	pop	rbp
	ret
SECTION .bss
_#N#:	resb	8
_#n#:	resb	8
_#a#:	resb	8
_#bak#:	resb	8
_#a_left#:	resb	8
_#a_right#:	resb	8
_#heap#:	resb	8
_#i1#:	resb	8
_#i2#:	resb	8
_#i3#:	resb	8
_#i4#:	resb	8
_#i5#:	resb	8
_#i6#:	resb	8
_#i7#:	resb	8
_#i8#:	resb	8
_#i9#:	resb	8
_#i10#:	resb	8
_#i11#:	resb	8
_#i12#:	resb	8
_#i13#:	resb	8
_#i14#:	resb	8
SECTION .rodata
; ============Library============
default rel

global __.array_.array
global __.array_new
global __.string_.string
global _print
global _println
global _getString
global __.string_length
global __.string_substring
global __.string_parseInt
global __.string_ord
global __.string__plus
global __.string__less
global __.string__lessEqual
global __.string__equal
global __.array_size

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
        lea     rdi, [rel L0_002]
        mov     eax, 0
        call    __isoc99_scanf
        mov     eax, dword [rbp-0CH]
        mov     rdx, qword [rbp-8H]


        xor     rdx, qword [fs:abs 28H]
        jz      L0_001
        call    __stack_chk_fail
L0_001:  leave
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
        lea     rsi, [rel L0_002]
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


_getString:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        lea     rsi, [rel buffer]
        lea     rdi, [rel L0_003]
        mov     eax, 0
        call    __isoc99_scanf
        lea     rdi, [rel buffer]
        call    strlen
        mov     dword [rbp-0CH], eax
        mov     eax, dword [rbp-0CH]
        mov     edi, eax
        call    __.string_.string
        mov     qword [rbp-8H], rax
        mov     rax, qword [rbp-8H]
        lea     rsi, [rel buffer]
        mov     rdi, rax
        call    strcpy
        mov     rax, qword [rbp-8H]
        leave
        ret



SECTION .data


SECTION .bss    align=32

buffer:
        resb    256


SECTION .rodata

L0_002:
        db 25H, 64H, 00H

L0_003:
        db 25H, 73H, 00H



;	=== O3 ===

SECTION .text   6

__.array_.array:
        push    rbx
        mov     ebx, edi
        lea     edi, [rdi*8]
        movsxd  rdi, edi
        add     rdi, 4
        call    malloc
        mov     dword [rax], ebx
        add     rax, 4
        pop     rbx
        ret






ALIGN   8

__.array_new:
        push    r15
        push    r14
        mov     r14d, edx
        push    r13
        push    r12
        mov     r13d, esi
        push    rbp
        push    rbx
        mov     rbx, rdi
        mov     r12, rcx
        sub     rsp, 24
        mov     r15, qword [rdi]
        lea     edi, [r15*8]
        movsxd  rdi, edi
        add     rdi, 4
        call    malloc
        mov     rbp, rax
        add     rax, 4
        test    r15, r15
        mov     qword [rsp], rax
        mov     dword [rbp], r15d
        jle     L_003
        lea     eax, [r13-1H]
        mov     r15d, 1
        mov     dword [rsp+0CH], eax
L_001:  cmp     r13d, 1
        jg      L_004
        test    r12, r12
        jz      L_002
        movsxd  rdi, r14d
        call    malloc
        mov     qword [rbp+r15*8-4H], rax
        mov     rdi, rax
        call    r12
L_002:  mov     rax, r15
        add     r15, 1
        cmp     rax, qword [rbx]
        jl      L_001
L_003:  mov     rax, qword [rsp]
        add     rsp, 24
        pop     rbx
        pop     rbp
        pop     r12
        pop     r13
        pop     r14
        pop     r15
        ret

L_004:  mov     esi, dword [rsp+0CH]
        lea     rdi, [rbx+8H]
        mov     rcx, r12
        mov     edx, r14d
        call    __.array_new
        mov     qword [rbp+r15*8-4H], rax
        jmp     L_002






ALIGN   8

__.string_.string:
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

__.string_length:
        mov     eax, dword [rdi-4H]
        ret







ALIGN   16

__.string_substring:
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
        jle     L_008
        mov     ecx, ebx
        lea     r8, [rbp+r13]
        xor     edx, edx
        add     rcx, 1




ALIGN   8
L_007:  movzx   esi, byte [r8+rdx]
        mov     byte [rdi+rdx+4H], sil
        add     rdx, 1
        cmp     rdx, rcx
        jnz     L_007
L_008:  add     rsp, 8
        pop     rbx
        pop     rbp
        pop     r12
        pop     r13
        ret






ALIGN   8

__.string_parseInt:
        sub     rsp, 8
        mov     edx, 10
        xor     esi, esi
        call    strtol
        add     rsp, 8
        ret


        nop





ALIGN   16

__.string_ord:
        movsxd  rsi, esi
        movzx   eax, byte [rdi+rsi]
        ret






ALIGN   16

__.string__plus:
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

__.string__less:
        sub     rsp, 8
        call    strcmp
        cmp     eax, -1
        sete    al
        add     rsp, 8
        ret







ALIGN   16

__.string__lessEqual:
        sub     rsp, 8
        call    strcmp
        test    eax, eax
        setle   al
        add     rsp, 8
        ret







ALIGN   16

__.string__equal:
        sub     rsp, 8
        call    strcmp
        test    eax, eax
        sete    al
        add     rsp, 8
        ret







ALIGN   16

__.array_size:
        mov     eax, dword [rdi-4H]
        ret



SECTION .data


SECTION .bss


