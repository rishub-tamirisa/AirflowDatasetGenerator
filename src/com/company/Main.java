package com.company;
import java.io.IOException;
import java.lang.Math;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.Writer;
public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("/Users/rishubtamirisa/Desktop", "randomAirflow9.csv");
        Writer br = new BufferedWriter(new FileWriter(file));
        //BufferedWriter mb = new BufferedWriter(new FileWriter("anomalies-3.csv"));
        StringBuilder sb = new StringBuilder();
        StringBuilder ta = new StringBuilder();

        int[] array = new int[10000];
        int[] labels = new int[10000];
        double coinFlip = 0;
        int clusterSize;
        for (int i = 0; i < array.length - 11; i++) {
            //coinFlip = Math.random();
            //System.out.println("i: " + i);
            //System.out.println(coinFlip);
            if (i % 4 == 0) {
                clusterSize = (int) (Math.random() * 2) + 2;
                //System.out.println(clusterSize);
                int start = 60;
                for (int j = i; j < i + clusterSize; j++) {
                    array[j] = (int) (Math.random() * 425) + start;
                    //i += clusterSize;
                    start += ((int) (Math.random() * 100) + 50);
                }

            }
        }
        for (int i = 0; i < array.length - 11; i++) {
            coinFlip = Math.random();
            if (coinFlip > 0.99) {
                clusterSize = (int) (Math.random() * 3) + 9;
                //System.out.println(clusterSize);
                for (int j = i; j < i + clusterSize; j++) {
                    array[j] = 0;//(int) (Math.random() * 50);
                    labels[j] = 1;
                    //i += clusterSize;
                }
            }
        }
        sb.append("Anomalies, Values\n");
        for(int i=0;i < array.length; i++) {

            sb.append(labels[i]);
            sb.append(",");

            sb.append(array[i]);
            sb.append('\n');
            //System.out.print(sb.toString()); to print values
            //sb =new StringBuilder();
        }
        br.write(sb.toString());
        br.close();
        //pw.close();

//        for (int element : array) {
//            sb.append("" + element);
//            sb.append(",");
//        }
//        for (int element : labels) {
//            ta.append("" + element);
//            ta.append(",");
//        }
//
//
//        br.write(sb.toString());
//        br.close();

        for (int i = 0; i < array.length; i++) {
            if (i % 100 == 0) {
                System.out.println();
            }
            if (array[i] == 1) {
                //array[i] = 0;
                System.out.print(array[i] + " ");
            } else {
                //array[i] = 1;
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();
        for (int i = 0; i < labels.length; i++) {
            if (i % 100 == 0) {
                System.out.println();
            }
            if (array[i] == 1) {
                //array[i] = 0;
                System.out.print(labels[i] + " ");
            } else {
                //array[i] = 1;
                System.out.print(labels[i] + " ");
            }
        }


    }

}



