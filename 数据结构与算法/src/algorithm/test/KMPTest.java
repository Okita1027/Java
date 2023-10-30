package algorithm.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author qzy
 * @time 2023/10/28 11:58 星期六
 * @title
 */

public class KMPTest {
    @Test
    public void testKMP() {
        String text = "ABABABA";
        String pattern = "ABA";
        int[] next = new int[pattern.length()];
        getNext(next, pattern);

        int index = kmp(text, pattern, next);
//        assertEquals(2, index);

        pattern = "ABC";
        getNext(next, pattern);

        index = kmp(text, pattern, next);
        assertEquals(-1, index);
    }

    private void getNext(int[] next, String str) {
        int i = 0, j = -1;
        next[0] = -1;
        while (i < str.length() - 1) {
            if (j == -1 || str.charAt(i) == str.charAt(j)) {
                next[++i] = ++j;
            } else {
                j = next[j];
            }
        }
    }

    private int kmp(String text, String pattern, int[] next) {
        int i = 0, j = 0;
        while (i < text.length() && j < pattern.length()) {
            if (j == -1 || text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        return j == pattern.length() ? i - j : -1;
    }
}