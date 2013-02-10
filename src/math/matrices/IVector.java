package math.matrices;


/**
 * The object representation of a mathematical vector. This interface provides basic use and manipulation methods.
 *
 * @author Brian Norman
 * @version 0.1 beta
 */
public interface IVector extends IMatrix {

   // ************************** //
   // ***** ACCESS METHODS ***** //
   // ************************** //

   /**
    * Returns the length of the vector.
    *
    * @return the length of the vector.
    */
   default int length() {
      return Math.max(rows(), columns());
   }

   /**
    * Returns the value of the vector at the specified index. This index is along the length of the vector.
    * <p/>
    * Unsafe method, does not perform dimension checks.
    *
    * @param i the index of the value.
    * @return the value at the specified index.
    */
   default double get(int i) {
      if (columns() > rows()) {
         return get(i, 0);
      }
      else {
         return get(0, i);
      }
   }

   // ******************************** //
   // ***** MANIPULATION METHODS ***** //
   // ******************************** //

   /**
    * Sets the vector to be the specified array. This methods does not copy but sets the array which will change if the
    * vector is modified.
    *
    * @param v the new array for the matrix.
    * @return the vector representation of the array.
    */
   default IVector set(double[] v) {
      set(new double[][] {v});
      return this;
   }

   /**
    * Sets the value at the corresponding index to be the specified value.
    * <p/>
    * Unsafe method, does not perform dimension checks.
    *
    * @param i the index of the value.
    * @param n the specified value.
    * @return the original matrix modified with the new value.
    */
   default IVector set(int i, double n) {
      if (columns() > rows()) {
         set(i, 0, n);
      }
      else {
         set(0, i, n);
      }
      return this;
   }

   /**
    * Sets all the values starting at the corresponding index with the specified values.
    * <p/>
    * Unsafe method, does not perform dimension checks.
    *
    * @param i the starting index of the new values.
    * @param v the new values.
    * @return the original matrix modified with the new values.
    */
   default IVector set(int i, double[] v) {
      for (int n = 0; n < v.length; n++) {
         set(i + n, v[n]);
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
   default IVector transpose() {
      IMatrix.super.transpose();
      return this;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   default IVector scale(double n) {
      IMatrix.super.scale(n);
      return this;
   }

   /**
    * Adds the specified vector to the original vector. This operation is value based and will add corresponding index
    * values. This method modifies the original values of the vector.
    * <p/>
    * Unsafe method, does not perform dimension checks.
    *
    * @param v the vector to add.
    * @return the original vector modified with the addition of the specified a vector.
    */
   default IVector add(IVector v) {
      IMatrix.super.add(v);
      return this;
   }

   /**
    * Subtracts the specified vector to the original vector. This operation is value based and will subtract
    * corresponding index values. This method modifies the original values of the vector.
    * <p/>
    * Unsafe method, does not perform dimension checks.
    *
    * @param v the vector to subtract.
    * @return the original vector modified with the subtraction of the specified vector.
    */
   default IVector subtract(IVector v) {
      IMatrix.super.subtract(v);
      return this;
   }

   /**
    * Dot-wise multiplies the specified vector to the original vector. This operation is value based and will multiply
    * corresponding index values. This method modifies the original values of the vector.
    * <p/>
    * Unsafe method, does not perform dimension checks.
    *
    * @param v the vector to dot-multiply.
    * @return the original vector modified with the dot-multiplication of the specified vector.
    */
   default IVector dotMultiply(IVector v) {
      IMatrix.super.dotMultiply(v);
      return this;
   }

   /**
    * Dot-wise divides the specified vector to the original vector. This operation is value based and will divide
    * corresponding index values. This method modifies the original values of the vector.
    * <p/>
    * Unsafe method, does not perform dimension checks.
    *
    * @param v the vector to dot-divide.
    * @return the original vector modified with the dot-division of the specified vector.
    */
   default IVector dotDivide(IVector v) {
      IMatrix.super.dotDivide(v);
      return this;
   }

   /**
    * Returns the outer-product of the vector and the specified vector.
    *
    * @param v the outer vector.
    * @return the outer-product of the vector multiplied by the specified vector.
    */
   default IMatrix outer(IVector v) {
      double[][] a = new double[length()][v.length()];
      for (int i = 0; i < length(); i++) {
         for (int j = 0; j < v.length(); j++) {
            a[i][j] = get(i) * get(j);
         }
      }
      return new Matrix(a);
   }

   /**
    * Returns the inner-product of the vector and the specified vector.
    * <p/>
    * Unsafe method, does not perform dimension checks.
    *
    * @param v the inner vector.
    * @return the inner-product of the vector multiplied by the specified vector.
    */
   default double inner(IVector v) {
      double sum = 0;
      for (int i = 0; i < length(); i++) {
         sum += get(i) * v.get(i);
      }
      return sum;
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
   public IVector copy();

}
