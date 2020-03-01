import java.util.Arrays;

public class SpiralArray {
    class Coordinates {
        int row, column;

        Coordinates(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    int[][] spiral(int n) {
        int[][] spiralMatrix = new int[n][n];
        int elements = n * n;

        Coordinates coord = null;
        Coordinates direction = new Coordinates(0, 1);
        for (int element = 1; element <= elements; element++) {
            //move until facing obstacle, turn right
            coord = move(coord, direction);
            if (facedObstacle(coord, spiralMatrix)) {
                coord = makeAStepBack(coord, direction);
                direction = turnRight(direction);
                coord = move(coord, direction);
            }

            spiralMatrix[coord.row][coord.column] = element;
        }
        return spiralMatrix;
    }

    private Coordinates turnRight(Coordinates direction) {
        if (direction.row == 0 && direction.column == 1) {
            direction.row = 1;
            direction.column = 0;
        } else if (direction.row == 1 && direction.column == 0) {
            direction.row = 0;
            direction.column = -1;
        } else if (direction.row == 0 && direction.column == -1) {
            direction.row = -1;
            direction.column = 0;
        } else if (direction.row == -1 && direction.column == 0) {
            direction.row = 0;
            direction.column = 1;
        }

        return direction;
    }

    private boolean facedObstacle(Coordinates coord, int[][] spiralMatrix) {
        int boundary = spiralMatrix.length -1;
        return coord.row > boundary || coord.column > boundary || coord.row < 0 || coord.column < 0
                || spiralMatrix[coord.row][coord.column] != 0;
    }

    private Coordinates move(Coordinates coord, Coordinates direction) {
        if (coord == null) return new Coordinates(0, 0);

        coord.column += direction.column;
        coord.row += direction.row;

        return coord;
    }

    private Coordinates makeAStepBack(Coordinates coord, Coordinates direction) {
        coord.row -= direction.row;
        coord.column -= direction.column;

        return coord;
    }

    public String toString(int[][] spiralMatrix) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : spiralMatrix) {
            for (int element : row) {
                sb.append(element);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}

class TestCase {

    static void input3() {
        int[][] expected = new int[][] {
                //       0  1  2
                /*0*/   {1, 2, 3},
                /*1*/   {8, 9, 4},
                /*2*/   {7, 6, 5}
        };
        SpiralArray spiralArray = new SpiralArray();
        int[][] actual = spiralArray.spiral(3);

        if (!Arrays.deepEquals(expected, actual)) throw new AssertionError("Input 3 case failed");
    }

    static void input8() {
        int[][] expected = new int[][] {
                {1,   2,  3,  4,  5,  6,  7, 8},
                {28, 29, 30, 31, 32, 33, 34, 9},
                {27, 48, 49, 50, 51, 52, 35, 10},
                {26, 47, 60, 61, 62, 53, 36, 11},
                {25, 46, 59, 64, 63, 54, 37, 12},
                {24, 45, 58, 57, 56, 55, 38, 13},
                {23, 44, 43, 42, 41, 40, 39, 14},
                {22, 21, 20, 19, 18, 17, 16, 15}
        };
        int[][] actual = new SpiralArray().spiral(8);

        if (!Arrays.deepEquals(expected, actual)) throw new AssertionError("Input 3 case failed");
    }

    public static void main(String[] args) {
        input3();
        input8();
        System.out.println("Problem solved.");
    }
}

//Learn of my mistakes:
// if column check bounds to decide direction by changer
//* coding before defining algorithm
//* no method decomposition, all spaghetti code inside one method
//
//            if (spiralMatrix[row][column] == 0) spiralMatrix[row][column] = element;
//            else {
//                columnOrRow = !columnOrRow;
//                if (columnOrRow) {
//                    if (column == 0) changer = 1;
//                    else if (column >= maxIndex) changer = -1;
//                    column +=changer;
//                } else {
//                    if (row == 0) changer = 1;
//                    else if (row >= maxIndex) changer = -1;
//                    row += changer;
//                }
//
//                spiralMatrix[row][column] = element;
//            }
//
//            if (columnOrRow && column >= maxIndex) {
//                columnOrRow = false;
//            } else if (!columnOrRow && row >= maxIndex) {
//                columnOrRow = true;
////                if (column >= maxIndex) changer = -1;
//            }
//
//            if (columnOrRow) column += changer;
//            else row += changer;

//naive hard codding
//* coding before defining algorithm
//* no method decomposition, all spaghetti code inside one method
//* coding a specific, simple example
//
//            System.out.printf("[%d][%d]=%d\n", row, column, element);
//            if (row != 0 && spiralMatrix[row - 1][column] != 0) {
//                ++column;
//            } else if (row + 1 >= spiralMatrix.length && column == 0) {
//                --row;
//            } else if (row + 1 >= spiralMatrix.length) {
//                --column;
//            } else if (column + 1 >= spiralMatrix[row].length) {
//                ++row;
//            } else ++column;