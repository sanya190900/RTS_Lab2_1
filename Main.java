package com;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

public class Main {
    /*
     * Змінна, що використовується для виведення обраного результату
     * Якщо id = 1, буде виведено графік DFT
     * Якщо id = 2, буде виведено графік DFT_Real
     * Якщо id = 3, буде виведено графік DFT_Imagine
     */
    public static final int id = 1;
    public static void main(String[] args) {

        //створення екземпляра класу Sinusoid
        Sinusoid sinusoid = new Sinusoid(12,2400,1024);
        //генерація випадкового сигналу
        sinusoid.genRandomSignal();
        //ініціалізація х
        double[] xData = arrayOfXData(sinusoid.getCountOfPoints());

        //змінна для вимірювання часу
        long startTime;
        // фіксуємо час початку
        startTime = System.nanoTime();
        /*
         * Побудова графіка дискретного перетворення Фур'є
         */
        sinusoid.calculateDFTArray();
        System.out.println("Time = " + (System.nanoTime() - startTime)/1000000.0 + " ms");
        if (id == 1) {
            XYChart chart = QuickChart.getChart("Lab2.1", "N", "x",
                    "DFT", xData, sinusoid.calculateDFTArray());
            new SwingWrapper<>(chart).displayChart();
        }
        if (id == 2) {
            XYChart chart = QuickChart.getChart("Lab2.1", "N", "x",
                    "DFT Real", xData, sinusoid.calculateDFTArray());
            new SwingWrapper<>(chart).displayChart();
        }
        if (id == 3) {
            XYChart chart = QuickChart.getChart("Lab2.1", "N", "x",
                    "DFT Imagine", xData, sinusoid.calculateDFTArray());
            new SwingWrapper<>(chart).displayChart();
        }
    }
    /*
     * Метод для ініціалізації даних(масиву Х)
     * */
    private static double[] arrayOfXData(int countOfDiscreteCalls) {
        if(countOfDiscreteCalls<0)
            return null;
        double[] res = new double[countOfDiscreteCalls];
        for (int i = 0; i < countOfDiscreteCalls; i++) {
            res[i] = (double)i;
        }
        return res;
    }
}