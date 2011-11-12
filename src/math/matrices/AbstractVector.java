package math.matrices;

/**
 * The object representation of a mathematical vector. This abstract class
 * provides an implementation for basic use.
 * 
 * @author Brian Norman
 * @version 0.1 beta
 */
public abstract class AbstractVector extends AbstractMatrix implements IVector {

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
    * Creates a new row vector with the specified array as a base. if the
    * resulting vector is modified the original vector will change as well.
    * 
    * @param v
    *           the base vector of the matrix.
    */
   protected AbstractVector(double[] v) {
      super(new double[][] { v });
   }

   /**
    * Creates a new vector with a copy of the specified vector.
    * 
    * @param v
    *           the vector to copy.
    */
   protected AbstractVector(AbstractVector v) {
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
   // ***** MUNIPULATION METHODS ***** //
   // ******************************** //

   /**
    * Sets the vector to be the specified array. This methods does not copy but
    * sets the array which will change if the vector is modified.
    * 
    * @param v
    *           the new array for the matrix.
    * @return the vector representation of the array.
    */
   protected IVector set(double[] v) {
      set(new double[][] { v });
      return this;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   protected AbstractMatrix set(double[][] a) {
      super.set(a);
      column = (columns() > rows());
      return this;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public IVector set(int i, double n) {
      if (column) {
         set(i, 0, n);
      } else {
         set(0, i, n);
      }
      return this;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public IVector set(int i, double[] v) {
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
   public AbstractVector transpose() {
      super.transpose();
      return this;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public AbstractVector scale(double a) {
      super.scale(a);
      return this;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public IVector add(IVector v) {
      add((IMatrix) v);
      return this;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public IVector subtract(IVector v) {
      subtract((IMatrix) v);
      return this;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public IVector dotMultiply(IVector v) {
      dotMultiply((IMatrix) v);
      return this;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public IVector dotDivide(IVector v) {
      dotDivide((IMatrix) v);
      return this;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public IMatrix cross(IVector v) {
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
    */
   @Override
   public double dot(IVector v) {
      double sum = 0;
      for (int i = 0; i < length(); i++) {
         sum += get(i) * v.get(i);
      }
      return sum;
   }

}
