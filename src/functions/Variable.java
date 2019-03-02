package functions;

public class Variable extends Function
{
    public static final Variable X = new Variable();

    public Variable()
    {

    }

    @Override
    public boolean isConstant(Function f) {
        return false;
    }

    public String toString()
    {
        return "X";
    }

    @Override
    public Function derivative(Function f) {
        return new Constant(1);
    }

    @Override
    public double integral(Function f) {
        return 0;
    }

    @Override
    public double evaluate(double x) {
        return x;
    }
}
