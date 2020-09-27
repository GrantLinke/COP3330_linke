public class BodyMassIndex
{
    private double height, weight;
    public BodyMassIndex(double height, double weight)
    {
        this.height = height;
        this.weight = weight;
    }

    public BodyMassIndex(BodyMassIndex bmi)
    {
        this.height = bmi.height;
        this.weight = bmi.weight;
    }

    public double calcBMI()
    {
        return 703 * this.weight / (this.height * this.height);
    }

    public double getBMI()
    {
        return calcBMI();
    }

    public String bmiCategory()
    {
        if (getBMI() < 18.5)
        {
            return "underweight";
        }

        else if (getBMI() < 24.9)
        {
            return "normal weight";
        }

        else if(getBMI() < 29.9)
        {
            return "overweight";
        }

        else {
            return "obese";
        }
    }

}
