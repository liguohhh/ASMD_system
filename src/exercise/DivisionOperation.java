package exercise;

/**
 * DivisionOperation类是产生除法法算式类
 * DivisionOperation()构造函数调用基类的 generateBinaryOperation()方法并传入参数生成成员变量的值
 * 该类的calculate方法与其他不同增加了检测算式是否为整数除法算式不带小数
 */
public class DivisionOperation extends BinaryOperation {
    public DivisionOperation() {
        generateBinaryOperation('/');
    }

    public boolean checkingCalculation(int anInteger) {
        return anInteger <= UPPER && anInteger >= LOW;
    }

    int calculate(int left, int right) {
        int n = -1;
        if (right == 0){
            return n;
        }
        if (left % right == 0) {
            n = left / right;
        }
        return n;
    }
}
