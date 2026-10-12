:- set_prolog_flag(double_quotes, chars).

word(W) :- member(W, ["CARD", "AREA", "REAR", "DART"]).

word_square(W1, W2, W3, W4) :-
    word(W1),
    word(W2),
    word(W3),
    word(W4),

    W1 = [A, B, C, D],
    W2 = [E, F, G, H],
    W3 = [I, J, K, L],
    W4 = [M, N, O, P],

    A = A,
    B = E,
    C = I,
    D = M,

    E = B,
    F = F,
    G = J,
    H = N,

    I = C,
    J = G,
    K = K,
    L = O,

    M = D,
    N = H,
    O = L,
    P = P.
