public class Complex implements Number{


    private int a;
    private int b;
    public Complex(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void parseComplex(String s){
        String[] parts = s.split("[+-]");
        String realPart = parts[0];
        String imaginaryPart = parts[1].substring(0, parts[1].length() - 1);

        setA(Integer.parseInt(realPart));
        setB(Integer.parseInt(imaginaryPart));
    }
    public Number add(Number other) {
        if (other instanceof Complex) {
            return new Complex(this.getA() + ((Complex) other).getA(), this.getB() + ((Complex) other).getB());
        } else if (other instanceof Real) {
            return new Complex(this.getA() + ((Real) other).getA(), this.getB());
        }
        return new Complex(a,b);
    }

    public Number multiply(Number other) {
       if(other instanceof Complex){
           return new Complex(this.getA() * ((Complex) other).getA() - this.getB() * ((Complex) other).getB(), this.getA() * ((Complex) other).getB() + this.getB() * ((Complex) other).getA());
       }else if(other instanceof Real){
           return new Complex(this.getA() * ((Real) other).getA(), this.getB() * ((Real) other).getA());
       }
       return new Complex(a,b);
    }
    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }


    public void PrintTrigonometric(){
        int v = a * a + b * b;
        double r = Math.sqrt(v);
        double theta = Math.atan2(b, a);
        System.out.println("sqrt" + v + " * (cos(arctg(" + b + "/" + a + ")) + i * sin(arctg(" + b + "/" + a + ")))\n");
        System.out.println(r + " * (cos(" + theta + ") + i * sin(" + theta + "))\n");
    }
    public void Print(){
        System.out.print(a + " + " + b+"i");
    }




}
