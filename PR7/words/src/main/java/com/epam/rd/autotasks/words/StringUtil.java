package com.epam.rd.autotasks.words;

import java.util.Arrays;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        int count = 0;
        if (words == null || words.length == 0 || sample == null) {
            return 0;
        }
        String sample1 = sample.trim();
        String[] words1 = Arrays.copyOf(words, words.length);
        for (int i = 0; i < words1.length; i++) {
            words1[i] = words1[i].trim();
            if (words1[i].equalsIgnoreCase(sample1)) {
                count++;
            }
        }
        return count;
    }

    public static String[] splitWords(String text) {
        if(text==null ){
            return null;
        }
        text=text.replaceAll("\\W+",",").replaceAll("^,|,*$","");
        if(text.isBlank()){
            return null;
        }
        return text.split(",");
    }

    public static String convertPath(String path, boolean toWin) {
        StringBuilder newPath = new StringBuilder();
        if(path == null || path.isEmpty())return null;
        if(!isPathCorrect(path))return null;
        if((path.contains("\\") || path.contains("C:\\")) && toWin)return path;
        if((path.contains("/") || path.contains("~")) && !toWin)return path;
        return convert(path, toWin);
    }

    public static String convert(String path, boolean toWin){
        String fromRoot = "C:\\User";
        String fromRoot1 = "C:";
        String toRoot = "~";
        String toRoot1 = "";
        String fromSlash = "\\";
        String toSlash = "/";
        if(toWin) {
            String temp = fromRoot;
            fromRoot = toRoot;
            toRoot = temp;
            temp = fromRoot1;
            fromRoot1 = toRoot1;
            toRoot1 = temp;
            temp = fromSlash;
            fromSlash = toSlash;
            toSlash = temp;
        }
        StringBuilder newPath = new StringBuilder();
        newPath.append(path.replace(fromSlash, toSlash));
        int index1 = path.lastIndexOf(fromRoot);
        int index2;
        if(toWin){
            index2 = path.indexOf(fromSlash);
        }else {
            index2 = path.lastIndexOf(fromRoot1);
        }
        if(index1 == 0){
            newPath.replace(0, fromRoot.length(), toRoot);
        }else if(index2 == 0){
            newPath.replace(0, fromRoot1.length(), toRoot1);
        }
        return newPath.toString();
    }

    public static boolean isPathCorrect(String path){
        if(path.contains("\\") && path.contains("/")){
            return false;
        }
        if(path.contains("\\") && path.contains("~")){
            return false;
        }
        if(path.contains("C:") && path.contains("/")){
            return false;
        }
        return path.lastIndexOf("C:") <= 0 && path.lastIndexOf("~") <= 0;
    }

    public static String joinWords(String[] words) {
        StringBuilder sb = new StringBuilder();
        if (words == null || words.length == 0)  { return null; }
        int count = 0;
        for (String word : words) {
            if (word.isEmpty()) {
                count++;
            }
            if (count == words.length) {
                return null;
            }
        }
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                sb.append("[");
            }
            if (!words[i].isEmpty()) {
                sb.append(words[i]);
                if (i < words.length - 1) {
                    sb.append(", ");
                }
            }
            if (i == words.length - 1) {
                sb.append("]");
            }
        }
        String str = sb.toString();
        if(str.endsWith(", ]")){
            str=str.replace(", ]","]");
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS",};
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}