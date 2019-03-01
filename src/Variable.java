public class Variable extends Function
{
    private static final Variable x = new Variable();

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
    public double derivative(Function f) {
        return 0;
    }

    @Override
    public double integral(Function f) {
        return 0;
    }

    @Override
    public double evaluate(double x, Function f) {
        return x;
    }
}