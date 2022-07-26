package Lesson2;

public class Main {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {

        String[][] arrayGood = {{"020", "021", "022", "023"}, {"120", "121", "122", "123"}, {"220", "221", "222", "223"}, {"320", "321", "322", "323"}};
        String[][] arrayWithEx = {{"020", "Ex", "022", "023"}, {"120", "121", "122", "123"}, {"220", "221", "222", "223"}, {"320", "321", "322", "323"}};
        String[][] arrayBedSize = {{"020", "021", "Ku"}, {"120", "121", "122", "123"}, {"220", "221", "222", "223"}, {"220", "221", "223"}};

        getSumm(arrayGood);

        try {
            getSumm(arrayWithEx);
        } catch (MyArrayDataException e){
            System.out.println(e.getMessage());
        }

        try {
            checkSize(arrayBedSize);
        } catch (MyArraySizeException e){
            System.out.println(e.getMessage());
        }



    }

    public static void checkSize(String[][] array) throws MyArraySizeException {

        if (array.length != 4 | array[0].length != 4) {
            throw new MyArraySizeException("Неправильный размер массива");
        }

    }


    public static void getSumm(String[][] array) throws MyArraySizeException, MyArrayDataException{
        checkSize(array);
        int summ = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                try {

                    summ += Integer.parseInt(array[i][j]);

                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException("Ошибка в позции " +i+j );
                    //System.out.println("NumberFormatException: " + e.getMessage()+i+j);
                }
            }
        }
        System.out.println("Array summ = " + summ);
    }

}

