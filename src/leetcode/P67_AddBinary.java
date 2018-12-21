package leetcode;

public class P67_AddBinary {

    public static void main(String[] args) {
        new P67_AddBinary().addBinary("1010", "1011");
    }

    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();

        boolean isCarry = false;
        int lenA = a.length();
        int lenB = b.length();
        for (int i = 0; i < Math.max(lenA, lenB); i++) {
            final char ai = (lenA - i - 1) < 0 ? '0' : a.charAt(lenA - i - 1);
            final char bi = (lenB - i - 1) < 0 ? '0' : b.charAt(lenB - i - 1);

            char x = '0';
            if (ai == '0' && bi == '0') {
                if (isCarry) {
                    x = '1';
                    isCarry = false;
                } else {
                    x = '0';
                }
            } else if (ai == '1' && bi == '1') {
                if (isCarry) {
                    x = '1';
                } else {
                    x = '0';
                }
                isCarry = true;
            } else {
                if (isCarry) {
                    x = '0';
                } else {
                    x = '1';
                }
            }

            sb.insert(0, x);
        }

        if (isCarry) {
            sb.insert(0, '1');
        }

        return sb.toString();
    }
}
