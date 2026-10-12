num ← ⍎ ⇔ ⍕

⍎ '1j_2'

num ← {j./ ⍎¨ '+' cut † ⍵} ⇔ {'i' ,⍨ '+' joinstring ⍕˝ +. ⍵}

'0+3i' ×⍢num '0+4i'

'1j2' +⍢⍎ '3j4'

1j1 × 1j1
