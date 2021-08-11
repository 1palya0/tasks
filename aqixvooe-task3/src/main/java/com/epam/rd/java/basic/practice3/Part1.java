package com.epam.rd.java.basic.practice3;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {


    public static void main(String[] args) {
        String input = Util.getInput("part1.txt");
        System.out.println(convert1(input) + "\n");
        System.out.println(convert2(input) + "\n");
        System.out.println(convert3(input) + "\n");
        System.out.println(convert4(input) + "\n");
    }


    public static String convert1(String input) {
        if (input == null || input.equals("")) {
            return null;
        }
        Pattern pattern = Pattern.compile("([\\w\\d\\u0410-\\u044F\\u0456\\u0457]+);.+;([\\w\\u0410-\\u044F\\u0456\\u0457\\d]+@\\w+\\.\\w+)");
        Matcher matcher = pattern.matcher(input);
        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()) {
            stringBuilder.append(matcher.group(1))
                    .append(": ")
                    .append(matcher.group(2))
                    .append('\n');
        }
        return stringBuilder.toString();
    }

    public static String convert2(String input) {

        final String[] lines = input.split("\n");

        final StringBuilder outPutResult = new StringBuilder();

        for (int i = 1; i < lines.length; i++) {

            final String[] fields = lines[i].split("[;]");

            final String[] name = fields[1].split("[\\s]");

            StringBuilder nameField = new StringBuilder().append(name[1].concat(" ")).append(name[0]);

            outPutResult.append(nameField).append(" (email: ".concat(fields[2])).append(")\n");
        }
        return outPutResult.toString();
    }


    public static String convert3(String input) {

        final String[] lines = input.split("\n");

        boolean google = true;

        boolean mail = true;

        StringBuilder findNameGoogle = new StringBuilder();

        StringBuilder findNameMail = new StringBuilder();

        for (int i = 1; i < lines.length; i++) {

            final String[] names = lines[i].split("[;]");

            final String[] emails = names[2].split("[@]");

            if (emails[1].equals("google.com")) {

                if (google) {
                    findNameGoogle.append(emails[1].concat(" ==> "));
                    google = false;
                }
                findNameGoogle.append(names[0]).append(", ");
            }

            if (emails[1].equals("mail.com")) {
                if (mail) {
                    findNameMail.append(emails[1].concat(" ==> "));
                    mail = false;
                }
                findNameMail.append(names[0]).append(", ");
            }
        }

        findNameMail.setLength(findNameMail.length() - 2);

        findNameGoogle.setLength(findNameGoogle.length() - 2);

        return findNameMail.append("\n").append(findNameGoogle).append("\n").toString();
    }


    public static String convert4(String input) {
        if (input == null || input.equals(" ")) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(input);
        Pattern pattern = Pattern.compile(".+");
        Matcher matcher = pattern.matcher(input);
        StringBuilder stringBuilder = new StringBuilder();
        if (!matcher.find()) {
            return null;
        }
        stringBuilder.append(matcher.group()).append(";Password").append("\n");
        SecureRandom secureRandom = new SecureRandom();
        while (matcher.find()) {
            int randomNumber = secureRandom.nextInt(9000) + 1000;
            stringBuilder.append(matcher.group())
                    .append(";")
                    .append(randomNumber)
                    .append(System.lineSeparator());
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}