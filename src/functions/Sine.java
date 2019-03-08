package functions;

public class Sine extends Function
{
    Function val;
    public Sine(Function val)
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
     * @param - the given function
     * @return - if the function is constant
     * or not.
     */
    @Override
    public boolean isConstant() {
        return val.isConstant();
    }

    /**
     * Create a toString override that will end up
     * creating a more appealing and readable
     * version of whatever function is
     * being called with it.
     * @return the new, easily read
     * string.
     */
    @Override
    public String toString() {
        String str = "sin (";
        str += val;
        str += " )";
        return str;
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
            return new Product(new Cosine(val), val.derivative());
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
        return Math.sin(x);
    }
}
