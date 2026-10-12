:- set_prolog_flag(double_quotes, chars).
:- use_module(library(clpfd)).

word_square(Vocab, Words) :-
    Words = [First|_],
    member(First, Vocab),
    length(First, N),
    length(Words, N),
    maplist([W]>>member(W, Vocab), Words),
    word_square_(Words).

word_square_([_]).
word_square_([Row|Rows]) :-
    maplist([[H|T], H, T]>>true, [Row|Rows], Col, [_|Rest]),
    Row = Col,
    word_square_(Rest).
