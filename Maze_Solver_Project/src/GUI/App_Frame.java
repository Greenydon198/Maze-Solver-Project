package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class App_Frame extends JFrame{

    //general app's GUI Attributes
    public App_Frame(){
        setTitle("MAZE SOLVER");
        setLocation(100,100);
        getContentPane().setBackground(Color.black);
        setSize(1200,480);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DFS.path(maze,path,1,1,new boolean[maze.length][maze[0].length]);
    }

    /*Sample data to generate a maze
        where 1 is wall or obstacle
              0 is free path
              9 is the goal or destination
     */
    public int[][] maze =  {{1,1,1,1,1,1,1,1,1,1,1,1,1},
                            {1,0,1,0,1,0,1,0,0,0,0,0,1},
                            {1,0,1,0,0,0,1,0,1,1,1,0,1},
                            {1,0,1,1,1,1,1,0,0,0,0,0,1},
                            {1,0,0,1,0,0,0,0,1,1,1,0,1},
                            {1,0,1,0,1,1,1,0,1,0,0,0,1},
                            {1,0,1,0,1,0,0,0,1,1,1,0,1},
                            {1,0,1,0,1,1,1,0,1,0,1,0,1},
                            {1,0,0,0,0,0,0,0,0,0,1,9,1},
                            {1,1,1,1,1,1,1,1,1,1,1,1,1}};

    //path is to store the shortest length from start to destination
    public ArrayList<Integer> path = new ArrayList<>();

    /*general touches with paint to make it appealing to the eye
      where walls or obstacles(1) is painted red
            free path is painted white
            and the destination as yellow

            finally the path from start to goal is marked with green
     */
    @Override
    public void paint(Graphics g){
        g.translate(50,50);
        for(int i=0;i<maze.length;i++) {
            for (int j = 0; j < maze[0].length; j++) {
                Color c;
                switch (maze[i][j]) {
                    case 1: {
                        c = Color.red;
                        break;
                    }
                    case 0: {
                        c = Color.white;
                        break;
                    }
                    default: {
                        c = Color.yellow;
                    }
                }
                g.setColor(c);
                g.fillRect(40 * j, 40 * i, 40, 40);
                g.setColor(Color.black);
                g.drawRect(40 * j, 40 * i, 40, 40);
            }
        }

        g.translate(550,0);
        for(int i=0;i<maze.length;i++) {
            for (int j = 0; j < maze[0].length; j++) {
                Color c;
                switch (maze[i][j]) {
                    case 1: {
                        c = Color.red;
                        break;
                    }
                    case 0: {
                        c = Color.white;
                        break;
                    }
                    default: {
                        c = Color.yellow;
                    }
                }
                g.setColor(c);
                g.fillRect(40 * j, 40 * i, 40, 40);
                g.setColor(Color.black);
                g.drawRect(40 * j, 40 * i, 40, 40);
            }
        }

        //this section paints the path from start to goal
        for(int x:path){
            int i = x/maze[0].length;
            int j = x%maze[0].length;
            g.setColor(Color.green);
            g.fillRect(40 * j, 40 * i, 40, 40);
        }
    }
    public static void main(String[] args) {
        new App_Frame();
    }
}
