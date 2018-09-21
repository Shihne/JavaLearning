import objects.corrector.ChangeLetterCorrector;
import objects.corrector.DeleteLetterCorrector;
import objects.corrector.WordCorrector;

import java.io.File;
import java.io.PrintStream;
import java.util.*;

public class FindTypo {
    public static void main(String[] args) {
        File words = new File("words.txt");
        File input = new File("input.txt");
        File output = new File("output.txt");
        List<String> dict = new ArrayList<>();

        try (Scanner in = new Scanner(words, "UTF-8").useDelimiter("[^a-zA-Z]+")) {
            while (in.hasNext())
                dict.add(in.next());
        } catch (Exception e) {
            System.out.println("Ошибка чтения");
        }
        Set<String> typo = new HashSet<>();
        try (Scanner in = new Scanner(input, "UTF-8").useDelimiter("[^a-zA-Z]+")) {
            while (in.hasNext()) {
                String w = in.next().toLowerCase();
                if (!dict.contains(w))
                    typo.add(w);
            }
        } catch (Exception e) {
            System.out.println("Ошибка чтения");
        }
        List<WordCorrector> lwc = new ArrayList<>();
        lwc.add(new ChangeLetterCorrector());
        lwc.add(new DeleteLetterCorrector());
        lwc.add(word -> {
            Set<String> corrections = new HashSet<>();
            for (int i = 0; i <= word.length(); i++)
                for (char l = 'a'; l <= 'z'; l++)
                    corrections.add(word.substring(0, i) + l + word.substring(i));
            return corrections;
        });
        lwc.add(word -> {
            Set<String> corrections = new HashSet<>();
            for (int i = 0; i < word.length() - 1; i++)
                corrections.add(word.substring(0, i) + word.charAt(i + 1) + word.charAt(i) + word.substring(i + 2));
            return corrections;
        });


        Set<String> ss = new HashSet<>();
        try (PrintStream out = new PrintStream(output, "UTF-8")) {
            for (String word : typo) {
                out.print(word + " : ");
                for (WordCorrector wc : lwc) {
                    for (String s1 : wc.proposeCorrections(word))
                        if (dict.contains(s1))
                            ss.add(s1);
                }
                out.print(ss);
                out.println();
                ss.clear();
            }
        } catch (Exception e) {
            System.out.println("Ошибка записи");
        }
    }
}
