package com.jboxers.regexParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataGetter {



    public List<String> getData(String pattern, String html, int group) {
        List<String> result = new ArrayList<>();

        Pattern pattern1 = Pattern.compile(pattern);
        Matcher matcher = pattern1.matcher(html);

        while (matcher.find()) {
            result.add(matcher.group(group));

            System.out.println("Occurrences: " + result);


            System.out.println("This is saved now: " + result);
        }
        System.out.println(result.size());
        return result;

    }

}
