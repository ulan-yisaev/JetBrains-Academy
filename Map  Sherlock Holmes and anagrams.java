package library.avenir.test.controller;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<Character, Integer> word1 = new HashMap<>();
        HashMap<Character, Integer> word2 = new HashMap<>();

        String s1 = scanner.nextLine().toLowerCase();
        String s2 = scanner.nextLine().toLowerCase();

        if (s1.length() == s2.length()) {
            countLetters(s1, word1);
            countLetters(s2, word2);
            System.out.println(word1.equals(word2) ? "yes" : "no");
        } else {
            System.out.println("no");
        }
    }

    static void countLetters(String s, HashMap<Character, Integer> hashMap) {
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            int count = hashMap.getOrDefault(c, 0);
            hashMap.put(c, count + 1);
        }
    }
}

/*
Reference:
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String a = scan.next().toLowerCase(Locale.US);
        String b = scan.next().toLowerCase(Locale.US);

        boolean rs = isAnagram(a, b);

        System.out.println(rs ? "yes" : "no");
    }

    public static boolean isAnagram(String a, String b) {
        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();

        for (char item : a.toCharArray()) {
            if (mapA.containsKey(item)) {
                mapA.put(item, mapA.get(item) + 1);
            } else {
                mapA.put(item, 1);
            }
        }

        for (char item : b.toCharArray()) {
            if (mapB.containsKey(item)) {
                mapB.put(item, mapB.get(item) + 1);
            } else {
                mapB.put(item, 1);
            }
        }

        return mapA.equals(mapB);
    }
}

 */
/*
Java Collections Map
Map  Sherlock Holmes and the mystery of anagrams

In this problem, you are Sherlock Holmes and you want to quickly detect all anagrams.

Write a program that finds out whether two words are anagrams or not. If one word is an anagram of another, print "yes", else print "no".

Note: anagrams are words that contain the same characters with the same frequencies. In other words, anagrams are created by changing the order of letters in the word.

For example:

"ppaaagg" (2 ps, 3 as, 2 gs) and "gagaapp" (2 ps, 3 as, 2 gs) are anagrams;
"hello" (1 h, 1 e, 2 ls, 1 o) and "helllo" (1 h, 1 e, 3 ls, 1 o) are not anagrams.
Remember: anagrams are case-insensitive.

 Report a typo
Sample Input 1:

ppaaagg
gagaapp
Sample Output 1:

yes
 */