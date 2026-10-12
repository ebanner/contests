:- set_prolog_flag(double_quotes, chars).

:- use_module(library(clpfd)).

word(W) :- member(W, ["MA", "AM", "MY", "ME"]).

word_square(Ws) :-
    Ws = [First|_],
    word(First),
    length(First, N),
    length(Ws, N),
    maplist(word, Ws),
    word_square_(Ws).

word_square_([_]).
word_square_([Row|Rows]) :-
    maplist([[H|T], H, T]>>true, [Row|Rows], Col, [_|Rest]),
    Row = Col,
    word_square_(Rest).
