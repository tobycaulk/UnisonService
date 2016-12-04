package com.tobycaulk.unison.util;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;

public class Util {

	public static boolean validateStringsInArray(boolean checkEmpty, String...strings) {
        return Arrays.asList(strings).stream()
                .filter(str -> (checkEmpty ? !StringUtils.isEmpty(str) : str != null))
                .collect(Collectors.toList()).size() == strings.length;
    }
}
