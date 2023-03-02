package src.App;

public class Matrix {
    public double[][] matrix;

    public Matrix(double gmatrix[][]){
        matrix = gmatrix;
    }
    public Matrix multiplyMatricies(Matrix gm){

        double [][] gmatrix = gm.matrix;

        /*
            Making the resultant matrix
         */
        double result[][] = new double[gmatrix.length][gmatrix[0].length];
        for(double row[] : result){
            for(double gdata : row){
                gdata = 0;
            }
        }

        /*
            Calculating the values for the matrix
         */
        for(int i = 0; i<matrix.length; i++){
            for(int ii = 0; ii<gmatrix[0].length; ii++){
                for(int iii = 0; iii<gmatrix.length; iii++){
                    result[i][ii] += matrix[i][iii] * gmatrix[iii][ii];
                }
            }
        }
        return new Matrix(result);
    }

    public void printMatrix(){
        for(double row[]:matrix){
            for(double col: row){
                System.out.println(col);
            }
            System.out.println("");
        }
    }
}
