package leetcode;

public class P482_LicenseKeyFormatting {

    public static void main(String[] args) {
        new P482_LicenseKeyFormatting().licenseKeyFormatting("5F3Z-2e-9-w", 4);
    }

    public String licenseKeyFormatting(String S, int K) {

        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) != '-') {
                sb.append(sb.length() % (K + 1) == K ? "-" : "").append(S.charAt(i));
            }
        }

        return sb.reverse().toString().toUpperCase();
    }
}
