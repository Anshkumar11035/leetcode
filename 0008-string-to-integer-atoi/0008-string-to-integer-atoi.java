class Solution {
    public int myAtoi(String s) {

        int i = 0;
        int n = s.length();

        // 1. Skip leading spaces

        while(i < n && s.charAt(i) == ' ') {
            i++;
        }

        // If string contains only spaces

        if(i == n)
            return 0;

        // 2. Check sign

        int sign = 1;

        if(s.charAt(i) == '-') {
            sign = -1;
            i++;
        }else if (s.charAt(i) == '+') {
            i++;
        }

        // 3. Convert digits

        int result = 0;

        while (i < n && Character.isDigit(s.charAt(i))) {

            int digit = s.charAt(i) - '0';

            // 4. Overflow check

            if(result > (Integer.MAX_VALUE - digit) / 10) {
                if (sign == 1)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}