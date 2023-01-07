
package listaenlazadasimple;
//Setter y Getter
public class Nodo {
    int codigo;
    String nombre;
    float nota1;
    float nota2; 
    float nota3;
    Nodo siguiente;

    public Nodo() {
        this.codigo =0;
        this.nombre = null;
        this.nota1 = 0;
        this.nota2 = 0;
        this.nota3 = 0;
        this.siguiente = null; 
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    public float getNota3() {
        return nota3;
    }

    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    public float definitiva(){
        return (this.getNota1()+this.getNota2()+this.getNota3())/3; //nota definitiva del estudiante
    }
    
}
