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
     * @param - the given function
     * @return - if the function is constant
     * or not.
     */
    @Override
    public boolean isConstant() {
        for (Function s : products)
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
    @Override
    public String toString()
    {
        String str = "(";
        for (Function prod : products)
        {
            str += prod + " * ";
        }
        int x = str.length();
        if (x >= 3)
        {
            str = str.substring(0, x-3);
            str += ")";
            return str;
        }
        else
        {
            return "(1.0)";
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
     *
     *
     * val * val2.d + val.d * val2
     */
    @Override
    public Function derivative() {
        Product[] pn = new Product[products.size()];
        Function[] fn = new Function[products.size()];
        int index = 0;
        int index2;
        for (Function prod : products) {
            index2 = 0;
            for (Function f : products) {
                if (index != index2) {
                    fn[index2] = new Product(prod.derivative(), f);
                }
                index2++;
            }
            fn[index] = prod.derivative();
            pn[index] = new Product(fn);
            index++;
        }

        return new Sum(pn);
    }

    // Low is b, high is a
    @Override
    public double integral(double b, double a, int trap) {
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
