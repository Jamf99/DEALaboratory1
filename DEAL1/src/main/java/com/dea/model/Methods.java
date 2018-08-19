package com.dea.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Methods {
	
	public Methods() {
		
	}
	
	public void merge(int[] numeros) {
		mergesort(numeros, 0, numeros.length-1);
	}
	
	public static void mergesort(int A[],int izq, int der){
	    if (izq<der){
	            int m=(izq+der)/2;
	            mergesort(A,izq, m);
	            mergesort(A,m+1, der);
	            merge(A,izq, m, der);
	    }
	}
	
	public static void merge(int A[],int izq, int m, int der){
		   int i, j, k;
		   int [] B = new int[A.length]; //array auxiliar
		   for (i=izq; i<=der; i++) //copia ambas mitades en el array auxiliar
		             B[i]=A[i];

		             i=izq; j=m+1; k=izq;
		             while (i<=m && j<=der) //copia el siguiente elemento más grande
		             if (B[i]<=B[j])
		                     A[k++]=B[i++];
		             else
		                     A[k++]=B[j++];
		             while (i<=m) //copia los elementos que quedan de la
		                           A[k++]=B[i++]; //primera mitad (si los hay)
	}
	
	public void radixSort(int[] numbers) {
		int max    = 1;
        int nbytes = 4;
        int nColas = (int) Math.pow(2,nbytes) ;
        Queue<Integer>[] cola = new LinkedList[nColas];
        for(int i=0; i<nColas; i++) cola[i]=new LinkedList<Integer>();
        int     div     = 0;
        for(int i=0; i<max; i++) {
            for(int numero: numbers) {
                if(i==0) if(numero>max) max=numero;
                int numCola = (numero>>div) & 0xf;
                cola[numCola].add(numero);
            }
            div = div+nbytes;
            int j=0;
            for(Queue<Integer> c: cola) {
                while(!c.isEmpty()) numbers[j++]=c.remove();
            }
            if(i==0) { max = (int) (Math.log(max)/Math.log(nColas)) + 1; }
        }
	}
	
	public void heapSort(int[] numbers) {
		final int N = numbers.length;
        for(int nodo = N/2; nodo>=0; nodo--) heapsort(numbers, nodo, N-1);
        for(int nodo = N-1; nodo>=0; nodo--) {
            int tmp = numbers[0];
            numbers[0]    = numbers[nodo];
            numbers[nodo] = tmp;
            heapsort(numbers, 0, nodo-1);
        }
	}
	
	public void heapsort(int[] numbers, int nodo, int fin) {
		int izq = 2*nodo+1;
        int der = izq+1;
        int may;
        if(izq>fin) return;
        if(der>fin) may=izq;
        else may= numbers[izq]>numbers[der]?izq:der;
        if(numbers[nodo] < numbers[may]) {
            int tmp = numbers[nodo];
            numbers[nodo] = numbers[may];
            numbers[may]  = tmp;
            heapsort(numbers, may, fin);
        }
	}
	
}