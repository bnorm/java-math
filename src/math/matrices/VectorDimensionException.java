package math.matrices;

/**
 * An unchecked exception for when a vector dimension error occurs.  This error could occur when trying to access part
 * of a vector that does not exist or multiplying two vectors together who's dimensions do not agree.
 *
 * @author Brian Norman
 * @version 0.1 beta
 */
public class VectorDimensionException extends RuntimeException {

   /**
    * Determines if a deserialized file is compatible with {@code this class}.
    * <p/>
    * Maintainers must change this value if and only if the new version of {@code this class} is not compatible with
    * old versions.
    */
   private static final long serialVersionUID = 619617926868327090L;

   /**
    * Creates a {@code VectorDimensionException} with no detail message.
    */
   public VectorDimensionException() {
      super();
   }

   /**
    * Creates a {@code VectorDimensionException} with the specified detail message.
    *
    * @param msg the detail message.
    */
   public VectorDimensionException(String msg) {
      super(msg);
   }

}
