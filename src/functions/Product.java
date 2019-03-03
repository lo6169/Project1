package functions;

import java.util.ArrayList;

public class Product extends Function
{
    public ArrayList<Function> products = new ArrayList<>();

    public Product(Function...vals)
    {
        for (Function val : vals)
        {
            products.add(val);
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
    public String toString()
    {
        String str = "(";
        for (Function prod : products)
        {
            str += prod + " * ";
        }
        int x = products.size();
        str = str.substring(0, x-3);
        str += ")";
        return str;
    }

    /**
     * The derivative function will take the
     * given function, f, and return its derivative
     * in the form of another function. The
     * derivative is the measure of a slope.
     * @param f the given function to have the
     *          derivative found.
     * @return a new function that is the
     * derivative of the old function.
     */
    @Override
    public Function derivative(Function f)
    {
        Function[] fn = new Function[products.size()];
        int index = 0;
        int index2 = 0;
        for (Function prod : products)
        {
            index2 = 0;
            for (Function pro : products)
            {
                if (index != index2)
                {
                    fn[index] = new Product (prod, derivative(pro));
                    index2++;
                }
            }
            index++;
        }
        return null;
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
    public double evaluate(double x)
    {
        double total = 1;
        for (Function prod : products)
        {
            total *= prod.evaluate(x);

        }
        return total;
    }

}
