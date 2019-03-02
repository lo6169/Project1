package functions;

import java.util.ArrayList;

public class Sin extends Function
{
    public ArrayList<Function> sin = new ArrayList<>();

    public Sin(Function...vals)
    {
        for (Function val : vals)
        {
            sin.add(val);
        }
    }

    @Override
    public boolean isConstant(Function f) {
        return false;
    }

    @Override
    public String toString() {
        String str = "sin (";
        str += " )";
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
        return 0;
    }
}
