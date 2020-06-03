package com.sixdee.utils.supporters;

public class StringUtil {

    /**
     * Returns given string if it is non-null and non-empty otherwise returns the default one.
     *
     * @param str Given string
     * @return string if the string is non-empty default string otherwise
     */
    public static String getNonNull(final String str, String defValue) {
        return isPresent(str) ? str : defValue;
    }

    /**
     * Checks whether the given string is non-null and non-empty.
     *
     * @param str Given string
     * @return true if the string is non-empty false otherwise
     */
    public static boolean isPresent(final String str) {
        return str != null && !str.equals("");
    }

}
