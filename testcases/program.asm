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
	sub	rsp,	2376
	push	rcx
	push	r9
	mov	rdi,	1
	call	__.array_.array
	pop	r9
	pop	rcx
	mov	rbx,	rax
	mov	qword [rbx + 0],	10100
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
	mov	qword [_#n# + 0],	10000
	mov	rbx,	1
_L0_0:
	mov	r11,	qword [_#n# + 0]
	cmp	rbx,	r11
	setle	al
	movzx	rsi,	al
	mov	r12,	rsi
	cmp	r12,	0
	je	_L0_1
	mov	r10,	qword [_#n# + 0]
	mov	r12,	r10
	add	r12,	1
	mov	r12,	r12
	sub	r12,	rbx
	mov	r10,	qword [_#a# + 0]
	mov	qword [r10 + rbx*8],	r12
	add	rbx,	1
	jmp	_L0_0
_L0_1:
_qsrt#4#:
	mov	r13,	1
	mov	r10,	qword [_#n# + 0]
	mov	qword [rbp + -184],	r10
	mov	r15,	r13
	mov	r10,	qword [rbp + -184]
	mov	rbx,	r10
	mov	r12,	r13
	mov	r10,	qword [rbp + -184]
	add	r12,	r10
	mov	rax,	r12
	mov	r10,	2
	cqo
	idiv	r10
	mov	r12,	rax
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + r12*8]
	mov	r12,	r10
	mov	r12,	r12
_L27_16:
	cmp	r15,	rbx
	setle	al
	movzx	rsi,	al
	mov	r14,	rsi
	cmp	r14,	0
	je	_L27_17
_L29_18:
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + r15*8]
	mov	r14,	r10
	cmp	r14,	r12
	setl	al
	movzx	rsi,	al
	mov	r14,	rsi
	cmp	r14,	0
	je	_L29_19
	add	r15,	1
	jmp	_L29_18
_L29_19:
_L31_20:
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	r14,	r10
	cmp	r14,	r12
	setg	al
	movzx	rsi,	al
	mov	r14,	rsi
	cmp	r14,	0
	je	_L31_21
	sub	rbx,	1
	jmp	_L31_20
_L31_21:
	cmp	r15,	rbx
	setle	al
	movzx	rsi,	al
	mov	r14,	rsi
	cmp	r14,	0
	je	_L36_22
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + r15*8]
	mov	r14,	r10
	mov	rcx,	r14
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	r14,	r10
	mov	r10,	qword [_#a# + 0]
	mov	qword [r10 + r15*8],	r14
	mov	r10,	qword [_#a# + 0]
	mov	qword [r10 + rbx*8],	rcx
	add	r15,	1
	sub	rbx,	1
_L36_22:
	jmp	_L27_16
_L27_17:
	cmp	r13,	rbx
	setl	al
	movzx	rsi,	al
	mov	r12,	rsi
	cmp	r12,	0
	je	_L38_24
_qsrt#13#:
	mov	r9,	r13
	mov	qword [rbp + -504],	rbx
	mov	r12,	r9
	mov	r10,	qword [rbp + -504]
	mov	rbx,	r10
	mov	r13,	r9
	mov	r10,	qword [rbp + -504]
	add	r13,	r10
	mov	rax,	r13
	mov	r10,	2
	cqo
	idiv	r10
	mov	r13,	rax
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + r13*8]
	mov	r13,	r10
	mov	r14,	r13
_L75_52:
	cmp	r12,	rbx
	setle	al
	movzx	rsi,	al
	mov	r13,	rsi
	cmp	r13,	0
	je	_L75_53
_L77_54:
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + r12*8]
	mov	r13,	r10
	cmp	r13,	r14
	setl	al
	movzx	rsi,	al
	mov	r13,	rsi
	cmp	r13,	0
	je	_L77_55
	add	r12,	1
	jmp	_L77_54
_L77_55:
_L79_56:
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	r13,	r10
	cmp	r13,	r14
	setg	al
	movzx	rsi,	al
	mov	r13,	rsi
	cmp	r13,	0
	je	_L79_57
	sub	rbx,	1
	jmp	_L79_56
_L79_57:
	cmp	r12,	rbx
	setle	al
	movzx	rsi,	al
	mov	r13,	rsi
	cmp	r13,	0
	je	_L84_58
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + r12*8]
	mov	r13,	r10
	mov	r13,	r13
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	rcx,	r10
	mov	r10,	qword [_#a# + 0]
	mov	qword [r10 + r12*8],	rcx
	mov	r10,	qword [_#a# + 0]
	mov	qword [r10 + rbx*8],	r13
	add	r12,	1
	sub	rbx,	1
_L84_58:
	jmp	_L75_52
_L75_53:
	cmp	r9,	rbx
	setl	al
	movzx	rsi,	al
	mov	r13,	rsi
	cmp	r13,	0
	je	_L86_60
	push	rcx
	push	r9
	mov	rdi,	r9
	mov	rsi,	rbx
	call	_qsrt
	pop	r9
	pop	rcx
_L86_60:
	mov	r11,	qword [rbp + -504]
	cmp	r12,	r11
	setl	al
	movzx	rsi,	al
	mov	rbx,	rsi
	cmp	rbx,	0
	je	_L88_62
	push	rcx
	push	r9
	mov	rdi,	r12
	mov	r10,	qword [rbp + -504]
	mov	rsi,	r10
	call	_qsrt
	pop	r9
	pop	rcx
_L88_62:
	mov	rax,	0
	jmp	___exit#13#_qsrt
___exit#13#_qsrt:
_L38_24:
	mov	r11,	qword [rbp + -184]
	cmp	r15,	r11
	setl	al
	movzx	rsi,	al
	mov	rbx,	rsi
	cmp	rbx,	0
	je	_L40_26
_qsrt#14#:
	mov	r14,	r15
	mov	r10,	qword [rbp + -184]
	mov	r15,	r10
	mov	r12,	r14
	mov	rbx,	r15
	mov	r13,	r14
	add	r13,	r15
	mov	rax,	r13
	mov	r10,	2
	cqo
	idiv	r10
	mov	r13,	rax
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + r13*8]
	mov	r13,	r10
	mov	r13,	r13
_L91_64:
	cmp	r12,	rbx
	setle	al
	movzx	rsi,	al
	mov	rcx,	rsi
	cmp	rcx,	0
	je	_L91_65
_L93_66:
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + r12*8]
	mov	rcx,	r10
	cmp	rcx,	r13
	setl	al
	movzx	rsi,	al
	mov	rcx,	rsi
	cmp	rcx,	0
	je	_L93_67
	add	r12,	1
	jmp	_L93_66
_L93_67:
_L95_68:
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	rcx,	r10
	cmp	rcx,	r13
	setg	al
	movzx	rsi,	al
	mov	rcx,	rsi
	cmp	rcx,	0
	je	_L95_69
	sub	rbx,	1
	jmp	_L95_68
_L95_69:
	cmp	r12,	rbx
	setle	al
	movzx	rsi,	al
	mov	rcx,	rsi
	cmp	rcx,	0
	je	_L100_70
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + r12*8]
	mov	rcx,	r10
	mov	r9,	rcx
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	rcx,	r10
	mov	r10,	qword [_#a# + 0]
	mov	qword [r10 + r12*8],	rcx
	mov	r10,	qword [_#a# + 0]
	mov	qword [r10 + rbx*8],	r9
	add	r12,	1
	sub	rbx,	1
_L100_70:
	jmp	_L91_64
_L91_65:
	cmp	r14,	rbx
	setl	al
	movzx	rsi,	al
	mov	r13,	rsi
	cmp	r13,	0
	je	_L102_72
	push	rcx
	push	r9
	mov	rdi,	r14
	mov	rsi,	rbx
	call	_qsrt
	pop	r9
	pop	rcx
_L102_72:
	cmp	r12,	r15
	setl	al
	movzx	rsi,	al
	mov	rbx,	rsi
	cmp	rbx,	0
	je	_L104_74
	push	rcx
	push	r9
	mov	rdi,	r12
	mov	rsi,	r15
	call	_qsrt
	pop	r9
	pop	rcx
_L104_74:
	mov	rax,	0
	jmp	___exit#14#_qsrt
___exit#14#_qsrt:
_L40_26:
	mov	rax,	0
	jmp	___exit#4#_qsrt
___exit#4#_qsrt:
	mov	rbx,	1
_L6_2:
	mov	r11,	qword [_#n# + 0]
	cmp	rbx,	r11
	setle	al
	movzx	rsi,	al
	mov	r12,	rsi
	cmp	r12,	0
	je	_L6_3
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	r12,	r10
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
	call	_print
	pop	r9
	pop	rcx
	push	rcx
	push	r9
	mov	rdi,	STR_0
	call	_print
	pop	r9
	pop	rcx
	add	rbx,	1
	jmp	_L6_2
_L6_3:
	push	rcx
	push	r9
	mov	rdi,	STR_1
	call	_print
	pop	r9
	pop	rcx
	mov	rax,	0
	jmp	___exit_main
___exit_main:
	add	rsp,	2376
	pop	r15
	pop	r14
	pop	r13
	pop	r12
	pop	rbx
	pop	rbp
	ret
_qsrt:
	push	rbp
	mov	rbp,	rsp
	add	rbp,	8
	push	rbx
	push	r12
	push	r13
	push	r14
	push	r15
	sub	rsp,	13128
	mov	r13,	rdi
	mov	qword [rbp + -80],	rsi
	mov	rcx,	r13
	mov	r10,	qword [rbp + -80]
	mov	rbx,	r10
	mov	r12,	r13
	mov	r10,	qword [rbp + -80]
	add	r12,	r10
	mov	rax,	r12
	mov	r10,	2
	cqo
	idiv	r10
	mov	r12,	rax
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + r12*8]
	mov	r12,	r10
	mov	r12,	r12
_L11_4:
	cmp	rcx,	rbx
	setle	al
	movzx	rsi,	al
	mov	r14,	rsi
	cmp	r14,	0
	je	_L11_5
_L13_6:
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + rcx*8]
	mov	r14,	r10
	cmp	r14,	r12
	setl	al
	movzx	rsi,	al
	mov	r14,	rsi
	cmp	r14,	0
	je	_L13_7
	add	rcx,	1
	jmp	_L13_6
_L13_7:
_L15_8:
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	r14,	r10
	cmp	r14,	r12
	setg	al
	movzx	rsi,	al
	mov	r14,	rsi
	cmp	r14,	0
	je	_L15_9
	sub	rbx,	1
	jmp	_L15_8
_L15_9:
	cmp	rcx,	rbx
	setle	al
	movzx	rsi,	al
	mov	r14,	rsi
	cmp	r14,	0
	je	_L20_10
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + rcx*8]
	mov	r14,	r10
	mov	r15,	r14
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	r14,	r10
	mov	r10,	qword [_#a# + 0]
	mov	qword [r10 + rcx*8],	r14
	mov	r10,	qword [_#a# + 0]
	mov	qword [r10 + rbx*8],	r15
	add	rcx,	1
	sub	rbx,	1
_L20_10:
	jmp	_L11_4
_L11_5:
	cmp	r13,	rbx
	setl	al
	movzx	rsi,	al
	mov	r12,	rsi
	cmp	r12,	0
	je	_L22_12
_qsrt#9#:
	mov	r9,	r13
	mov	qword [rbp + -280],	rbx
	mov	r15,	r9
	mov	r10,	qword [rbp + -280]
	mov	rbx,	r10
	mov	r12,	r9
	mov	r10,	qword [rbp + -280]
	add	r12,	r10
	mov	rax,	r12
	mov	r10,	2
	cqo
	idiv	r10
	mov	r12,	rax
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + r12*8]
	mov	r12,	r10
	mov	r13,	r12
_L43_28:
	cmp	r15,	rbx
	setle	al
	movzx	rsi,	al
	mov	r12,	rsi
	cmp	r12,	0
	je	_L43_29
_L45_30:
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + r15*8]
	mov	r12,	r10
	cmp	r12,	r13
	setl	al
	movzx	rsi,	al
	mov	r12,	rsi
	cmp	r12,	0
	je	_L45_31
	add	r15,	1
	jmp	_L45_30
_L45_31:
_L47_32:
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	r12,	r10
	cmp	r12,	r13
	setg	al
	movzx	rsi,	al
	mov	r12,	rsi
	cmp	r12,	0
	je	_L47_33
	sub	rbx,	1
	jmp	_L47_32
_L47_33:
	cmp	r15,	rbx
	setle	al
	movzx	rsi,	al
	mov	r12,	rsi
	cmp	r12,	0
	je	_L52_34
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + r15*8]
	mov	r12,	r10
	mov	r14,	r12
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	r12,	r10
	mov	r10,	qword [_#a# + 0]
	mov	qword [r10 + r15*8],	r12
	mov	r10,	qword [_#a# + 0]
	mov	qword [r10 + rbx*8],	r14
	add	r15,	1
	sub	rbx,	1
_L52_34:
	jmp	_L43_28
_L43_29:
	cmp	r9,	rbx
	setl	al
	movzx	rsi,	al
	mov	r12,	rsi
	cmp	r12,	0
	je	_L54_36
_qsrt#19#:
	mov	qword [rbp + -1520],	r9
	mov	qword [rbp + -1528],	rbx
	mov	r10,	qword [rbp + -1520]
	mov	r12,	r10
	mov	r10,	qword [rbp + -1528]
	mov	rbx,	r10
	mov	r10,	qword [rbp + -1520]
	mov	r13,	r10
	mov	r10,	qword [rbp + -1528]
	add	r13,	r10
	mov	rax,	r13
	mov	r10,	2
	cqo
	idiv	r10
	mov	r13,	rax
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + r13*8]
	mov	r13,	r10
	mov	r14,	r13
_L107_76:
	cmp	r12,	rbx
	setle	al
	movzx	rsi,	al
	mov	r13,	rsi
	cmp	r13,	0
	je	_L107_77
_L109_78:
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + r12*8]
	mov	r13,	r10
	cmp	r13,	r14
	setl	al
	movzx	rsi,	al
	mov	r13,	rsi
	cmp	r13,	0
	je	_L109_79
	add	r12,	1
	jmp	_L109_78
_L109_79:
_L111_80:
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	r13,	r10
	cmp	r13,	r14
	setg	al
	movzx	rsi,	al
	mov	r13,	rsi
	cmp	r13,	0
	je	_L111_81
	sub	rbx,	1
	jmp	_L111_80
_L111_81:
	cmp	r12,	rbx
	setle	al
	movzx	rsi,	al
	mov	r13,	rsi
	cmp	r13,	0
	je	_L116_82
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + r12*8]
	mov	r13,	r10
	mov	r13,	r13
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	r9,	r10
	mov	r10,	qword [_#a# + 0]
	mov	qword [r10 + r12*8],	r9
	mov	r10,	qword [_#a# + 0]
	mov	qword [r10 + rbx*8],	r13
	add	r12,	1
	sub	rbx,	1
_L116_82:
	jmp	_L107_76
_L107_77:
	mov	r10,	qword [rbp + -1520]
	cmp	r10,	rbx
	setl	al
	movzx	rsi,	al
	mov	r13,	rsi
	cmp	r13,	0
	je	_L118_84
	push	rcx
	push	r9
	mov	r10,	qword [rbp + -1520]
	mov	rdi,	r10
	mov	rsi,	rbx
	call	_qsrt
	pop	r9
	pop	rcx
_L118_84:
	mov	r11,	qword [rbp + -1528]
	cmp	r12,	r11
	setl	al
	movzx	rsi,	al
	mov	rbx,	rsi
	cmp	rbx,	0
	je	_L120_86
	push	rcx
	push	r9
	mov	rdi,	r12
	mov	r10,	qword [rbp + -1528]
	mov	rsi,	r10
	call	_qsrt
	pop	r9
	pop	rcx
_L120_86:
	mov	rax,	0
	jmp	___exit#19#_qsrt
___exit#19#_qsrt:
_L54_36:
	mov	r11,	qword [rbp + -280]
	cmp	r15,	r11
	setl	al
	movzx	rsi,	al
	mov	rbx,	rsi
	cmp	rbx,	0
	je	_L56_38
_qsrt#20#:
	mov	r9,	r15
	mov	r10,	qword [rbp + -280]
	mov	qword [rbp + -3192],	r10
	mov	r12,	r9
	mov	r10,	qword [rbp + -3192]
	mov	rbx,	r10
	mov	r13,	r9
	mov	r10,	qword [rbp + -3192]
	add	r13,	r10
	mov	rax,	r13
	mov	r10,	2
	cqo
	idiv	r10
	mov	r13,	rax
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + r13*8]
	mov	r13,	r10
	mov	r14,	r13
_L123_88:
	cmp	r12,	rbx
	setle	al
	movzx	rsi,	al
	mov	r13,	rsi
	cmp	r13,	0
	je	_L123_89
_L125_90:
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + r12*8]
	mov	r13,	r10
	cmp	r13,	r14
	setl	al
	movzx	rsi,	al
	mov	r13,	rsi
	cmp	r13,	0
	je	_L125_91
	add	r12,	1
	jmp	_L125_90
_L125_91:
_L127_92:
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	r13,	r10
	cmp	r13,	r14
	setg	al
	movzx	rsi,	al
	mov	r13,	rsi
	cmp	r13,	0
	je	_L127_93
	sub	rbx,	1
	jmp	_L127_92
_L127_93:
	cmp	r12,	rbx
	setle	al
	movzx	rsi,	al
	mov	r13,	rsi
	cmp	r13,	0
	je	_L132_94
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + r12*8]
	mov	r13,	r10
	mov	r13,	r13
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	r15,	r10
	mov	r10,	qword [_#a# + 0]
	mov	qword [r10 + r12*8],	r15
	mov	r10,	qword [_#a# + 0]
	mov	qword [r10 + rbx*8],	r13
	add	r12,	1
	sub	rbx,	1
_L132_94:
	jmp	_L123_88
_L123_89:
	cmp	r9,	rbx
	setl	al
	movzx	rsi,	al
	mov	r13,	rsi
	cmp	r13,	0
	je	_L134_96
	push	rcx
	push	r9
	mov	rdi,	r9
	mov	rsi,	rbx
	call	_qsrt
	pop	r9
	pop	rcx
_L134_96:
	mov	r11,	qword [rbp + -3192]
	cmp	r12,	r11
	setl	al
	movzx	rsi,	al
	mov	rbx,	rsi
	cmp	rbx,	0
	je	_L136_98
	push	rcx
	push	r9
	mov	rdi,	r12
	mov	r10,	qword [rbp + -3192]
	mov	rsi,	r10
	call	_qsrt
	pop	r9
	pop	rcx
_L136_98:
	mov	rax,	0
	jmp	___exit#20#_qsrt
___exit#20#_qsrt:
_L56_38:
	mov	rax,	0
	jmp	___exit#9#_qsrt
___exit#9#_qsrt:
_L22_12:
	mov	r11,	qword [rbp + -80]
	cmp	rcx,	r11
	setl	al
	movzx	rsi,	al
	mov	rbx,	rsi
	cmp	rbx,	0
	je	_L24_14
_qsrt#10#:
	mov	r13,	rcx
	mov	r10,	qword [rbp + -80]
	mov	qword [rbp + -696],	r10
	mov	r15,	r13
	mov	r10,	qword [rbp + -696]
	mov	rbx,	r10
	mov	r12,	r13
	mov	r10,	qword [rbp + -696]
	add	r12,	r10
	mov	rax,	r12
	mov	r10,	2
	cqo
	idiv	r10
	mov	r12,	rax
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + r12*8]
	mov	r12,	r10
	mov	r12,	r12
_L59_40:
	cmp	r15,	rbx
	setle	al
	movzx	rsi,	al
	mov	r14,	rsi
	cmp	r14,	0
	je	_L59_41
_L61_42:
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + r15*8]
	mov	r14,	r10
	cmp	r14,	r12
	setl	al
	movzx	rsi,	al
	mov	r14,	rsi
	cmp	r14,	0
	je	_L61_43
	add	r15,	1
	jmp	_L61_42
_L61_43:
_L63_44:
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	r14,	r10
	cmp	r14,	r12
	setg	al
	movzx	rsi,	al
	mov	r14,	rsi
	cmp	r14,	0
	je	_L63_45
	sub	rbx,	1
	jmp	_L63_44
_L63_45:
	cmp	r15,	rbx
	setle	al
	movzx	rsi,	al
	mov	r14,	rsi
	cmp	r14,	0
	je	_L68_46
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + r15*8]
	mov	r14,	r10
	mov	rcx,	r14
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	r14,	r10
	mov	r10,	qword [_#a# + 0]
	mov	qword [r10 + r15*8],	r14
	mov	r10,	qword [_#a# + 0]
	mov	qword [r10 + rbx*8],	rcx
	add	r15,	1
	sub	rbx,	1
_L68_46:
	jmp	_L59_40
_L59_41:
	cmp	r13,	rbx
	setl	al
	movzx	rsi,	al
	mov	r12,	rsi
	cmp	r12,	0
	je	_L70_48
_qsrt#21#:
	mov	r9,	r13
	mov	qword [rbp + -6520],	rbx
	mov	r12,	r9
	mov	r10,	qword [rbp + -6520]
	mov	rbx,	r10
	mov	r13,	r9
	mov	r10,	qword [rbp + -6520]
	add	r13,	r10
	mov	rax,	r13
	mov	r10,	2
	cqo
	idiv	r10
	mov	r13,	rax
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + r13*8]
	mov	r13,	r10
	mov	r14,	r13
_L139_100:
	cmp	r12,	rbx
	setle	al
	movzx	rsi,	al
	mov	r13,	rsi
	cmp	r13,	0
	je	_L139_101
_L141_102:
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + r12*8]
	mov	r13,	r10
	cmp	r13,	r14
	setl	al
	movzx	rsi,	al
	mov	r13,	rsi
	cmp	r13,	0
	je	_L141_103
	add	r12,	1
	jmp	_L141_102
_L141_103:
_L143_104:
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	r13,	r10
	cmp	r13,	r14
	setg	al
	movzx	rsi,	al
	mov	r13,	rsi
	cmp	r13,	0
	je	_L143_105
	sub	rbx,	1
	jmp	_L143_104
_L143_105:
	cmp	r12,	rbx
	setle	al
	movzx	rsi,	al
	mov	r13,	rsi
	cmp	r13,	0
	je	_L148_106
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + r12*8]
	mov	r13,	r10
	mov	rcx,	r13
	mov	r10,	qword [_#a# + 0]
	mov	r10,	qword [r10 + rbx*8]
	mov	r13,	r10
	mov	r10,	qword [_#a# + 0]
	mov	qword [r10 + r12*8],	r13
	mov	r10,	qword [_#a# + 0]
	mov	qword [r10 + rbx*8],	rcx
	add	r12,	1
	sub	rbx,	1
_L148_106:
	jmp	_L139_100
_L139_101:
	cmp	r9,	rbx
	setl	al
	movzx	rsi,	al
	mov	r13,	rsi
	cmp	r13,	0
	je	_L150_108
	push	rcx
	push	r9
	mov	rdi,	r9
	mov	rsi,	rbx
	call	_qsrt
	pop	r9
	pop	rcx
_L150_108:
	mov	r11,	qword [rbp + -6520]
	cmp	r12,	r11
	setl	al
	movzx	rsi,	al
	mov	rbx,	rsi
	cmp	rbx,	0
	je	_L152_110
	push	rcx
	push	r9
	mov	rdi,	r12
	mov	r10,	qword [rbp + -6520]
	mov	rsi,	r10
	call	_qsrt
	pop	r9
	pop	rcx
_L152_110:
	mov	rax,	0
	jmp	___exit#21#_qsrt
___exit#21#_qsrt:
_L70_48:
	mov	r11,	qword [rbp + -696]
	cmp	r15,	r11
	setl	al
	movzx	rsi,	al
	mov	rbx,	rsi
	cmp	rbx,	0
	je	_L72_50
	push	rcx
	push	r9
	mov	rdi,	r15
	mov	r10,	qword [rbp + -696]
	mov	rsi,	r10
	call	_qsrt
	pop	r9
	pop	rcx
_L72_50:
	mov	rax,	0
	jmp	___exit#10#_qsrt
___exit#10#_qsrt:
_L24_14:
	mov	rax,	0
	jmp	___exit_qsrt
___exit_qsrt:
	add	rsp,	13128
	pop	r15
	pop	r14
	pop	r13
	pop	r12
	pop	rbx
	pop	rbp
	ret
SECTION .bss
_#a#:	resb	8
_#n#:	resb	8
SECTION .rodata
	dd 1
STR_0:
	db " ", 0
	dd 1
STR_1:
	db 10, 0
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


