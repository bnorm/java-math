package math.matrices;

/**
 * The object representation of a mathematical vector. This class provides an
 * implementation for basic use. This is not a safe vector. It does not perform
 * any dimension checks before performing any actions.
 *
 * @author Brian Norman
 * @version 0.1 beta
 */
public class Vector extends Matrix implements IVector {

   // ****************** //
   // ***** FIELDS ***** //
   // ****************** //

   /**
    * Whether the vector is a column vector or not.
    */
   private boolean column;

   // ************************ //
   // ***** CONSTRUCTORS ***** //
   // ************************ //

   /**
    * Creates a new vector with no values and of size zero.
    */
   public Vector() {
      this(0);
   }

   /**
    * Creates a new vector of the specified length and with all values equaling
    * zero.
    *
    * @param length
    *           the length of this vector.
    */
   public Vector(int length) {
      this(new double[length]);
   }

   /**
    * Creates a new row vector with the specified array as a base. if the
    * resulting vector is modified the original vector will change as well.
    * 
    * @param v
    *           the base vector of the matrix.
    */
   public Vector(double[] v) {
      super(new double[][] { v });
   }

   /**
    * Creates a new vector that is a copy of the specified vector.
    * 
    * @param v
    *           the vector to copy.
    */
   protected Vector(Vector v) {
      super(v);
   }

   // ************************** //
   // ***** ACCESS METHODS ***** //
   // ************************** //

   /**
    * {@inheritDoc}
    */
   @Override
   public int length() {
      return (column ? rows() : columns());
   }

   /**
    * {@inheritDoc}
    * 
    * Unsafe method, does not perform dimension checks.
    */
   @Override
   public double get(int i) {
      if (column) {
         return get(i, 0);
      } else {
         return get(0, i);
      }
   }

   // ******************************** //
   // ***** MANIPULATION METHODS ***** //
   // ******************************** //

   /**
    * {@inheritDoc}
    */
   @Override
   public Vector set(double[][] a) {
      super.set(a);
      column = (columns() > rows());
      return this;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public Vector set(double[] v) {
      set(new double[][] { v });
      return this;
   }

   /**
    * {@inheritDoc}
    * 
    * Unsafe method, does not perform dimension checks.
    */
   @Override
   public Vector set(int i, double n) {
      if (column) {
         set(i, 0, n);
      } else {
         set(0, i, n);
      }
      return this;
   }

   /**
    * {@inheritDoc}
    * 
    * Unsafe method, does not perform dimension checks.
    */
   @Override
   public Vector set(int i, double[] v) {
      if (column) {
         set(i, 0, new double[][] { v });
      } else {
         set(0, i, new double[][] { v });
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
   public Vector transpose() {
      super.transpose();
      return this;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public Vector scale(double a) {
      super.scale(a);
      return this;
   }

   /**
    * {@inheritDoc}
    * 
    * Unsafe method, does not perform dimension checks.
    */
   @Override
   public Vector add(IVector v) {
      add((IMatrix) v);
      return this;
   }

   /**
    * {@inheritDoc}
    * 
    * Unsafe method, does not perform dimension checks.
    */
   @Override
   public Vector subtract(IVector v) {
      subtract((IMatrix) v);
      return this;
   }

   /**
    * {@inheritDoc}
    * 
    * Unsafe method, does not perform dimension checks.
    */
   @Override
   public Vector dotMultiply(IVector v) {
      dotMultiply((IMatrix) v);
      return this;
   }

   /**
    * {@inheritDoc}
    * 
    * Unsafe method, does not perform dimension checks.
    */
   @Override
   public Vector dotDivide(IVector v) {
      dotDivide((IMatrix) v);
      return this;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public Matrix outer(IVector v) {
      double[][] a = new double[length()][v.length()];
      for (int i = 0; i < length(); i++) {
         for (int j = 0; j < v.length(); j++) {
            a[i][j] = get(i) * get(j);
         }
      }
      return new Matrix(a);
   }

   /**
    * {@inheritDoc}
    * 
    * Unsafe method, does not perform dimension checks.
    */
   @Override
   public double inner(IVector v) {
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
    * {@inheritDoc}
    */
   @Override
   public Vector copy() {
      return new Vector(this);
   }

}
