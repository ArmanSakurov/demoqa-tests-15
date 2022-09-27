package guru.qa;

public class JavaBasics {

    public static void main(String[] args) {

        int firstNumber = 10;
        int secondNumber = 2;
        int thirdNumber = 100;

        // Арифметические операторы
        System.out.println(firstNumber + secondNumber);
        System.out.println(firstNumber - secondNumber);
        System.out.println(firstNumber * secondNumber);
        System.out.println(firstNumber / secondNumber);
        System.out.println(firstNumber % secondNumber);
        System.out.println(firstNumber++);
        System.out.println(firstNumber--);
        System.out.println(++firstNumber);


        // Операторы сравнения
        if (firstNumber > secondNumber) {
            System.out.println("Первое число больше второго");
        }
        else if (firstNumber < secondNumber) {
            System.out.println("Первое число меньше второго");
        }
        else {
            System.out.println("Числа равны");
        }

        // Логические операторы
        System.out.println(firstNumber > secondNumber && thirdNumber < secondNumber);
        System.out.println(firstNumber > secondNumber || thirdNumber < secondNumber);
        System.out.println(!(firstNumber > secondNumber) || thirdNumber < secondNumber);

        // Конструкция switch/case
        int caseNumber = 3;
        switch (caseNumber){
            case 1:
                System.out.println("Вы выбрали кейс №" + caseNumber);
                break;
            case 2:
                System.out.println("Вы выбрали кейс №" + caseNumber);
                break;
            case 3:
                System.out.println("Вы выбрали кейс №" + caseNumber);
                break;
            default:
                System.out.println("Вы выбрали ни один из предложенных вариантов");
        }

    }
}
