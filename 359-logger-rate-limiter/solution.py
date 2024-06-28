class Logger:
    buffer = {}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        maybe_timestamp = self.buffer.get(message)
        if not maybe_timestamp or maybe_timestamp + 10 <= timestamp:
            self.buffer[message] = timestamp
            return True
        return False


if __name__ == '__main__':
    logger = Logger()
    input_params = [
        [1, "foo"], [2, "bar"], [3, "foo"], [8, "bar"], [10, "foo"], [11, "foo"]
    ]
    results = [True, True, False, False, False, True]

    for params, expected_result in zip(input_params, results):
        actual_result = logger.shouldPrintMessage(*params)
        assert expected_result == actual_result, f"{params} expected to be printed: {expected_result}"

    print("All passed")


