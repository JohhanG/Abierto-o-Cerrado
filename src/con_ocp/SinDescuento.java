package con_ocp;

public class SinDescuento implements Descuento {

    @Override
    public double aplicar(double precioBase) {
        return precioBase;
    }

    @Override
    public String getDescripcion() {
        return "Sin Descuento (Tarifa Plena 0%)";
    }
}
