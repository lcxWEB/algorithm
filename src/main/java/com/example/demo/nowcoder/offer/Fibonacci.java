package com.example.demo.nowcoder.offer;


public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.Fibonacci(0));
        System.out.println(fibonacci.Fibonacci(1));
        System.out.println(fibonacci.Fibonacci(2));
        System.out.println(fibonacci.Fibonacci(3));
        System.out.println(fibonacci.Fibonacci(4));
        System.out.println(fibonacci.Fibonacci(5));
        System.out.println(fibonacci.Fibonacci2(6));

    }

    public int Fibonacci1(int n) {
        if (n <= 1) {
            return n;
        }
        return Fibonacci1(n - 1) + Fibonacci1(n - 2);
    }

    public int Fibonacci2(int n) {
        if (n <= 1) {
            return n;
        }
        int fobMinusOne = 1;
        int fibMinusTwo = 0;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = fobMinusOne + fibMinusTwo;
            fibMinusTwo = fobMinusOne;
            fobMinusOne = fib;
        }
        return fib;
    }

    public int Fibonacci(int n) {
        int f = 0, g = 1;
        while (n-- > 0) {
            g += f;
            f = g - f;
        }
        return f;
    }


}
