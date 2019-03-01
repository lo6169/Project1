public abstract class Function
{
    public Function()
    {

    }

    public abstract boolean isConstant(Function f);

    @Override
    public abstract String toString();

    public abstract double derivative(Function f);

    public abstract double integral(Function f);

    public abstract double evaluate(double x, Function f);

}
