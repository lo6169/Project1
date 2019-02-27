import java.util.ArrayList;

public class Sum extends Function
{
    public ArrayList<Function> sums = new ArrayList<>();
    public boolean constant = true;

    public Sum(Function...vals)
    {
        for (Function val : vals)
        {
            sums.add(val);
            if (val instanceof Variable)
            {
                constant = false;
            }
        }
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

    public Function addSums()
    {
        if (constant)
        {
            for (Function val : sums)
            {
              //  total.add(val);
            }
            return null;
        }
        return null;
    }

}
