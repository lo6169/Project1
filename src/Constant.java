public class Constant extends Function
{
    double val;

    public Constant(double val)
    {
        this.val = val;
    }

    public String toString()
    {
        return Double.toString(val);
    }
}
