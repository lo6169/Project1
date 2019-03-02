package functions;

import functions.Function;

import java.util.ArrayList;

public class Cos extends Function
{
    public ArrayList<Function> cos = new ArrayList<>();

    public Cos(Function ... vals)
    {
        for (Function val : vals)
        {
            cos.add(val);
        }
    }

    @Override
    public boolean isConstant(Function f) {
        return false;
    }

    @Override
    public String toString() {
        String str = "cos ( ";
        str += " )";
        return str;
    }

    @Override
    public Function derivative(Function f) {
        return new Product (new Constant (-1), new Sin(f), derivative(f));
    }

    @Override
    public double integral(Function f) {
        return 0;
    }

    @Override
    public double evaluate(double x) {
        return Math.cos(evaluate(x));
    }
}
