package Leetcode.hard;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        RegularExpressionMatching solution = new RegularExpressionMatching();
        final String word = "abc";
        final String pattern = "a*.c";
        System.out.println(solution.isMatch(word, pattern));
    }

    private boolean solve(final String word, final String pattern) {
        final boolean[][] matrix = new boolean[word.length() + 1][pattern.length() + 1];
        matrix[0][0] = true;

        for(int i = 1; i <= pattern.length(); i ++) {
            if(pattern.charAt(i-1) == '*' && matrix[0][i-2]) {
                matrix[0][i] = true;
            }
        }

        for(int i = 1; i <= word.length(); i ++) {
            for(int j = 1; j <= pattern.length(); j ++) {
                char sChar = word.charAt(i-1);
                char pChar = pattern.charAt(j-1);

                if(sChar == pChar || pChar == '.') {
                    matrix[i][j] = matrix[i-1][j-1];
                } else if(pChar == '*') {
                    matrix[i][j] = matrix[i][j-2];
                    if(!matrix[i][j] &&
                            (pattern.charAt(j-2) == sChar ||
                             pattern.charAt(j-2) == '.')) {
                        matrix[i][j] = matrix[i-1][j];
                    }
                }
            }
        }
        return matrix[word.length()][pattern.length()];
    }

    public boolean isMatch(final String s, final String p) {
        if (p == null || p.length() == 0) {
            return s == null || s.length() == 0;
        }

        // Case 1: p.length() == 1
        if (p.length() == 1) {
            if (s == null || s.length() == 0) {
                return false;
            }

            if (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.') {
                return false;
            }

            return isMatch(s.substring(1), p.substring(1));
        }

        // Case 2: p.charAt(1) != '*'
        if (p.charAt(1) != '*') {
            if (s.length() == 0) {
                return false;
            }

            if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        } else { // case 3
            if (isMatch(s, p.substring(2))) {
                return true;
            }

            int i = 0;
            while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s.substring(i + 1), p.substring(2))) {
                    return true;
                }
                i++;
            }

            return false;
        }
    }
}
