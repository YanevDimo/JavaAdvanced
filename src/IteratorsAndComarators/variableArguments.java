package IteratorsAndComarators;

public class variableArguments {
    public static void main(String[] args) {

        printData(2,5,7);
        printData(3,5,6,7,8,9,0,1);
        printData(123);
        printData();

    }
    public static void printData(int f){

    }
    public  static  void printData(int...data){//работи с всички зададени му аргументи вкличително 0,но не работи
        //със списък, приема само изброени интове и масиви
        //varargs не може да се извика повече от 1 път и винаги се слага последен
        if (data.length == 0){
            System.out.println("No data was provided");
            return;
        }
        for (Integer integer : data) {
            System.out.println(integer);
        }
    }
}
