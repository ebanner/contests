:- set_prolog_flag(double_quotes, chars).

word(W) :- member(W, ["SUN", "USE", "NET", "SEE", "TEN"]).

word_square(W1, W2, W3) :-
    word(W1),
    word(W2),
    word(W3),

    W1 = [A, B, C],
    W2 = [D, E, F],
    W3 = [G, H, I],

    A = A,
    B = D,
    C = G,

    D = B,
    E = E,
    F = H,

    G = C,
    H = F,
    I = I.
