package access_modifiers_encapsulation.assigment_problems;

class MembershipLibraryMember {
    private String membershipPin;
    String branchCode;
    protected double finesOwed;
    public String displayName;
}

public class MembershipFieldReachChecker {

    static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier.equals("private")) {
            if (accessorContext.equals("SAME_CLASS")) {
                return "ALLOWED";
            }
            return "DENIED";
        }

        if (fieldModifier.equals("default")) {
            if (accessorContext.equals("SAME_CLASS")
                    || accessorContext.equals("SAME_PACKAGE")) {
                return "ALLOWED";
            }
            return "DENIED";
        }

        if (fieldModifier.equals("protected")) {
            if (accessorContext.equals("SAME_CLASS")
                    || accessorContext.equals("SAME_PACKAGE")) {
                return "ALLOWED";
            }
            return "DENIED";
        }

        if (fieldModifier.equals("public")) {
            return "ALLOWED";
        }

        return "DENIED";
    }

    static String summarizeByModifier(String[][] attempts) {
        String[] modifiers = {"private", "default", "protected", "public"};
        int[] allowed = new int[4];
        int[] denied = new int[4];

        for (String[] attempt : attempts) {
            String result = classifyAccess(attempt[0], attempt[1]);

            for (int i = 0; i < modifiers.length; i++) {
                if (attempt[0].equals(modifiers[i])) {
                    if (result.equals("ALLOWED")) {
                        allowed[i]++;
                    } else {
                        denied[i]++;
                    }
                }
            }
        }

        return "private: " + allowed[0] + " allowed / " + denied[0]
                + " denied | default: " + allowed[1] + " allowed / " + denied[1]
                + " denied | protected: " + allowed[2] + " allowed / " + denied[2]
                + " denied | public: " + allowed[3] + " allowed / " + denied[3]
                + " denied";
    }

    public static void main(String[] args) {
        String[][] attempts = {
                {"private", "SAME_CLASS"},
                {"private", "SAME_PACKAGE"},
                {"default", "SAME_PACKAGE"},
                {"default", "DIFFERENT_PACKAGE"},
                {"protected", "SAME_PACKAGE"},
                {"protected", "SAME_CLASS"},
                {"public", "DIFFERENT_PACKAGE"}
        };

        System.out.println(classifyAccess("private", "SAME_CLASS"));
        System.out.println(classifyAccess("protected", "DIFFERENT_PACKAGE"));
        System.out.println(summarizeByModifier(attempts));
    }
}