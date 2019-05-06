package leetcode;

class P983_Minimum_Cost_For_Tickets {


    public int mincostTickets(int[] days, int[] costs) {

        // 构造一个dp数组，存储了365天，每一天旅游所需要的花费，1表示第一天的花费，30表示第30天的花费
        // 0表示初始不需要任何花费
        int[] dp = new int[366];

        // 将这个dp数组初始化为一个max数
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // 然后将需要旅游的日期都标记为0，这样不需要旅游的日期和需要旅游的日期就区分开来了
        for (int day: days) {
            dp[day] = 0;
        }

        dp[0] = 0;

        for (int i = 1; i < 366; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                // 当我们遇到一个不需要旅行的日期，那么它的花费等于上一天的花费
                dp[i] = dp[i - 1];
            } else {
                // 当我们遇到需要旅行的日期，我们这一天的花费等于
                // 1.上一天的花费加上1天的票价
                // 2.上7天的花费，加上7天的票价
                // 3.上30天的花费，加上30天的票价
                // 上面三个数值中最小的一个

                int plan1 = dp[i - 1] + costs[0];
                int plan2 = dp[Math.max(0, i - 7)] + costs[1];
                int plan3 = dp[Math.max(0, i - 30)] + costs[2];

                dp[i] = Math.min(plan1, Math.min(plan2, plan3));
            }
        }

        // 因此数组最后一个存储的就是最小的花费了
        return dp[dp.length - 1];
    }


}
