package math.matrices;

/**
 * The object representation of a mathematical matrix.  This class provides an implementation for basic use.  This
 * <em>is</em> a safe matrix.  It performs dimension checks before performing every actions.
 *
 * @author Brian Norman
 * @version 0.1 beta
 */
public interface ISafeMatrix extends IMatrix {

   /**
    * Returns the value at the corresponding row and column.
    *
    * @param r the row of the value.
    * @param c the column of the value.
    * @return the value at the row and column.
    */
   @Override
   double get(int r, int c);

   /**
    * Returns all the elements in the corresponding row.
    *
    * @param r the row of all the elements.
    * @return all the elements in the row.
    */
   @Override
   default double[] getRow(int r) {
      DimensionChecking.catchOutOfBounds(this, r, 0);
      return IMatrix.super.getRow(r);
   }


   /**
    * Returns all the elements in the corresponding column.
    *
    * @param c the column of all the elements.
    * @return all the elements in the column.
    */
   @Override
   default double[] getColumn(int c) {
      DimensionChecking.catchOutOfBounds(this, 0, c);
      return IMatrix.super.getColumn(c);
   }

   /**
    * Sets the value at the corresponding row and column with the specified new value.
    *
    * @param r the row of the new value.
    * @param c the column of the new value.
    * @param n the new value.
    * @return the original matrix modified with the new value.
    */
   @Override
   ISafeMatrix set(int r, int c, double n);

   /**
    * Sets all the values of the corresponding row with the specified new values.
    *
    * @param r the row of the new values.
    * @param v the new values.
    * @return the original matrix modified with the new values.
    */
   @Override
   default ISafeMatrix setRow(int r, double[] v) {
      DimensionChecking.catchOutOfBounds(this, r, 0);
      if (v == null) {
         throw new NullPointerException("Cannot access a null array.");
      } else if (columns() != v.length) {
         throw new MatrixDimensionException(
                 "Array length needs to be the same as the number of columns " + "in the matrix: " + columns());
      }
      return (ISafeMatrix) IMatrix.super.setRow(r, v);
   }

   /**
    * Sets all the values of the corresponding column with the specified new values.
    *
    * @param c the column of the new values.
    * @param v the new values.
    * @return the original matrix modified with the new values.
    */
   @Override
   default ISafeMatrix setColumn(int c, double[] v) {
      DimensionChecking.catchOutOfBounds(this, 0, c);
      if (v == null) {
         throw new NullPointerException("Cannot access a null array.");
      } else if (rows() != v.length) {
         throw new MatrixDimensionException(
                 "Array length needs to be the same as the " + "number of rows in the matrix: " + rows());
      }
      return (ISafeMatrix) IMatrix.super.setColumn(c, v);
   }

   /**
    * Sets all the values starting at the corresponding row and column with the specified values.
    *
    * @param r the starting row of new values.
    * @param c the starting column of new values.
    * @param a the new values.
    * @return the original matrix modified with the new values.
    */
   @Override
   default ISafeMatrix set(int r, int c, double[][] a) {
      DimensionChecking.catchOutOfBounds(this, r, c);
      if (a == null) {
         throw new NullPointerException("Cannot access a null array.");
      } else if (r + a.length > rows()) {
         throw new MatrixDimensionException(
                 "Row insertion plus array rows exceeds dimensions of matrix. [" + r + " + " + a.length + " > " + rows()
                         + "]");
      } else if (a.length != 0 && c + a[0].length > columns()) {
         throw new MatrixDimensionException(
                 "Column insertion plus array columns exceeds dimensions of matrix. [" + r + " + " + a[0].length + " > "
                         + columns() + "]");
      }
      return (ISafeMatrix) IMatrix.super.set(r, c, a);
   }

   @Override
   ISafeMatrix set(double[][] a);

   @Override
   default ISafeMatrix transpose() {
      return (ISafeMatrix) IMatrix.super.transpose();
   }

   @Override
   default ISafeMatrix inverse() {
      return (ISafeMatrix) IMatrix.super.inverse();
   }

   @Override
   default ISafeMatrix scale(double n) {
      return (ISafeMatrix) IMatrix.super.scale(n);
   }

   /**
    * Adds the specified matrix to the original matrix.  This operation is value based and will add corresponding
    * row-column values.  This method modifies the original values of the matrix.
    *
    * @param a the matrix to add.
    * @return the original matrix modified with the addition of the specified matrix.
    */
   @Override
   default ISafeMatrix add(IMatrix a) {
      DimensionChecking.catchEqualDimensions(this, a);
      return (ISafeMatrix) IMatrix.super.add(a);
   }

   /**
    * Subtracts the specified matrix to the original matrix.  This operation is value based and will subtract
    * corresponding row-column values.  This method modifies the original values of the matrix.
    *
    * @param a the matrix to subtract.
    * @return the original matrix modified with the subtraction of the specified matrix.
    */
   @Override
   default ISafeMatrix subtract(IMatrix a) {
      DimensionChecking.catchEqualDimensions(this, a);
      return (ISafeMatrix) IMatrix.super.subtract(a);
   }

   /**
    * Matrix-multiplies the specified matrix against the original matrix.  This method modifies the original matrix by
    * setting it equal to the resulting matrix.
    * <p/>
    * Note: this changes the underlying data structure to a different data structure since the dimensions might change.
    *
    * @param a the matrix to matrix-multiply.
    * @return the original matrix modified with the matrix-multiplication by the specified matrix.
    */
   @Override
   default ISafeMatrix multiply(IMatrix a) {
      if (a == null) {
         throw new NullPointerException("Cannot access a null matrix.");
      } else if (columns() != a.rows()) {
         throw new MatrixDimensionException(
                 "Matrix dimensions do not agree" + " for multiplying: number of columns of first (" + columns()
                         + ") must equal the number of rows of second (" + a.rows() + ").");
      }
      return (ISafeMatrix) IMatrix.super.multiply(a);
   }

   /**
    * Dot-wise multiplies the specified matrix to the original matrix.  This operation is value based and will multiply
    * corresponding row-column values. This method modifies the original values of the matrix.
    *
    * @param a the matrix to dot-multiply.
    * @return the original matrix modified with the dot-multiplication of the specified matrix.
    */
   @Override
   default ISafeMatrix dotMultiply(IMatrix a) {
      DimensionChecking.catchEqualDimensions(this, a);
      return (ISafeMatrix) IMatrix.super.dotMultiply(a);
   }

   /**
    * Dot-wise divides the specified matrix to the original matrix.  This operation is value based and will divide
    * corresponding row-column values. This method modifies the original values of the matrix.
    *
    * @param a the matrix to dot-divide.
    * @return the original matrix modified with the dot-division of the specified matrix.
    */
   @Override
   default ISafeMatrix dotDivide(IMatrix a) {
      DimensionChecking.catchEqualDimensions(this, a);
      return (ISafeMatrix) IMatrix.super.dotDivide(a);
   }

   @Override
   ISafeMatrix copy();

}
