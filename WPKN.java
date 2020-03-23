package com;
/*
 * Клас створено для виконання додаткового завдання
 * до лабораторної роботи
 * Завдання - реалізація запису Wpkn у таблицю
 */
public class WPKN {
    /*
     * Опис локальних змінних класу WPKN
     */
    private double realPartOfWPKN; //змінна для роботи з реальною частиною
    private double imaginePartOfWPKN; //змінна для роботи з уявною частиною
    /*
     * Конструктор класу WPKN
     */
    public WPKN(double realPartOfWPKN, double imaginePartOfWPKN) {
        this.realPartOfWPKN = realPartOfWPKN;
        this.imaginePartOfWPKN = imaginePartOfWPKN;
    }
    /*
     * Метод, що викликається з Sinusoid для отримання реальної частини Wpkn
     * для виконання додаткового завдання
     * Викликається в циклі
     */
    public double getRealPartOfWPKN() {
        return realPartOfWPKN;
    }
    /*
     * Метод, що викликається з Sinusoid для отримання уявної частини Wpkn
     * для виконання додаткового завдання
     * Викликається в циклі
     */
    public double getImaginePartOfWPKN() {
        return imaginePartOfWPKN;
    }
}
