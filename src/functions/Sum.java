package functions;

import java.util.ArrayList;

public class Sum extends Function
{
    public ArrayList<Function> sum = new ArrayList<>();
    public ArrayList<Function> sums = new ArrayList<>();

    public Sum(Function...vals)
    {
        for (Function val : vals)
        {
            sum.add(val);
        }

        double total = 0;
        for (Function s : sum)
        {
            if (s.isConstant())
            {
                total += s.evaluate(4);
            }
            else
            {
                sums.add(s);
            }
        }
        sums.add(new Constant(total));
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
    public boolean isConstant()
    {
        for (Function s : sums)
        {
            if (!(s.isConstant()))
            {
                return false;
            }
        }
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
    public String toString() {
        String str = "(";
        for (Function sum : sums) {
            str += sum + " + ";
        }
        int x = str.length();
        if (x >= 3)
        {
            str = str.substring(0, x - 3);
            str += ")";
            return str;
        }
        else
        {
            return "(0.0)";
        }
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
        Function[] fn = new Function[sums.size()];
        int index = 0;
        for (Function sum : sums)
        {
            fn[index] = sum.derivative();
            index++;
        }
        return new Sum(fn);
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
    public double integral(double b, double a, int trap)
    {
        double total = 0;
        for (Function sum : sums)
        {
            total += sum.integral(b, a, 0);
        }

        return total;
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
        double total = 0;
        for (Function val : sums)
        {
            total += val.evaluate(x);
        }
        return total;
    }

}
