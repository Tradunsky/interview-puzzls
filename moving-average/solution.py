class MovingAverage:
    def __init__(self, window_size: int):
        self.window_size = window_size
        self.window = list()

    def next(self, element: int | float) -> float:
        if len(self.window) == self.window_size:
            self.window.pop(0)
        self.window.append(element)

        return sum(self.window) / len(self.window)


if __name__ == '__main__':
    m = MovingAverage(3)
    assert m.next(1) == 1
    assert m.next(10) == (1 + 10) / 2
    assert m.next(3) == (1 + 10 + 3) / 3
    assert m.next(5) == (10 + 3 + 5) / 3

    print("All passed")