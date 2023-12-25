import math


def euclidian_distance(q: tuple[float, float], p: tuple[float, float]) -> float:
    return math.sqrt(math.pow(q[0] - p[0], 2) + math.pow(q[1] - p[1], 2))


def nearest_neighbors(v: list[tuple[float, float]], k: int, p: tuple[float, float]) -> list[tuple[float, float]]:
    if k < 1:
        return []

    # O(n)
    distance_points = []
    for point in v:
        distance = euclidian_distance(point, p)
        distance_points.append((distance, point))

    # O(n log n)
    distance_points.sort(key=lambda x: x[0])
    # O(k)
    return [d[1] for d in distance_points[:k]]


if __name__ == '__main__':
    test_cases = [
        dict(
            v=[(9, 1), (3, 7), (0, -1), (2, 3)],
            k=2,
            p=(1.1, -1.1),
            expected_output=[(0, -1), (2, 3)]
        ),
        dict(
            v=[(9, 1), (3, 7), (0, -1), (2, 3)],
            k=5,
            p=(1.1, -1.1),
            expected_output=[(0, -1), (2, 3), (9, 1), (3, 7)]
        ),
        dict(
            v=[(9, 1), (3, 7), (0, -1), (2, 3)],
            k=1,
            p=(1.1, -1.1),
            expected_output=[(0, -1)]
        ),
        dict(
            v=[],
            k=1,
            p=(1.1, -1.1),
            expected_output=[]
        ),
        dict(
            v=[(9, 1), (3, 7), (0, -1), (2, 3)],
            k=0,
            p=(1.1, -1.1),
            expected_output=[]
        )
    ]

    for test_case in test_cases:
        v, k, p, expected_output = test_case.values()
        assert len(v) >= len(expected_output) and k > -1, "Invalid test case"

        actual_output = nearest_neighbors(v, k, p)
        assert actual_output == expected_output, ("Invalid solution:\n"
                                                  f"Actual:   {actual_output}\n"
                                                  f"Expected: {expected_output}\n")
