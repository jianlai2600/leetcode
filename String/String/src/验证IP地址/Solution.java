package 验证IP地址;

class Solution {
    public boolean containsEnglishCharacter(String str) {
        for (char c : str.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                return true;
            }
        }
        return false;
    }
    public boolean checkIPv4(String s) {

        String[]sArr = s.split("\\.");
        if (sArr.length != 4) {
            return false;
        }
        for (String singleS : sArr) {
            if (singleS.isEmpty()) {
                return false;
            }
            if (containsEnglishCharacter(singleS)) {
                return false;
            }
            if (singleS.length() > 1 && singleS.charAt(0) == '0') {
                return false;
            }
            if (Integer.valueOf(singleS) > 255) {
                return false;
            }
        }

        return true;
    }
    public boolean checkIPv6(String s) {

        String[]sArr = s.split("\\:");
        if (sArr.length != 8) {
            return false;
        }
        for (String singleS : sArr) {
            if (singleS.length() > 4 || singleS.isEmpty()) {
                return false;
            }
            for (Character c : singleS.toCharArray()) {
                if (!(c >= '0' && c <= '9') && !(c >= 'a' && c <= 'f') && !(c >= 'A' && c <= 'F')) {
                    return false;
                }
            }
        }

        return true;
    }
    public String validIPAddress(String queryIP) {

        if (queryIP.length() > 39) {
            return "Neither";
        }
        int dot = 0, colon = 0;
        for (Character c : queryIP.toCharArray()) {
            if (c.equals('.')) {
                dot++;
            } else if (c.equals(':')) {
                colon++;
            }
        }
        if (dot == 3 && colon == 0 && checkIPv4(queryIP)) {
            return "IPv4";
        } else if (colon == 7 && dot == 0 && checkIPv6(queryIP)){
            return "IPv6";
        } else {
            return "Neither";
        }
    }
    public static void main(String[] args) {

        String queryIP = "12..33.4";

        Solution sol = new Solution();
        String ret = sol.validIPAddress(queryIP);

        System.out.println(ret);
    }
}