import java.io.*;
import java.util.*;

public class RecommendationFromCSV {
    public static void main(String[] args) {
        String targetUser = "User3"; 
        String fileName = "data.csv";

        Set<String> allItems = new HashSet<>();
        Map<String, Set<String>> userItems = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 2) continue;

                String user = parts[0].trim();
                String item = parts[1].trim();

                allItems.add(item);
                userItems.putIfAbsent(user, new HashSet<>());
                userItems.get(user).add(item);
            }

            Set<String> targetLikes = userItems.getOrDefault(targetUser, new HashSet<>());
            Set<String> recommendations = new HashSet<>(allItems);
            recommendations.removeAll(targetLikes);

            System.out.println("Recommended items for " + targetUser + ":");
            for (String item : recommendations) {
                System.out.println("- " + item);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}