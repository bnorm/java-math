package math.matrices;

/**
 * The object representation of a mathematical matrix. This class provides an
 * implementation for basic use. This <em>is</em> a safe matrix. It performs
 * dimension checks before performing every actions.
 * 
 * @author Brian Norman
 * @version 0.1 beta
 */
public class SafeMatrix extends Matrix {

   // ************************ //
   // ***** CONSTRUCTORS ***** //
   // ************************ //

   /**
    * Creates a new safe matrix with no values and of size zero.
    */
   public SafeMatrix() {
      super();
   }

   /**
    * Creates a new safe matrix of the specified size and with all values
    * equaling zero.
    * 
    * @param rows
    *           the number of rows in this matrix.
    * @param columns
    *           the number of columns in this matrix.
    */
   public SafeMatrix(int rows, int columns) {
      super(rows, columns);
   }

   /**
    * Creates a new safe matrix with the specified array as a base. If the
    * resulting matrix is modified the original matrix will change as well.
    * 
    * @param a
    *           the base array of the matrix.
    */
   public SafeMatrix(double[][] a) {
      super(a);
   }

   /**
    * Creates a new safe matrix that is a copy of the specified matrix.
    * 
    * @param a
    *           the matrix to copy.
    */
   public SafeMatrix(IMatrix a) {
      super(a);
   }

   // ************************** //
   // ***** ACCESS METHODS ***** //
   // ************************** //

   /**
    * Returns the value at the corresponding row and column.
    * 
    * @param r
    *           the row of the value.
    * @param c
    *           the column of the value.
    * @return the value at the row and column.
    */
   @Override
   public double get(int row, int column) {
      catchOutOfBounds(row, column);
      return super.get(row, column);
   }

   /**
    * Returns all the elements in the corresponding row.
    * 
    * @param r
    *           the row of all the elements.
    * @return all the elements in the row.
    */
   @Override
   public double[] getRow(int row) {
      catchOutOfBounds(row, 0);
      return super.getRow(row);
   }

   /**
    * Returns all the elements in the corresponding column.
    * 
    * @param c
    *           the column of all the elements.
    * @return all the elements in the column.
    */
   @Override
   public double[] getColumn(int column) {
      catchOutOfBounds(0, column);
      return super.getColumn(column);
   }

   // ******************************** //
   // ***** MUNIPULATION METHODS ***** //
   // ******************************** //

   /**
    * Sets the value at the corresponding row and column with the specified new
    * value.
    * 
    * @param r
    *           the row of the new value.
    * @param c
    *           the column of the new value.
    * @param n
    *           the new value.
    * @return the original matrix modified with the new value.
    */
   @Override
   public SafeMatrix set(int r, int c, double n) {
      catchOutOfBounds(r, c);
      super.set(r, c, n);
      return this;
   }

   /**
    * Sets all the values of the corresponding row with the specified new
    * values.
    * 
    * @param r
    *           the row of the new values.
    * @param v
    *           the new values.
    * @return the original matrix modified with the new values.
    */
   @Override
   public SafeMatrix setRow(int r, double[] v) {
      catchOutOfBounds(r, 0);
      if (v == null)
         throw new NullPointerException("Cannot access a null array.");
      if (columns() != v.length)
         throw new MatrixDimensionException("Array length needs to be the same as the number of columns "
               + "in the matrix: " + columns());
      super.setRow(r, v);
      return this;
   }

   /**
    * Sets all the values of the corresponding column with the specified new
    * values.
    * 
    * @param c
    *           the column of the new values.
    * @param v
    *           the new values.
    * @return the original matrix modified with the new values.
    */
   @Override
   public SafeMatrix setColumn(int c, double[] v) {
      catchOutOfBounds(0, c);
      if (v == null)
         throw new NullPointerException("Cannot access a null array.");
      if (rows() != v.length)
         throw new MatrixDimensionException("Matrix dimension exception: array length needs to be the same as the "
               + "number of rows in the matrix: " + rows());
      super.setColumn(c, v);
      return this;
   }

   /**
    * Sets all the values starting at the corresponding row and column with the
    * specified values.
    * 
    * @param r
    *           the starting row of new values.
    * @param c
    *           the starting column of new values.
    * @param a
    *           the new values.
    * @return the original matrix modified with the new values.
    */
   @Override
   public SafeMatrix set(int r, int c, double[][] a) {
      catchOutOfBounds(r, c);
      if (a == null)
         throw new NullPointerException("Cannot access a null array.");
      if (a.length != 0 && a[0].length != 0) {
         if (r + a.length > rows())
            throw new MatrixDimensionException();
         if (c + a[0].length > columns())
            throw new MatrixDimensionException();
      }
      super.set(r, c, a);
      return this;
   }

   // ***************************** //
   // ***** OPERATION METHODS ***** //
   // ***************************** //

   /**
    * Adds the specified matrix to the original matrix. This operation is value
    * based and will add corresponding row-column values. This method modifies
    * the original values of the matrix.
    * 
    * @param a
    *           the matrix to add.
    * @return the original matrix modified with the addition of the specified
    *         matrix.
    */
   @Override
   public SafeMatrix add(IMatrix a) {
      catchEqualDimensions(a);
      super.add(a);
      return this;
   }

   /**
    * Subtracts the specified matrix to the original matrix. This operation is
    * value based and will subtract corresponding row-column values. This method
    * modifies the original values of the matrix.
    * 
    * @param a
    *           the matrix to subtract.
    * @return the original matrix modified with the subtraction of the specified
    *         matrix.
    */
   @Override
   public SafeMatrix subtract(IMatrix a) {
      catchEqualDimensions(a);
      super.subtract(a);
      return this;
   }

   /**
    * Matrix-multiplies the specified matrix against the original matrix. This
    * method modifies the original matrix by setting it equal to the resulting
    * matrix.
    * 
    * @param a
    *           the matrix to matrix-multiply.
    * @return the original matrix modified with the matrix-multiplication by the
    *         specified matrix.
    */
   @Override
   public SafeMatrix multiply(IMatrix a) {
      if (a == null)
         throw new NullPointerException("Cannot access a null matrix.");
      if (columns() != a.rows())
         throw new MatrixDimensionException("Matrix dimension exception: matrix dimensions do not agree"
               + " for multiplying: number of columns of first (" + columns()
               + ") must equal the number of rows of second (" + a.rows() + ").");
      super.multiply(a);
      return this;
   }

   /**
    * Dot-wise multiplies the specified matrix to the original matrix. This
    * operation is value based and will multiply corresponding row-column
    * values. This method modifies the original values of the matrix.
    * 
    * @param a
    *           the matrix to dot-multiply.
    * @return the original matrix modified with the dot-multiplication of the
    *         specified matrix.
    */
   @Override
   public SafeMatrix dotMultiply(IMatrix a) {
      catchEqualDimensions(a);
      super.dotMultiply(a);
      return this;
   }

   /**
    * Dot-wise divides the specified matrix to the original matrix. This
    * operation is value based and will divide corresponding row-column values.
    * This method modifies the original values of the matrix.
    * 
    * @param a
    *           the matrix to dot-divide.
    * @return the original matrix modified with the dot-division of the
    *         specified matrix.
    */
   @Override
   public SafeMatrix dotDivide(IMatrix a) {
      catchEqualDimensions(a);
      super.dotDivide(a);
      return this;
   }

   // *************************** //
   // ***** UTILITY METHODS ***** //
   // *************************** //

   /**
    * Returns a copy of the matrix.
    * 
    * @return a copy of the matrix.
    */
   @Override
   public Matrix copy() {
      return new SafeMatrix(this);
   }

   /**
    * Catches any out of bounds errors given the specified row and column and
    * throws the proper dimension exception.
    * 
    * @param r
    *           the access row.
    * @param c
    *           the access column.
    */
   private void catchOutOfBounds(int r, int c) {
      boolean re = (r < 0 || r >= rows());
      boolean ce = (c < 0 || c >= columns());
      if (re || ce) {
         if (re && ce) {
            throw new MatrixDimensionException("Matrix dimension exception: row (" + r + ") and column (" + c
                  + ") are not in the range of this matrix's dimensions (" + rows() + "x" + columns() + ").");
         } else if (re) {
            throw new MatrixDimensionException("Matrix dimension exception: row (" + r
                  + ") is not in the range of this matrix's dimensions (" + rows() + "x" + columns() + ").");
         } else if (ce) {
            throw new MatrixDimensionException("Matrix dimension exception: column (" + c
                  + ") is not in the range of this matrix's dimensions (" + rows() + "x" + columns() + ").");
         }
      }
   }

   /**
    * Catches any equal dimension errors given the specified matrix and throws
    * the proper dimension exception.
    * 
    * @param a
    *           the tested equal matrix.
    */
   private void catchEqualDimensions(IMatrix a) {
      if (a == null)
         throw new NullPointerException("Cannot access a null matrix.");
      if (rows() != a.rows() || columns() != a.columns())
         throw new MatrixDimensionException("Matrix dimension exception: matrix dimensions do not agree: " + rows()
               + "x" + columns() + " and " + a.rows() + "x" + a.columns());
   }

}
