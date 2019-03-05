package functions;

public class Cos extends Function
{
    public Function[] cos;
    int amntvals;

    public Cos(Function ... vals)
    {
        int index = 0;
        amntvals = 0;
        for (Function val : vals)
        {
            cos[index] = val;
            index++;
            amntvals++;
        }
    }

    /**
     * The isConstant abstract function will
     * end up returning whether or not Function
     * f, the parameter, is a constant, meaning that
     * it holds no variables and the answer
     * will remain the same regardless of the
     * value of x.
     * @param f - the given function
     * @return - if the function is constant
     * or not.
     */
    @Override
    public boolean isConstant(Function f) {
        return false;
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
        String str = "cos ( ";
        for (Function c : cos)
        {
            str += c;
        }
        str += ")";
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
    public Function derivative()
    {
        int i = -1;
        Function[] fn = new Function[amntvals-1];
        for (Function f : cos)
        {
            if (i == -1)
            {
                i++;
            }
            else
            {
                fn[i] = f;
                i++;
            }

        }
        return new Product (new Constant (-1), new Sin(), derivative());
    }

    /**
     * The integral function will take
     * the given function, f, and return its
     * integral in the form of a double. The
     * integral is the area underneath
     * the curve/function, which we will find
     * using the trapezoid method.
     * @param f, x - the function and the
     *           double value of x we will use
     *           to evaluate the function.
     * @return the value of the integral.
     */
    @Override
    public double integral(Function f, double x) {
        return 0;
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
        return Math.cos(evaluate(x));
    }
}
