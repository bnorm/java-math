package math.matrices;

/**
 * Utilities for checking dimensions of matrices and vectors.
 *
 * @author Brian Norman
 * @version 0.1 beta
 */
public final class DimensionChecking {

   /**
    * Private method for utility class.
    */
   private DimensionChecking() {
   }

   /**
    * Catches any out of bounds errors given a matrix and the specified row and column and throws the proper dimension
    * exception.
    *
    * @param self the self matrix.
    * @param r the access row.
    * @param c the access column.
    */
   public static void catchOutOfBounds(IMatrix self, int r, int c) {
      boolean re = (r < 0 || r >= self.rows());
      boolean ce = (c < 0 || c >= self.columns());
      if (re || ce) {
         if (re && ce) {
            throw new MatrixDimensionException(
                    "Row (" + r + ") and column (" + c + ") are not in the range of this matrix's dimensions (" + self
                            .rows() + "x" + self.columns() + ")");
         } else if (re) {
            throw new MatrixDimensionException(
                    "Row (" + r + ") is not in the range of this matrix's dimensions (" + self.rows() + "x" + self
                            .columns() + ")");
         } else {
            throw new MatrixDimensionException(
                    "Column (" + c + ") is not in the range of this matrix's dimensions (" + self.rows() + "x" + self
                            .columns() + ")");
         }
      }
   }

   /**
    * Catches any out of bounds errors given a vector and the specified index and throws the proper dimension
    * exception.
    *
    * @param self the self vector.
    * @param i the access index.
    */
   public static void catchOutOfBounds(IVector self, int i) {
      if (i < 0 || i >= self.length()) {
         throw new VectorDimensionException(
                 "Index (" + i + ") is not in the range of this vector's dimensions (length:" + self.length() + ")");
      }
   }

   /**
    * Catches any equal dimension errors given a matrix and the specified matrix and throws the proper dimension
    * exception.
    *
    * @param self the self matrix.
    * @param a the tested equal matrix.
    */
   public static void catchEqualDimensions(IMatrix self, IMatrix a) {
      if (a == null) {
         throw new NullPointerException("Cannot access a null matrix");
      } else if (self.rows() != a.rows() || self.columns() != a.columns()) {
         throw new MatrixDimensionException(
                 "Matrix dimensions do not agree: (" + self.rows() + "x" + self.columns() + ") and (" + a.rows() + "x"
                         + a.columns() + ")");
      }
   }

   /**
    * Catches any equal dimension errors given a vector and the specified vector and throws the proper dimension
    * exception.
    *
    * @param self the self vector.
    * @param v the tested equal vector.
    */
   public static void catchEqualDimensions(IVector self, IVector v) {
      if (v == null) {
         throw new NullPointerException("Cannot access a null vector");
      } else if (self.length() != v.length()) {
         throw new VectorDimensionException("Vector dimensions do not agree: " + self.length() + " and " + v.length());
      }
   }
}
