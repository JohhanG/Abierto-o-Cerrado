package con_ocp;

/**
 * NUEVA EXTENSIÓN DEL SISTEMA
 * 
 * ¡OBSERVA LA MAGIA DE OCP!
 * Para añadir esta nueva campaña de Cyber Monday:
 * 1. Solo creamos esta NUEVA clase.
 * 2. NO tocamos ni una sola línea de CalculadoraDescuentos ni de las demás clases.
 * 3. Cero riesgo de romper el código previo.
 */
public class DescuentoCyberMonday implements Descuento {

    @Override
    public double aplicar(double precioBase) {
        // 25% de descuento en Cyber Monday
        return precioBase * 0.75;
    }

    @Override
    public String getDescripcion() {
        return "Campaña Cyber Monday (25%)";
    }
}
