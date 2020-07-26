import java.util.*;

public class ED234 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int flag = Integer.parseInt(scanner.nextLine());
        int counter = Integer.parseInt(scanner.nextLine());

        String[] movies = new String[counter];
        int[] classification = new int[counter];

        for (int i = 0; i < counter; i++) {
            String line = scanner.nextLine();
            movies[i] = line.split(" ")[0];
            classification[i] = Integer.parseInt(line.split(" ")[1]);
        }

        switch (flag) {
            case 1: {
                flag1(movies);
                break;
            }
            case 2: {
                flag2(movies, counter);
                break;
            }
            case 3: {
                flag3(movies, classification, counter);
                break;
            }
        }
    }

    public static void flag1(String[] movies) {
        System.out.println(new HashSet<>(Arrays.asList(movies)).size());
    }

    public static void flag2(String[] movies, int counter) {
        HashMap<String, Integer> movieMap = new HashMap<>();

        for (int i = 0; i < counter; i++) {
            if (movieMap.containsKey(movies[i])) {
                movieMap.put(movies[i], movieMap.get(movies[i]) + 1);
            } else {
                movieMap.put(movies[i], 1);
            }
        }

        String movie = movies[0];
        int max = 0;

        for (Map.Entry<String, Integer> entry : movieMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            if (value > max) {
                max = value;
                movie = key;
            }
        }

        System.out.println(movie + " " + max);
    }

    public static void flag3(String[] movies, int[] classification, int counter) {
        HashMap<String, Integer> counterMap = new HashMap<>();

        for (int i = 0; i < counter; i++) {
            if (counterMap.containsKey(movies[i])) {
                counterMap.put(movies[i], counterMap.get(movies[i]) + 1);
            } else {
                counterMap.put(movies[i], 1);
            }
        }

        HashMap<String, Integer> classificationMap = new HashMap<>();

        for (int i = 0; i < counter; i++) {
            if (classificationMap.containsKey(movies[i])) {
                classificationMap.put(movies[i], classificationMap.get(movies[i]) + classification[i]);
            } else {
                classificationMap.put(movies[i], classification[i]);
            }
        }

        Set<String> uniqueMovies = new HashSet<>(Arrays.asList(movies));
        TreeSet<String> uniqueMoviesOrdered = new TreeSet<>(uniqueMovies);

        for (String movie : uniqueMoviesOrdered) {
            int countMovie = counterMap.get(movie);
            int countClassification = classificationMap.get(movie);
            double average = (double) countClassification / (double) countMovie;

            if(average >= 5.0) {
                System.out.println(movie);
            }
        }
    }
}