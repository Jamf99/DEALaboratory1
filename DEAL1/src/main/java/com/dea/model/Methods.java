package com.dea.model;

import java.util.LinkedList;
import java.util.Queue;

public class Methods {
	
	public Methods() {
		
	}
	
	public void mergeSort(double arr[], int l, int r) {
        if (l < r) {
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr , m+1, r);
            merge(arr, l, m, r);
        }
    }
	
	public void merge(double arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        double L[] = new double [n1];
        double R[] = new double [n2];

        for (int i=0; i<n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j=0; j<n2; ++j) {
            R[j] = arr[m + 1+ j];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }	
	public void radixSort(double[] numbers) {
		int max    = 1;
        int nbytes = 4;
        int nColas = (int) Math.pow(2,nbytes) ;
        Queue<Integer>[] cola = new LinkedList[nColas];
        for(int i=0; i<nColas; i++) cola[i]=new LinkedList<Integer>();
        int     div     = 0;
        for(int i=0; i<max; i++) {
            for(double numero: numbers) {
                if(i==0) if(numero>max) max=(int)numero;
                int numCola = ((int)numero>>div) & 0xf;
                cola[numCola].add((int)numero);
            }
            div = div+nbytes;
            int j=0;
            for(Queue<Integer> c: cola) {
                while(!c.isEmpty()) numbers[j++]=c.remove();
            }
            if(i==0) { max = (int) (Math.log(max)/Math.log(nColas)) + 1; }
        }
	}
	
	public void heapSort(double[] numbers) {
		final int N = numbers.length;
        for(int nodo = N/2; nodo>=0; nodo--) {
        	heapsort(numbers, nodo, N-1);
        }
        for(int nodo = N-1; nodo>=0; nodo--) {
            double tmp = numbers[0];
            numbers[0]    = numbers[nodo];
            numbers[nodo] = tmp;
            heapsort(numbers, 0, nodo-1);
        }
	}
	
	public void heapsort(double[] numbers, int nodo, int fin) {
		int izq = 2*nodo+1;
        int der = izq+1;
        int may;
        if(izq>fin) return;
        if(der>fin) may=izq;
        else may= numbers[izq]>numbers[der]?izq:der;
        if(numbers[nodo] < numbers[may]) {
            double tmp = numbers[nodo];
            numbers[nodo] = numbers[may];
            numbers[may]  = tmp;
            heapsort(numbers, may, fin);
        }
	}
	
}