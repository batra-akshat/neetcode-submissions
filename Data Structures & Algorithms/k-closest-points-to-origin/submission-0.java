class Solution {
    class Point {
        int x;
        int y;
        int dis;
        Point(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    public int[][] kClosest(int[][] p, int k) {
        List<Point> points = new ArrayList<>();
        for (int[] ints : p) {
            int x = ints[0];
            int y = ints[1];
            int dis = x * x + y * y;
            points.add(new Point(x, y, dis));
        }
        points.sort((a,b) -> a.dis - b.dis);
        int[][] ans = new int[k][2];
        for(int i = 0 ;i<k;i++) {
            ans[i][0] = points.get(i).x;
            ans[i][1] = points.get(i).y;
        }
        return ans;
    }
}
