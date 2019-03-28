import java.util.*;

/**
 * Author     : WindAsMe
 * File       : professorChoice.java
 * Time       : Create on 19-3-23
 * Location   : ../Home/JavaForLeetCode/professorChoice.java
 */
// This programme is for the professor choice
public class professorChoice {

    // Professor class
    // university score: * 0.3 weight  Range(2, 10)
    // age score: * 0.1 weight  Range(2, 5)
    // impression score: * 0.3 weight  Range(4, 10)
    // majority matching score: * 0.2 weight  Range(5, 10)
    // random factor: * 0.1 weight  Range(0, 3)
    private static class Professor {
        private String name;
        private String university;
        private int universityScore;
        private int ageScore;
        private int impressionScore;
        private int matchScore;
        private int randomFactor;
        private double sum;

        Professor(String name, String university, int ageScore, int impressionScore, int matchScore, int randomFactor) {
            this.name = name;
            this.university = university;
            this.ageScore = ageScore;
            this.impressionScore = impressionScore;
            this.matchScore = matchScore;
            this.randomFactor = randomFactor;
        }

        String getName() {
            return name;
        }

        String getUniversity() {
            return university;
        }

        int getUniversityScore() {
            return universityScore;
        }

        int getAgeScore() {
            return ageScore;
        }

        int getImpressionScore() {
            return impressionScore;
        }

        int getMatchScore() {
            return matchScore;
        }

        int getRandomFactor() {
            return randomFactor;
        }

        double getSum() {
            return sum;
        }

        void setUniversityScore(int universityScore) {
            this.universityScore = universityScore;
        }

        void setSum(double sum) {
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "Professor: " + name + ", " + university + ", " + String.format("%.2f", sum) + '\'';
        }
    }

    private static void calculate(List<List<Professor>> lists) {
        Map<String, Integer> universityMap = new HashMap<>();
        universityMap.put("University of Tokyo", 10);
        universityMap.put("Osaka University", 10);
        universityMap.put("Tohoku University", 8);
        universityMap.put("Hokkaido University", 8);
        universityMap.put("Nagoya University", 8);
        universityMap.put("Kyushu University", 8);
        universityMap.put("University of Tsukuba", 6);
        universityMap.put("Hiroshima University", 4);
        universityMap.put("Kobe University", 4);
        universityMap.put("Chiba University", 2);

        for (List<Professor> list : lists) {
            for (Professor professor : list) {
                professor.setUniversityScore(universityMap.get(professor.getUniversity()));
                professor.setSum(professor.getUniversityScore() * 0.3
                        + professor.getAgeScore() * 0.1 + professor.getImpressionScore() * 0.3
                        + professor.getMatchScore() * 0.3 + professor.getRandomFactor() * 0.1);
            }
        }

        for (List<Professor> list : lists) {
            // sort by sum
            list.sort((o1, o2) -> {
                if (o1.getSum() > o2.getSum())
                    return -1;
                else if (o1.getSum() < o2.getSum())
                    return 1;
                else
                    return o1.getUniversityScore() - o2.getUniversityScore();
            });
        }
        for (List<Professor> list : lists) {
            System.out.println(list.toString());
        }
    }

    private static void sortByUniversity() {

    }

    public static void main(String[] args) {
        List<Professor> list1 = new ArrayList<>();
        list1.add(new Professor("越塚登", "University of Tokyo", 4, 8, 10, (int)(3 * Math.random())));
        list1.add(new Professor("川原圭博", "University of Tokyo", 4, 7, 6, (int)(3 * Math.random())));
        list1.add(new Professor("森川博之", "University of Tokyo",4, 8, 9, (int)(3 * Math.random())));
        list1.add(new Professor("杉山 佐藤 本多研究室", "University of Tokyo", 4, 9, 8, (int)(3 * Math.random())));
        list1.add(new Professor("杉山 佐藤 本多研究室", "University of Tokyo", 4, 9, 8, (int)(3 * Math.random())));
        list1.add(new Professor("宫尾研究室", "University of Tokyo", 4, 8, 8, (int)(3 * Math.random())));


        List<Professor> list2 = new ArrayList<>();
        list2.add(new Professor("增泽利光", "Osaka University", 3, 9, 8, (int)(3 * Math.random())));
        list2.add(new Professor("石黑浩", "Osaka University", 3, 8, 7, (int)(3 * Math.random())));
        list2.add(new Professor("鬼塚真", "Osaka University", 3, 10, 8, (int)(3 * Math.random())));
        list2.add(new Professor("荒濑由纪", "Osaka University", 5, 8, 9, (int)(3 * Math.random())));

        List<Professor> list3 = new ArrayList<>();
        list3.add(new Professor("佐藤 松崎研究室", "Tohoku University", 4, 9, 8, (int)(3 * Math.random())));
        list3.add(new Professor("後藤英昭", "Tohoku University", 3, 8, 8, (int)(3 * Math.random())));
        list3.add(new Professor("乾健太郎", "Tohoku University", 3, 8, 7, (int)(3 * Math.random())));
        list3.add(new Professor("伊藤彰则", "Tohoku University", 3, 9, 9, (int)(3 * Math.random())));

        List<Professor> list4 = new ArrayList<>();
        list4.add(new Professor("高田研究室", "Nagoya University", 4, 8, 8, (int)(3 * Math.random())));
        list4.add(new Professor("户田研究所", "Nagoya University", 4, 8, 8, (int)(3 * Math.random())));
        list4.add(new Professor("户田研究所", "Nagoya University", 4, 8, 8, (int)(3 * Math.random())));
        list4.add(new Professor("户田研究所", "Nagoya University", 4, 8, 8, (int)(3 * Math.random())));

        List<Professor> list5 = new ArrayList<>();
        list5.add(new Professor("川崎研究室", "Kyushu University", 4, 10, 9, (int)(3 * Math.random())));
        list5.add(new Professor("福田研究室", "Kyushu University", 4, 9, 9, (int)(3 * Math.random())));

        List<List<Professor>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        lists.add(list5);
        calculate(lists);
    }

}
