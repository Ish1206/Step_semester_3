package string_operations.assigment_problems;

import java.util.Scanner;

public class LibraryIsbnValidator {

    public static String normalizeCode(String raw) {
        String code = raw.trim();

        if (code.length() < 3) {
            return code.toUpperCase();
        }

        String publisherCode = code.substring(0, 3).toUpperCase();
        String remaining = code.substring(3);

        return publisherCode + remaining;
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        for (int index = 0; index < 3; index++) {
            if (!Character.isLetter(code.charAt(index))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int index = 3; index < code.length(); index++) {
            if (!Character.isDigit(code.charAt(index))) {
                return "Invalid: body must contain only digits";
            }
        }

        String publisherCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7);

        StringBuilder formattedCode = new StringBuilder();
        formattedCode.append("[");
        formattedCode.append(publisherCode);
        formattedCode.append("] YEAR: ");
        formattedCode.append(year);
        formattedCode.append(" | CATALOG: ");
        formattedCode.append(catalog);

        return formattedCode.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter ISBN code: ");
        String rawCode = scanner.nextLine();

        String normalizedCode = normalizeCode(rawCode);
        System.out.println(validateAndFormat(normalizedCode));
    }
}