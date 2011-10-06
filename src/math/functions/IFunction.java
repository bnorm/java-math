package math.functions;

/**
 * Defines a mathematical relationship that represents a function. Used to
 * describe a relationship between an input space and an output space. For the
 * case of this representation the space is one dimensional.
 * 
 * @author Brian Norman
 * @version 0.1 beta
 * @since 0.1 beta
 */
public interface IFunction {

  /**
   * Defines a mathematical relationship between an input and an output value.
   * 
   * @param x
   *          input value.
   * @return output value.
   */
  public double f(double x);

  /**
   * Returns a new function that is a copy of this class and has the specified
   * value added to its output.
   * 
   * @param a
   *          the value by which the output is shifted.
   * @return a new shifted function.
   */
  public IFunction add(double a);

  /**
   * Returns a new function that is a copy of this class and has the specified
   * function at the same input added to its output.
   * 
   * @param f
   *          the function by which this class is shifted.
   * @return a new shifted function.
   */
  public IFunction add(IFunction f);

  /**
   * Returns a new function that is a copy of this class and has the specified
   * value subtracted from its output.
   * 
   * @param a
   *          the value by which the output is shifted.
   * @return a new shifted function.
   */
  public IFunction subtract(double a);

  /**
   * Returns a new function that is a copy of this class and has the specified
   * function at the same input subtracted from its output.
   * 
   * @param f
   *          the function by which this class is shifted.
   * @return a new shifted function.
   */
  public IFunction subtract(IFunction f);

  /**
   * Returns a new function that is a copy of this class and has its output
   * multiplied by the specified value.
   * 
   * @param a
   *          the value by which the output is scaled.
   * @return a new scaled function.
   */
  public IFunction multiply(double a);

  /**
   * Returns a new function that is a copy of this class and has its output
   * multiplied by the specified function at the same input.
   * 
   * @param f
   *          the function by which the output is scaled.
   * @return a new scaled function.
   */
  public IFunction multiply(IFunction f);

  /**
   * Returns a new function that is a copy of this class and has its output
   * divided by the specified function at the same input.
   * 
   * @param f
   *          the function by which the output is scaled.
   * @return a new scaled function.
   */
  public IFunction divide(IFunction f);

  /**
   * Returns a new function that is a copy of this class and has its output
   * divided by the specified value.
   * 
   * @param a
   *          the value by which the output is scaled.
   * @return a new scaled function.
   */
  public IFunction divide(double a);

  /**
   * Returns a new function that is a copy of this class and has its input first
   * evaluated by the specified function and uses that as input.
   * 
   * @param f
   *          the function that evaluates the input first.
   * @return a new composite function.
   */
  public IFunction composite(IFunction f);

}
