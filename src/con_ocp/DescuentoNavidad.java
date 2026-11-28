package con_ocp;

public class DescuentoNavidad implements Descuento {

    @Override
    public double aplicar(double precioBase) {
        // 20% de descuento en temporada navideña
        return precioBase * 0.80;
    }

    @Override
    public String getDescripcion() {
        return "Promoción de Navidad (20%)";
    }
}
