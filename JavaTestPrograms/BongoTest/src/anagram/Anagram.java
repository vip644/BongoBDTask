package anagram;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram {

    private static boolean checkAnagram(char[] str1, char[] str2) {

        int count[] = new int[26];
        for (int i = 0; i < str1.length; i++) {
            count[str1[i] - 97]++;
            count[str2[i] - 97]--;
        }

        for (int i = 0; i < str1.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkAnagramHashmap(char[] str1, char[] str2){

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char aN : str1) {
            if (map1.get(aN) == null) {
                map1.put(aN, 1);
            } else {
                Integer count = map1.get(aN);
                map1.put(aN, ++count);
            }
        }

        for (char bN : str2) {
            if (map2.get(bN) == null) {
                map2.put(bN, 1);
            } else {
                Integer count = map2.get(bN);
                map2.put(bN, ++count);
            }
        }

        return map1.equals(map2);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First String : ");
        String a = sc.next();

        System.out.println("Enter Second String : ");
        String b = sc.next();

        char[] n = a.toLowerCase().toCharArray();
        char[] m = b.toLowerCase().toCharArray();

        if (n.length != m.length) {
            System.out.println("Both Strings should've same length.");

        } else {
            if (checkAnagram(n, m)) {
                System.out.println("Anagram");
            } else {
                System.out.println("Not Anagram");
            }
        }
    }
}
