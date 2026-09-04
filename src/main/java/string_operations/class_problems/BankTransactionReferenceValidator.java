package string_operations.class_problems;

import java.util.Scanner;

public class BankTransactionReferenceValidator {

    public static String normalizeReference(String raw) {
        String reference = raw.trim();

        if (reference.length() < 3) {
            return reference.toUpperCase();
        }

        String bankCode = reference.substring(0, 3).toUpperCase();
        String remaining = reference.substring(3);

        return bankCode + remaining;
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        for (int index = 0; index < 3; index++) {
            if (!Character.isLetter(reference.charAt(index))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int index = 3; index < reference.length(); index++) {
            if (!Character.isDigit(reference.charAt(index))) {
                return "Invalid: body must contain only digits";
            }
        }

        String bankCode = reference.substring(0, 3);
        String date = reference.substring(3, 9);
        String sequence = reference.substring(9);

        StringBuilder formattedReference = new StringBuilder();
        formattedReference.append("[");
        formattedReference.append(bankCode);
        formattedReference.append("] DATE: ");
        formattedReference.append(date.substring(0, 2));
        formattedReference.append("/");
        formattedReference.append(date.substring(2, 4));
        formattedReference.append("/");
        formattedReference.append(date.substring(4, 6));
        formattedReference.append(" | SEQ: ");
        formattedReference.append(sequence);

        return formattedReference.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter transaction reference: ");
        String rawReference = scanner.nextLine();

        String normalizedReference = normalizeReference(rawReference);
        System.out.println(validateAndFormat(normalizedReference));
    }
}