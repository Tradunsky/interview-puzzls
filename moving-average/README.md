346. Moving Average from Data Stream
Problem Description
In the given problem, we are required to calculate the moving average of a stream of integers with a specified window size. The moving average is simply the average of the most recent size numbers in the stream; as a new number comes in, the oldest number in the window gets removed.

To solve this, we create a class MovingAverage that accomplishes two tasks:

It initializes the window with a specific size, and to track the numbers within the window, it stores them in an array.

It calculates the next average each time a new value is added to the window. If the window is full, it replaces the oldest number with the new value. If the window has not yet filled to its specified size, it simply adds the new value.

The result is that at any given time, we can obtain the moving average of the last size elements, efficiently and without having to sum the entire set of values each time.


346. Moving Average from Data Stream
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Example:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3