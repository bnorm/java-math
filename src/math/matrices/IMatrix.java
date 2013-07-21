package math.matrices;

/**
 * A object representation of a mathematical matrix. This interface provides basic use and manipulation methods.
 *
 * @author Brian Norman
 * @version 0.1 beta
 */
public interface IMatrix {

   /**
    * Returns the number of rows the matrix has.
    *
    * @return the number of rows.
    */
   public int rows();

   /**
    * Returns the number of columns the matrix has.
    *
    * @return the number of columns.
    */
   public int columns();

   /**
    * Returns the value at the corresponding row and column.
    *
    * @param r the row of the value.
    * @param c the column of the value.
    * @return the value at the row and column.
    */
   public double get(int r, int c);

   /**
    * Returns all the elements in the corresponding row.
    * <p/>
    * Unsafe method, does not perform dimension checks.
    *
    * @param r the row of all the elements.
    * @return all the elements in the row.
    */
   default double[] getRow(int r) {
      double[] v = new double[columns()];
      for (int i = 0; i < columns(); i++) {
         v[i] = get(r, i);
      }
      return v;
   }

   /**
    * Returns all the elements in the corresponding column.
    * <p/>
    * Unsafe method, does not perform dimension checks.
    *
    * @param c the column of all the elements.
    * @return all the elements in the column.
    */
   default double[] getColumn(int c) {
      double[] v = new double[rows()];
      for (int i = 0; i < rows(); i++) {
         v[i] = get(i, c);
      }
      return v;
   }

   /**
    * Sets the matrix to be the specified array.  This method does not copy but sets the array which will change if the
    * matrix is modified.
    * <p/>
    * Note: this changes the underlying data structure to a different data structure since the dimensions might change.
    *
    * @param a the new array for the matrix.
    * @return the matrix representation of the array.
    */
   public IMatrix set(double[][] a);

   /**
    * Sets the value at the corresponding row and column with the specified new value.
    * <p/>
    * Unsafe method, does not perform dimension checks.
    *
    * @param r the row of the new value.
    * @param c the column of the new value.
    * @param n the new value.
    * @return the original matrix modified with the new value.
    */
   public IMatrix set(int r, int c, double n);

   /**
    * Sets all the values of the corresponding row with the specified new values.
    * <p/>
    * Unsafe method, does not perform dimension checks.
    *
    * @param r the row of the new values.
    * @param v the new values.
    * @return the original matrix modified with the new values.
    */
   default IMatrix setRow(int r, double[] v) {
      for (int i = 0; i < columns(); i++) {
         set(r, i, v[i]);
      }
      return this;
   }

   /**
    * Sets all the values of the corresponding column with the specified new values.
    * <p/>
    * Unsafe method, does not perform dimension checks.
    *
    * @param c the column of the new values.
    * @param v the new values.
    * @return the original matrix modified with the new values.
    */
   default IMatrix setColumn(int c, double[] v) {
      for (int i = 0; i < rows(); i++) {
         set(i, c, v[i]);
      }
      return this;
   }

   /**
    * Sets all the values starting at the corresponding row and column with the specified values.
    * <p/>
    * Unsafe method, does not perform dimension checks.
    *
    * @param r the starting row of new values.
    * @param c the starting column of new values.
    * @param a the new values.
    * @return the original matrix modified with the new values.
    */
   default IMatrix set(int r, int c, double[][] a) {
      for (int i = 0; i < a.length; i++) {
         for (int j = 0; j < a[0].length; j++) {
            set(r + i, c + j, a[i][j]);
         }
      }
      return this;
   }

   /**
    * Returns the transpose of the matrix.  This operation does not create a new matrix but modifies the original
    * matrix.
    * <p/>
    * Note: this changes the underlying data structure to a different data structure since the dimensions might change.
    *
    * @return the transpose of the matrix.
    */
   default IMatrix transpose() {
      double[][] transpose = new double[columns()][rows()];
      for (int i = 0; i < columns(); i++) {
         for (int j = 0; j < rows(); j++) {
            transpose[i][j] = get(j, i);
         }
      }
      return set(transpose);
   }

   /**
    * Returns the inverse of the matrix.  This operation does not create a new matrix but modifies the original matrix.
    *
    * @return the inverse of the matrix.
    */
   default IMatrix inverse() {
      throw new RuntimeException("Method not implemented.");
   }

   /**
    * Scales the matrix by multiplying the specified value against all the values of this matrix.  This method modifies
    * the original values of the matrix.
    *
    * @param n the scaling factor.
    * @return the original matrix multiplied by the scaling factor.
    */
   default IMatrix scale(double n) {
      for (int i = 0; i < rows(); i++) {
         for (int j = 0; j < columns(); j++) {
            set(i, j, n * get(i, j));
         }
      }
      return this;
   }

   /**
    * Adds the specified matrix to the original matrix.  This operation is value based and will add corresponding
    * row-column values.  This method modifies the original values of the matrix.
    * <p/>
    * Unsafe method, does not perform dimension checks.
    *
    * @param a the matrix to add.
    * @return the original matrix modified with the addition of the specified matrix.
    */
   default IMatrix add(IMatrix a) {
      for (int i = 0; i < rows(); i++) {
         for (int j = 0; j < columns(); j++) {
            set(i, j, get(i, j) + a.get(i, j));
         }
      }
      return this;
   }

   /**
    * Subtracts the specified matrix to the original matrix.  This operation is value based and will subtract
    * corresponding row-column values.  This method modifies the original values of the matrix.
    * <p/>
    * Unsafe method, does not perform dimension checks.
    *
    * @param a the matrix to subtract.
    * @return the original matrix modified with the subtraction of the specified matrix.
    */
   default IMatrix subtract(IMatrix a) {
      for (int i = 0; i < rows(); i++) {
         for (int j = 0; j < columns(); j++) {
            set(i, j, get(i, j) - a.get(i, j));
         }
      }
      return this;
   }

   /**
    * Matrix-multiplies the specified matrix against the original matrix.  This method modifies the original matrix by
    * setting it equal to the resulting matrix.
    * <p/>
    * Unsafe method, does not perform dimension checks.
    * <p/>
    * Note: this changes the underlying data structure to a different data structure since the dimensions might change.
    *
    * @param a the matrix to matrix-multiply.
    * @return the original matrix modified with the matrix-multiplication by the specified matrix.
    */
   default IMatrix multiply(IMatrix a) {
      double[][] c = new double[rows()][a.columns()];
      for (int i = 0; i < rows(); i++) {
         for (int j = 0; j < a.columns(); j++) {
            double sum = 0;
            for (int k = 0; k < a.rows(); k++) {
               sum += get(i, k) * a.get(k, j);
            }
            c[i][j] = sum;
         }
      }
      return set(c);
   }

   /**
    * Dot-wise multiplies the specified matrix to the original matrix.  This operation is value based and will multiply
    * corresponding row-column values. This method modifies the original values of the matrix.
    * <p/>
    * Unsafe method, does not perform dimension checks.
    *
    * @param a the matrix to dot-multiply.
    * @return the original matrix modified with the dot-multiplication of the specified matrix.
    */
   default IMatrix dotMultiply(IMatrix a) {
      for (int i = 0; i < rows(); i++) {
         for (int j = 0; j < columns(); j++) {
            set(i, j, get(i, j) * a.get(i, j));
         }
      }
      return this;
   }

   /**
    * Dot-wise divides the specified matrix to the original matrix.  This operation is value based and will divide
    * corresponding row-column values. This method modifies the original values of the matrix.
    * <p/>
    * Unsafe method, does not perform dimension checks.
    *
    * @param a the matrix to dot-divide.
    * @return the original matrix modified with the dot-division of the specified matrix.
    */
   default IMatrix dotDivide(IMatrix a) {
      for (int i = 0; i < rows(); i++) {
         for (int j = 0; j < columns(); j++) {
            set(i, j, get(i, j) / a.get(i, j));
         }
      }
      return this;
   }

   /**
    * Returns a copy of the matrix.
    *
    * @return a copy of the matrix.
    */
   public IMatrix copy();

}
