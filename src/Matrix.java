import static java.lang.Integer.*;

public class Matrix {
    private int rows = 0;
    private int columns = 0;
    private Number matrix[][];
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new Number[rows][columns];
    }

    public Matrix sum(Matrix a){
        if(this.getColumns() != a.getColumns() || this.getRows() != a.getColumns()){
            System.out.println("rows or Columns are not the same");
            return null;
        }
        Matrix NewMatrix = new Matrix(this.getRows(), this.getColumns());
        for (int i = 0; i < this.getRows(); ++i) {
            for (int j = 0; j < this.getColumns(); ++j) {
                NewMatrix.matrix[i][j] = this.matrix[i][j].add(a.matrix[i][j]);
            }
        }
        return NewMatrix;
    }
    public Matrix multiply(Matrix a) {
        if(this.getColumns() != a.getColumns() || this.getRows() != a.getColumns()){
            System.out.println("rows or Columns are not the same");
            return null;
        }
        Matrix newMatrix = new Matrix(this.getRows(), a.getColumns());

        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                newMatrix.matrix[i][j] = this.matrix[i][0].multiply(a.matrix[0][j]);
                for (int k = 1; k < this.getColumns(); k++) {
                    newMatrix.matrix[i][j] = newMatrix.matrix[i][j].add(this.matrix[i][k].multiply(a.matrix[k][j]));
                }
            }
        }

        return newMatrix;
    }
    public void transponse(){
        Matrix newMatrix = new Matrix (this.getColumns(), this.getRows());
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                newMatrix.matrix[j][i] = this.matrix[i][j];
            }
        }
        int temp = this.getRows();
        this.setRows(this.getColumns());
        this.setColumns(temp);
        for(int i = 0; i < this.getRows();i++){
            for(int j = 0; j < this.getColumns(); j++){
                this.matrix[i][j] = newMatrix.matrix[i][j];
            }
        }
    }
    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
        this.matrix = new Number[rows][columns];
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
        this.matrix = new Number[rows][columns];
    }
    public void setValue(int i, int j, String value){

        if (value.matches("-?\\d+(\\.\\d+)?")) {
            int element = parseInt(value);
            Real realElement = new Real(element);
            this.matrix[i][j] = realElement;
        } else if (value.matches("-?\\d+(\\.\\d+)?[+-]\\d+(\\.\\d+)?i")) {
            String[] parts = value.split("[+-]");
            String realPart = parts[0];
            String imaginaryPart = parts[1].substring(0, parts[1].length() - 1);

            Complex complexElement = new Complex(parseInt(realPart),parseInt(imaginaryPart));
            this.matrix[i][j] = complexElement;
        } else {
            System.out.println("Ошибка: Невозможно распознать число");
        }
    }
    public void print(){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                matrix[i][j].Print();
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }

}
