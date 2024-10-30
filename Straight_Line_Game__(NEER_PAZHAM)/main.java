import java.util.*;

/**
 * main
 */
public class main {

    static String matrix[][] = new String[3][3];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Arrays.fill(matrix[0], "-");
        Arrays.fill(matrix[1], "-");
        Arrays.fill(matrix[2], "-");

        List<int[]> contains = new ArrayList<>();
        contains.add(new int[] { 0, 0 });
        contains.add(new int[] { 0, 1 });
        contains.add(new int[] { 0, 2 });
        contains.add(new int[] { 1, 0 });
        contains.add(new int[] { 1, 1 });
        contains.add(new int[] { 1, 2 });
        contains.add(new int[] { 2, 0 });
        contains.add(new int[] { 2, 1 });
        contains.add(new int[] { 2, 2 });

        int p1c1[] = new int[2];
        int p1c2[] = new int[2];
        int p1c3[] = new int[2];
        int p2c1[] = new int[2];
        int p2c2[] = new int[2];
        int p2c3[] = new int[2];

        // --------------------welcome 2 straight line game----------------
        System.out.println();
        System.out.println("--------------------welcome to straight line game----------------");

        print();

        int index;
        // player 1 coin 1
        System.out.println("player 1 assign value for c1 :");
        justprintcontains(contains);
        index = sc.nextInt();
        p1c1 = contains.get(index - 1);
        contains.remove(index - 1);
        matrix[p1c1[0]][p1c1[1]] = "X1";
        print();

        // player 2 coin 1
        System.out.println("player 2 assign value for c1 :");
        justprintcontains(contains);
        index = sc.nextInt();
        p2c1 = contains.get(index - 1);
        contains.remove(index - 1);
        matrix[p2c1[0]][p2c1[1]] = "O1";
        print();

        // player 1 coin 2
        System.out.println("player 1 assign value for c2 :");
        justprintcontains(contains);
        index = sc.nextInt();
        p1c2 = contains.get(index - 1);
        contains.remove(index - 1);
        matrix[p1c2[0]][p1c2[1]] = "X2";
        print();

        // player 2 coin 2
        System.out.println("player 2 assign value for c2 :");
        justprintcontains(contains);
        index = sc.nextInt();
        p2c2 = contains.get(index - 1);
        contains.remove(index - 1);
        matrix[p2c2[0]][p2c2[1]] = "O2";
        print();

        // player 1 coin 3
        System.out.println("player 1 assign value for c3 :");
        justprintcontains(contains);
        index = sc.nextInt();
        p1c3 = contains.get(index - 1);
        contains.remove(index - 1);
        matrix[p1c3[0]][p1c3[1]] = "X3";
        print();

        boolean g = condition_checker();
        if (g) {
            System.out.println("Congralution player 1 !!!");
            System.out.print("You Won The Game !!!");
            return;
        }

        // player 2 coin 3
        System.out.println("player 1 assign value for c3 :");
        justprintcontains(contains);
        index = sc.nextInt();
        p2c3 = contains.get(index - 1);
        contains.remove(index - 1);
        matrix[p2c3[0]][p2c3[1]] = "O3";
        print();

        // condition checker
        g = condition_checker();
        if (g) {
            System.out.println("Congralution player 2 !!!");
            System.out.print("You Won The Game !!!");
            return;
        }

        // select or exit
        boolean f = true;
        while (true) {
            System.out.println("1.Select");
            System.out.println("2.Exit");
            int sl = sc.nextInt();
            if (sl != 1) {
                return;
            }
            System.out.println("Before matix : ");
            print();
            if (f) {
                System.out.println("Player 1 :");
                System.out.println("         X1          X2        X3");
                System.out.println("         {" + p1c1[0] + "," + p1c1[1] + "}" + "     " + "{" + p1c2[0] + ","
                        + p1c2[1] + "}" + "     " + "{" + p1c3[0] + "," + p1c3[1] + "}");
                List<int[]> path = new ArrayList<>();
                int sl1;
                boolean indicater = true;
                do {
                    if (!indicater) {
                        System.out.println("Sorry Your Entered Path Is Not Valid Please Select Another Path !!!");
                    }
                    System.out.print("Enter X Mover : ");
                    sl1 = sc.nextInt();
                    if (sl1 == 1) {
                        path = pathmover(p1c1);

                    } else if (sl1 == 2) {
                        path = pathmover(p1c2);
                    } else if (sl1 == 3) {
                        path = pathmover(p1c3);
                    }
                    indicater = false;
                } while (path.isEmpty());

                System.out.println("Your Enter path X" + sl1);
                justprintcontains(path);
                System.out.print("       Enter PathMover ");
                int pm = sc.nextInt();
                int changer[] = new int[2];
                changer = path.get(pm - 1);
                matrix[changer[0]][changer[1]] = "X" + sl1;
                if (sl1 == 1) {
                    matrix[p1c1[0]][p1c1[1]] = "-";
                    p1c1 = changer;
                } else if (sl1 == 2) {
                    matrix[p1c2[0]][p1c2[1]] = "-";
                    p1c2 = changer;
                } else if (sl1 == 3) {
                    matrix[p1c3[0]][p1c3[1]] = "-";
                    p1c3 = changer;
                }

            } else {
                System.out.println("Player 2 :");
                System.out.println("          O1          O2        O3");
                System.out.println("          {" + p2c1[0] + "," + p2c1[1] + "}" + "     " + "{" + p2c2[0] + ","
                        + p2c2[1] + "}" + "     " + "{" + p2c3[0] + "," + p2c3[1] + "}");
                List<int[]> path = new ArrayList<>();
                int sl2;
                boolean indicater = true;
                do {
                    if (!indicater) {
                        System.out.println("Sorry Your Entered Path Is Not Valid Please Select Another Path !!!");
                    }
                    System.out.print("Enter O Mover : ");
                    sl2 = sc.nextInt();
                    if (sl2 == 1) {
                        path = pathmover(p2c1);

                    } else if (sl2 == 2) {
                        path = pathmover(p2c2);

                    } else if (sl2 == 3) {
                        path = pathmover(p2c3);

                    }
                    indicater = false;
                } while (path.isEmpty());

                System.out.println("Your Enter path O" + sl2);
                justprintcontains(path);
                System.out.print("          Enter PathMover : ");
                int pm = sc.nextInt();
                int changer[] = new int[2];
                changer = path.get(pm - 1);
                matrix[changer[0]][changer[1]] = "O" + sl2;
                if (sl2 == 1) {
                    matrix[p2c1[0]][p2c1[1]] = "-";
                    p2c1 = changer;
                } else if (sl2 == 2) {
                    matrix[p2c2[0]][p2c2[1]] = "-";
                    p2c2 = changer;
                } else if (sl2 == 3) {
                    matrix[p2c3[0]][p2c3[1]] = "-";
                    p2c3 = changer;
                }
            }
            System.out.println("After matix : ");
            print();
            g = condition_checker();
            if (g) {
                if (f)
                    System.out.println("Congralution player 1 !!!");
                else
                    System.out.println("Congralution player 2 !!!");
                System.out.print("You Won The Game !!!");
                return;
            }
            f = !f;

        }

    }

    public static void justprintcontains(List<int[]> a) {
        for (int i = 0; i < a.size(); i++) {
            int sy[] = a.get(i);
            System.out.println("          " + (i + 1) + " : {" + sy[0] + "," + sy[1] + "}");

        }
    }

    public static void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("          " + matrix[i][j] + "  ");
            }
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }

    public static boolean condition_checker() {

        // 1
        if (matrix[0][0].charAt(0) == matrix[0][1].charAt(0) && matrix[0][1].charAt(0) == matrix[0][2].charAt(0)
                && (matrix[0][0].charAt(0) != '-' && matrix[0][1].charAt(0) != '-' && matrix[0][2].charAt(0) != '-')) {
            return true;
        }

        // 2
        if (matrix[0][0].charAt(0) == matrix[1][0].charAt(0) && matrix[1][0].charAt(0) == matrix[2][0].charAt(0)
                && (matrix[0][0].charAt(0) != '-' && matrix[1][0].charAt(0) != '-' && matrix[2][0].charAt(0) != '-')) {
            return true;
        }

        // 3
        if (matrix[0][0].charAt(0) == matrix[1][1].charAt(0) && matrix[1][1].charAt(0) == matrix[2][2].charAt(0)
                && (matrix[0][0].charAt(0) != '-' && matrix[1][1].charAt(0) != '-' && matrix[2][2].charAt(0) != '-')) {
            return true;
        }

        // 4
        if (matrix[0][2].charAt(0) == matrix[1][2].charAt(0) && matrix[1][2].charAt(0) == matrix[2][2].charAt(0)
                && (matrix[0][2].charAt(0) != '-' && matrix[1][2].charAt(0) != '-' && matrix[2][2].charAt(0) != '-')) {
            return true;
        }

        // 5
        if (matrix[2][0].charAt(0) == matrix[2][1].charAt(0) && matrix[2][1].charAt(0) == matrix[2][2].charAt(0)
                && (matrix[2][0].charAt(0) != '-' && matrix[2][1].charAt(0) != '-' && matrix[2][2].charAt(0) != '-')) {
            return true;
        }

        // 6
        if (matrix[2][0].charAt(0) == matrix[1][1].charAt(0) && matrix[1][1].charAt(0) == matrix[0][2].charAt(0)
                && (matrix[2][0].charAt(0) != '-' && matrix[1][1].charAt(0) != '-' && matrix[0][2].charAt(0) != '-')) {
            return true;
        }

        // 7
        if (matrix[0][1].charAt(0) == matrix[1][1].charAt(0) && matrix[1][1].charAt(0) == matrix[2][1].charAt(0)
                && (matrix[0][1].charAt(0) != '-' && matrix[1][1].charAt(0) != '-' && matrix[2][1].charAt(0) != '-')) {
            return true;
        }

        // 8
        if (matrix[1][0].charAt(0) == matrix[1][1].charAt(0) && matrix[1][1].charAt(0) == matrix[1][2].charAt(0)
                && (matrix[1][0].charAt(0) != '-' && matrix[1][1].charAt(0) != '-' && matrix[1][2].charAt(0) != '-')) {
            return true;
        }
        return false;
    }

    public static List<int[]> pathmover(int[] a) {
        int i = a[0];
        int j = a[1];
        List<int[]> res = new ArrayList<>();
        if (i == 0 && j == 0) {
            if (matrix[1][0].equals("-")) {
                res.add(new int[] { 1, 0 });
            }
            if (matrix[1][1].equals("-")) {
                res.add(new int[] { 1, 1 });
            }
            if (matrix[0][1].equals("-")) {
                res.add(new int[] { 0, 1 });
            }
            return res;
        }
        if (i == 0 && j == 1) {
            if (matrix[0][0].equals("-")) {
                res.add(new int[] { 0, 0 });
            }
            if (matrix[0][2].equals("-")) {
                res.add(new int[] { 0, 2 });
            }
            if (matrix[1][1].equals("-")) {
                res.add(new int[] { 1, 1 });
            }
            return res;
        }
        if (i == 0 && j == 2) {
            if (matrix[0][1].equals("-")) {
                res.add(new int[] { 0, 1 });
            }
            if (matrix[1][1].equals("-")) {
                res.add(new int[] { 1, 1 });
            }
            if (matrix[1][2].equals("-")) {
                res.add(new int[] { 1, 2 });
            }
            return res;
        }
        if (i == 1 && j == 0) {
            if (matrix[0][0].equals("-")) {
                res.add(new int[] { 0, 0 });
            }
            if (matrix[1][1].equals("-")) {
                res.add(new int[] { 1, 1 });
            }
            if (matrix[2][0].equals("-")) {
                res.add(new int[] { 2, 0 });
            }
            return res;
        }
        if (i == 1 && j == 1) {
            if (matrix[0][0].equals("-")) {
                res.add(new int[] { 0, 0 });
            }
            if (matrix[0][1].equals("-")) {
                res.add(new int[] { 0, 1 });
            }
            if (matrix[0][2].equals("-")) {
                res.add(new int[] { 0, 2 });
            }
            if (matrix[1][0].equals("-")) {
                res.add(new int[] { 1, 0 });
            }
            if (matrix[1][2].equals("-")) {
                res.add(new int[] { 1, 2 });
            }
            if (matrix[2][0].equals("-")) {
                res.add(new int[] { 2, 0 });
            }
            if (matrix[2][1].equals("-")) {
                res.add(new int[] { 2, 1 });
            }
            if (matrix[2][2].equals("-")) {
                res.add(new int[] { 2, 2 });
            }
            return res;
        }
        if (i == 1 && j == 2) {
            if (matrix[1][1].equals("-")) {
                res.add(new int[] { 1, 1 });
            }
            if (matrix[0][2].equals("-")) {
                res.add(new int[] { 0, 2 });
            }
            if (matrix[2][2].equals("-")) {
                res.add(new int[] { 2, 2 });
            }
            return res;
        }
        if (i == 2 && j == 0) {
            if (matrix[1][0].equals("-")) {
                res.add(new int[] { 1, 0 });
            }
            if (matrix[1][1].equals("-")) {
                res.add(new int[] { 1, 1 });
            }
            if (matrix[2][1].equals("-")) {
                res.add(new int[] { 2, 1 });
            }
            return res;
        }
        if (i == 2 && j == 1) {
            if (matrix[2][0].equals("-")) {
                res.add(new int[] { 2, 0 });
            }
            if (matrix[1][1].equals("-")) {
                res.add(new int[] { 1, 1 });
            }
            if (matrix[2][2].equals("-")) {
                res.add(new int[] { 2, 2 });
            }
            return res;
        }
        if (i == 2 && j == 2) {
            if (matrix[1][2].equals("-")) {
                res.add(new int[] { 1, 2 });
            }
            if (matrix[1][1].equals("-")) {
                res.add(new int[] { 1, 1 });
            }
            if (matrix[2][1].equals("-")) {
                res.add(new int[] { 2, 1 });
            }
            return res;
        }
        return res;
    }
}