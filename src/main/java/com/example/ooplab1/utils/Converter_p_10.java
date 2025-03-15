package com.example.ooplab1.utils;

import java.util.ArrayList;
import java.util.List;

public class Converter_p_10 {

    public static List<Character> symbols = new ArrayList<>(List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G'));

    //Преобразовать цифру в число.
    static double char_To_num(char ch) {
        return symbols.indexOf(ch);
    }

    //Преобразовать строку в число
    private static double convert(String P_num, int P, double weight) {
      char[] array = P_num.toCharArray();
      double result = 0;
      for (var it : array){
          result += char_To_num(it) * weight;
          weight /= (double) P;
      }
      return result;
    }

    //Преобразовать из с.сч. с основанием р
    //в с.сч. с основанием 10.
    public static double dval(String P_num, int P) {
        int minus = (P_num.indexOf("-") != -1) ? -1 : 1;
        P_num = P_num.replace("-", "");
        int pointIndex = (P_num.indexOf(".") != -1) ? P_num.indexOf(".") : P_num.length();
        P_num = P_num.replace(".", "");
        return minus * convert(P_num, P, Math.pow(P, pointIndex-1));
    }
}
