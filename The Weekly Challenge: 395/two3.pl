:- set_prolog_flag(double_quotes, chars).

word(W) :- member(W, ["MA", "AM", "MY", "ME"]).

word_square(W1, W2) :-
    word(W1),
    word(W2),
    W1 = [A, B],
    W2 = [C, D],
    A = A,
    B = C,
    C = B,
    D = D.
