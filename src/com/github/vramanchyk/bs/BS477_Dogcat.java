package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/13/20.
 */
public class BS477_Dogcat {

    public int solve(String text, String word0, String word1) {

        StringBuilder currentWord = new StringBuilder();

        int lastWord0 = -1;
        int lastWord1 = -1;
        int wordsCount = 0;
        int minDistance = -1;

        for (char ch : (text + " ").toCharArray()) {
            if (ch == ' ') {

                if (currentWord.length() > 0) {
                    String word = currentWord.toString();

                    if (word.equals(word0)) {
                        lastWord0 = wordsCount;
                    }

                    if (word.equals(word1)) {
                        lastWord1 = wordsCount;
                    }

                    if (lastWord0 != -1 && lastWord1 != -1) {
                        int distance = Math.abs(lastWord1 - lastWord0) - 1;
                        if (minDistance == -1 || distance < minDistance) {
                            minDistance = distance;
                        }
                    }

                    wordsCount++;
                }

                currentWord.setLength(0);
            } else {
                currentWord.append(ch);
            }
        }

        return minDistance;
    }

}
