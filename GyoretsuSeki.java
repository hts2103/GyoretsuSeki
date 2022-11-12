import java.util.Scanner;

public class GyoretsuSeki {
    public static void main(String[] args){
        int[][] a;
        int[][] b;
        int[][] ans;
        int m, n, n2;

        Scanner sc = new Scanner(System.in);

        System.out.printf("\n１つ目の行列と２つ目の行列の積を計算します。\n\n");

        System.out.println("１つ目のm行n列の行列を入力してください。");
        System.out.print("m = ");
        m = sc.nextInt();
        System.out.print("n = ");
        n = sc.nextInt();
        System.out.println();
        a = new int[m + 1][n + 1];//
        a = hairetsu(m, n, 'a', a, sc);
        
        System.out.println("２つ目のm行n列の行列を入力してください。");
        System.out.printf("m = %d\n", n);
        System.out.print("n = ");
        n2 = sc.nextInt();
        System.out.println();
        b = new int[n + 1][n2 + 1];//
        b = hairetsu(n, n2, 'b', b, sc);

        ans = new int[m + 1][n2 + 1];
        ans = seki(m, n, n2, a, b, ans);

        System.out.printf("１つ目の行列\n");
        printHairetsu(m, n, a);
        System.out.printf("\n２つ目の行列\n");
        printHairetsu(n, n2, b);
        System.out.printf("\n計算結果は以下の通りです。\n");
        printHairetsu(m, n2, ans);
    }

    public static int[][] hairetsu(int a, int b, char c, int[][] h, Scanner sc){
        int i,j;

        for(i = 1; i < a + 1; i++){
            for(j = 1; j < b + 1; j++){
                System.out.printf("%c[%d][%d] = ", c, i, j);
                h[i][j] = sc.nextInt();
            }
        }

        System.out.println();

        return h;
    }

    public static int[][] seki(int m, int n, int n2, int a[][], int b[][], int ans[][]){
        int h, i, j, temp;
        
        for(h = 1; h < m + 1; h++){
            for(i = 1; i < n2 + 1; i++){
                temp = 0;

                for(j = 1; j < n + 1; j++){
                    temp = temp + a[h][j] * b[j][i];
                }

                ans[h][i] = temp;
            }
        }
        
        return ans;
    }

    public static void printHairetsu(int a, int b, int[][] h){
        int i, j;
        
        for(i = 1; i < a + 1; i++){
            System.out.print("[ ");
            for(j = 1; j < b + 1; j++){
                System.out.printf("%d ", h[i][j]);
            }
            System.out.println("]");
        }
    }
}