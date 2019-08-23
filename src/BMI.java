import java.io.Serializable;

public class BMI implements Serializable {
    private double height, weight,BMI;

    public BMI(double weight, double height){
        this.height=height;
        this.weight = weight;
    }

    public void calculateBMI(){
        this.BMI = weight/(Math.pow(height,2));
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setBMI(double BMI) {
        this.BMI = BMI;
    }
    public double getBMI(){
        return this.BMI;
    }
}
