package math.matrices;

/**
 * The object representation of a mathematical vector. This interface provides basic use and manipulation methods.
 *
 * @author Brian Norman
 * @version 0.1 beta
 */
public interface IVector extends IMatrix {

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
         return get(0, i);
      } else {
         return get(i, 0);
      }
   }

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
         set(0, i, n);
      } else {
         set(i, 0, n);
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
      if (columns() > rows()) {
         for (int n = 0; n < v.length; n++) {
            set(0, i + n, v[n]);
         }
      } else {
         for (int n = 0; n < v.length; n++) {
            set(i + n, 0, v[n]);
         }
      }
      return this;
   }

   @Override
   default IVector transpose() {
      return (IVector) IMatrix.super.transpose();
   }

   @Override
   default IVector scale(double n) {
      return (IVector) IMatrix.super.scale(n);
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
      IVector b = v;
      // If they don't have the same orientation...
      if (columns() > rows() != v.columns() > v.rows()) {
         b = b.copy().transpose();
      }
      return (IVector) IMatrix.super.add(b);
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
      IVector b = v;
      // If they don't have the same orientation...
      if (columns() > rows() != v.columns() > v.rows()) {
         b = b.copy().transpose();
      }
      return (IVector) IMatrix.super.subtract(b);
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
      IVector b = v;
      // If they don't have the same orientation...
      if (columns() > rows() != v.columns() > v.rows()) {
         b = b.copy().transpose();
      }
      return (IVector) IMatrix.super.dotMultiply(b);
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
      IVector b = v;
      // If they don't have the same orientation...
      if (columns() > rows() != v.columns() > v.rows()) {
         b = b.copy().transpose();
      }
      return (IVector) IMatrix.super.dotDivide(b);
   }

   /**
    * Returns the outer-product of the vector and the specified vector.
    *
    * @param v the outer vector.
    * @return the outer-product of the vector multiplied by the specified vector.
    */
   default IMatrix outer(IVector v) {
      IVector a = v.copy();
      // make 'a' a column vector
      if (columns() < rows()) {
         a.transpose();
      }
      IVector b = v;
      // make 'b' a row vector (don't modify v though)
      if (b.rows() < b.columns()) {
         b = v.copy().transpose();
      }
      return a.multiply(b);
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
      IVector a = copy();
      // make 'a' a row vector
      if (rows() < columns()) {
         a.transpose();
      }
      IVector b = v;
      // make 'b' a column vector (don't modify v though)
      if (b.columns() < b.rows()) {
         b = v.copy().transpose();
      }
      return a.multiply(b).get(0, 0);
   }

   @Override
   public IVector copy();

}
