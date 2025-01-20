import java.util.Scanner;

public class CreateArray {
    float[] arrayOfTemperatures = null;

    public CreateArray (int sizeOfArray){
        arrayOfTemperatures = new float[sizeOfArray];

        // Can be alternatively handled this way:
        // Arrays.fill(arrayOfTemperatures, Float.MIN_VALUE);
        for (int i=0; i < arrayOfTemperatures.length; i++){
            arrayOfTemperatures[i] = Float.MIN_VALUE;
        }

    }

    public void assignValueToIndex (int index, float valueToInsert, CreateArray temperatureArray){
        temperatureArray.arrayOfTemperatures[index] = valueToInsert;
//        arrayOfTemperatures[index] = valueToInsert;
    }

    public void assignValuesToArray (int numOfTemperaturesToInput){
        for (int i=0; i < numOfTemperaturesToInput; i++){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please input the temperature value (" + (i+1) + "/"+ numOfTemperaturesToInput + "): ");
            float temperatureValue = scanner.nextFloat();
            this.assignValueToIndex(i, temperatureValue, this);
//            TemperaturesArray.AssignValueToIndex(i,temperatureValue);
        };
    }

    public float calculateAverage(){
        float sumOfTemperatures = 0;

        for (int i=0; i < this.arrayOfTemperatures.length; i++){
            sumOfTemperatures += this.arrayOfTemperatures[i];
        }

        return sumOfTemperatures / this.arrayOfTemperatures.length;

    }

    public String howManyAboveAverage (){
        float averageTemperature = this.calculateAverage();
        int aboveAverageTemperatures = 0;
//        float[] temperaturesAboveAverage;

        for (int i=0; i< this.arrayOfTemperatures.length; i++){
            if (this.arrayOfTemperatures[i] > averageTemperature){
                aboveAverageTemperatures++;
            }
        }

        return aboveAverageTemperatures + " from the total of " + this.arrayOfTemperatures.length + " temperatures are above average.";
    }


}
