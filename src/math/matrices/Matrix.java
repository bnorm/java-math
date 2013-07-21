package math.matrices;

/**
 * The object representation of a mathematical matrix.  This class provides an implementation for basic use.  This is
 * <em>not</em> a safe matrix. It does not perform any dimension checks before performing any actions.
 *
 * @author Brian Norman
 * @version 0.1 beta
 */
public class Matrix implements IMatrix {

   /**
    * The primitive representation of the matrix. It is an array of rows which are also arrays.
    */
   private double[][] matrix;

   /**
    * The number of rows that are in this matrix.
    */
   private int rows;

   /**
    * The number of columns that are in this matrix.
    */
   private int columns;

   /**
    * Creates a new matrix with no values and of size zero.
    */
   public Matrix() {
      this(new double[0][0]);
   }

   /**
    * Creates a new matrix of the specified size and with all values equaling zero.
    *
    * @param rows the number of rows in this matrix.
    * @param columns the number of columns in this matrix.
    */
   public Matrix(int rows, int columns) {
      this(new double[rows][columns]);
   }

   /**
    * Creates a new matrix with the specified array as a base.  If the resulting matrix is modified the original matrix
    * will change as well.
    *
    * @param a the base array of the matrix.
    */
   public Matrix(double[][] a) {
      set(a);
   }

   /**
    * Creates a new matrix that is a copy of the specified matrix.
    *
    * @param a the matrix to copy.
    */
   protected Matrix(IMatrix a) {
      double[][] m = new double[a.rows()][a.columns()];
      for (int i = 0; i < a.rows(); i++) {
         for (int j = 0; j < a.columns(); j++) {
            m[i][j] = a.get(i, j);
         }
      }
      set(m);
   }

   @Override
   public int rows() {
      return rows;
   }

   @Override
   public int columns() {
      return columns;
   }

   @Override
   public Matrix set(double[][] a) {
      rows = a.length;
      columns = (rows == 0 ? 0 : a[0].length);
      matrix = a;
      return this;
   }

   @Override
   public double get(int r, int c) {
      return matrix[r][c];
   }

   @Override
   public Matrix set(int r, int c, double n) {
      matrix[r][c] = n;
      return this;
   }

   @Override
   public Matrix setRow(int r, double[] v) {
      return (Matrix) IMatrix.super.setRow(r, v);
   }

   @Override
   public Matrix setColumn(int c, double[] v) {
      return (Matrix) IMatrix.super.setColumn(c, v);
   }

   @Override
   public Matrix set(int r, int c, double[][] a) {
      return (Matrix) IMatrix.super.set(r, c, a);
   }

   @Override
   public Matrix transpose() {
      return (Matrix) IMatrix.super.transpose();
   }

   @Override
   public Matrix inverse() {
      return (Matrix) IMatrix.super.inverse();
   }

   @Override
   public Matrix scale(double n) {
      return (Matrix) IMatrix.super.scale(n);
   }

   @Override
   public Matrix add(IMatrix a) {
      return (Matrix) IMatrix.super.add(a);
   }

   @Override
   public Matrix subtract(IMatrix a) {
      return (Matrix) IMatrix.super.subtract(a);
   }

   @Override
   public Matrix multiply(IMatrix a) {
      return (Matrix) IMatrix.super.multiply(a);
   }

   @Override
   public Matrix dotMultiply(IMatrix a) {
      return (Matrix) IMatrix.super.dotMultiply(a);
   }

   @Override
   public Matrix dotDivide(IMatrix a) {
      return (Matrix) IMatrix.super.dotDivide(a);
   }

   @Override
   public Matrix copy() {
      return new Matrix(this);
   }
}
