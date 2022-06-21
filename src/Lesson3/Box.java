package Lesson3;

public class Box <T extends Fruit>{
    private int quant;
    T fruit;

    public Box(int quant, T fruit) {
        this.quant = quant;
        this.fruit = fruit;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public int getQuant() {
        return quant;
    }

    public float getWeightBox (){
        float weightBox = 0.0f;
        weightBox = getQuant()* fruit.getWeight();

        return weightBox;
    }

    public boolean compare (Box<?> box){
        return Math.abs(this.getWeightBox() - box.getWeightBox()) < 0.0001;
    }

    public void peresipat (Box<T> box){
        if (this.getQuant() != 0) {
            box.setQuant(this.getQuant() + box.getQuant());
            this.setQuant(0);

            System.out.println("В текущей коробке " + this.getQuant() + " фруктов");
            System.out.println("В другой коробке " + box.getQuant() + " фруктов");
        }else{
            System.out.println("Коробка пустая");
        }
    }
}
