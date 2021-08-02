import java.util.*;

public class Main{
    static boolean[][] visited;
    static int[][] vector = {{0,1},{1,0},{0,-1},{-1,0}};
    static int x,y,area;
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        y=scan.nextInt();
        x=scan.nextInt();
        List<Integer> arealist =new ArrayList<>();
        visited=new boolean[y][x];
        int k= scan.nextInt();

        for(int i=0;i<k;i++){             //0,2 가 사실상 우리 좌표에서 2,0임
            int x1=scan.nextInt();
            int y1=scan.nextInt();
            int x2=scan.nextInt();
            int y2=scan.nextInt();

            for(int py=y1;py<y2;py++){
                for(int px=x1;px<x2;px++){
                    visited[py][px]=true;
                }
            }

        }
        for(int i=0;i<y;i++){
            for(int j=0;j<x;j++){
                if(visited[i][j]==false){
                    area=0;
                    dfs(i,j);
                    arealist.add(area);
                }
            }
        }

        System.out.println(arealist.size());
        Collections.sort(arealist);
        for(int data:arealist){
            System.out.print(data+" ");
        }
        //배열찍어보기
//        for(boolean[] data :visited){
//            System.out.println(Arrays.toString(data));
//        }

    }
    static void dfs(int row,int col){
        visited[row][col]=true;
        area++;

        for(int i=0;i<4;i++){
            int nr=row+vector[i][0];
            int nc=col+vector[i][1];
            if (nr >= 0 && nr < y  && nc >= 0 && nc < x && visited[nr][nc] == false ) {
                dfs(nr,nc);
            }
        }
    }

}
