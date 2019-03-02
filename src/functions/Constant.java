package functions;

public class Constant extends Function
{
    double val;

    public Constant(double val)
    {
        this.val = val;
    }

    @Override
    public boolean isConstant(Function f) {
        return true;
    }

    public String toString()
    {
        return Double.toString(this.val);
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
        return this.val;
    }

}
