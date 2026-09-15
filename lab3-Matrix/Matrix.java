import java.util.*;

public class Matrix {
    private int[][] data;
    private int rows;
    private int cols;

    public Matrix(int rows, int cols) {
        this.data = new int[rows][cols];
        this.rows = rows;
        this.cols = cols;
    }

    public Matrix(int[][] data) {
        this.data = data;
        this.rows = data.length;
        this.cols = data[0].length;
    }

    public void populateRandom() {
        for (int i = 0; i < data.length; i++) {
            for(int j = 0; j < data[i].length; j++) {
                data[i][j] = (int) ((Math.random() * 10) + 1);
            }
        }
    }

    public Matrix add(Matrix other) {
        if ((this.data.length == other.data.length) && (this.data[0].length == other.data[0].length)) {
            Matrix newData = new Matrix(rows, cols);

            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[0].length; j++) {
                    newData.data[i][j] = data[i][j] + other.data[i][j];
                }
            }

            return newData;
        } else {
            throw new IllegalArgumentException("Sowwy, both rows and columns of both matrices have to be equal :(");
        }
    }

    public Matrix multiply(Matrix other) {
        if (data[0].length == other.data.length) {
            Matrix newData = new Matrix(this.data.length, other.data[0].length);
            int sum = 0;

            for (int row = 0; row < newData.data.length; row++) {
                for (int col = 0; col < newData.data[0].length; col++) {

                    //Multiplying loop
                    for (int k = 0; k < this.data[0].length; k++) {
                        sum += this.data[row][k] * other.data[k][col];
                    }

                    newData.data[row][col] = sum;

                    sum = 0;
                }
            }

            return newData;
        } else {
            throw new IllegalArgumentException("Sowwy matrix 1's columns don't equal matrix 2's rows");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                sb.append(data[i][j]);

                //tab for better format
                sb.append("\t");
            }

                sb.append("\n"); 
            }

            return sb.toString();
    }
}