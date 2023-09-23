public class Main {
    /*
    n = 15

    *=============*
    |1234567890123|
    |123456789012 |
    *12345678901  *
    *1234567890   *
    *123456789    *
    |12345678     |
    |      7------|
    |     6 \     |
    |    5   \    |
    *   4     \   *
    *  3       \  *
    * 2         \ *
    *1           \*
    *-------------*

     */
    public static void draw(int n) {
        char border = '*';  // символ для печати границ
        int willChanged = 1;  // символ для печати границ будет изменён на этой строке

        // Сколько строк должен будет печататься символ после изменения. Нужен для расчёта следующего willChanged.
        int nextSerieLength = 2;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {

                if (c == n - 1 || c == 0) {
                    if (r == willChanged) {
                        border = border == '*' ? '|' : '*';  // меняем символ на противоположную
                        willChanged += nextSerieLength++;  // строка на которой в следующий раз будет измененён символ
                    }
                    System.out.print(border);
                } else if (r == 0) {
                    System.out.print('=');
                } else if (r == n - 1) {
                    System.out.print('-');
                } else if (c + r == n - 1) {
                    System.out.print((n - 1 - r) % 10);
                } else if (r < n / 2 && c + r < n - 1) {
                    System.out.print(c % 10);
                } else if (r == n / 2 && c > n / 2) {
                    System.out.print('-');
                } else if (r == c && c > n / 2) {
                    System.out.print('\\');
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        draw(15);
    }

}