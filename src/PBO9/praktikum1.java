package PBO9;


import java.util.*;

public class praktikum1 {
        public static void main(String[] args) {
            // Data anggota tim futsal
            Map<String, List<Integer>> teamA = new HashMap<>();
            teamA.put("Tim A", Arrays.asList(168, 170, 165, 168, 172, 170, 169, 165, 171, 166));
            teamA.put("Berat Badan A", Arrays.asList(50, 60, 56, 55, 60, 70, 66, 56, 72, 56));

            Map<String, List<Integer>> teamB = new HashMap<>();
            teamB.put("Tim B", Arrays.asList(170, 167, 165, 166, 168, 175, 172, 171, 168, 169));
            teamB.put("Berat Badan B", Arrays.asList(66, 60, 59, 58, 58, 71, 68, 68, 65, 60));

            // a. Mencari data pemain yang mempunyai tinggi badan sama
            Set<Integer> sameHeight = new HashSet<>(teamA.get("Tim A"));
            sameHeight.retainAll(teamB.get("Tim B"));
            System.out.println("Pemain dengan tinggi badan yang sama: " + sameHeight);

            // b. Mencari data pemain yang mempunyai berat badan sama
            Set<Integer> sameWeight = new HashSet<>(teamA.get("Berat Badan A"));
            sameWeight.retainAll(teamB.get("Berat Badan B"));
            System.out.println("Pemain dengan berat badan yang sama: " + sameWeight);

            // c. Mencari rentang nilai tinggi badan kedua tim
            List<Integer> allHeights = new ArrayList<>();
            allHeights.addAll(teamA.get("Tim A"));
            allHeights.addAll(teamB.get("Tim B"));
            int minHeight = Collections.min(allHeights);
            int maxHeight = Collections.max(allHeights);
            System.out.println("Rentang nilai tinggi badan: " + minHeight + " - " + maxHeight);

            // d. Mencari rentang nilai berat badan kedua tim
            List<Integer> allWeights = new ArrayList<>();
            allWeights.addAll(teamA.get("Berat Badan A"));
            allWeights.addAll(teamB.get("Berat Badan B"));
            int minWeight = Collections.min(allWeights);
            int maxWeight = Collections.max(allWeights);
            System.out.println("Rentang nilai berat badan: " + minWeight + " - " + maxWeight);

            // e. Mencari tinggi badan pada tim A yang tidak ada pada tim B
            Set<Integer> uniqueHeightA = new HashSet<>(teamA.get("Tim A"));
            uniqueHeightA.removeAll(teamB.get("Tim B"));
            System.out.println("Tinggi badan pada tim A yang tidak ada pada tim B: " + uniqueHeightA);

            // f. Mencari berat badan pada tim B yang tidak ada pada tim A
            Set<Integer> uniqueWeightB = new HashSet<>(teamB.get("Berat Badan B"));
            uniqueWeightB.removeAll(teamA.get("Berat Badan A"));
            System.out.println("Berat badan pada tim B yang tidak ada pada tim A: " + uniqueWeightB);
        }
    }
