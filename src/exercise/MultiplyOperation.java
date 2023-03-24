package exercise;

/**
 * MultiplyOperation类是产生乘法法算式类
 * MultiplyOperation()构造函数调用基类的 generateBinaryOperation()方法并传入参数生成成员变量的值
 */
public class MultiplyOperation extends BinaryOperation {
    public MultiplyOperation() {
        generateBinaryOperation('*');
    }

    public boolean checkingCalculation(int anInteger) {
        return anInteger <= UPPER && anInteger >= LOW;
    }

    int calculate(int left, int right) {
        return left * right;
    }
}
