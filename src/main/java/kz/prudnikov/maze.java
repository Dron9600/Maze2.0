package kz.prudnikov;

import java.util.LinkedList;

public class maze {
    static LinkedList<position> path = new LinkedList<position>();

    static int[][] Maze = {
            {2, 0, 0, 1, 1, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 1, 1, 0, 1, 0},
            {0, 0, 0, 1, 1, 0, 1, 1},
            {1, 1, 1, 1, 0, 1, 0, 1},
            {0, 0, 0, 1, 1, 0, 1, 0}
    };

    public static void main(String[] args) {
        position p = new position(3, 6);
        path.push(p);
        //  System.out.println(Arrays.deepToString(new int[][]{new int[]{Maze[y][x]}}));

        while(true) {
        int y = path.peek().y;
        int x = path.peek().x;
        Maze[y][x] = 8;
        print();

        if (Valid(y + 1, x)) {
            if (Maze[y + 1][x] == 2) {
                System.out.println("Finish!");
                return;
            } else if (Maze[y + 1][x] == 1) {
                System.out.println("go down");
                path.push(new position(y + 1, x));
                continue;
            }
        }
        if (Valid(y - 1, x)) {
            if (Maze[y - 1][x] == 2) {
                System.out.println("Finish!");
                return;
            } else if (Maze[y - 1][x] == 1) {
                System.out.println("go up");
                path.push(new position(y - 1, x));
                continue;
            }
        }
        if(Valid(y, x + 1)) {
            if (Maze[y][x + 1] == 2) {
                System.out.println("Finish!");
                return;
            } else if (Maze[y][x + 1] == 1) {
                System.out.println("go right");
                path.push(new position(y, x + 1));
                continue;
            }
        }
        if(Valid(y, x-1)) {
            if (Maze[y][x - 1] == 2) {
                System.out.println("Finish!");
                return;
            } else if (Maze[y][x - 1] == 1) {
                System.out.println("go left");
                path.push(new position(y, x - 1));
                continue;
            }
        }
            System.out.println("back");
            path.pop();
            Maze[y][x] = 0;
            if(path.size() <= 0) System.out.println("No way");
    }
}


    private static void print() {
        for (int i = 0; i < Maze.length; i++) {
            for (int j = 0; j < Maze[i].length; j++) {
                System.out.print(Maze[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------");
    }
    public static boolean Valid(int y, int x){
        if (y < 0 || y >= Maze.length || x < 0 || x >= Maze[y].length ){
            return false;
        } return true;
    }
}
