# I think I did not understand, not it being clarified if that is ok to use list as vector?
# I simply used lists originally, but here making it a dedicated data structure.

class Vector:

    def __init__(self, *args: float | int):
        self._elements: list[float | int] = list(args)

    def size(self):
        return len(self._elements)

    def __getitem__(self, index):
        return self._elements[index]

    def dot_product(self, vector: "Vector"):
        if self.size() != vector.size():
            raise ValueError("Vectors must be the same size")

        dot_sum = 0
        for n in range(self.size()):
            a = self[n]
            b = vector[n]
            if a != 0 and b != 0:
                dot_sum += a * b

        return dot_sum


if __name__ == '__main__':
    assert Vector(1, 2, 3, 4, 5).dot_product(Vector(6, 7, 8, 9, 0)) == 80
    assert Vector(1, 2, 3, 4, 5, 0, 0, 0, 0).dot_product(Vector(0, 0, 0, 0, 0, 6, 7, 9, 10)) == 0
