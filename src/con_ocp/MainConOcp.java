package con_ocp;

import java.util.List;

public class MainConOcp {
    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println(" DEMOSTRACIÓN: SISTEMA CUMPLIENDO EL PRINCIPIO OCP (SOLID)");
        System.out.println("==========================================================");

        CalculadoraDescuentos calculadora = new CalculadoraDescuentos();
        double precioBase = 100000.0; // $100.000 COP

        System.out.printf("Precio Base del Producto: $%,.2f\n\n", precioBase);

        // Lista polimórfica de descuentos
        List<Descuento> promociones = List.of(
            new SinDescuento(),
            new DescuentoEstudiante(),
            new DescuentoBlackFriday(),
            new DescuentoNavidad(),
            // 🌟 ¡Extensión agregada sin tocar CalculadoraDescuentos!
            new DescuentoCyberMonday()
        );

        for (Descuento descuento : promociones) {
            double precioFinal = calculadora.calcularPrecioFinal(precioBase, descuento);
            double ahorro = precioBase - precioFinal;

            System.out.printf("• %-42s -> Precio Final: $%,10.2f (Ahorro: $%,.2f)\n", 
                descuento.getDescripcion(), 
                precioFinal, 
                ahorro);
        }

        System.out.println("\n✅ CONCLUSIÓN DEL OCP:");
        System.out.println("1. Se agregó la promoción 'DescuentoCyberMonday' creando un NUEVO archivo.");
        System.out.println("2. La clase 'CalculadoraDescuentos' NO sufrió ninguna modificación.");
        System.out.println("3. El código previo se mantuvo 100% inmune a errores de regresión.");
        System.out.println("==========================================================");
    }
}
