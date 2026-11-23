package sin_ocp;

/**
 * EJEMPLO DE VIOLACIÓN DEL PRINCIPIO ABIERTO/CERRADO (OCP)
 * 
 * Problema: Esta clase NO está cerrada a la modificación.
 * Cada vez que la tienda lanza una nueva campaña comercial (ej: CyberMonday o Descuento Senior),
 * el desarrollador está OBLIGADO a abrir este archivo y añadir otro "else if" al método calcular.
 * 
 * Riesgos:
 * 1. Riesgo de regresión: Al modificar el código existente, se pueden introducir errores que rompan
 *    los descuentos que ya estaban funcionando correctamente en producción.
 * 2. Re-testeo masivo: Obliga a volver a certificar y realizar pruebas unitarias sobre toda la clase.
 * 3. Violación de Responsabilidad Única (SRP): La calculadora conoce todas las fórmulas de todos los descuentos.
 */
public class CalculadoraDescuentos {

    public double calcularPrecioFinal(double precioBase, String tipoDescuento) {
        if (tipoDescuento == null || tipoDescuento.equalsIgnoreCase("NINGUNO")) {
            return precioBase;
        } else if (tipoDescuento.equalsIgnoreCase("ESTUDIANTE")) {
            // 10% de descuento
            return precioBase * 0.90;
        } else if (tipoDescuento.equalsIgnoreCase("BLACK_FRIDAY")) {
            // 30% de descuento
            return precioBase * 0.70;
        } else if (tipoDescuento.equalsIgnoreCase("NAVIDAD")) {
            // 20% de descuento
            return precioBase * 0.80;
        } 
        // ❌ Si el negocio pide hoy "CYBER_MONDAY", tenemos que modificar esta clase:
        // else if (tipoDescuento.equalsIgnoreCase("CYBER_MONDAY")) { ... }
        
        throw new IllegalArgumentException("Tipo de descuento no reconocido: " + tipoDescuento);
    }
}
