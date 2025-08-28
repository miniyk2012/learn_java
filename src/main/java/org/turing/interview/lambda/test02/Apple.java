package org.turing.interview.lambda.test02;

public class Apple {
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Apple(int weight) {
        this.weight = weight;
    }

    private Integer weight;


    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                '}';
    }
}
