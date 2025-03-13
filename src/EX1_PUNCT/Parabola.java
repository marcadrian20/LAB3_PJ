package EX1_PUNCT;

public class Parabola {
    private int a;
    private int b;
    private int c;

    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public Punct getVarf(){
        return new Punct((float) -b /(2*a), (float) (-(b * b) + 4 * a * c) /(4*a));
    }

    @Override
    public String toString() {
        return "f(x) = " + a +"x^2 + "+b+"x + "+c;
    }
    public Punct getMijloc(Parabola p)
    {
        Punct varf1= this.getVarf();
        Punct varf2= p.getVarf();
        return new Punct((varf1.getX()+varf2.getX())/2,(varf1.getY()+varf2.getY())/2);
    }
    public static Punct getMijloc(Parabola p,Parabola p2)
    {
        Punct varf1= p.getVarf();
        Punct varf2= p2.getVarf();
        return new Punct((varf1.getX()+varf2.getX())/2,(varf1.getY()+varf2.getY())/2);
    }
    public float getLungimeSegment(Parabola p)
    {
        Punct varf1= this.getVarf();
        Punct varf2= p.getVarf();
        return (float) Math.hypot((varf2.getX()-varf1.getX()),(varf2.getY()-varf1.getY()));
    }
    public static float getLungimeSegment(Parabola p,Parabola p2)
    {
        Punct varf1= p.getVarf();
        Punct varf2= p2.getVarf();
        return (float) Math.hypot((varf2.getX()-varf1.getX()),(varf2.getY()-varf1.getY()));
    }
}
