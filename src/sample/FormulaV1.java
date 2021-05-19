package sample;

public class FormulaV1 extends Formula
{
    public FormulaV1(double a, double b, int koef)
    {
        super(a, b, koef);
    }
    public int getX(double t)
    {
        return this.koef * (int)((this.a - this.b) * Math.cos(t) + this.b * Math.cos(t * (this.a / this.b - 1)));
    }
    public int getY(double t)
    {
        return this.koef * (int)((this.a - this.b) * Math.sin(t) - this.b * Math.sin(t * (this.a / this.b - 1)));
    }
    public String getName()
    {
        return "FormulaV1";
    }
}
