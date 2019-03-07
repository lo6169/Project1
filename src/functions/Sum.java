package functions;

import java.util.ArrayList;

public class Sum extends Function
{
    public ArrayList<Function> sums = new ArrayList<>();

    public Sum(Function...vals)
    {
        for (Function val : vals)
        {
            sums.add(val);
        }
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
