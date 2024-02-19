public class Real implements Number {
    private int a;

    public Real(int a) {
        this.a = a;
    }

    public Number add(Number other) {
        if (other instanceof Complex) {
            return new Complex(this.getA() + ((Complex) other).getA(), ((Complex) other).getB());
        } else if (other instanceof Real) {
            return new Real(this.getA() + ((Real) other).getA());
        }
        return new Real(a);
    }
    public Number multiply(Number other){
        if (other instanceof Complex) {
            return new Complex(this.getA() * ((Complex) other).getA(), this.getA() * ((Complex) other).getB());
        } else if (other instanceof Real) {
            return new Real(this.getA() * ((Real) other).getA());
        }
        return new Real(a);
    }
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void Print() {
        System.out.print(a);
    }
}

