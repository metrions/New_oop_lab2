package com.example.ooplab1.service.impl;

public class Converter_10_p {
        public static int FLOAT_ITERATIONS = 10;
        public static String[] symbols = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G"};

        //Преобразовать целое в символ.
        public static String int_to_Char(int n, int p) {
            return symbols[n % p];
        }

        //Преобразовать десятичное целое в с.сч. с основанием р.
        public static String int_to_P(int n, int p) {
            StringBuilder value = new StringBuilder();
            while (n / p > 0) {
                value.append(int_to_Char(n, p));
                n /= p;
            }
            value.append(int_to_Char(n, p));
            return value.reverse().toString();
        }

        //Преобразовать десятичную дробь в с.сч. с основанием р.
        public static String flt_to_P(double n, int p) {
            StringBuilder value = new StringBuilder();
            for (int i = 0; i < FLOAT_ITERATIONS && n != (double) ((int) n); i++) {
                n = n * p;
                int int_part = (int) n;
                value.append(int_to_Char(int_part, p));
                n = n - int_part;
            }
            return value.toString();
        }

        //Преобразовать десятичное
        //действительное число в с.сч. с осн. р.
        public static String Do(double n, int p) {
            StringBuilder value = new StringBuilder();
            if (n < 0) {
                value.append("-");
                n *= -1;
            }
            int int_part = (int) n;
            double double_part = n - int_part;
            value.append(int_to_P(int_part, p));
            value.append(".");
            value.append(flt_to_P(double_part, p));
            return value.toString();
        }
}
