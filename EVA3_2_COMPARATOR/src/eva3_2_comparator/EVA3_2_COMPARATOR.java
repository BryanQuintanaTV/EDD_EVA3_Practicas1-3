/*
 * " Comparator --> Establece un criterio de ordenamiento para collections
 * "                Se usa para el método sort();
    Ordenar sirve básicamente para una cosa: buscar
    Busqueda Binaria --> Recursiva
    Busquede Secuencial
 */
package eva3_2_comparator;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Quintana Juarez Bryan Alexis
 */
public class EVA3_2_COMPARATOR {

    public static void main(String[] args) {
        //Lista
        LinkedList<Integer> miLista = new <Integer>LinkedList();
        miLista.add((int) (Math.random() * 100));
        miLista.add((int) (Math.random() * 100));
        miLista.add((int) (Math.random() * 100));
        miLista.add((int) (Math.random() * 100));
        miLista.add((int) (Math.random() * 100));
        miLista.add((int) (Math.random() * 100));
        miLista.add((int) (Math.random() * 100));
        System.out.println(miLista);
        //Ordenar --> Comparator
        //Comparator es una interfaz
        Comparator ordenar = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer val1 = (Integer) o1;
                Integer val2 = (Integer) o2;

                return val2 - val1;
            }
        };
        miLista.sort(ordenar);
        System.out.println(miLista);

        //
        LinkedList<Persona> listaPersonas = new <Persona>LinkedList();
        listaPersonas.add(new Persona("Juan","Perez","Jpolote",50,100.0));
        listaPersonas.add(new Persona("Pedro", "Chavez", "Martinez",30,100.0));
        listaPersonas.add(new Persona("Alberto", "Perez", "Zaira",23,100.0));
        listaPersonas.add(new Persona("Dora", "Dominguez", "Estrada",11,100.0));
        listaPersonas.add(new Persona("Estela", "Sanchez", "Baldomero",34,100.0));
        listaPersonas.add(new Persona("Monica", "Molina", "Rodriguez",26,100.0));
        listaPersonas.add(new Persona("Esteba", "Antunez", "Garcia",11,100.0));
        //Comparator: Apellido paterno
        //Comparator: Salario
        
        //Como recorrer collections
        //Iterator
       
        for (Iterator<Persona> iterador = listaPersonas.iterator(); 
                iterador.hasNext();) {
            
        }
    }

    
    class Persona {

        private String nombre;
        private String paterno;
        private String materno;
        private int edad;
        private double salario;

        public Persona(String nombre, String paterno, String materno, int edad, double salario) {
            this.nombre = nombre;
            this.paterno = paterno;
            this.materno = materno;
            this.edad = edad;
            this.salario = salario;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getPaterno() {
            return paterno;
        }

        public void setPaterno(String paterno) {
            this.paterno = paterno;
        }

        public String getMaterno() {
            return materno;
        }

        public void setMaterno(String materno) {
            this.materno = materno;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        public double getSalario() {
            return salario;
        }

        public void setSalario(double salario) {
            this.salario = salario;
        }

    }

}
