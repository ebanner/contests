:- set_prolog_flag(double_quotes, chars).

word(W) :- member(W, ["HEART", "TREND", "EMBER", "RESIN", "ABUSE"]).

word_square(W1, W2, W3, W4, W5) :-
    word(W1),
    word(W2),
    word(W3),
    word(W4),
    word(W5),

    W1 = [A, B, C, D, E],
    W2 = [F, G, H, I, J],
    W3 = [K, L, M, N, O],
    W4 = [P, Q, R, S, T],
    W5 = [U, V, W, X, Y],

    A = A,
    B = F,
    C = K,
    D = P,
    E = U,

    F = B,
    G = G,
    H = L,
    I = Q,
    J = V,

    K = C,
    L = H,
    M = M,
    N = R,
    O = W,

    P = D,
    Q = I,
    R = N,
    S = S,
    T = X,

    U = E,
    V = J,
    W = O,
    X = T,
    Y = Y.
