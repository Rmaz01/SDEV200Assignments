import java.util.*;
import java.io.*;

public class M04ProgrammingAssignment2 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java KeywordCounter <sourceFile>");
            return;
        }

        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("File " + args[0] + " does not exist");
            return;
        }

        try {
            int keywordCount = countKeywords(file);
            System.out.println("The number of keywords in " + args[0] + " is " + keywordCount);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    public static int countKeywords(File file) throws IOException {
        String[] keywords = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", "for",
                "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package",
                "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized",
                "this", "throw", "throws", "transient", "try", "void", "volatile", "while", "true", "false", "null"};

        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywords));
        int count = 0;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (!word.startsWith("//") && !word.startsWith("/*")) {
                    if (word.contains("\"")) {
                        while (!word.contains("\"")) {
                            if (!scanner.hasNext()) break;
                            word = scanner.next();
                        }
                    } else if (keywordSet.contains(word)) {
                        count++;
                    }
                } else if (word.startsWith("/*")) {
                    while (!word.endsWith("*/")) {
                        if (!scanner.hasNext()) break;
                        word = scanner.next();
                    }
                } else { 
                    scanner.nextLine();
                }
            }
        }
        return count;
    }
}