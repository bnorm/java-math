package math.matrices;

/**
 * The object representation of a mathematical vector. This class provides an
 * implementation for basic use. This is not a safe vector. It does not perform
 * any dimension checks before performing any actions.
 * 
 * @author Brian Norman
 * @version 0.1 beta
 */
public class Vector extends AbstractVector {

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
      super(new double[length]);
   }

   /**
    * Creates a new row vector with the specified array as a base. if the
    * resulting vector is modified the original vector will change as well.
    * 
    * @param v
    *           the base vector of the matrix.
    */
   public Vector(double[] v) {
      super(v);
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

   /**
    * Creates a new vector that is a copy of the specified matrix. If the matrix
    * is not a vector then a vector of size zero is created.
    * 
    * @param m
    *           the matrix to copy.
    */
   public Vector(IMatrix m) {
      this();
      if (m.rows() == 1) {
         set(m.getRow(0));
      } else if (m.columns() == 1) {
         set(m.getColumn(0));
      }
      // else throw error?
   }

   // *************************** //
   // ***** UTILITY METHODS ***** //
   // *************************** //

   /**
    * {@inheritDoc}
    */
   @Override
   public IVector copy() {
      return new Vector(this);
   }

}
