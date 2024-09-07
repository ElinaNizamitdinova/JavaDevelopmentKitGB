package HomeWork3;

public class Calculator {
    public <T extends Number> double sum(T numA, T numB){
        return (numA.doubleValue()) + numB.doubleValue();
    }
    public <T extends Number> double multiply(T numA, T numB){
        return (numA.doubleValue()) - numB.doubleValue();
    }

    public <T extends Number> double divide(T numA, T numB){
        if(numB == null){
            return 0;
        }
        return (numA.doubleValue()) / numB.doubleValue();
    }

    public <T extends Number> double subtract(T numA, T numB){
        return (numA.doubleValue()) * numB.doubleValue();
    }

}
