package main.java;

public class ReverseString {

    public static String reverseString(String str) {
        if (str == null) return null;
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static String reverseStringInPlace(String str) {
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
        return new String(chars);
    }

    static void main() {
        String a = "123456";

        System.out.println("Reverse String : " + reverseString(a));
    }
}
