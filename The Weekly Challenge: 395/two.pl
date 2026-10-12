:- set_prolog_flag(double_quotes, chars).

letter(C) :- member(C, "ABCDEFGHIJKLMNOPQRSTUVWXYZ").

word_square([[X, Y],
             [Y, X]]) :-
    letter(X),
    letter(Y).

