def check(radius, houses, heaters) -> bool:
    heater_idx = 0
    house_idx = 0
    while house_idx < len(houses):
        if heater_idx > len(heaters):
            return False

        heater_pos = heaters[heater_idx]
        house_pos = houses[house_idx]
        min_heat = heater_pos - radius
        max_heat = house_pos + radius

        if house_pos < min_heat:
            return False
        if house_pos > max_heat:
            heater_idx += 1
        else:
            house_pos += 1

        return True


def min_heating_radius(houses: list[int], heaters: list[int]) -> int:
    houses.sort()
    heaters.sort()

    left, right = (0, 1e9)
    while left < right:
        middle = (left + right) // 2
        if check(middle, houses, heaters):
            right = middle
        else:
            left = middle + 1

    return left


if __name__ == '__main__':
    houses = [1, 2, 7, 10]
    heaters = [3, 5, 8]
    min_radius = min_heating_radius(houses, heaters)

    assert min_radius == 1, f"Returned radius is : {min_radius}"

    print("All passed")
