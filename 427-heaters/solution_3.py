def min_heating_radius(houses: list[int], heaters: list[int]) -> int:
    houses.sort()
    heaters.sort()

    heater_idx = 0
    min_radius = 0
    for house in houses:
        while (
                min_radius is not None and
                heater_idx + 1 < len(heaters) and abs(house - heaters[heater_idx + 1]) <= abs(
            house - heaters[heater_idx])
        ):
            heater_idx += 1

        heater = heaters[heater_idx]
        min_radius = max(abs(house - heater), min_radius) if min_radius is not None else abs(house - heater)

    return min_radius


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

    houses = [1, 3, 5, 7]
    heaters = [4]
    min_radius = min_heating_radius(houses, heaters)

    assert min_radius == 3, f"Returned radius is : {min_radius}"

    houses = [1, 3, 5, 7]
    heaters = [0]
    min_radius = min_heating_radius(houses, heaters)

    assert min_radius == 7, f"Returned radius is : {min_radius}"

    houses = [1, 3, 5, 7]
    heaters = []
    min_radius = min_heating_radius(houses, heaters)

    assert min_radius == -1, f"Returned radius is : {min_radius}"

    houses = [1, 2, 3]
    heaters = [1, 2, 3]
    min_radius = min_heating_radius(houses, heaters)

    assert min_radius == 0, f"Returned radius is : {min_radius}"

    houses = [1, 2, 3, 4]
    heaters = [1, 4]
    min_radius = min_heating_radius(houses, heaters)

    assert min_radius == 1, f"Returned radius is : {min_radius}"

    houses = [1, 1, 1, 1, 1, 1, 999, 999, 999, 999, 999]
    heaters = [499, 500, 501]
    min_radius = min_heating_radius(houses, heaters)

    assert min_radius == 498, f"Returned radius is : {min_radius}"

    print("All passed")
