import java.util.*;

class StopWordFilteredFrequency {
public static void printFilteredWordFrequency(String feedback) {
String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

```
    feedback = feedback.toLowerCase();
    feedback = feedback.replace(".", "").replace(",", "");

    String[] words = feedback.split("\\s+");
    HashMap<String, Integer> frequency = new HashMap<>();

    for (String word : words) {
        if (word.isEmpty()) {
            continue;
        }

        boolean stop = false;

        for (String s : stopWords) {
            if (word.equals(s)) {
                stop = true;
                break;
            }
        }

        if (!stop) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }
    }

    List<Map.Entry<String, Integer>> list =
            new ArrayList<>(frequency.entrySet());

    list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

    for (Map.Entry<String, Integer> entry : list) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
    }
}

public static void main(String[] args) {
    printFilteredWordFrequency(
        "The mentor was great, the session was great and clear."
    );
}
```

}
