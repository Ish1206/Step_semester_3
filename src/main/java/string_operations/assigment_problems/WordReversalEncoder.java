package string_operations.assigment_problems;

import java.util.Scanner;

public class WordReversalEncoder {

    public static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int index = 0; index < words.length; index++) {
            StringBuilder reversedWord = new StringBuilder(words[index]);
            reversedWord.reverse();

            result.append(reversedWord);

            if (index < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter sentence: ");
        String sentence = scanner.nextLine();

        System.out.println(reverseEachWord(sentence));
    }
}