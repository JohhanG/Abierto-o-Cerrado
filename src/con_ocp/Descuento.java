package con_ocp;

/**
 * CONTRATO ABSTRACTO ESTABLE (INTERFAZ)
 * 
 * Cumple con OCP: Define una abstracción invariable que encapsula
 * la variación del cálculo del descuento.
 */
public interface Descuento {

    /**
     * Aplica la regla de descuento sobre el precio base.
     * @param precioBase monto original del producto
     * @return monto final con el descuento aplicado
     */
    double aplicar(double precioBase);

    /**
     * Descripción textual de la promoción.
     */
    String getDescripcion();
}
