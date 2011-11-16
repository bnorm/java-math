package math.matrices;

/**
 * The object representation of a mathematical vector. This class provides an
 * implementation for basic use. This <em>is</em> a safe vector. It performs
 * dimension checks before performing every actions.
 * 
 * @author Brian Norman
 * @version 0.1 beta
 */
public class SafeVector extends Vector {

   // ************************ //
   // ***** CONSTRUCTORS ***** //
   // ************************ //

   /**
    * Creates a new vector with no values and of size zero.
    */
   public SafeVector() {
      this(0);
   }

   /**
    * Creates a new vector of the specified length and with all values equaling
    * zero.
    * 
    * @param length
    *           the length of this vector.
    */
   public SafeVector(int length) {
      super(new double[length]);
   }

   /**
    * Creates a new row vector with the specified array as a base. if the
    * resulting vector is modified the original vector will change as well.
    * 
    * @param v
    *           the base vector of the matrix.
    */
   public SafeVector(double[] v) {
      super(v);
   }

   /**
    * Creates a new vector that is a copy of the specified vector.
    * 
    * @param v
    *           the vector to copy.
    */
   protected SafeVector(SafeVector v) {
      super(v);
   }

   /**
    * Creates a new vector that is a copy of the specified matrix. If the matrix
    * is not a vector then a vector of size zero is created.
    * 
    * @param m
    *           the matrix to copy.
    */
   public SafeVector(IMatrix m) {
      this();
      if (m.rows() == 1) {
         set(m.getRow(0));
      } else if (m.columns() == 1) {
         set(m.getColumn(0));
      }
      // else throw error?
   }

   // ************************** //
   // ***** ACCESS METHODS ***** //
   // ************************** //

   /**
    * Returns the value at the corresponding row and column.
    * 
    * @param row
    *           the row of the value.
    * @param column
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
    * @param row
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
    * @param column
    *           the column of all the elements.
    * @return all the elements in the column.
    */
   @Override
   public double[] getColumn(int column) {
      catchOutOfBounds(0, column);
      return super.getColumn(column);
   }

   /**
    * Returns the value of the vector at the specified index. This index is
    * along the length of the vector.
    * 
    * @param i
    *           the index of the value.
    * @return the value at the specified index.
    */
   @Override
   public double get(int i) {
      return super.get(i);
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
   public SafeVector set(int r, int c, double n) {
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
   public SafeVector setRow(int r, double[] v) {
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
   public SafeVector setColumn(int c, double[] v) {
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
   public SafeVector set(int r, int c, double[][] a) {
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

   /**
    * Sets the value at the coorespond1ing index to be the specified value.
    * 
    * @param i
    *           the index of the value.
    * @param n
    *           the specified value.
    * @return the original matrix modified with the new value.
    */
   @Override
   public SafeVector set(int i, double n) {
      super.set(i, n);
      return this;
   }

   /**
    * Sets all the values starting at the corresponding index with the specified
    * values.
    * 
    * @param i
    *           the starting index of the new values.
    * @param v
    *           the new values.
    * @return the original matrix modified with the new values.
    */
   @Override
   public SafeVector set(int i, double[] v) {
      super.set(i, v);
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
   public SafeVector add(IMatrix a) {
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
   public SafeVector subtract(IMatrix a) {
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
   public AbstractMatrix multiply(IMatrix a) {
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
   public SafeVector dotMultiply(IMatrix a) {
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
   public SafeVector dotDivide(IMatrix a) {
      catchEqualDimensions(a);
      super.dotDivide(a);
      return this;
   }

   /**
    * Adds the specified vector to the original vector. This operation is value
    * based and will add corresponding index values. This method modifies the
    * original values of the vector.
    * 
    * @param v
    *           the vector to add.
    * @return the original vector modified with the addition of the specified a
    *         vector.
    */
   @Override
   public SafeVector add(IVector v) {
      return add((IMatrix) v);
   }

   /**
    * Subtracts the specified vector to the original vector. This operation is
    * value based and will subtract corresponding index values. This method
    * modifies the original values of the vector.
    * 
    * @param v
    *           the vector to subtract.
    * @return the original vector modified with the subtraction of the specified
    *         vector.
    */
   @Override
   public SafeVector subtract(IVector v) {
      return subtract((IMatrix) v);
   }

   /**
    * Dot-wise multiplies the specified vector to the original vector. This
    * operation is value based and will multiply corresponding index values.
    * This method modifies the original values of the vector.
    * 
    * @param v
    *           the vector to dot-multiply.
    * @return the original vector modified with the dot-multiplication of the
    *         specified vector.
    */
   @Override
   public SafeVector dotMultiply(IVector v) {
      return dotMultiply((IMatrix) v);
   }

   /**
    * Dot-wise divides the specified vector to the original vector. This
    * operation is value based and will divide corresponding index values. This
    * method modifies the original values of the vector.
    * 
    * @param v
    *           the vector to dot-divide.
    * @return the original vector modified with the dot-division of the
    *         specified vector.
    */
   @Override
   public SafeVector dotDivide(IVector v) {
      return dotDivide((IMatrix) v);
   }

   /**
    * Returns the dot-product, or inner-product, of the vector and the specified
    * vector.
    * 
    * @param v
    *           the dotting vector.
    * @return the dot-product of the vector dotted by the specified vector.
    */
   @Override
   public double dot(IVector v) {
      if (v == null)
         throw new NullPointerException("Cannot access a null matrix.");
      if (length() != v.length())
         throw new MatrixDimensionException("Matrix dimension exception: vector lengths do not agree: " + length()
               + " and " + v.length() + ".");
      return super.dot(v);
   }

   // *************************** //
   // ***** UTILITY METHODS ***** //
   // *************************** //

   /**
    * Returns a copy of the vector.
    * 
    * @return a copy of the vector.
    */
   @Override
   public SafeVector copy() {
      return new SafeVector(this);
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
    * @param v
    *           the tested equal matrix.
    */
   private void catchEqualDimensions(IMatrix v) {
      if (v == null)
         throw new NullPointerException("Cannot access a null matrix.");
      if (rows() != v.rows() || columns() != v.columns())
         throw new MatrixDimensionException("Matrix dimension exception: matrix dimensions do not agree: " + rows()
               + "x" + columns() + " and " + v.rows() + "x" + v.columns() + ".");
   }

}
