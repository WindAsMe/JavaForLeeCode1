import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author     : WindAsMe
 * File       : professorChoice.java
 * Time       : Create on 19-3-23
 * Location   : ../Home/JavaForLeetCode/professorChoice.java
 */
// This programme is for the professor choice
public class professorChoice {

    // Professor class
    // university score: * 0.3 weight
    // age score: * 0.1 weight
    // impression score: * 0.3 weight
    // majority matching score: * 0.2 weight
    // random factor: * 0.1 weight
    private class Professor {
        private String name;
        private String university;
        private int universityScore;
        private int ageScore;
        private int impressionScore;
        private int matchScore;
        private int randomFactor;
        private double sum;

        public Professor(String name, String university, int universityScore, int ageScore, int impressionScore, int matchScore, int randomFactor) {
            this.name = name;
            this.university = university;
            this.universityScore = universityScore;
            this.ageScore = ageScore;
            this.impressionScore = impressionScore;
            this.matchScore = matchScore;
            this.randomFactor = randomFactor;
        }

        public String getName() {
            return name;
        }

        public String getUniversity() {
            return university;
        }

        public int getUniversityScore() {
            return universityScore;
        }

        public int getAgeScore() {
            return ageScore;
        }

        public int getImpressionScore() {
            return impressionScore;
        }

        public int getMatchScore() {
            return matchScore;
        }

        public int getRandomFactor() {
            return randomFactor;
        }

        public double getSum() {
            return sum;
        }

        public void setSum(double sum) {
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "Professor: " + name + ", " + university +
                    ", " + universityScore + ", " + ageScore +
                    ", " + impressionScore + ", " + matchScore +
                    ", " + randomFactor + ", "+ sum + '\'';
        }
    }

    static {
        Map<String, Integer> map = new HashMap<>();
        map.put("University of Tokyo", 10);
        map.put("Osaka University", 10);
        map.put("Tohoku University", 8);
        map.put("Hokkaido University", 8);
        map.put("Nagoya University", 8);
        map.put("Kyushu University", 8);
        map.put("University of Tsukuba", 6);
        map.put("Hiroshima University", 4);
        map.put("Kobe University", 4);
        map.put("Chiba University", 2);
    }

    public static void calculate(List<Professor> list) {
        for (Professor professor : list) {
            professor.setSum(professor.getUniversityScore() * 0.3
            + professor.getAgeScore() * 0.1 + professor.getImpressionScore() * 0.3
            + professor.getMatchScore() * 0.3 + professor.getRandomFactor() * 0.1);
            System.out.println(professor.toString());
        }
    }

}
