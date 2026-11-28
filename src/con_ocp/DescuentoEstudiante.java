package con_ocp;

public class DescuentoEstudiante implements Descuento {

    @Override
    public double aplicar(double precioBase) {
        // 10% de descuento para estudiantes
        return precioBase * 0.90;
    }

    @Override
    public String getDescripcion() {
        return "Descuento Estudiante Universitario (10%)";
    }
}
