public abstract class Function
{
    public boolean isConstant(Node f)
    {
        return false;
    }
    @Override
    public abstract String toString();

    public double derivative(Function f)
    {
        return 0;
    }
    public double integral(Function f)
    {
        return 0;
    }
    public double evaluate(double x)
    {
        return 0;
    }

}
