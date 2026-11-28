package con_ocp;

import java.util.Objects;

/**
 * CLASE CERRADA A MODIFICACIÓN / ABIERTA A EXTENSIÓN
 * 
 * ¿Por qué cumple OCP?
 * 1. Esta clase SOLO depende del contrato abstracto {@link Descuento}.
 * 2. Utiliza POLIMORFISMO: llama al método aplicar() sin importarle la implementación concreta.
 * 3. Si en el futuro se crean 50 descuentos nuevos, esta clase JAMÁS se volverá a modificar.
 * 4. Respeta el Principio de Responsabilidad Única (SRP): su única responsabilidad es coordinar
 *    el cálculo delegando la fórmula al descuento correspondiente.
 */
public class CalculadoraDescuentos {

    /**
     * Calcula el precio final aplicando la estrategia de descuento inyectada.
     * 
     * @param precioBase monto original
     * @param estrategiaDescuento cualquier objeto que implemente la interfaz Descuento
     * @return monto final
     */
    public double calcularPrecioFinal(double precioBase, Descuento estrategiaDescuento) {
        Objects.requireNonNull(estrategiaDescuento, "La estrategia de descuento no puede ser nula");

        if (precioBase < 0) {
            throw new IllegalArgumentException("El precio base no puede ser negativo");
        }

        // Delegación polimórfica pura (Patrón Strategy + OCP)
        return estrategiaDescuento.aplicar(precioBase);
    }
}
