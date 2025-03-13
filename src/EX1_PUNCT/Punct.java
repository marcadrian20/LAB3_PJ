package EX1_PUNCT;

public class Punct {
    private final float x;
    private final float y;
    public Punct(float x, float y) {
        super();
        this.x = x;
        this.y = y;
    }
    public Punct getPunct() {
        return new Punct(x, y);
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

}
