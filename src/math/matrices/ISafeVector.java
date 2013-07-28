package math.matrices;

/**
 * The object representation of a mathematical vector.  This class provides an implementation for basic use.  This
 * <em>is</em> a safe vector.  It performs dimension checks before performing every actions.
 *
 * @author Brian Norman
 * @version 0.1 beta
 */
public interface ISafeVector extends IVector, ISafeMatrix {

   /**
    * Returns the value of the vector at the specified index.  This index is along the length of the vector.
    *
    * @param i the index of the value.
    * @return the value at the specified index.
    */
   @Override
   default double get(int i) {
      DimensionChecking.catchOutOfBounds(this, i);
      return IVector.super.get(i);
   }

   @Override
   default ISafeVector set(double[] v) {
      return (ISafeVector) IVector.super.set(v);
   }

   @Override
   ISafeVector set(double[][] a);

   /**
    * Sets the value at the corresponding index to be the specified value.
    *
    * @param i the index of the value.
    * @param n the specified value.
    * @return the original matrix modified with the new value.
    */
   @Override
   default ISafeVector set(int i, double n) {
      DimensionChecking.catchOutOfBounds(this, i);
      return (ISafeVector) IVector.super.set(i, n);
   }

   @Override
   ISafeVector set(int r, int c, double n);

   @Override
   default ISafeVector setRow(int r, double[] v) {
      return (ISafeVector) ISafeMatrix.super.setRow(r, v);
   }

   @Override
   default ISafeVector setColumn(int c, double[] v) {
      return (ISafeVector) ISafeMatrix.super.setColumn(c, v);
   }

   /**
    * Sets all the values starting at the corresponding index with the specified values.
    *
    * @param i the starting index of the new values.
    * @param v the new values.
    * @return the original matrix modified with the new values.
    */
   @Override
   default ISafeVector set(int i, double[] v) {
      DimensionChecking.catchOutOfBounds(this, i);
      if (v == null) {
         throw new NullPointerException("Cannot access a null array.");
      } else if (i + v.length > length()) {
         throw new VectorDimensionException(
                 "Index insertion plus array length exceeds dimensions of vector. [" + i + " + " + v.length + " > "
                         + length() + "]");
      }
      return (ISafeVector) IVector.super.set(i, v);
   }

   @Override
   default ISafeVector set(int r, int c, double[][] a) {
      return (ISafeVector) ISafeMatrix.super.set(r, c, a);
   }

   @Override
   default ISafeVector transpose() {
      return (ISafeVector) IVector.super.transpose();
   }

   @Override
   default ISafeVector inverse() {
      return (ISafeVector) IVector.super.inverse();
   }

   @Override
   default ISafeVector scale(double n) {
      return (ISafeVector) IVector.super.scale(n);
   }

   /**
    * Adds the specified vector to the original vector.  This operation is value based and will add corresponding index
    * values.  This method modifies the original values of the vector.
    *
    * @param v the vector to add.
    * @return the original vector modified with the addition of the specified a vector.
    */
   @Override
   default ISafeVector add(IVector v) {
      DimensionChecking.catchEqualDimensions(this, v);
      return (ISafeVector) IVector.super.add(v);
   }

   @Override
   default ISafeVector add(IMatrix a) {
      return (ISafeVector) ISafeMatrix.super.add(a);
   }

   /**
    * Subtracts the specified vector to the original vector.  This operation is value based and will subtract
    * corresponding index values.  This method modifies the original values of the vector.
    *
    * @param v the vector to subtract.
    * @return the original vector modified with the subtraction of the specified vector.
    */
   @Override
   default ISafeVector subtract(IVector v) {
      DimensionChecking.catchEqualDimensions(this, v);
      return (ISafeVector) IVector.super.subtract(v);
   }

   @Override
   default ISafeVector subtract(IMatrix a) {
      return (ISafeVector) ISafeMatrix.super.subtract(a);
   }

   @Override
   default ISafeVector multiply(IMatrix a) {
      return (ISafeVector) ISafeMatrix.super.multiply(a);
   }

   @Override
   default ISafeVector dotMultiply(IMatrix a) {
      return (ISafeVector) ISafeMatrix.super.dotMultiply(a);
   }

   @Override
   default ISafeVector dotDivide(IMatrix a) {
      return (ISafeVector) ISafeMatrix.super.dotDivide(a);
   }

   /**
    * Dot-wise multiplies the specified vector to the original vector.  This operation is value based and will multiply
    * corresponding index values.  This method modifies the original values of the vector.
    *
    * @param v the vector to dot-multiply.
    * @return the original vector modified with the dot-multiplication of the specified vector.
    */
   @Override
   default ISafeVector dotMultiply(IVector v) {
      DimensionChecking.catchEqualDimensions(this, v);
      return (ISafeVector) IVector.super.dotMultiply(v);
   }

   /**
    * Dot-wise divides the specified vector to the original vector.  This operation is value based and will divide
    * corresponding index values.  This method modifies the original values of the vector.
    *
    * @param v the vector to dot-divide.
    * @return the original vector modified with the dot-division of the specified vector.
    */
   @Override
   default ISafeVector dotDivide(IVector v) {
      DimensionChecking.catchEqualDimensions(this, v);
      return (ISafeVector) IVector.super.dotDivide(v);
   }

   @Override
   default ISafeMatrix outer(IVector v) {
      return (ISafeMatrix) IVector.super.outer(v);
   }

   /**
    * Returns the inner-product of the vector and the specified vector.
    *
    * @param v the inner vector.
    * @return the inner-product of the vector multiplied by the specified vector.
    */
   @Override
   default double inner(IVector v) {
      DimensionChecking.catchEqualDimensions(this, v);
      return IVector.super.inner(v);
   }

   @Override
   public ISafeVector copy();

}
