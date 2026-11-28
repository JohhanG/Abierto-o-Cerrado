package con_ocp;

public class DescuentoBlackFriday implements Descuento {

    @Override
    public double aplicar(double precioBase) {
        // 30% de descuento en Black Friday
        return precioBase * 0.70;
    }

    @Override
    public String getDescripcion() {
        return "Descuento Especial Black Friday (30%)";
    }
}
