package sample;

public abstract class Formula
{
    double a;
    double b;
    int koef;

    public Formula(double a, double b, int koef)
    {
        this.a = a;
        this.b = b;
        this.koef = koef;
    }

    public void setA(double a)
    {
        this.a = a;
    }

    public void setB(double b)
    {
        this.b = b;
    }

    public void setKoef(int koef)
    {
        this.koef = koef;
    }

    public abstract int getX(double t);
    public abstract int getY(double t);
    public abstract String getName();
}
