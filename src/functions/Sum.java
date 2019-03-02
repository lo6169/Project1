package functions;

import functions.Constant;

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

    @Override
    public boolean isConstant(Function f)
    {
        for (Function sum : sums)
        {
            if (!(sum instanceof Constant))
            {
                return false;
            }
        }
        return true;
    }

    public String toString()
    {
        String str = "(";
        for (Function sum : sums)
        {
            str += sum + " + ";
        }
        int x = sums.size();
        str = str.substring(0, x-3);
        str += ")";
        return str;
    }

    @Override
    public double derivative(Function f) {
        return 0;
    }

    @Override
    public double integral(Function f) {
        return 0;
    }

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
