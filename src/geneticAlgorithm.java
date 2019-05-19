/**
 * Author     : WindAsMe
 * File       : geneticAlgorithm.java
 * Time       : Create on 19-5-17
 * Location   : ../Home/JavaForLeetCode/geneticAlgorithm.java
 */
public class geneticAlgorithm {

    static int popSize  = 100; // The amount of population
    int chromosomeSize = 0; // The size of chromosome
    int maxGene = 100; // The max generation
    double Pc = 0.1; // The possibility of mutation
    double Pm = 0.001; // The possibility of mutation

    static class individual { // The class of individual
        public double objectiveValue; // The value of individual
        public double fitValue; // The value to fit the environment;
        public String chromosome; // Encoding the chromosome;

        public individual() {
            this.objectiveValue = 0;
            this.fitValue = 0;
            this.chromosome = "000000000";
        }
    }

    abstract class abstractEvolution { // The class to process the evolution
        int generation; // the amount of generation
        double average; // the average
        int worstIndex; // The worst index
        individual Population[]; // population
        individual Best; // The best individual
        individual Worst; // The worst individual
        individual HistoryBest; // The history best individual
        individual HistoryWorst; // The history worst individual
        abstract void SelectPop(); // going select
        abstract void VaryPop(); // going mutation
        abstract void CrossPop(); // going matching
        abstract void OptimizePop(); // going optimize
        abstract void Initialization(); // randomly to construct a population
        abstract void Statistics(); // find the best one and worst one and the average
        abstract void EvaluatePop(); // evaluate the population
        abstract void NextPopulation(); // create the next population
        abstract void output(); // output the information
    }

    class Evolution extends abstractEvolution {
        void SelectPop() { // select the operation
            double fitSum = 0;
            double selection[] = new double[popSize];
            individual[] newPopulation = new individual[popSize];
            for (int index = 0; index < popSize; index++)  // sum the fitValue
                fitSum += Population[index].fitValue;
            for (int index = 0; index < popSize; index++)
                selection[index] = Population[index].fitValue / fitSum;
            for (int index = 1; index < popSize; index++)
                selection[index] = selection[index - 1] + selection[index];

            for (int popIndex = 0; popIndex < popSize; popIndex++) { // roulette selection
                double p = Math.random() * Integer.MAX_VALUE % 100;
                p /= 100;
                int index = 0;
                while (p > selection[index])
                    index++;
                newPopulation[popIndex] = Population[index];
            }

            if (popSize >= 0) // update the generation
                System.arraycopy(newPopulation, 0, Population, 0, popSize);
        }
        void VaryPop() { // mutation operator
            String str1 = "0";
            String str2 = "1";
            for (int index = 0; index < popSize; index++) {
                for (int bitIndex = 0; bitIndex < chromosomeSize; bitIndex++) {
                    double r = Math.random() * Integer.MAX_VALUE % 1000;
                    r /= 1000;
                    if (r < Pm) {
                        if (Population[index].chromosome.charAt(bitIndex) == str1.charAt(0))
                            Population[index].chromosome = Population[index].chromosome.substring(0, bitIndex) + str2.charAt(0) + Population[index].chromosome.substring(bitIndex);
                        else
                            Population[index].chromosome = Population[index].chromosome.substring(0, bitIndex) + str1.charAt(0) + Population[index].chromosome.substring(bitIndex);
                    }
                }
            }
        }
        void CrossPop() {
            for (int index = 0; index < popSize; index++) {
                int r = (int) ((Math.random() * Integer.MAX_VALUE) % popSize);
                individual temp = Population[index];
                Population[index] = Population[r];
                Population[r] = temp;
            }
            for (int index = 0; index < popSize; index += 2) {
                double temp = (Math.random() * Integer.MAX_VALUE) % 1000 / 1000.0;
                if (temp < Pc) { // create the new chromosome
                    int Location = (int) (Math.random() * Integer.MAX_VALUE) % chromosomeSize;
                    String str1 = Population[index].chromosome.substring(0, Location);
                    String str2 = Population[index].chromosome.substring(Location);
                    String str3 = Population[index + 1].chromosome.substring(0, Location);
                    String str4 = Population[index + 1].chromosome.substring(Location);
                    Population[index].chromosome = str1 + str4;
                    Population[index + 1].chromosome = str3 + str2;
                }
            }
        }
        void OptimizePop() {
            Worst = HistoryBest;
        }
        void Initialization() { // Initialization the population
            for (int index = 0; index < popSize; index++) { // create every individual's chromosome
                StringBuilder builder = new StringBuilder();
                for (int bitIndex = 0; bitIndex < chromosomeSize; bitIndex++)
                    builder.append(Math.random() * Integer.MAX_VALUE % 2);
                Population[index].chromosome = builder.toString();
            }
            HistoryBest = Population[0]; // permanently to set the history best as the first
            EvaluatePop(); // evaluate the population
            Statistics();

        }
        void Statistics() {
            Best = Population[0];
            Worst = Population[0];
            double sum = 0;
            for (int index = 0; index < popSize; index++)
            {
                if (Best.fitValue < Population[index].fitValue)
                    Best = Population[index];
                if (Worst.fitValue > Population[index].fitValue) {
                    Worst = Population[index];
                    worstIndex = index;
                }
                sum += Population[index].fitValue;
            }
            if (HistoryBest.fitValue < Best.fitValue)
                HistoryBest = Best;
            average = sum / popSize;
        }
        void EvaluatePop() { // f(x1, x2) = x1 ^ 2 + x2 ^ 2;
            for (int index = 0; index < popSize; index++) {
                int value1 = Integer.parseInt(Population[index].chromosome.substring(0, 3), 2);
                int value2 = Integer.parseInt(Population[index].chromosome.substring(3, 3), 2);
                int value3 = Integer.parseInt(new StringBuilder(Population[index].chromosome.substring(3, 6)).reverse().toString(), 2);
                int a = value1 / 100;
                int b = (value1 - a * 100) / 10;
                int c = value1 - a * 100 - b * 10;
                value1 = a * 4 + b * 2 + c;
                a = value2 / 100;
                b = (value2 - a * 100) / 10;
                c = value2 - a * 100 - b * 10;
                value2 = a * 4 + b * 2 + c;
                a = value3 / 100;
                b = (value3 - a * 100) / 10;
                c = value3 - a * 100 - b * 10;
                value3 = a * 4 + b * 2 + c;
                Population[index].fitValue = value1 * value1 + value2 * value2 + value3 * value3;
                Population[index].objectiveValue = value1 * value1 + value2 * value2 + value3 * value3;
            }
        }
        void NextPopulation() { // create the next generation
             SelectPop();
             VaryPop();
             CrossPop();
             EvaluatePop();
             Statistics();
             OptimizePop();
             EvaluatePop();
             Statistics();
             generation++;
        }
        void output() {
            System.out.println("Generation: " + generation + " Average: " + average + " Best: " + Best.fitValue + " Chromosome: " + Best.chromosome);
        }

        public Evolution() { // Initialization
            Initialization();
            generation = 0;
        }
    }
}
