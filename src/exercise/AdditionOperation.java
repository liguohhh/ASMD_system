package exercise;

/**
 * AdditionOperation类是产生加法算式类
 * AdditionOperation()构造函数调用基类的 generateBinaryOperation()方法并传入参数生成成员变量的值
 */
public class AdditionOperation extends BinaryOperation {
    public AdditionOperation() {
        generateBinaryOperation('+');
    }

    public boolean checkingCalculation(int anInteger) {
        return anInteger <= UPPER && anInteger >= LOW;
    }

    int calculate(int left, int right) {
        return left + right;
    }
}
