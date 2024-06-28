from dataclasses import dataclass
from typing import Union


@dataclass
class TreeNode:
    val: int
    left: Union["TreeNode", None] = None
    right: Union["TreeNode", None] = None


def min_moves_to_balance_coins_to_one(root: TreeNode) -> int:
    #      (4)
    #   (0)  (0)
    #      (0)

    #      (3)
    #   (0)  (1)
    #      (0)

    #      (3)
    #   (0)  (0)
    #      (1)
    # mc ==2

    #      (2)
    #   (0)  (1)
    #      (1)
    # mc ==3

    #      (1)
    #   (1)  (1)
    #      (1)
    # mc ==4
    def dfs(node: TreeNode | None, moves_count: int) -> [int, int]:
        if node == None:
            return 0, 0

        left_balance, mc_left = dfs(node.left, moves_count)
        right_balance, mc_right = dfs(node.right, moves_count)

        moves_count += mc_left + mc_right
        moves_count += abs(left_balance) + abs(right_balance)

        return left_balance + right_balance + node.val - 1, moves_count

    return dfs(root, 0)[1]


if __name__ == '__main__':
    root = TreeNode(
        left=TreeNode(val=0),
        right=TreeNode(val=0, left=TreeNode(val=0)),
        val=4,
    )
    mc = min_moves_to_balance_coins_to_one(root)
    assert mc == 4, f"Moves count: {mc}"
    print("All tests passed")
