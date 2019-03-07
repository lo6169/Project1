import functions.*;

/**
 * This class, FunctionTest2,
 * is used to test all of the
 * functions within the Function
 * heirarchy for the first part,
 * including product, derivative,
 * and integral, on top of all
 * those tested in FunctionTest1.
 */
public class FunctionTest2
{
    /**
     * Here we will test to see if the product class
     * is fully functional. We will use constants, variables,
     * nothing, sums, and a mixture. Later it will be tested in the
     * sin and cos classes, as well.
     */
    public static void TestProducts()
    {
        System.out.println("----------Testing Products:----------");
        System.out.println(new Product(new Sum(new Constant(8), new Constant(27)), new Variable()));
        System.out.println(new Product());
        System.out.println(new Product(new Variable(), new Variable()));
        System.out.println(new Product(new Sum(new Constant(8.25), new Variable(), new Constant(-9.25)),
                new Variable(), new Constant(7)));
        System.out.println("\n");
    }

    /**
     * Here we will test the sin class
     * to ensure that it prints out everything
     * as it should. Later on, we will be evaluating these
     * functions.
     */
    public static void TestSin()
    {
        System.out.println("----------Testing Sin:----------");
        System.out.println(new Sin(new Constant(12)));
        System.out.println(new Sin (new Sum(new Constant(5), new Variable())));
        System.out.println(new Sin(new Sin(new Sin(new Variable()))));
        System.out.println(new Sin(new Product(new Sin(new Variable()), new Variable())));
        System.out.println("\n");
    }

    /**
     * Here we will test the cos class
     * to ensure that it prints out everything
     * as it should. Later on, we will be evaluating
     * these functions to ensure they give the proper answer.
     */
    public static void TestCos()
    {
        System.out.println("----------Testing Cos:----------");
        System.out.println(new Cos(new Constant(12)));
        System.out.println(new Cos(new Sum(new Constant(5), new Variable())));
        System.out.println(new Cos(new Cos(new Cos(new Variable()))));
        System.out.println(new Cos(new Sin(new Variable())));
        System.out.println(new Cos(new Product (new Sin(new Variable()), new Constant(8))));
        System.out.println("\n");
    }

    /**
     * Here we will be testing evaluate in regards
     * to products, sin, and cos functions.
     * Within all of these, we will include tests from
     * the previous methods, including
     * addition, constants, and variables.
     */
    public static void TestEval()
    {
        System.out.println("----------Testing Evaluate:----------");
        System.out.println((new Product(new Constant(5), new Constant(5))).evaluate(5));
        System.out.println(new Product(new Constant(5), new Variable()).evaluate(5));
        System.out.println(new Product(new Sum(new Constant(5), new Variable()), new Constant(12)).evaluate(5));
        System.out.println(new Product(new Constant(5), new Sin(new Variable())).evaluate(0));
        System.out.println(new Product(new Constant(5), new Cos(new Variable())).evaluate(0));
        System.out.println("\n");
    }

    /**
     * Here we will be testing the derivative function
     * to ensure that we get the proper derivative for
     * every answer, including constants, variables,
     * sums, products, sin, and cos.
     */
    public static void TestDerivative()
    {
        System.out.println("----------Testing Derivative:----------");
        System.out.println(new Constant(5).derivative());
        System.out.println(new Variable().derivative());
        System.out.println(new Product(new Constant(5), new Variable()).derivative());
        System.out.println(new Sum(new Constant(5), new Variable()).derivative());
        System.out.println(new Sum(new Constant(5), new Product(new Variable(), new Variable())).derivative());
        System.out.println(new Sin(new Variable()).derivative());
        System.out.println(new Cos(new Variable()).derivative());
        System.out.println("\n");
    }

    /**
     * Here we will be testing the integral function
     * to ensure that we get the proper integrand for
     * every answer, including constants, variables,
     * sums, products, sin, and cos.
     */
    public static void TestIntegral()
    {
        System.out.println("----------Testing Integral:----------");
        System.out.println(new Constant(12).integral(0, 1, 100));
        System.out.println(new Constant(12).integral(0, 2, 100));
        System.out.println(new Variable().integral(0, 1, 100));
        System.out.println(new Sum(new Constant(5), new Constant(5)).integral(0, 1, 100));
        System.out.println(new Sum(new Constant(5), new Constant(5)).integral(0, 2, 100));
    }


    public static void main(String[] args)
    {
        TestProducts();
        TestSin();
        TestCos();
        TestEval();
        TestDerivative();
        TestIntegral();
    }
}


/**
 * Expected output
 * ----------Testing Products:----------
 * ((8.0 + 27.0) * X)
 * (1.0)
 * (X * X)
 * ((8.25 + X + -9.25) * X * 7.0)
 *
 *
 * ----------Testing Sin:----------
 * sin (12.0)
 * sin ((5.0 + X))
 * sin (sin (sin (X)))
 * sin ((sin (X) * X))
 *
 *
 * ----------Testing Cos:----------
 * cos (12.0)
 * cos ((5.0 + X))
 * cos (sin (X))
 * cos ( (sin (X) * 8.0))
 *
 *
 * ----------Testing Evaluate:----------
 * 25.0
 * 25.0
 * 120.0
 * 0.0
 * 5.0
 *
 *
 * ----------Testing Derivative:----------
 * 0.0
 * 1.0
 * ((0.0 * (0.0 * X)) + ((1.0 * 5.0) * 1.0))
 * (0.0 + 1.0)
 * (0.0 + ((1.0 * (1.0 * X) + ((1.0 * X) + 1.0)))
 * (cos ( X ) * 1.0)
 * (-1.0 * cos (X ) * 1.0)
 *
 *
 *----------Testing Integral:----------
 * 12.0
 * 24.0
 * 0.5
 * 10.0
 * 20.0
 *
 */