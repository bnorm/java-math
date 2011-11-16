package math.matrices;

/**
 * The object representation of a mathematical vector. This interface provides
 * basic use and manipulation methods.
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
   public int length();

   /**
    * Returns the value of the vector at the specified index. This index is
    * along the length of the vector.
    * 
    * @param i
    *           the index of the value.
    * @return the value at the specified index.
    */
   public double get(int i);

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
   public IVector set(double[] v);

   /**
    * Sets the value at the corresponding index to be the specified value.
    * 
    * @param i
    *           the index of the value.
    * @param n
    *           the specified value.
    * @return the original matrix modified with the new value.
    */
   public IVector set(int i, double n);

   /**
    * Sets all the values starting at the corresponding index with the specified
    * values.
    * 
    * @param i
    *           the starting index of the new values.
    * @param v
    *           the new values.
    * @return the original matrix modified with the new values.
    */
   public IVector set(int i, double[] v);

   // ***************************** //
   // ***** OPERATION METHODS ***** //
   // ***************************** //

   /**
    * {@inheritDoc}
    */
   @Override
   public IVector transpose();

   /**
    * {@inheritDoc}
    */
   @Override
   public IVector scale(double t);

   /**
    * Adds the specified vector to the original vector. This operation is value
    * based and will add corresponding index values. This method modifies the
    * original values of the vector.
    * 
    * @param v
    *           the vector to add.
    * @return the original vector modified with the addition of the specified a
    *         vector.
    */
   public IVector add(IVector v);

   /**
    * Subtracts the specified vector to the original vector. This operation is
    * value based and will subtract corresponding index values. This method
    * modifies the original values of the vector.
    * 
    * @param v
    *           the vector to subtract.
    * @return the original vector modified with the subtraction of the specified
    *         vector.
    */
   public IVector subtract(IVector v);

   /**
    * Dot-wise multiplies the specified vector to the original vector. This
    * operation is value based and will multiply corresponding index values.
    * This method modifies the original values of the vector.
    * 
    * @param v
    *           the vector to dot-multiply.
    * @return the original vector modified with the dot-multiplication of the
    *         specified vector.
    */
   public IVector dotMultiply(IVector v);

   /**
    * Dot-wise divides the specified vector to the original vector. This
    * operation is value based and will divide corresponding index values. This
    * method modifies the original values of the vector.
    * 
    * @param v
    *           the vector to dot-divide.
    * @return the original vector modified with the dot-division of the
    *         specified vector.
    */
   public IVector dotDivide(IVector v);

   /**
    * Returns the cross-product, or outer-product, of the vector and the
    * specified vector.
    * 
    * @param v
    *           the crossing vector.
    * @return the cross-product of the vector crossed by the specified vector.
    */
   public IMatrix cross(IVector v);

   /**
    * Returns the dot-product, or inner-product, of the vector and the specified
    * vector.
    * 
    * @param v
    *           the dotting vector.
    * @return the dot-product of the vector dotted by the specified vector.
    */
   public double dot(IVector v);

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
