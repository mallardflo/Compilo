; entete
extrn lirent:proc, ecrent:proc, ecrbool:proc, ecrch:proc, ligsuiv:proc
.model SMALL
.586

.CODE
debut:
STARTUPCODE
; ouvbloc 8
enter 8,0
; ecrireChaine "n="
.DATA
mess0 DB "n=$"
.CODE
lea dx,mess0
push dx
call ecrch
; lireEnt -6
lea dx,[bp-6]
push dx
call lirent
; iconst 1
push word ptr 1
; istore -4
pop ax
mov word ptr [bp-4],ax
; iconst 0
push word ptr 0
; istore -2
pop ax
mov word ptr [bp-2],ax
FAIRE1:
; iload -4
push word ptr [bp-4]
; iload -6
push word ptr [bp-6]
; iinfegal
pop bx
pop ax
cmp ax,bx
jg $+6
push -1
jmp $+4
push 0
; iffaux FAIT1
pop ax
cmp ax,0
je FAIT1
; iload -2
push word ptr [bp-2]
; iload -4
push word ptr [bp-4]
; iadd
pop bx
pop ax
add ax,bx
push ax
; istore -2
pop ax
mov word ptr [bp-2],ax
; iload -4
push word ptr [bp-4]
; iconst 1
push word ptr 1
; iadd
pop bx
pop ax
add ax,bx
push ax
; istore -4
pop ax
mov word ptr [bp-4],ax
FAIRE2:
; iload -8
push word ptr [bp-8]
; iconst 10
push word ptr 10
; iinf
pop bx
pop ax
cmp ax,bx
jge $+6
push -1
jmp $+4
push 0
; iffaux FAIT2
pop ax
cmp ax,0
je FAIT2
; iload -8
push word ptr [bp-8]
; iconst 1
push word ptr 1
; iadd
pop bx
pop ax
add ax,bx
push ax
; istore -8
pop ax
mov word ptr [bp-8],ax
;goto FAIRE2
jmp FAIRE2

FAIT2:
; aLaLigne
call ligsuiv
; ecrireChaine "m="
.DATA
mess1 DB "m=$"
.CODE
lea dx,mess1
push dx
call ecrch
; iload -8
push word ptr [bp-8]
; ecrireEnt
call ecrent
;goto FAIRE1
jmp FAIRE1

FAIT1:
; aLaLigne
call ligsuiv
; ecrireChaine "s="
.DATA
mess2 DB "s=$"
.CODE
lea dx,mess2
push dx
call ecrch
; iload -2
push word ptr [bp-2]
; ecrireEnt
call ecrent
; queue
nop
EXITCODE
end debut
