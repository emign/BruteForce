package sample;
import java.util.Arrays;

/**
 * Copyright:
 * https://github.com/a11n/bruteforce
 * https://github.com/a11n
 * <p>
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2015 André Diermann
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

public class BruteForcer {
    private static final String NUMERIC_ALPHABET = "0123456789";
    private static final String LOWER_CASE_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_CASE_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final char[] alphabet;
    private final int alphabetLength;
    private int[] indices;
    private char[] combination;

    private BruteForcer(String alphabet) {
        this.alphabet = alphabet.toCharArray();
        this.alphabetLength = alphabet.length();

        indices = new int[1];
        combination = new char[1];
    }

    static BruteForcer createNumericBruteForcer() {
        return new BruteForcer(NUMERIC_ALPHABET);
    }

    static BruteForcer createAlphaBruteForcer() {
        return new BruteForcer(LOWER_CASE_ALPHABET + UPPER_CASE_ALPHABET);
    }

    static BruteForcer createAlphaNumericBruteForcer() {
        return new BruteForcer(LOWER_CASE_ALPHABET + UPPER_CASE_ALPHABET + NUMERIC_ALPHABET);
    }


    public static BruteForcer createGenericBruteForcer(String alphabet){
        return new BruteForcer(alphabet);
    }

    String computeNextCombination() {
        combination[0] = alphabet[indices[0]];
        String nextCombination = String.valueOf(combination);

        if (indices[0] < alphabetLength - 1) {
            indices[0]++;
        } else {
            for (int i = 0; i < indices.length; i++) {
                if (indices[i] < alphabetLength - 1) {
                    indices[i]++;
                    combination[i] = alphabet[indices[i]];
                    break;
                } else {
                    indices[i] = 0;
                    combination[i] = alphabet[indices[i]];

                    if (i == indices.length - 1) {
                        indices = Arrays.copyOf(indices, indices.length + 1);
                        combination = Arrays.copyOf(combination, combination.length + 1);
                        combination[combination.length - 1] = alphabet[indices[indices.length - 1]];
                        break;
                    }
                }
            }
        }

        return nextCombination;
    }
}