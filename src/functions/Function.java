package functions;

/**
 * This is the function class, the parent
 * of all other classes within this package.
 * It will be used for numerous things,
 * and is abstract.
 */
public abstract class Function
{
    /**
     * The isConstant abstract function will
     * end up returning whether or not Function
     * f, the parameter, is a constant, meaning that
     * it holds no variables and the answer
     * will remain the same regardless of the
     * value of x.
     * @param - the given function
     * @return - if the function is constant
     * or not.
     */
    public abstract boolean isConstant();

    /**
     * Create a toString override that will end up
     * creating a more appealing and readable
     * version of whatever function is
     * being called with it.
     * @return the new, easily read
     * string.
     */
    @Override
    public abstract String toString();

    /**
     * The derivative function will take the
     * given function, f, and return its derivative
     * in the form of another function. The
     * derivative is the measure of a slope.
     * @return a new function that is the
     * derivative of the old function.
     */
    public abstract Function derivative();

    /**
     * The integral function will take
     * the given function, f, and return its
     * integral in the form of a double. The
     * integral is the area underneath
     * the curve/function, which we will find
     * using the trapezoid method.
     * @param b - the low value, a -the high value -
     *          trap - the number of trapezoids
     * @return the value of the integral.
     */
    public double integral(double b, double a, int trap)
    {
        double height = (a - b) / trap;
        double total = 0.5 * (evaluate(a) + evaluate(b));

        for (int i = 1; i < trap; i++)
        {
            double x = b + height * i;
            total += evaluate(x);
        }

        return total * height;
    }

    /**
     * Evaluate the given function using
     * the value of x to solve for it. Return
     * a double.
     * @param x - The double value of the variable.
     * @return The double value of the function.
     */
    public abstract double evaluate(double x);

}
