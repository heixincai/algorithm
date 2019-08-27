package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-email-addresses/
 * */
public class P929_UniqueEmailAddresses {

    public static void main(String[] args) {
        String[] arr = new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        new P929_UniqueEmailAddresses().numUniqueEmails(arr);
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> sets = new HashSet<>();

        for (String s : emails) {
            sets.add(standard(s));
        }

        return sets.size();
    }

    static String standard(String email) {
        String[] arr = email.split("@");
        String local = arr[0];
        String host = arr[1];
        local = local.replaceAll("\\.", "");
        int plusSymbolIndex = local.indexOf('+');
        if (plusSymbolIndex >= 0) {
            return local.substring(0, plusSymbolIndex) + "@" + host;
        } else {
            return email + "@" + host;
        }
    }

}
