import java.util.*;

/*
* javac ClimbStairs.java; java -ea ClimbStairs
* https://leetcode.com/problems/climbing-stairs/description/
*/


class ClimbStairs {
    public int climbStairs(int n) {
        System.out.println("Input is " + n);
        if (n <= 2) {
            return n;
        }

        int prev2 = 1;
        int prev1 = 2;

        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        System.out.println("Output is " + prev1);
        return prev1;
    }


    public static void main(String[] args) {
        ClimbStairs s = new ClimbStairs();

        assert s.climbStairs(1) == 1;
        assert s.climbStairs(2) == 2;
        assert s.climbStairs(3) == 3;
        assert s.climbStairs(4) == 5;
        assert s.climbStairs(5) == 8;
    }
}

