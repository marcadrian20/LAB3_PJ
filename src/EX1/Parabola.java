package EX1;

public class Parabola {
    private int a;
    private int b;
    private int c;

    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public float[] getVarf(){
        return new float[]{((float) -b /(2*a)), (float) (-(b * b) + 4 * a * c) /(4*a)};
    }

    @Override
    public String toString() {
        return "f(x) = " + a +"x^2 + "+b+"x + "+c;
    }
    public float[] getMijloc(Parabola p)
    {
        float[] varf1= this.getVarf();
        float[] varf2= p.getVarf();
        return new float[]{(varf1[0]+varf2[0])/2,(varf1[1]+varf2[1])/2};
    }
    public static float[] getMijloc(Parabola p,Parabola p2)
    {
        float[] varf1= p.getVarf();
        float[] varf2= p2.getVarf();
        return new float[]{(varf1[0]+varf2[0])/2,(varf1[1]+varf2[1])/2};
    }
    public float getLungimeSegment(Parabola p)
    {
        float[] varf1= this.getVarf();
        float[] varf2= p.getVarf();
        return (float) Math.hypot((varf2[0]-varf1[0]),(varf2[1]-varf1[1]));
    }
    public static float getLungimeSegment(Parabola p,Parabola p2)
    {
        float[] varf1= p.getVarf();
        float[] varf2= p2.getVarf();
        return (float) Math.hypot((varf2[0]-varf1[0]),(varf2[1]-varf1[1]));
    }
}
