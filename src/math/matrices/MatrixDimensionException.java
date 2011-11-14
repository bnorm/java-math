package math.matrices;

/**
 * An unchecked exception for when a matrix dimension error occurs. This error
 * could occur when trying to access part of a matrix that does not exist or
 * multiplying two matrices together who's dimensions do not agree.
 * 
 * @author Brian Norman
 * @version 0.1 beta
 */
public class MatrixDimensionException extends RuntimeException {

   /**
    * Determines if a deserialized file is compatible with {@code this class}. <br>
    * <br>
    * Maintainers must change this value if and only if the new version of
    * {@code this class} is not compatible with old versions.
    */
   private static final long serialVersionUID = -4196177985686327090L;

   /**
    * Creates a {@code MatrixDimensionException} with no detail message.
    */
   public MatrixDimensionException() {
      super();
   }

   /**
    * Creates a {@code MatrixDimensionException} with the specified detail
    * message.
    * 
    * @param msg
    *           the detail message.
    */
   public MatrixDimensionException(String msg) {
      super(msg);
   }

}
