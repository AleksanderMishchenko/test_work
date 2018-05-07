/* 2. Структура данных
 * Дано: выражение вида [5] * 3 - ( 4 - 7 * [3-6]).
 * Написать функцию checkBrackets(String s), которая принимает на вход строку с выражением и возвращает TRUE или FALSE.
 * Если скобки расставлены правильно — TRUE, в противном случае — FALSE.
 * Пример неправильно расставленных скобок: ( 5 * 3 [ 6 ) - 6]
 */

import java.util.Stack;

public class TestBrackets {
    private static final char a1 = '(';
    private static final char a2 = ')';
    private static final char b1 = '[';
    private static final char b2 = ']';
    private static final char c1 = '{';
    private static final char c2 = '}';

    public static boolean checkBrackets(String s) {

        // создаем стек, где будут помещены скобки
        // разбиваем строку на массив символов
        Stack<Character> stack = new Stack<Character>();
        char[] array = s.toCharArray();
        for(char c : array) {

            // если символ является закрывающей скобкой И стек пустой
            // сразу возвращаем false, т.к. закрывающая скобка не может быть первой
            if((c == a2 || c == b2 || c == c2) && stack.empty()) {
                return false;
            }

            // если символ является открывающей скобкой, кладем его в стек
            if(c == a1 || c == b1 || c == c1) {
                stack.push(c);
            }

            // если символ является закрывающей скобкой и стеке уже находится одна или более открывающих скобок,
            // создаем временную переменную, в которую помещаем символ, находящийся "сверху" в стеке. Этот метоод не удаляет элемент из стека
            // если наверху стека находится открывающая скобка, то удаляем ее из стека. Таким образом удаляем пары скобок
            if((c == a2 || c == b2 || c == c2) && !stack.empty()) {
                char t = stack.peek();
                switch(c) {
                    case ')':
                        if(t == '(') stack.pop();
                        break;
                    case ']':
                        if(t == '[') stack.pop();
                        break;
                    case '}':
                        if(t == '{') stack.pop();
                        break;
                }
            }
        }

        // если стек оказался пуст - у каждой скобки была своя пара
        // если нет - скобки были расставлены неправильно
        if(stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Проверяем работу программы
        String str = "[5] * 3 - ( 4 - 7 * [3-6])";
        if(checkBrackets(str)) {
            System.out.println(str + " - cкобки расставлены правильно");

        } else {
            System.out.println(str + " - cкобки расставлены неправильно");
        }
        System.out.println("_________________________________________________________\n");

        str = "( 5 * 3 [ 6 ) - 6]";
        if(checkBrackets(str)) {
            System.out.println(str + " - cкобки расставлены правильно");
        } else {
            System.out.println(str + " - cкобки расставлены неправильно");
        }

    }

}
