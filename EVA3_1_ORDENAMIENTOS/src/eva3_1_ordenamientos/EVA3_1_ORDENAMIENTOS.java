/*
 * "
 * "
 */
package eva3_1_ordenamientos;

/**
 *
 * @author Quintana Juarez Bryan Alexis
 */
public class EVA3_1_ORDENAMIENTOS {

    public static void main(String[] args) {
        int[] arregloDatos = new int[15];
        int[] arregloSel = new int[arregloDatos.length];
        int[] arregloIns = new int[arregloDatos.length];
        int[] arregloQ = new int[arregloDatos.length];
        int[] arregloB = new int[arregloDatos.length];

        System.out.println("Arreglo Original");
        llenar(arregloDatos);
        imprimir(arregloDatos);
        System.out.println("Selection sort");
        copiar(arregloDatos, arregloSel);
        imprimir(arregloSel);
        double ini = System.nanoTime();
        selectionSort(arregloSel);
        double fin = System.nanoTime();
        imprimir(arregloSel);
        System.out.println("Slection sort = " + (fin - ini));

        System.out.println("Insertion sort");
        copiar(arregloDatos, arregloIns);
        imprimir(arregloIns);
        ini = System.nanoTime();
        insertionSort(arregloIns);
        fin = System.nanoTime();
        imprimir(arregloIns);
        System.out.println("Insertion sort = " + (fin - ini));

        System.out.println("Quick sort");
        copiar(arregloDatos, arregloQ);
        imprimir(arregloQ);
        ini = System.nanoTime();
        quickSort(arregloQ);
        fin = System.nanoTime();
        imprimir(arregloQ);
        System.out.println("Quick sort = " + (fin - ini));

    }

    public static void llenar(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int) (Math.random() * 100);
        }
    }

    public static void imprimir(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] < 10) {
                System.out.print("[ " + arreglo[i] + "]");
            } else {
                System.out.print("[" + arreglo[i] + "]");
            }
        }
        System.out.println("");
    }
    //Copiar arreglo.

    public static void copiar(int[] arreglo, int[] copia) {
        for (int i = 0; i < arreglo.length; i++) {
            copia[i] = arreglo[i];

        }
    }

    //Selection Sort O(n²).
    //Comparaciones.
    //Intercambios.
    public static void selectionSort(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            int min = i;
            //Busco el elemento (Posición) más pequeño.
            for (int j = i + 1; j < arreglo.length; j++) {
                //Buscar el más pequeño.
                if (arreglo[min] > arreglo[j]) {
                    min = j;
                }
            }
            //Swap intercambiar.
            if (min != i) {
                int temp = arreglo[i];
                arreglo[i] = arreglo[min];
                arreglo[min] = temp;
            }
        }
    }

    public static void insertionSort(int[] arreglo) {
        for (int i = 1; i < arreglo.length; i++) {
            int temp = arreglo[i];  //Es lo que vamos a ordenar.
            int insP = i;
            //Buscamos en que punto debe quedar temp
            //Esa posición queda almacenada en insP
            for (int prev = (i - 1); prev >= 0; prev--) { //Comparamos
                if (arreglo[prev] > temp) {
                    //Swap (Intercambio parcial)
                    arreglo[insP] = arreglo[prev];
                    insP--;
                } else {
                    break;
                }
            }
            arreglo[insP] = temp;
        }
    }

    //Bubble sort no lo vamos a programar
    //Quicksort PÚBLICO
    public static void quickSort(int[] arreglo) {
        quickSortRec(arreglo, 0, arreglo.length - 1); //Se llama al método "quickSortRec"
    }

    private static void quickSortRec(int[] arreglo, int ini, int fin) {
        //Pivote --> Posicion
        //Dos índices:
        //Ind_gran --> Busca los mayores al pivote
        //Ind_peq --> Busca los menores al pivote
        //Si se encuentran valores, se intercambian
        //Si se crizan, se intercambia pivote con Ind_peq
        //Quicksort a cada lado del pivote

        int pivote, big, small, temp;
        pivote = ini;
        big = ini;
        small = fin;
        if (ini < fin) {
            while (big < small) {  //Los índices se cruzaron
                //Buscar los elementos más grandes que el pivote
                while ((arreglo[big] <= arreglo[pivote]) && (big < small)) {
                    big++;
                }
                //Buscar los elementos más pequeños que el pivote
                while (arreglo[small] > arreglo[pivote]) {
                    small--;
                }

                //Verificamos que no hayan cruzado los índices
                if (big < small) {
                    temp = arreglo[big];
                    arreglo[big] = arreglo[small];
                    arreglo[small] = temp;
                }
            }
            //Swap pivote con small
            temp = arreglo[pivote];
            arreglo[pivote] = arreglo[small];
            arreglo[small] = temp;
            pivote = small;

            quickSortRec(arreglo, ini, pivote - 1);

            quickSortRec(arreglo, pivote + 1, fin);

            //Lllamada recursiva
        }
    }
}
