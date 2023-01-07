package listaenlazadasimple; //Llamanos el paquete

public class ListaEnlazada {

    Nodo cabeza;//Se declara el atributo de la clase, cabeza primer nodo de la lista.

    public ListaEnlazada() {
        this.cabeza = null;//Inicialmente la lista está vacía, la cabeza apunta a nulo 
    }

    //Implementación del método para obtener el primer nodo de la lista (nodo cabeza).
    public Nodo getCabeza() {
        return cabeza;
    }

    //Implementación del método que asigna el primer nodo de la lista (nodo cabeza).
    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    //Método que recorre la lista y devuelve el último nodo de la lista. 
    public Nodo ultimo() {
        Nodo temp = cabeza;
        while (temp != null) {
            //Si temp apunta a nulo el nodo temporal (temp) es el último de la lista
            if (temp.getSiguiente() == null) {
                break;//Se rompe el ciclo.
            } else {//De lo contrario se pasa al siguiente nodo de la lista.
                temp = temp.getSiguiente();
            }
        }
        return temp;
    }

    //Método que recorre la lista para contar cuantos nodos hay almacenados.
    public int contarNodos() {
        int contador = 0;
        Nodo temp = cabeza;
        while (temp != null) {
            contador++; //contador para el total de nodos
            temp = temp.getSiguiente();
        }
        return contador;
    }

    //Método para agregar un nuevo nodo en la lista, por el final.
    public void agregarNodo(Nodo nuevo) {
        if (cabeza == null) {//La lista está vacía, no hay nodos. 
            this.setCabeza(nuevo); //Se asigna el primer nodo de la lista.
        } else {
            ultimo().setSiguiente(nuevo); //Se asigna el primer nodo de la lista.
        }
    }

    //Implementación del método que busca un nodo dentro de la lista, pasando como parámetro de
    //búsqueda el código del estudiante.
    public Nodo buscar(int codigo) {
        Nodo temp = cabeza;
        while (temp != null) {
            if (temp.getCodigo() == codigo) { //Si el codigo existe muestramelo
                break;
            } else {
                temp = temp.getSiguiente();
            }
        }
        return temp;
    }

    //Implementación del método que elimina el nodo de la lista pasado como parámetro (nd) el nodo
    //que se quiere eliminar.
    public void eliminar(Nodo nd) {
        Nodo anterior;
        if (nd == cabeza) {//Si el nodo a eliminar en la lista es el primero entonces. 
            cabeza = cabeza.getSiguiente();
        } else {//De lo contrario, se busca el nodo anterior al que se quiere eliminar (nd). 
            anterior = cabeza;
            while (anterior.getSiguiente() != nd) {
                anterior = anterior.getSiguiente();
            }
            //De lo contrario, se busca el nodo anterior al que se quiere eliminar (nd). 
            anterior.setSiguiente(nd.getSiguiente());
        }
        nd.setSiguiente(null);
    }

    //Implementación del método que devuelve la nota definitiva más alta de las almacenadas.
    public float maxDefinitiva() {
        float def, max = 0;
        Nodo temp = cabeza; //Nodo
        while (temp != null) {
            def = temp.definitiva(); //notas divididas entre 3
            if (def > max) { // si la nota definitiva es mayor a 0
                max = def; //Asigname la nota definitiva maxima
            }
            temp = temp.getSiguiente();
        }
        return max; //Retorname la nota maxima
    }

    //Implementación del método para el promedio General
    public float promedioGeneral() {
        float promedio_general = 0, pcontador = 0, promedio = 0; //Variables
        Nodo general = cabeza;
        while (general != null) {
            pcontador++; //Contador de nodos para dividir entre el total de notas
            promedio_general += general.definitiva(); //Sumame el valor anterior con el nuevo valor
            general = general.getSiguiente();
            promedio = promedio_general / pcontador; //Guardame el promedio general suma de todas las notas dividadas sentre el total de nodos
        }
        return promedio; //Retorname el promedio general
    }

    //Implementación del método para agregar entre nodos
    public void agregarEntreNodos(Nodo nd, Nodo nuevo) {
        nuevo.setSiguiente(nd.getSiguiente()); //Agregame entre nodos
        nd.setSiguiente(nuevo); //Agregame el nuevo nuevo 
    }

    //Implementación del método para agregar nodos por la cabeza
    void agregarAcabeza(Nodo nuevo) {
        nuevo.setSiguiente(cabeza);
        setCabeza(nuevo); //Agregame desde la cabeza
    }

    //Implementación del método para limpiar y/o eliminar toda la lista
    public void limpiar() {
        while (cabeza != null) {
            eliminar(cabeza); //Eliminame la cabeza empezando desde el primero
        }
    }
}
