:- set_prolog_flag(double_quotes, chars).

letter(C) :- member(C, "ABCDEFGHIJKLMNOPQRSTUVWXYZ").

word_square(W1, W2) :-
    W1 = [A, B],
    W2 = [C, D],
    letter(A),
    letter(B),
    letter(C),
    letter(D),
    A = A,
    B = C,
    C = B,
    D = D.
