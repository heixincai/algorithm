package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krosshuang on 2019/3/27.
 */
public class P535_Encode_and_Decode_TinyURL {

public List<String> data = new ArrayList<>();

// Encodes a URL to a shortened URL.
public String encode(String longUrl) {
    int id = data.size();
    data.add(longUrl);
    return convert(id);
}

// Decodes a shortened URL to its original URL.
public String decode(String shortUrl) {
    return data.get(convert(shortUrl));
}

public static final String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*_+-=~`";

public static String convert(int number) {
    if (number == 0) {
        return alphabet.charAt(0) + "";
    }
    StringBuilder sb = new StringBuilder();
    while (number > 0) {
        sb.append(alphabet.charAt(number % alphabet.length()));
        number /= alphabet.length();
    }
    return sb.reverse().toString();
}

public static int convert(String code) {
    int num = 0;
    for (int i = 0; i < code.length(); i++) {
        num += alphabet.indexOf(code.charAt(i)) * Math.pow(alphabet.length(), code.length() - i - 1);
    }
    return num;
}

public static void main(String[] args) {
    for (int i = 0; i < 10000; i++) {
        String code = convert(i);
        System.out.println("num=" + i + " code=" + code + " back=" + convert(code));
    }
}

}
