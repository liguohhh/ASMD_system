package exercise;

/**
 * SubstractOperation类是产生减法法算式类
 * SubstractOperation()构造函数调用基类的 generateBinaryOperation()方法并传入参数生成成员变量的值
 */
public class SubstractOperation extends BinaryOperation {
    public SubstractOperation() {
        generateBinaryOperation('-');
    }

    public boolean checkingCalculation(int anInteger) {
        return anInteger <= UPPER && anInteger >= LOW;
    }

    int calculate(int left, int right) {
        return left - right;
    }
}
