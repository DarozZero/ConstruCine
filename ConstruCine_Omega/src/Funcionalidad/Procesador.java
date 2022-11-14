
package Funcionalidad;
/**
 *
 * @author daroz
 */
public abstract class Procesador {
    private Lector archivo;
    
   public abstract void procesar();
   public abstract void imprimir();

    public void setArchivo(String direccion) {
        this.archivo = new Lector(direccion) ;
    }

    public Lector getArchivo() {
        return archivo;
    }
    
    
    
}
