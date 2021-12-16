package ru.geekbrains.homework2;

public class HomeWorkApp {
    public static void main(String[] args) {
      String[][] str = new  String[][]{
              {"1","2","3","4"},
              {"5","6","7","8"},
              {"9","10","11","12"},
              {"13","14","15","16"},
      };
        try {
            try {
                int upshot = main(str);
                System.out.println(upshot );
            } catch (MyArraySizeException e) {
                System.out.println("Массив больше положенного размера!");
            }
        }
        catch (MyArrayDataException e) {
            System.out.println("Значение в массиве не верно!");
            System.out.println("Ошибка в ячейке: " + e.i + "x" + e.j);
        }

    }


    public static int main(String[][] str)
            throws MyArraySizeException, MyArrayDataException {
        int number = 0;
        if (str.length != 4) {
            throw new MyArraySizeException ();
        }
        for (int i = 0; i < str.length; i++) {
            if (str[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < str[i].length; j++) {
                try {
                    number = number + Integer.parseInt(str[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }

        }
        return number;
    }
}
