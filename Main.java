/*Universidad del Valle de Guatemala
Algoritmos y estruccturas de datos
Hoja de Trabajo 7 - Trabajo individual
Linda Chen 23173*/

import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        try {
            dictionary.loadDictionary("diccionario.txt");
            String translatedText = dictionary.translateText("texto.txt");
            System.out.println(translatedText);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

