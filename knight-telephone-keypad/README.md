Given knight that makes moves on a telephone keypad, like this:
```
| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |
| _ | 0 | _ |
```
given number hops/moves "h", you need to output all permutations of possible moves of a knight from the given position "p".

For example,
A knight at the position p=0 and number of moves h=1 have the following possible moves:
```
p=0, h=1
['04', '06']

p=0, h=2
['040', '043', '049', '060', '061', '067']

p=0, h=3
['0404', '0406', '0434', '0438', '0492', '0494', '0604', '0606', '0616', '0618', '0672', '0676']
```

You can assume a data structure is given that given current position returns th next possible moves of the knight on the telephone keypad:
```
next_move_after[0] returns [4, 6]
next_move_after[4] returns [0, 3, 9]
```