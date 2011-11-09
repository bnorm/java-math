package math.matrices;


/**
 * A object representation of a mathematical matrix. This interface provides
 * basic use and manipulation methods.
 * 
 * @author Brian Norman
 * @version 0.1 beta
 */
public interface IMatrix {

    // ************************** //
    // ***** ACCESS METHODS ***** //
    // ************************** //

    /**
     * Returns the number of rows the matrix has.
     * 
     * @return the number of rows.
     */
    public int rows();

    /**
     * Returns the number of columns the matrix has.
     * 
     * @return the number of columns.
     */
    public int columns();

    /**
     * Returns the value at the corresponding row and column.
     * 
     * @param r
     *            the row of the value.
     * @param c
     *            the column of the value.
     * @return the value at the row and column.
     */
    public double get(int r, int c);

    /**
     * Returns all the elements in the corresponding row.
     * 
     * @param r
     *            the row of all the elements.
     * @return all the elements in the row.
     */
    public double[] getRow(int r);

    /**
     * Returns all the elements in the corresponding column.
     * 
     * @param c
     *            the column of all the elements.
     * @return all the elements in the column.
     */
    public double[] getColumn(int c);

    // ******************************** //
    // ***** MUNIPULATION METHODS ***** //
    // ******************************** //

    /**
     * Sets the value at the corresponding row and column with the specified new
     * value.
     * 
     * @param r
     *            the row of the new value.
     * @param c
     *            the column of the new value.
     * @param n
     *            the new value.
     * @return the original matrix modified with the new value.
     */
    public IMatrix set(int r, int c, double n);

    /**
     * Sets all the values of the corresponding row with the specified new
     * values.
     * 
     * @param r
     *            the row of the new values.
     * @param v
     *            the new values.
     * @return the original matrix modified with the new values.
     */
    public IMatrix setRow(int r, double[] v);

    /**
     * Sets all the values of the corresponding column with the specified new
     * values.
     * 
     * @param c
     *            the column of the new values.
     * @param v
     *            the new values.
     * @return the original matrix modified with the new values.
     */
    public IMatrix setColumn(int c, double[] v);

    /**
     * Sets all the values starting at the corresponding row and column with the
     * specified values.
     * 
     * @param r
     *            the starting row of new values.
     * @param c
     *            the starting column of new values.
     * @param a
     *            the new values.
     * @return the original matrix modified with the new values.
     */
    public IMatrix set(int r, int c, double[][] a);

    // ***************************** //
    // ***** OPERATION METHODS ***** //
    // ***************************** //

    /**
     * Returns the transpose of the matrix. This operation does not create a new
     * matrix but modifies the original matrix.
     * 
     * @return the transpose of the matrix.
     */
    public IMatrix transpose();

    /**
     * Returns the inverse of the matrix. This operation does not create a new
     * matrix but modifies the original matrix.
     * 
     * @return the inverse of the matrix.
     */
    public IMatrix inverse();

    /**
     * Scales the matrix by multiplying the specified value against all the
     * values of this matrix. This method modifies the original values of the
     * matrix.
     * 
     * @param n
     *            the scaling factor.
     * @return the original matrix multiplied by the scaling factor.
     */
    public IMatrix scale(double n);

    /**
     * Adds the specified matrix to the original matrix. This operation is value
     * based and will add corresponding row-column values. This method modifies
     * the original values of the matrix.
     * 
     * @param a
     *            the matrix to add.
     * @return the original matrix modified with the addition of the specified
     *         matrix.
     */
    public IMatrix add(IMatrix a);

    /**
     * Subtracts the specified matrix to the original matrix. This operation is
     * value based and will subtract corresponding row-column values. This
     * method modifies the original values of the matrix.
     * 
     * @param a
     *            the matrix to subtract.
     * @return the original matrix modified with the subtraction of the
     *         specified matrix.
     */
    public IMatrix subtract(IMatrix a);

    /**
     * Matrix-multiplies the specified matrix against the original matrix. This
     * method modifies the original matrix by setting it equal to the resulting
     * matrix.
     * 
     * @param a
     *            the matrix to matrix-multiply.
     * @return the original matrix modified with the matrix-multiplication by
     *         the specified matrix.
     */
    public IMatrix multiply(IMatrix a);

    /**
     * Dot-wise multiplies the specified matrix to the original matrix. This
     * operation is value based and will multiply corresponding row-column
     * values. This method modifies the original values of the matrix.
     * 
     * @param a
     *            the matrix to dot-multiply.
     * @return the original matrix modified with the dot-multiplication of the
     *         specified matrix.
     */
    public IMatrix dotMultiply(IMatrix a);

    /**
     * Dot-wise divides the specified matrix to the original matrix. This
     * operation is value based and will divide corresponding row-column values.
     * This method modifies the original values of the matrix.
     * 
     * @param a
     *            the matrix to dot-divide.
     * @return the original matrix modified with the dot-division of the
     *         specified matrix.
     */
    public IMatrix dotDivide(IMatrix a);

    // *************************** //
    // ***** UTILITY METHODS ***** //
    // *************************** //

    /**
     * Returns a copy of the matrix.
     * 
     * @return a copy of the matrix.
     */
    public IMatrix copy();

}
