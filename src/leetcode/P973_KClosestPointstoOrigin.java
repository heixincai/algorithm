package leetcode;

public class P973_KClosestPointstoOrigin {

    public static class Data {
        public Data(int[] point) {
            dist = dist(point);
            this.point = point;
        }

        public int dist;
        public int[] point;
    }

    public static int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public int[][] kClosest(int[][] points, int K) {

        Data[] datas = new Data[points.length];
        datas[0] = new Data(points[0]);

        for (int i = 1; i < points.length; i++) {
            Data d = new Data(points[i]);
            int j = i - 1;

            while (j >= 0 && datas[j].dist > d.dist) {
                datas[j + 1] = datas[j];
                j--;
            }

            datas[j + 1] = d;
        }

        int[][] result = new int[K][2];

        for (int i = 0; i < K; i++) {
            result[i] = datas[i].point;
        }

        return result;
    }

}
