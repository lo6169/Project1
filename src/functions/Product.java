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

    @Override
    public boolean isConstant(Function f) {
        return false;
    }

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

    @Override
    public Function derivative(Function f) {
        return null;
    }

    @Override
    public double integral(Function f) {
        return 0;
    }

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
