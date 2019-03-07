import functions.Constant;
import functions.Sum;
import functions.Variable;

/**
 * This class, FunctionTest1,
 * is used to test all of the
 * functions within the Function
 * heirarchy for the first part,
 * including constant, variable,
 * and sum.
 */
public class FunctionTest1
{
    /**
     * Test to make sure that
     * the constants exist as they should
     * and keep all values.
     */
    public static void TestConstant()
    {
        System.out.println("----------Testing Constants:----------");
        System.out.println(new Constant(7.0));
        System.out.println(new Constant(18.73));
        System.out.println(new Constant(-194.2567));
        System.out.println("\n");
    }

    /**
     * Test to ensure that the variable, X,
     * exists as it should be.
     */
    public static void TestVariable()
    {
        System.out.println("----------Testing Variables:----------");
        System.out.println(new Variable());
        System.out.println("\n");
    }

    /**
     * Make sure that the sums
     * are being printed out as they should be,
     * and that they are in correct form.
     */
    public static void TestSums()
    {
        System.out.println("----------Testing Sums:----------");
        System.out.println(new Sum(new Constant(12), new Constant(3)));
        System.out.println(new Sum(new Constant(18.3), new Constant(-5.25)));
        System.out.println(new Sum(new Constant(62), new Variable()));
        System.out.println(new Sum(new Constant(27), new Variable(), new Variable()));
        System.out.println(new Sum());
        System.out.println("\n");
    }

    /**
     * Test the evaluate function to make sure
     * that all of the output is as desired when evaluating
     * and that the mathematical functions are
     * being done correctly.
     */
    // ISSUE
    public static void TestEvaluate()
    {
        System.out.println("----------Testing Evaluate:----------");
        System.out.println((new Sum(new Constant(5), new Constant(5))).evaluate(12));
        System.out.println(new Sum(new Variable(), new Constant(12), new Variable()).evaluate(4));
        System.out.println(new Variable().evaluate(7));
        System.out.println(new Constant(5).evaluate(12));
        System.out.println(new Sum().evaluate(2));
    }

    /**
     * Test the isConstant function
     * to ensure that all variables / functions
     * with variables will return false.
     */
    // ISSUE
    public static void TestisConstant()
    {
        System.out.println("----------Testing isConstant:----------");
        System.out.println(new Sum(new Constant(8), new Variable()).isConstant());
        System.out.println(new Constant(5).isConstant());
        System.out.println(new Variable().isConstant());
        System.out.println(new Sum(new Constant(10), new Constant(80), new Constant(100)).isConstant());
        System.out.println(new Sum(new Variable(), new Variable()).isConstant());
    }

    public static void main(String[] args)
    {
        TestConstant();
        TestVariable();
        TestSums();
        TestEvaluate();
        TestisConstant();

    }
}

/**
 * Expected results:
 * ----------Testing Constants:----------
 * 7.0
 * 18.73
 * -194.2567
 *
 *
 * ----------Testing Variables:----------
 * X
 *
 *
 * ----------Testing Sums:----------
 * (12.0 + 3.0)
 * (18.3 + - 5.25)
 * (62.0 + X)
 * (27.0 + X + X)
 * 0.0
 *
 *
 * ----------Testing Evaluate:----------
 * 10.0
 * 20.0
 * 7.0
 * 5.0
 * 0.0
 *
 *
 * ----------Testing isConstant:----------
 * false
 * true
 * false
 * true
 * false
 */
