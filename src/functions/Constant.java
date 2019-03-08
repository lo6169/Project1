package functions;

public class Constant extends Function
{
    private double val;

    public Constant(double val)
    {
        this.val = val;
    }

    /**
     * The isConstant abstract function will
     * end up returning whether or not Function
     * f, the parameter, is a constant, meaning that
     * it holds no variables and the answer
     * will remain the same regardless of the
     * value of x.
     * @param  - the given function
     * @return - if the function is constant
     * or not.
     */
    @Override
    public boolean isConstant() {
        return true;
    }

    /**
     * Create a toString override that will end up
     * creating a more appealing and readable
     * version of whatever function is
     * being called with it.
     * @return the new, easily read
     * string.
     */
    public String toString()
    {
        return Double.toString(this.val);
    }

    /**
     * The derivative function will take the
     * given function, f, and return its derivative
     * in the form of another function. The
     * derivative is the measure of a slope.
     * @param
     * @return a new function that is the
     * derivative of the old function.
     */
    @Override
    public Function derivative() {
        return new Constant(0);
    }

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
    @Override
    public double integral(double b, double a, int trap) {
        double x = new Product(new Constant(val), new Variable()).evaluate(a) -
                new Product(new Constant(val), new Variable()).evaluate(b);
        return x;
    }

    /**
     * Evaluate the given function using
     * the value of x to solve for it. Return
     * a double.
     * @param x - The double value of the variable.
     * @return The double value of the function.
     */
    @Override
    public double evaluate(double x) {
        return val;
    }

}
