package library.avenir.test.controller;

import java.util.*;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<Character, Integer> word1 = new HashMap<>();
        HashMap<Character, Integer> word2 = new HashMap<>();

        String s1 = scanner.nextLine().toLowerCase();
        String s2 = scanner.nextLine().toLowerCase();

        countLetters(s1, word1);
        countLetters(s2, word2);

        if (word1.size() >= word2.size()) {
            removeDuplicates(word1, word2);
        } else {
            removeDuplicates(word2, word1);
        }
    }

    static void countLetters(String s, HashMap<Character, Integer> hashMap) {
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            int count = hashMap.getOrDefault(c, 0);
            hashMap.put(c, count + 1);
        }
    }

    static void removeDuplicates(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        int cnt = 0;
//        System.out.println("map1 before remove loop: " + map1);
//        System.out.println("map2 before remove loop: " + map2);

        for (Iterator<Map.Entry<Character, Integer>> it = map1.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<Character, Integer> entry = it.next();
            Character key = entry.getKey();
//            System.out.println("Current key in the Iterator: " + key);
            if (map2.containsKey(key)) {
//                cnt += abs(map1.remove(key) - map2.remove(key));    // wrong - will throw ConcurrentModficationException
                cnt += abs(entry.getValue() - map2.remove(key));
                it.remove();
//                System.out.println("Key: "+key+" removed.");
            }
        }

//        System.out.println("map1 after remove loop: " + map1);
//        System.out.println("map2 after remove loop: " + map2);
//        System.out.println("cnt after remove loop: " + cnt);

        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            Integer value = entry.getValue();
            cnt += value;
        }

        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            Integer value = entry.getValue();
            cnt += value;
        }
        System.out.println(cnt);
    }
}

/*
Reference:

 */
/*
Map  Sherlock Holmes and removing of characters

Wow! This problem is kind of tricky. If you're ready to put your thinking cap on, brace yourself and good luck! Otherwise, you can skip it by now and return any time later
For this problem, imagine that you are Sherlock Holmes. You've deduced that the clues are somehow hidden within the pairs of words that contain only the same letters with the same frequencies. To crack the case, you now need to find out how many characters must be deleted to get such words (character sequences) from the given ones.

For example: for two words "case" and "seal" you'll need to remove characters "c" and "l" respectively to get "ase" and "sea". In this case, the answer is 2 ("c" and "l").

Remember: these "words" are case-insensitive

 Report a typo
Sample Input 1:

case
seal
Sample Output 1:

2
Sample Input 2:

Poooohgf
poohgf
Sample Output 2:

2
Sample Input 3:

write
write
Sample Output 3:

0
 */