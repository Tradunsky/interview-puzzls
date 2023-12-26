
"""
| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |
| _ | 0 | _ |
"""
next_move_after = [
    [4, 6], #0
    [6, 8], #1
    [7, 9], #2
    [4, 8], #3
    [0, 3, 9], #4
    [], #5
    [0, 1, 7], #6
    [2, 6], #7
    [1, 3], #8
    [2, 4], #9
]


def possible_knight_moves(p: int, h: int) -> list[str]:
    if h <= 0:
        return []

    chain = [str(p)]

    for ch in range(h):  # O(h)
        print("ch", ch)
        print("start chain:", chain)

        new_chain = []
        for prefix in chain:  # O(2^h)
            current_move = int(prefix[-1])  # 0

            moves_from_current = next_move_after[current_move]  # [4, 6]

            print("moves_so_far:", prefix)
            print("moves_from_current:", moves_from_current)
            for m in moves_from_current:
                new_chain.append(f"{prefix}{m}")
            print("new chain:", new_chain)
        chain = new_chain

        if not chain:
            break

    return chain


def possible_knight_moves1(p: int, h: int) -> list[str]:
    chain = [[p]]
    ch = 0
    while ch != h:
        print("ch", ch)
        print("start chain:", chain)
        ch += 1

        new_chain = []
        for moves_so_far in chain:
            current_move = moves_so_far[-1]  # 0

            moves_from_current = next_move_after[current_move]  # [4, 6]

            print("moves_so_far:", moves_so_far)
            print("moves_from_current:", moves_from_current)
            for m in moves_from_current:
                prefix = moves_so_far.copy()
                prefix.append(m)
                new_chain.append(prefix)
            print("end chain:", chain)
        chain = new_chain

    return ["".join(map(str, c)) for c in chain]


if __name__ == '__main__':
    test_cases = [
        dict(p=0, h=1, expected_output=['04', '06']),
        dict(p=0, h=2, expected_output=['040', '043', '049', '060', '061', '067']),
        dict(p=0, h=3, expected_output=['0404', '0406', '0434', '0438', '0492', '0494', '0604', '0606', '0616', '0618', '0672', '0676']),
        dict(p=5, h=100, expected_output=[]),
        dict(p=0, h=-1, expected_output=[]),
    ]

    for test_case in test_cases:
        p, h, expected_output = test_case.values()
        print("Test case:", test_case)

        actual_output = possible_knight_moves(p=p, h=h)
        assert actual_output == expected_output, ("Invalid solution:\n"
                                                  f"Actual:   {actual_output}\n"
                                                  f"Expected: {expected_output}\n")
        print("=====")
