package listaenlazadasimple;

import javax.swing.JOptionPane;

public class ListaEnlazadaSimple {

    //Se declaran los siguientes métodos, que serán llamados dentro del método static void main:
    //Método para asignar los valores a los atributos de la clase Nodo, aquí se crea una instancia por
    //parámetro de la clase Nodo llamada nod.
    public static void llenar(Nodo nod) {
        int cod = Integer.parseInt(JOptionPane.showInputDialog("Ingrese código: "));
        nod.setCodigo(cod);
        String nombre = JOptionPane.showInputDialog("Ingrese nombre: ");
        nod.setNombre(nombre);
        float nota1 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese nota 1: "));
        nod.setNota1(nota1);
        float nota2 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese nota 2: "));
        nod.setNota2(nota2);
        float nota3 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese nota 3: "));
        nod.setNota3(nota3);
    }

    //Método para obtener y mostrar los valores asignados a los atributos de la clase Nodo.
    public static void mostrar(Nodo nod) {
        String datosNodo = "";
        datosNodo = datosNodo + String.valueOf("" + "Código: " + nod.getCodigo() + "\n"
                + "Nombre: " + nod.getNombre() + "\n" + "Nota 1: " + nod.getNota1() + "\n"
                + "Nota 2: " + nod.getNota2() + "\n" + "Nota 3: " + nod.getNota3() + "\n"
                + "Nota Definitiva: " + nod.definitiva() + "\n" + "\n");
        JOptionPane.showMessageDialog(null, "----------- Información de los nodos de la Lista Enlazada Simple --------" + "\n"
                + datosNodo);
    }

    //Método para listar cada uno de los nodos de la lista y visualizarlos en pantalla.
    public static void listarNodos(Nodo nod) {
        Nodo temp = nod;
        while (temp != null) {
            mostrar(temp); //lISTAR 
            temp = temp.getSiguiente();
        }
    }

    //Método para visualizar el menú de opciones y asignar la opción seleccionada. 
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();//Se crea el objeto lista de la clase ListaEnlazada.
        int opcion = 0; //opción
        int cod = 0;
        Nodo aux; //Nodo auxiliar

        //Mientras la opción elegida sea 0, preguntamos al usuario 
        //Si la opcion en 11 finaliza el ciclo
        while (opcion != 11) {
            //Try catch para evitar que el programa termine si hay un error
            try {
                //Menu de opciones 
                opcion = Integer.parseInt(JOptionPane.showInputDialog("---------- MENÚ DE OPCIONES DE LA LISTA ---------" + "\n"
                        + "1. Agregar nodo a la lista" + "\n"
                        + "2. Agregar entre nodos" + "\n"
                        + "3. Agregar nodo desde la cabeza" + "\n"
                        + "4. Mostrar nodos de la lista" + "\n"
                        + "5. Cantidad de nodos de la lista" + "\n"
                        + "6. Buscar la información de un estudiante" + "\n"
                        + "7. Eliminar Nodo de la Lista" + "\n"
                        + "8. Promedio General\n"
                        + "9. Informe: Promedio General y nota Máxima" + "\n"
                        + "10. Borrar toda la lista" + "\n"
                        + "11. Salir"));

                //Menu de opciones
                switch (opcion) {
                    case 1: //Opicion 1
                        aux = new Nodo();//Cuando se agrega un nodo se crea un nuevo objeto de la clase nodo. 
                        llenar(aux); //Llena la lista
                        lista.agregarNodo(aux); //Agrega el nodo
                        break; //No sigas despues de aqui
                    case 2: //Opicion 2 para agregar un nodo y/o estudiante entre nodos
                        cod = Integer.parseInt(JOptionPane.showInputDialog("Código del estudiante después del que Quiere Agregar el Nuevo Nodo: "));
                        Nodo nd = lista.buscar(cod);
                        if (nd != null) { //Si es distinto de null agregame a la lista
                            aux = new Nodo();
                            llenar(aux);
                            lista.agregarEntreNodos(nd, aux); //Agregame un nodo entre nodos
                        } else {
                            JOptionPane.showMessageDialog(null, "Código no encontrado...."); //Codigo no encontrado en la lista
                        }
                        break; //No sigas despues de aqui
                     case 3:
                        aux = new Nodo();
                        llenar(aux);
                        lista.agregarAcabeza(aux);
                        break;    
                    case 4: //Opicion 3 para mostrar los notos empezando desde la cabeza
                        if (lista.getCabeza() != null) {
                            listarNodos(lista.getCabeza());
                        } else {
                            JOptionPane.showMessageDialog(null, "Lista Vacía.....");
                        }
                        break; //No sigas despues de aqui
                    case 5: //Opicion 4 total de nodos registrados y/o estudiantes
                        JOptionPane.showMessageDialog(null, "------- Cantidad de Nodos de la Lista ------\n" + lista.contarNodos() + " Nodos");
                        break;
                    case 6: //Opicion 5 para buscar por codigo a un estudiante
                        cod = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código a buscar en lista: "));
                        aux = lista.buscar(cod);
                        if (aux != null) {
                            mostrar(aux);
                        } else { //Codigo del estudiante no encontrado
                            JOptionPane.showMessageDialog(null, "Código no encontrado....");
                        }
                        break; //No sigas despues de aqui
                    case 7: //Opicion 6 para buscar un estudiante de la lista a eliminar
                        cod = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del estudiante a eliminar: "));
                        aux = lista.buscar(cod);
                        if (aux != null) {
                            lista.eliminar(aux); //Eliminame el nodo y/o estudiante encontrado en la lista
                            JOptionPane.showMessageDialog(null, "Nodo elimidado con éxito...");
                        } else {
                            JOptionPane.showMessageDialog(null, "Código no encontrado....");
                        }
                        break; //No sigas despues de aqui
                    case 8: //Opicion 7 para mostrar el promedio general
                        JOptionPane.showMessageDialog(null, "-------- Informe Promedio General-------\n"
                                + "Promedio General : " + lista.promedioGeneral());
                        break;
                    case 9: //Opicion 8 // para mostrar un informe general del promedio general y nota maxima
                        JOptionPane.showMessageDialog(null, "-------- Informe Promedio General y Nota Máxima -------\n"
                                + "Promedio General : " + lista.promedioGeneral() + "\n" + "Nota máxima del curso: " + lista.maxDefinitiva());
                        break; //No sigas despues de aqui
                    case 10: //Opicion 9 para limpar toda la lista
                        lista.limpiar();
                        JOptionPane.showMessageDialog(null, "Lista Vacía....");
                        break; //No sigas despues de aqui                
                    case 11: //Opicion 10 para finalizar el programa
                        JOptionPane.showMessageDialog(null, "Muchas gracias");
                        break; //No sigas despues de aqui
                    default: //Si precionas un numero diferente a los del menu devuelve opcion invalida
                        JOptionPane.showMessageDialog(null, "opcion invalida");
                        break; //No sigas despues de aqui
                }
            } catch (Exception e) { //Si el programa falla 
                JOptionPane.showMessageDialog(null, "Uoop! Error!");
            }
        }

    }

}
