package PBO9;
import java.util.*;
public class praktikum2 {
    public static void main(String[] args) {
        // a) Implementasi Map untuk menyimpan data tim A dan tim B dalam bentuk Map terpisah.
        Map<String, List<Integer>> teamA = new HashMap<>();
        teamA.put("Tinggi Badan A", new ArrayList<>(Arrays.asList(168, 170, 165, 168, 172, 170, 169, 165, 171, 166)));
        teamA.put("Berat Badan A", new ArrayList<>(Arrays.asList(50, 60, 56, 55, 60, 70, 66, 56, 72, 56)));

        Map<String, List<Integer>> teamB = new HashMap<>();
        teamB.put("Tinggi Badan B", new ArrayList<>(Arrays.asList(170, 167, 165, 166, 168, 175, 172, 171, 168, 169)));
        teamB.put("Berat Badan B", new ArrayList<>(Arrays.asList(66, 60, 59, 58, 58, 71, 68, 68, 65, 60)));

        // b) Update data Map untuk tim B karena kesalahan pencatatan berat badan
        int index = teamB.get("Tinggi Badan B").indexOf(168);
        teamB.get("Berat Badan B").set(index, 66);
        System.out.println("Data tim B setelah diperbaiki: ");
        System.out.println("Tinggi Badan B: " + teamB.get("Tinggi Badan B"));
        System.out.println("Berat Badan B: " + teamB.get("Berat Badan B"));

        // c) Implementasikan Map untuk menyimpan data tinggi badan dan berat badan dari tim A yang tinggi badannya sama dengan tim B
        Map<Integer, Integer> heightWeightMap = new HashMap<>();
        List<Integer> sameHeight = new ArrayList<>(teamA.get("Tinggi Badan A"));
        sameHeight.retainAll(teamB.get("Tinggi Badan B"));
        for (Integer height : sameHeight) {
            int weightA = teamA.get("Berat Badan A").get(teamA.get("Tinggi Badan A").indexOf(height));
            int weightB = teamB.get("Berat Badan B").get(teamB.get("Tinggi Badan B").indexOf(height));
            heightWeightMap.put(height, weightA);
            heightWeightMap.put(height, weightB);
        }
        System.out.println("Data tinggi badan dan berat badan yang sama di tim A dan tim B: ");
        for (Map.Entry<Integer, Integer> entry : heightWeightMap.entrySet()) {
            System.out.println("Tinggi Badan: " + entry.getKey() + ", Berat Badan: " + entry.getValue());
        }

        // d) Update data Map untuk tim A setelah eliminasi pemain dengan tinggi badan kurang dari 168
        List<Integer> eliminatedIndexes = new ArrayList<>();
        List<Integer> tinggiBadanA = new ArrayList<>(teamA.get("Tinggi Badan A"));
        List<Integer> beratBadanA = new ArrayList<>(teamA.get("Berat Badan A"));
        for (int i = 0; i < tinggiBadanA.size(); i++) {
            if (tinggiBadanA.get(i) < 168) {
                eliminatedIndexes.add(i);
            }
        }
        for (int i = eliminatedIndexes.size() - 1; i >= 0; i--) {
            int indexToRemove = eliminatedIndexes.get(i);
            tinggiBadanA.remove(indexToRemove);
            beratBadanA.remove(indexToRemove);
        }
        System.out.println("Data tim A setelah eliminasi pemain dengan tinggi badan kurang dari 168: ");
        System.out.println("Tinggi Badan A: " + tinggiBadanA);
        System.out.println("Berat Badan A: " + beratBadanA);
    }
}
