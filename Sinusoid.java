package com;

import java.util.Random;

public class Sinusoid {

    private int amountOfSinusoids; // кількість синусоїд
    private int frequency; // частота
    private int amountOfPoints; // кількість точок
    private double[] x; // проміжний масив для результатів
    private int id;//змінна для виведення графіків, використання описано у класі Main
    /*
     * Конструктор класу Sinusoid
     */
    public Sinusoid(int amountOfSinusoids, int frequency, int amountOfPoints) {
        this.amountOfSinusoids = amountOfSinusoids;
        this.frequency = frequency;
        this.amountOfPoints = amountOfPoints;
        this.x = new double[amountOfPoints];
        this.id = Main.id;
    }
    /*
     * Метод, що викликається з Main для побудови графіків
     * Викликає метод для обчислення функції дискретного перетворення Фур'є, яка повертає
     * dft_final, dft_real, dft_imagine залежно від параметра id
     */
    public double[] calculateDFTArray(){
        return calculateDFTArray(getSygnalsForResultingGarmonic(), id);
    }
    /*
     * Метод для обчислення функції дискретного перетворення Фур'є
     * У якості параметрів надходять масив х та ідентифікатор id
     */
    public double[] calculateDFTArray(double[] sygnalsOfResultingGarmonic, int id){

        int N = sygnalsOfResultingGarmonic.length;
        double[] array = new double[N];
        double[] dft_real = new double[N];
        double[] dft_image = new double[N];
        double[] dft_final = new double[N];

        TableOfWPKN tableWpkN = new TableOfWPKN(N);
        tableWpkN.createTable();

        for (int p = 0; p < N; p++) {
            for (int k = 0; k < N; k++) {
                dft_real[p] += sygnalsOfResultingGarmonic[k] * tableWpkN.getTableWpkn(p,k).getRealPartOfWPKN();
                dft_image[p] += sygnalsOfResultingGarmonic[k] * tableWpkN.getTableWpkn(p,k).getImaginePartOfWPKN();
            }
            dft_final[p] = Math.sqrt(Math.pow(dft_real[p],2) + Math.pow(dft_image[p],2));
        }
        if (id == 1) array =  dft_final;
        else if (id == 2) array =  dft_real;
        else if (id == 3) array =  dft_image;
        return array;
    }
    /*
     * Метод для обчислення реальної частини W
     * @return - Math.cos(2*Math.PI*p*k/N)
     */
    /*private double WReal(int p, int k, int N){
        return Math.cos(2*Math.PI*p*k/N);
    }*/
    /*
     * Метод для обчислення уявної частини W
     * @return - Math.sin(2*Math.PI*p*k/N)
     */
    /*private double WImage(int p, int k, int N){
        return Math.sin(2*Math.PI*p*k/N);
    }*/
    /*
     * Метод для генерації випадкового сигналу
     */
    public double[] genRandomSignal() {
        Random r = new Random();
        double A = r.nextDouble();
        double q = r.nextDouble();
        for (int i = 0; i < amountOfPoints; i++) {
            for (int j = 0; j < amountOfSinusoids; j++) {
                x[i] += A * Math.sin(1.*frequency*(i+1)/amountOfSinusoids*j + q);
            }
        }
        return x;
    }
    /*
     * Метод для отримання кількості точок
     * @return - amountOfPoints
     */
    public int getCountOfPoints() {
        return amountOfPoints;
    }
    /*
     * Метод для отримання масиву х
     * @return - х
     */
    public double[] getSygnalsForResultingGarmonic() {
        return x;
    }
}