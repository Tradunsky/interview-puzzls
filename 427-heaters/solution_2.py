import sys


def min_heating_radius(houses: list[int], heaters: list[int]) -> int:
    max_radius = 0
    for house in houses:
        min_radius = sys.maxsize
        for heater in heaters:
            min_radius = min(abs(house - heater), min_radius)
        max_radius = max(max_radius, min_radius)

    return max_radius


if __name__ == '__main__':
    houses = [1, 2, 7, 10]
    heaters = [3, 5, 8]
    min_radius = min_heating_radius(houses, heaters)

    assert min_radius == 2, f"Returned radius is : {min_radius}"

    houses = [1, 3, 5, 7]
    heaters = [2, 4, 6]
    min_radius = min_heating_radius(houses, heaters)

    assert min_radius == 1, f"Returned radius is : {min_radius}"

    houses = [1, 3, 5, 7]
    heaters = [2, 6]
    min_radius = min_heating_radius(houses, heaters)

    assert min_radius == 1, f"Returned radius is : {min_radius}"

    houses = [1, 3, 5, 7]
    heaters = [8]
    min_radius = min_heating_radius(houses, heaters)

    assert min_radius == 7, f"Returned radius is : {min_radius}"

    print("All passed")
