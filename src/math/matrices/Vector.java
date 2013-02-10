package math.matrices;


/**
 * The object representation of a mathematical vector. This class provides an implementation for basic use. This is not
 * a safe vector. It does not perform any dimension checks before performing any actions.
 *
 * @author Brian Norman
 * @version 0.1 beta
 */
public class Vector extends Matrix implements IVector {

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
    * Creates a new vector of the specified length and with all values equaling zero.
    *
    * @param length the length of this vector.
    */
   public Vector(int length) {
      this(new double[length]);
   }

   /**
    * Creates a new row vector with the specified array as a base. if the resulting vector is modified the original
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
   protected Vector(Vector v) {
      super(v);
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
