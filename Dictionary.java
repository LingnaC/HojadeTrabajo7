/*Universidad del Valle de Guatemala
Algoritmos y estruccturas de datos
Hoja de Trabajo 7 - Trabajo individual
Linda Chen 23173*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dictionary {
    private BinaryTree<Association<String, String>> dictionaryTree;

    public Dictionary() {
        dictionaryTree = new BinaryTree<>();
    }

    public void loadDictionary(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.replaceAll("[()]", "").split(", ");
            dictionaryTree.insert(new Association<>(parts[0], parts[1]));
        }
        reader.close();
    }

    public String translateText(String textFileName) throws IOException {
        StringBuilder translatedText = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(textFileName));
        String line;
        while ((line = reader.readLine()) != null) {
            for (String word : line.split(" ")) {
                String lowerCaseWord = word.toLowerCase();
                Association<String, String> searchResult = dictionaryTree.find(new Association<>(lowerCaseWord, null));
                if (searchResult != null) {
                    translatedText.append(searchResult.getValue()).append(" ");
                } else {
                    translatedText.append("*").append(word).append("* ").append(" ");
                }
            }
        }
        reader.close();
        return translatedText.toString().trim();
    }
}
