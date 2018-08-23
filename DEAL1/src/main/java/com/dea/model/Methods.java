package com.dea.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

public class Methods {
	
	public Methods() {
		
	}
	
	public void mergeSortBigInteger(BigInteger arr[], int l, int r) {
        if (l < r) {
            int m = (l+r)/2;
            mergeSortBigInteger(arr, l, m);
            mergeSortBigInteger(arr , m+1, r);
            mergeBigInteger(arr, l, m, r);
        }
    }
	
	public void mergeBigInteger(BigInteger arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        BigInteger L[] = new BigInteger[n1];
        BigInteger R[] = new BigInteger[n2];

        for (int i=0; i<n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j=0; j<n2; ++j) {
            R[j] = arr[m + 1+ j];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
        if (L[i].doubleValue() <= R[j].doubleValue()) {
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
	
	public void mergeSortBigIntegerInversely(BigInteger arr[], int l, int r) {
        if (l < r) {
            int m = (l+r)/2;
            mergeSortBigInteger(arr, l, m);
            mergeSortBigInteger(arr , m+1, r);
            mergeBigInteger(arr, l, m, r);
        }
    }
	
	public void mergeBigIntegerInversely(BigInteger arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        BigInteger L[] = new BigInteger[n1];
        BigInteger R[] = new BigInteger[n2];

        for (int i=0; i<n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j=0; j<n2; ++j) {
            R[j] = arr[m + 1+ j];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
        if (L[i].doubleValue() >= R[j].doubleValue()) {
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
	
	public void radixSortBigInteger(BigInteger[] numbers) {
		double max    = 1;
        int nbytes = 4;
        int nColas = (int) Math.pow(2,nbytes) ;
        Queue<BigInteger>[] cola = new LinkedList[nColas];
        for(int i=0; i<nColas; i++) cola[i]=new LinkedList<BigInteger>();
        int     div     = 0;
        for(int i=0; i<max; i++) {
            for(BigInteger numero: numbers) {
                if(i==0) if(numero.doubleValue()>max) max=numero.doubleValue();
                int numCola = ((numero.intValue()>>div) & 0xf);
                cola[numCola].add(numero);
            }
            div = div+nbytes;
            int j=0;
            for(Queue<BigInteger> c: cola) {
                while(!c.isEmpty()) numbers[j++]=c.remove();
            }
            if(i==0) { max = (int) (Math.log(max)/Math.log(nColas)) + 1; }
        }
	}
	
	public void heapSortBigInteger(BigInteger[] numbers) {
		final int N = numbers.length;
        for(int nodo = N/2; nodo>=0; nodo--) {
        	heapsortBigInteger(numbers, nodo, N-1);
        }
        for(int nodo = N-1; nodo>=0; nodo--) {
            BigInteger tmp = numbers[0];
            numbers[0]    = numbers[nodo];
            numbers[nodo] = tmp;
            heapsortBigInteger(numbers, 0, nodo-1);
        }
	}
	
	public void heapsortBigInteger(BigInteger[] numbers, int nodo, int fin) {
		int izq = 2*nodo+1;
        int der = izq+1;
        int may;
        if(izq>fin) return;
        if(der>fin) may=izq;
        else may= numbers[izq].doubleValue()>numbers[der].doubleValue()?izq:der;
        if(numbers[nodo].doubleValue() < numbers[may].doubleValue()) {
            BigInteger tmp = numbers[nodo];
            numbers[nodo] = numbers[may];
            numbers[may] = tmp;
            heapsortBigInteger(numbers, may, fin);
        }
	}
	
	public void mergeSortBigDecimal(BigDecimal arr[], int l, int r) {
        if (l < r) {
            int m = (l+r)/2;
            mergeSortBigDecimal(arr, l, m);
            mergeSortBigDecimal(arr , m+1, r);
            mergeBigDecimal(arr, l, m, r);
        }
    }
	
	public void mergeBigDecimal(BigDecimal arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        BigDecimal L[] = new BigDecimal[n1];
        BigDecimal R[] = new BigDecimal[n2];

        for (int i=0; i<n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j=0; j<n2; ++j) {
            R[j] = arr[m + 1+ j];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
        if (L[i].doubleValue() <= R[j].doubleValue()) {
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
	
	public void mergeSortBigDecimalInversely(BigDecimal arr[], int l, int r) {
        if (l < r) {
            int m = (l+r)/2;
            mergeSortBigDecimal(arr, l, m);
            mergeSortBigDecimal(arr , m+1, r);
            mergeBigDecimal(arr, l, m, r);
        }
    }
	
	public void mergeBigDecimalInversely(BigDecimal arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        BigDecimal L[] = new BigDecimal[n1];
        BigDecimal R[] = new BigDecimal[n2];

        for (int i=0; i<n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j=0; j<n2; ++j) {
            R[j] = arr[m + 1+ j];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
        if (L[i].doubleValue() >= R[j].doubleValue()) {
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
	
	public void radixSortBigDecimal(BigDecimal[] numbers) {
		double max    = 1;
        int nbytes = 4;
        int nColas = (int) Math.pow(2,nbytes) ;
        Queue<BigDecimal>[] cola = new LinkedList[nColas];
        for(int i=0; i<nColas; i++) cola[i]=new LinkedList<BigDecimal>();
        int     div     = 0;
        for(int i=0; i<max; i++) {
            for(BigDecimal numero: numbers) {
                if(i==0) if(numero.doubleValue()>max) max=numero.doubleValue();
                int numCola = ((numero.intValue()>>div) & 0xf);
                cola[numCola].add(numero);
            }
            div = div+nbytes;
            int j=0;
            for(Queue<BigDecimal> c: cola) {
                while(!c.isEmpty()) numbers[j++]=c.remove();
            }
            if(i==0) { max = (int) (Math.log(max)/Math.log(nColas)) + 1; }
        }
	}
	
	public void heapSortBigDecimal(BigDecimal[] numbers) {
		final int N = numbers.length;
        for(int nodo = N/2; nodo>=0; nodo--) {
        	heapsortBigDecimal(numbers, nodo, N-1);
        }
        for(int nodo = N-1; nodo>=0; nodo--) {
            BigDecimal tmp = numbers[0];
            numbers[0]    = numbers[nodo];
            numbers[nodo] = tmp;
            heapsortBigDecimal(numbers, 0, nodo-1);
        }
	}
	
	public void heapsortBigDecimal(BigDecimal[] numbers, int nodo, int fin) {
		int izq = 2*nodo+1;
        int der = izq+1;
        int may;
        if(izq>fin) return;
        if(der>fin) may=izq;
        else may= numbers[izq].doubleValue()>numbers[der].doubleValue()?izq:der;
        if(numbers[nodo].doubleValue() < numbers[may].doubleValue()) {
            BigDecimal tmp = numbers[nodo];
            numbers[nodo] = numbers[may];
            numbers[may] = tmp;
            heapsortBigDecimal(numbers, may, fin);
        }
	}
	
}