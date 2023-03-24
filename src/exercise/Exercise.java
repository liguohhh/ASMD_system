package exercise;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author :LGH
 * Exercise类
 * 类中包括成员变量operationList为存储习题数据的列表
 * current为遍历列表是的指针变量
 * generateAdditionExercise(),generateSubstractExercise(),generateMultiplyExercise(),generateDivisionExercise()为生成对应的加减乘除算式*/
public class Exercise {
    private ArrayList<BinaryOperation> operationList = new ArrayList<>();
    private int current = 0;//用于遍历数据集

    public void generateAdditionExercise(int operationCount) {
        BinaryOperation anOperation = null;
        while (operationCount > 0) {
            do {
                anOperation = new AdditionOperation();

            }
            while (operationList.contains(anOperation));

            operationCount--;
            operationList.add(anOperation);
        }

    }

    public void generateSubstractExercise(int operationCount) {
        BinaryOperation anOperation = null;
        while (operationCount > 0) {
            do {
                anOperation = new SubstractOperation();

            }
            while (operationList.contains(anOperation));

            operationCount--;
            operationList.add(anOperation);
        }

    }
    public void generateMultiplyExercise(int operationCount) {
        BinaryOperation anOperation = null;
        while (operationCount > 0) {
            do {
                anOperation = new MultiplyOperation();

            }
            while (operationList.contains(anOperation));

            operationCount--;
            operationList.add(anOperation);
        }

    }
    public void generateDivisionExercise(int operationCount) {
        BinaryOperation anOperation = null;
        while (operationCount > 0) {
            do {
                anOperation = new DivisionOperation();

            }
            while (operationList.contains(anOperation));

            operationCount--;
            operationList.add(anOperation);
        }

    }


    //下面两个方法用于实现遍历数据
    //若有元素，返回true,否则返回false
    public boolean hasNext() {
        return current <= operationList.size() - 1;
    }

    //若有元素，返回当前元素，移动到一个
    public BinaryOperation next() {
        return operationList.get(current++);
    }


}


