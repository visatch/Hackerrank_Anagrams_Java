package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Anagrams {
    static HashMap<Character,Integer> getHashMapCharacter(String a){
        ArrayList<Character> arrayList = new ArrayList();
        HashMap<Character,Integer> hashMapChracter = new HashMap<>();
        a = a.toLowerCase();
        char character = a.charAt(0);
        arrayList.add(character);
        for (int i = 1; i <= a.length()-1; i++) {
            if(character != a.charAt(i))
            {
                if(!arrayList.contains(a.charAt(i)))
                {
                    character = a.charAt(i);
                    arrayList.add(character);
                }
            }
        }
        for (char j:arrayList ) {
            char c = j;
            Matcher matcher = Pattern.compile(String.valueOf(c)).matcher(a);
            int count = 0;
            while (matcher.find())
            {
                count ++;
            }
            hashMapChracter.put(c,count);
        }
        return hashMapChracter;
    }
    static boolean isAnagram(String a, String b) {
        if(a.length() > b.length() || b.length() > a.length())
        {
            return false;
        }
        else {
            HashMap<Character,Integer> hashMap1 = getHashMapCharacter(a);
            HashMap<Character,Integer> hashMap2 = getHashMapCharacter(b);
            for(Map.Entry<Character,Integer> entry1: hashMap1.entrySet())
            {
                for(Map.Entry<Character,Integer> entry2:hashMap2.entrySet())
                {
                    if(!hashMap1.get(entry1.getKey()).equals(hashMap2.get(entry1.getKey())))
                    {
                        return false;
                    }
                }
            }
            return true;
        }
    }
    public static void main(String[] args) {
        String a = "Abul";
//        String b = "BulA";
        String b = "BulA";
        System.out.println(isAnagram(a,b));
//        getHashMapCharacter(a);


    }
}

//        hashMap1.forEach((i,v) -> {
//            hashMap2.forEach((k,l)-> {
//                if(!hashMap1.get(i).equals(hashMap2.get(i)))
//                {
//                    return;
//                }
//            });
//        });
