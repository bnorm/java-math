package math.matrices;

/**
 * The object representation of a mathematical vector.  This class provides an implementation for basic use.  This is
 * not a safe vector. It does not perform any dimension checks before performing any actions.
 *
 * @author Brian Norman
 * @version 0.1 beta
 */
public class Vector extends Matrix implements IVector {

   /**
    * Creates a new vector with no values and of size zero.
    */
   public Vector() {
      this(0);
   }

   /**
    * Creates a new vector of the specified length and with all values equaling zero.
    *
    * @param length the length of this vector.
    */
   public Vector(int length) {
      this(new double[length]);
   }

   /**
    * Creates a new row vector with the specified array as a base.  If the resulting vector is modified the original
    * vector will change as well.
    *
    * @param v the base vector of the matrix.
    */
   public Vector(double[] v) {
      super(new double[][] {v});
   }

   /**
    * Creates a new vector that is a copy of the specified vector.
    *
    * @param v the vector to copy.
    */
   protected Vector(IVector v) {
      super(v);
   }

   @Override
   public Vector set(double[] v) {
      return (Vector) IVector.super.set(v);
   }

   @Override
   public Vector set(double[][] a) {
      return (Vector) super.set(a);
   }

   @Override
   public Vector set(int i, double n) {
      return (Vector) IVector.super.set(i, n);
   }

   @Override
   public Vector set(int r, int c, double n) {
      return (Vector) super.set(r, c, n);
   }

   @Override
   public Vector setRow(int r, double[] v) {
      return (Vector) super.setRow(r, v);
   }

   @Override
   public Vector setColumn(int c, double[] v) {
      return (Vector) super.setColumn(c, v);
   }

   @Override
   public Vector set(int i, double[] v) {
      return (Vector) IVector.super.set(i, v);
   }

   @Override
   public Vector set(int r, int c, double[][] a) {
      return (Vector) super.set(r, c, a);
   }

   @Override
   public Vector transpose() {
      return (Vector) super.transpose();
   }

   @Override
   public Vector scale(double n) {
      return (Vector) super.scale(n);
   }

   @Override
   public Vector inverse() {
      return (Vector) super.inverse();
   }

   @Override
   public Vector add(IVector v) {
      return (Vector) IVector.super.add(v);
   }

   @Override
   public Vector add(IMatrix a) {
      return (Vector) super.add(a);
   }

   @Override
   public Vector subtract(IVector v) {
      return (Vector) IVector.super.subtract(v);
   }

   @Override
   public Vector subtract(IMatrix a) {
      return (Vector) super.subtract(a);
   }

   @Override
   public Matrix outer(IVector v) {
      return (Matrix) IVector.super.outer(v);
   }

   @Override
   public Vector multiply(IMatrix a) {
      return (Vector) super.multiply(a);
   }

   @Override
   public Vector dotMultiply(IMatrix a) {
      return (Vector) super.dotMultiply(a);
   }

   @Override
   public Vector dotMultiply(IVector v) {
      return (Vector) IVector.super.dotMultiply(v);
   }

   @Override
   public Vector dotDivide(IMatrix a) {
      return (Vector) super.dotDivide(a);
   }

   @Override
   public Vector dotDivide(IVector v) {
      return (Vector) IVector.super.dotDivide(v);
   }

   @Override
   public Vector copy() {
      return new Vector(this);
   }
}
