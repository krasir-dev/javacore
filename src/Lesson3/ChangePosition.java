package Lesson3;

public class ChangePosition <T> {
    private T[] array;
    private T obj1;

    public  T[] getChangePosition(T[] array, int posBefore, int posAfter){
        for (int i=0; i< array.length; i++){
            if (i==posBefore){
                obj1=array[i];
                array[i]=array[posAfter];
                array[posAfter]=obj1;
            }
        }
        return array;
    }
}
