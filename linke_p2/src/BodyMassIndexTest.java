import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest
{
    @Test
    public void testcalcBMITwoPosDoub()
    {
        BodyMassIndex bmi = new BodyMassIndex(10, 10);
        assertEquals(70.3, bmi.calcBMI());
    }

    @Test
    public void testcalcBMITwoNegDoub()
    {
        BodyMassIndex bmi = new BodyMassIndex(-10, -10);
        assertEquals(-70.3, bmi.calcBMI());
    }

    @Test
    public void testcalcBMINegHeightPosWeight()
    {
        BodyMassIndex bmi = new BodyMassIndex(-10, 10);
        assertEquals(70.3, bmi.calcBMI());
    }

    @Test
    public void testcalcBMIPosHeightNegWeight()
    {
        BodyMassIndex bmi = new BodyMassIndex(10, -10);
        assertEquals(-70.3, bmi.calcBMI());
    }

    @Test
    public void testcalcBMITwoPosDoubHardCodeCheck()
    {
        BodyMassIndex bmi = new BodyMassIndex(20, 5);
        assertEquals(8.7875, bmi.calcBMI());
    }

    @Test
    public void testUnderweightCategory()
    {
        BodyMassIndex bmi = new BodyMassIndex(100, 10);
        assertEquals("underweight", bmi.bmiCategory());
    }

    @Test
    public void testNormWeightCategory()
    {
        BodyMassIndex bmi = new BodyMassIndex(100, 300);
        assertEquals("normal weight", bmi.bmiCategory());
    }

    @Test
    public void testOverweightCategory()
    {
        BodyMassIndex bmi = new BodyMassIndex(100, 400);
        assertEquals("overweight", bmi.bmiCategory());
    }

    @Test
    public void testObeseCategory()
    {
        BodyMassIndex bmi = new BodyMassIndex(100, 500);
        assertEquals("obese", bmi.bmiCategory());
    }

    @Test
    public void testgetBMI()
    {
        BodyMassIndex bmi = new BodyMassIndex(10, 10);
        assertEquals(70.3, bmi.getBMI());
    }
}