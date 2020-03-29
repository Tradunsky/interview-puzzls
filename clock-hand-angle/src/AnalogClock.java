import java.text.MessageFormat;

public class AnalogClock {
    //angle for 1 min step  (degree in circle/max number of minutes in circle)
    static float ONE_MIN_ANGLE = 360f / 60; //6
    //angle for 1 hour step  (degree in circle/max number of hours in circle)/minutes in circle
    static float ONE_HOUR_ANGLE = (360f / 12) / 60; //0.5

    public float minimalAngleBetween(int hour, int minute) {
        //corner case of 12:60
        if (hour == 12) hour = 0;
        if (minute == 60) minute = 0;

        //convert hour to minute
//        float hourMin = hour * 60; //original task
        float hourMin = hour * 60 + minute;
        //hourAngle = hour_min * angle of 1 hour
        float hourAngle = hourMin * ONE_HOUR_ANGLE;
        //minuteAngle = minute_min * angle of 1 min
        float minAngle = minute * ONE_MIN_ANGLE;

        float angle = Math.abs(hourAngle - minAngle);

        return Math.min(360 - angle, angle);
    }
}

class TestCases {
    static void runTest(int[][] input, float[] expectedAngles) {
        AnalogClock clock = new AnalogClock();
        for (int testCase = 0; testCase < input.length; testCase++) {
            int hour = input[testCase][0], minute = input[testCase][1];
            float expectedAngle = expectedAngles[testCase];

            float angle = clock.minimalAngleBetween(hour, minute);
            if (angle != expectedAngle)
                throw new AssertionError(MessageFormat.format("Wrong angle {3}. {0}:{1}={2}", hour, minute, expectedAngle, angle));
        }
    }

    public static void main(String[] args) {
        int[][] testCases = new int[][]{
                {3, 20},
                {9, 35},
                {12, 60},
                {10, 00}
        };
        float[] expectedAngle = new float[]{
                20f,
                77.5f,
                0f,
                60f
        };

        runTest(testCases, expectedAngle);

        System.out.println("Problem solved!");
    }
}