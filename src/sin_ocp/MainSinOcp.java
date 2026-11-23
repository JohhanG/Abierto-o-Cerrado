package sin_ocp;

public class MainSinOcp {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" DEMOSTRACIÓN: SISTEMA SIN APLICAR OCP (MAL DISEÑO)");
        System.out.println("==================================================");

        CalculadoraDescuentos calculadora = new CalculadoraDescuentos();
        double precioBase = 100000.0; // $100.000 COP

        System.out.printf("Precio Base: $%,.2f\n\n", precioBase);

        double precioEstudiante = calculadora.calcularPrecioFinal(precioBase, "ESTUDIANTE");
        System.out.printf("• Descuento Estudiante (10%%):     $%,.2f\n", precioEstudiante);

        double precioBlackFriday = calculadora.calcularPrecioFinal(precioBase, "BLACK_FRIDAY");
        System.out.printf("• Descuento Black Friday (30%%):   $%,.2f\n", precioBlackFriday);

        double precioNavidad = calculadora.calcularPrecioFinal(precioBase, "NAVIDAD");
        System.out.printf("• Descuento Navidad (20%%):        $%,.2f\n", precioNavidad);

        System.out.println("\n⚠️ PROBLEMA:");
        System.out.println("Para agregar un nuevo descuento (ej. 'CYBER_MONDAY'),");
        System.out.println("tuvimos que ABRIR y MODIFICAR la clase CalculadoraDescuentos.");
        System.out.println("¡Esto viola el Principio Abierto/Cerrado!");
        System.out.println("==================================================");
    }
}
