/**
 * Author     : WindAsMe
 * File       : geneticAlgorithm.java
 * Time       : Create on 19-5-17
 * Location   : ../Home/JavaForLeetCode/geneticAlgorithm.java
 */
public class geneticAlgorithm {

    static int popSize  = 100; // The amount of population
    int chromosomeSize = 0; // The size of chromosome
    double mutationRate = 0.001; // The rate of being mutated
    int maxGene = 100; // The max generation


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
        void SelectPop() {

        }
        void VaryPop() {}
        void CrossPop() {}
        void OptimizePop() {}
        void Initialization() { // Initialization the population
            for (int index = 0; index < popSize; index++) { // create every individual's chromosome
                StringBuilder builder = new StringBuilder();
                for (int bitIndex = 0; bitIndex < chromosomeSize; bitIndex++)
                    builder.append(Math.random() % 2);
                Population[index].chromosome = builder.toString();
            }
            HistoryBest = Population[0]; // permanently to set the history best as the first
            EvaluatePop(); // evaluate the population
            Statistics();

        }
        void Statistics() {}
        void EvaluatePop() {}
        void NextPopulation() {}
        void output() {}

        public Evolution() { // Initialization
            Initialization();
            generation = 0;
        }

    }
}
