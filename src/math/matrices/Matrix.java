package math.matrices;

/**
 * The object representation of a mathematical matrix. This class provides an
 * implementation for basic use. This is <em>not</em> a safe matrix. It does not
 * perform any dimension checks before performing any actions.
 *
 * @author Brian Norman
 * @version 0.1 beta
 */
public class Matrix implements IMatrix {

   // ****************** //
   // ***** FIELDS ***** //
   // ****************** //

   /**
    * The primitive representation of the matrix. It is an array of rows which
    * are also arrays.
    */
   private double[][] matrix;

   /**
    * The number of rows that are in this matrix.
    */
   private int        rows;

   /**
    * The number of columns that are in this matrix.
    */
   private int        columns;

   // ************************ //
   // ***** CONSTRUCTORS ***** //
   // ************************ //

   /**
    * Creates a new matrix with no values and of size zero.
    */
   public Matrix() {
      this(new double[0][0]);
   }

   /**
    * Creates a new matrix of the specified size and with all values equaling
    * zero.
    *
    * @param rows
    *           the number of rows in this matrix.
    * @param columns
    *           the number of columns in this matrix.
    */
   public Matrix(int rows, int columns) {
      this(new double[rows][columns]);
   }

   /**
    * Creates a new matrix with the specified array as a base. If the resulting
    * matrix is modified the original matrix will change as well.
    * 
    * @param a
    *           the base array of the matrix.
    */
   public Matrix(double[][] a) {
      set(a);
   }

   /**
    * Creates a new matrix that is a copy of the specified matrix.
    * 
    * @param a
    *           the matrix to copy.
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

   // ************************** //
   // ***** ACCESS METHODS ***** //
   // ************************** //

   /**
    * {@inheritDoc}
    */
   @Override
   public int rows() {
      return rows;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public int columns() {
      return columns;
   }

   /**
    * {@inheritDoc}
    * 
    * Unsafe method, does not perform dimension checks.
    */
   @Override
   public double get(int row, int column) {
      return matrix[row][column];
   }

   /**
    * {@inheritDoc}
    * 
    * Unsafe method, does not perform dimension checks.
    */
   @Override
   public double[] getRow(int row) {
      double[] v = new double[columns()];
      for (int i = 0; i < columns(); i++) {
         v[i] = get(row, i);
      }
      return v;
   }

   /**
    * {@inheritDoc}
    * 
    * Unsafe method, does not perform dimension checks.
    */
   @Override
   public double[] getColumn(int column) {
      double[] v = new double[rows()];
      for (int i = 0; i < rows(); i++) {
         v[i] = get(i, column);
      }
      return v;
   }

   // ******************************** //
   // ***** MANIPULATION METHODS ***** //
   // ******************************** //

   // /**
   // * Sets the matrix to be equal to the specified matrix. This method does
   // not
   // * copy but sets the array which will change if the matrix is modified.
   // *
   // * @param a
   // * the new matrix for the matrix.
   // * @return the matrix representation of the array.
   // */
   // protected Matrix set(Matrix a) {
   // return set(a.matrix);
   // }

   /**
    * {@inheritDoc}
    */
   @Override
   public Matrix set(double[][] a) {
      rows = a.length;
      columns = (rows == 0 ? 0 : a[0].length);
      matrix = a;
      return this;
   }

   /**
    * {@inheritDoc}
    * 
    * Unsafe method, does not perform dimension checks.
    */
   @Override
   public Matrix set(int row, int column, double n) {
      matrix[row][column] = n;
      return this;
   }

   /**
    * {@inheritDoc}
    * 
    * Unsafe method, does not perform dimension checks.
    */
   @Override
   public Matrix setRow(int r, double[] v) {
      for (int i = 0; i < columns; i++) {
         // matrix[r][i] = v[i];
         set(r, i, v[i]);
      }
      return this;
   }

   /**
    * {@inheritDoc}
    * 
    * Unsafe method, does not perform dimension checks.
    */
   @Override
   public Matrix setColumn(int c, double[] v) {
      for (int i = 0; i < rows; i++) {
         // matrix[i][c] = v[i];
         set(i, c, v[i]);
      }
      return this;
   }

   /**
    * {@inheritDoc}
    * 
    * Unsafe method, does not perform dimension checks.
    */
   @Override
   public Matrix set(int r, int c, double[][] a) {
      for (int i = 0; i < a.length; i++) {
         for (int j = 0; j < a[0].length; j++) {
            // matrix[r + i][c + j] = a[i][j];
            set(r + i, c + j, a[i][j]);
         }
      }
      return this;
   }

   // ***************************** //
   // ***** OPERATION METHODS ***** //
   // ***************************** //

   /**
    * {@inheritDoc}
    */
   @Override
   public Matrix transpose() {
      double[][] transpose = new double[columns()][rows()];
      for (int i = 0; i < columns(); i++) {
         for (int j = 0; j < rows(); j++) {
            // transpose[i][j] = matrix[j][i];
            transpose[i][j] = get(j, i);
         }
      }
      return set(transpose);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public Matrix inverse() {
      throw new RuntimeException("Method not implemented.");
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public Matrix scale(double a) {
      for (int i = 0; i < rows(); i++) {
         for (int j = 0; j < columns(); j++) {
            // matrix[i][j] = a * matrix[i][j];
            set(i, j, a * get(i, j));
         }
      }
      return this;
   }

   /**
    * {@inheritDoc}
    * 
    * Unsafe method, does not perform dimension checks.
    */
   @Override
   public Matrix add(IMatrix a) {
      for (int i = 0; i < rows(); i++) {
         for (int j = 0; j < columns(); j++) {
            // matrix[i][j] += a.get(i, j);
            set(i, j, get(i, j) + a.get(i, j));
         }
      }
      return this;
   }

   /**
    * {@inheritDoc}
    * 
    * Unsafe method, does not perform dimension checks.
    */
   @Override
   public Matrix subtract(IMatrix a) {
      for (int i = 0; i < rows(); i++) {
         for (int j = 0; j < columns(); j++) {
            // matrix[i][j] -= a.get(i, j);
            set(i, j, get(i, j) - a.get(i, j));
         }
      }
      return this;
   }

   /**
    * {@inheritDoc}
    * 
    * Unsafe method, does not perform dimension checks.
    */
   @Override
   public Matrix multiply(IMatrix a) {
      double[][] c = new double[rows()][a.columns()];
      for (int i = 0; i < rows(); i++) {
         for (int j = 0; j < a.columns(); j++) {
            double sum = 0;
            for (int k = 0; k < a.rows(); k++) {
               // sum += matrix[i][k] * a.get(k, j);
               sum += get(i, k) * a.get(k, j);
            }
            c[i][j] = sum;
         }
      }
      return set(c);
   }

   /**
    * {@inheritDoc}
    * 
    * Unsafe method, does not perform dimension checks.
    */
   @Override
   public Matrix dotMultiply(IMatrix a) {
      for (int i = 0; i < rows(); i++) {
         for (int j = 0; j < columns(); j++) {
            // matrix[i][j] *= a.get(i, j);
            set(i, j, get(i, j) * a.get(i, j));
         }
      }
      return this;
   }

   /**
    * {@inheritDoc}
    * 
    * Unsafe method, does not perform dimension checks.
    */
   @Override
   public Matrix dotDivide(IMatrix a) {
      for (int i = 0; i < rows(); i++) {
         for (int j = 0; j < columns(); j++) {
            // matrix[i][j] /= a.get(i, j);
            set(i, j, get(i, j) / a.get(i, j));
         }
      }
      return this;
   }

   // *************************** //
   // ***** UTILITY METHODS ***** //
   // *************************** //

   /**
    * {@inheritDoc}
    */
   @Override
   public Matrix copy() {
      return new Matrix(this);
   }

}
