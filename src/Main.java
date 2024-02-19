import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Complex first = new Complex(0,0);
        System.out.println("Enter a,b for the first complex number: ");
        System.out.println("a: ");
        first.setA(in.nextInt());
        System.out.println("b: ");
        first.setB(in.nextInt());
        Complex second = new Complex(0,0);
        System.out.println("Enter a,b for the second complex number: ");
        System.out.println("a: ");
        second.setA(in.nextInt());
        System.out.println("b: ");
        second.setB(in.nextInt());
        System.out.println("First complex number:");
        first.Print();
        System.out.print("\n");
        System.out.print("Trigonometric form first: ");
        first.PrintTrigonometric();
        System.out.print("\n");
        System.out.println("Second complex number:");
        second.Print();
        System.out.print("\n");
        Complex addresult = (Complex) first.add(second);
        System.out.println("Sum: ");
        addresult.Print();
        System.out.print("\n");
        Complex mulresult = (Complex) first.multiply(second);
        System.out.println("Multiply: ");
        mulresult.Print();
        System.out.print("\n");
        Matrix m = new Matrix(0,0);
        System.out.println("First matrix: ");
        System.out.println("Rows: ");
        m.setRows(in.nextInt());
        System.out.println("Columns: ");
        m.setColumns(in.nextInt());
        int rows = m.getRows();
        int columns = m.getColumns();
        for(int i = 0; i < rows;i++){
            for(int j = 0; j < columns; j++){
                System.out.print("Enter element at position without spaces in complex number(a+bi) (" + i + ", " + j + "): ");
                String element = in.next();
                m.setValue(i, j, element);
            }
        }
        m.print();
        Matrix a = new Matrix(0,0);
        System.out.println("Second matrix: ");
        System.out.println("Rows: ");
        a.setRows(in.nextInt());
        System.out.println("Columns: ");
        a.setColumns(in.nextInt());
        rows = a.getRows();
        columns = a.getColumns();
        for(int i = 0; i < rows;i++){
            for(int j = 0; j < columns; j++){
                System.out.print("Enter element at position without spaces in complex number(a+bi) (" + i + ", " + j + "): ");
                String element = in.next();
                a.setValue(i, j, element);
            }
        }
        a.print();

        System.out.print("Sum: \n");
        Matrix sumExample = m.sum(a);
        if(sumExample != null){
            sumExample.print();
        }
        System.out.print("Multiply: \n");
        Matrix MultiplyExample = m.multiply(a);
        if(MultiplyExample != null){
            MultiplyExample.print();
        }
        System.out.print("Transpose first: \n");
        m.transponse();
        m.print();
        System.out.print("Transpose second: \n");
        a.transponse();
        a.print();
    }
}
