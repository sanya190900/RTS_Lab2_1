package com;
/*
 * Клас створено для виконання додаткового завдання
 * до лабораторної роботи
 * Завдання - реалізація запису Wpkn у таблицю
 */
public class TableOfWPKN {
    /*
     * Опис локальних змінних класу TableOfWPKN
     */
    private WPKN[][] tableWpkn; // власне таблиця
    private int N; // розмірність
    /*
     * Конструктор класу TableOfWPKN
     */
    public TableOfWPKN(int N) {
        this.N = N;
        this.tableWpkn = new WPKN[N][N];
    }
    /*
     * Метод, що викликається з Sinusoid для створення таблиці Wpkn для виконання додаткового завдання
     * Кожен елемент даної таблиці - елемент класу WPKN, який приймає у якості параметрів
     * два значення типу double, а саме реальну частину та уявну частину
     * По завершенні проходження циклів буде сформована таблиця WPKN
     */
    public void createTable(){
        for (int p = 0; p < N; p++) {
            for (int k = 0; k < N; k++) {
                tableWpkn[p][k] = new WPKN(RealPartOfWPKN(p,k,N), ImaginePartOfWPKN(p,k,N));
            }
        }
    }
    /*
     * Метод, що викликається з TableOfWPKN для обчислення уявної частини
     * для виконання додаткового завдання
     * Викликається в циклі
     */
    private double ImaginePartOfWPKN(int p, int k, int N){
        return Math.sin(2*Math.PI*p*k/N);
    }
    /*
     * Метод, що викликається з TableOfWPKN для обчислення реальної частини
     * для виконання додаткового завдання
     * Викликається в циклі
     */
    private double RealPartOfWPKN(int p, int k, int N){
        return Math.cos(2*Math.PI*p*k/N);
    }
    /*
     * Метод, що викликається з Sinusoid для обчислення реальної та уявної частини
     * для виконання додаткового завдання
     * Викликається в циклі, тому маємо доступ до кожного елемента
     */
    public WPKN getTableWpkn(int p, int k){
        return tableWpkn[p][k];
    }
}
