package GUI;

import java.util.*;

/*Use of DFS and Backtracking to find the shortest path
    form the starting index to the goal(9)
 */
public class DFS {
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};

    public static ArrayList<Integer> temp = new ArrayList<>();
    public static void path(int[][] maze, ArrayList<Integer> path, int i, int j, boolean[][] visit){
        if(maze[i][j]==9){
            temp.add(i*maze[0].length+j);
            if(path.size()==0 || temp.size()<path.size()){
                path.addAll(temp);
            }
            temp.remove(temp.size()-1);

            return;
        }
        visit[i][j] = true;
        temp.add(i*maze[0].length+j);
        for(int x=0;x<4;x++){
            int ni = i + dx[x];
            int nj = j + dy[x];
            if(ni<0 || nj<0 || ni>=maze.length || nj>=maze[0].length || maze[ni][nj]==1 || visit[ni][nj])continue;
            path(maze,path,ni,nj,visit);
        }
        visit[i][j] = false;
        temp.remove(temp.size()-1);
    }
}
