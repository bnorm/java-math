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
public abstract class AbstractFunction implements IFunction {

  /**
   * {@inheritDoc}
   */
  public IFunction add(final double a) {
    return new AbstractFunction() {
      @Override
      public double f(double x) {
        return AbstractFunction.this.f(x) + a;
      }
    };
  }

  /**
   * {@inheritDoc}
   */
  public IFunction add(final IFunction f) {
    return new AbstractFunction() {
      @Override
      public double f(double x) {
        return AbstractFunction.this.f(x) + f.f(x);
      }
    };
  }

  /**
   * {@inheritDoc}
   */
  public IFunction subtract(final double a) {
    return add(-a);
  }

  /**
   * {@inheritDoc}
   */
  public IFunction subtract(final IFunction f) {
    return new AbstractFunction() {
      @Override
      public double f(double x) {
        return AbstractFunction.this.f(x) - f.f(x);
      }
    };
  }

  /**
   * {@inheritDoc}
   */
  public IFunction multiply(final double a) {
    return new AbstractFunction() {
      @Override
      public double f(double x) {
        return AbstractFunction.this.f(x) * a;
      }
    };
  }

  /**
   * {@inheritDoc}
   */
  public IFunction multiply(final IFunction f) {
    return new AbstractFunction() {
      @Override
      public double f(double x) {
        return AbstractFunction.this.f(x) * f.f(x);
      }
    };
  }

  /**
   * {@inheritDoc}
   */
  public IFunction divide(final double a) {
    return multiply(1.0 / a);
  }

  /**
   * {@inheritDoc}
   */
  public IFunction divide(final IFunction f) {
    return new AbstractFunction() {
      @Override
      public double f(double x) {
        return AbstractFunction.this.f(x) / f.f(x);
      }
    };
  }

  /**
   * {@inheritDoc}
   */
  public IFunction composite(final IFunction f) {
    return new AbstractFunction() {
      @Override
      public double f(double x) {
        return AbstractFunction.this.f(f.f(x));
      }
    };
  }

}
