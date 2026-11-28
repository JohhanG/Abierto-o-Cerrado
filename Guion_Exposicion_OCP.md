# Guion de Exposición: Principio Abierto / Cerrado (OCP) - SOLID
**Grupo 2 | Programación II**
* Integrantes: Heidy Valentina, Santiago Palma, Johan Gonzalez

---

## 🎙️ BLOQUE 1: Heidy Valentina (Diapositivas 1 a 6)
**Enfoque:** Contexto, evolución histórica y definición canónica.

### Diapositiva 1 — Portada
> "Buenas tardes, profesor y compañeros. Hoy nuestro grupo va a exponer el **Principio Abierto / Cerrado** (*Open/Closed Principle*), correspondiente a la letra **'O'** dentro de los principios de diseño orientado a objetos conocidos como **SOLID**."

### Diapositiva 2 — El cambio es inevitable; el riesgo no
> "Todo software en el mundo real cambia continuamente: cambian las reglas de negocio, los clientes piden nuevas opciones o se ajustan tarifas.  
> El problema no es el cambio en sí, sino el **riesgo**: si para agregar una nueva regla abrimos y modificamos clases que ya llevan meses funcionando en producción, corremos el riesgo de introducir 'errores de regresión' y dañar cosas que antes servían. El OCP busca que el software crezca agregando **nuevo código**, sin alterar el código existente."

### Diapositiva 3 — Objetivos de la Presentación
> "Nuestros objetivos son:  
> 1. Comprender la definición formal del principio.  
> 2. Comparar sus dos visiones históricas: Bertrand Meyer (herencia) frente a Robert C. Martin (polimorfismo).  
> 3. Demostrar en código Java la solución mediante interfaces.  
> 4. Reconocer los límites prácticos y no caer en sobreingeniería con el principio YAGNI."

### Diapositiva 4 — Una idea que evoluciona en el tiempo
> "El concepto nació en **1988** con Bertrand Meyer, quien proponía extender el código mediante **herencia clásica**.  
> En **1992**, Jacobson enfatizó el cambio en el ciclo de vida.  
> En **1996**, Robert C. Martin reformuló el principio: demostró que la herencia acopla demasiado el código y propuso usar **interfaces y polimorfismo**.  
> En el año **2000**, lo consolidó como la 'O' de SOLID.  
> Y en **2001**, Craig Larman presentó *Protected Variation* en GRASP, que protege los puntos inestables detrás de una interfaz."

### Diapositiva 5 — Abierto para extensión. Cerrado para modificación
> "La regla de oro de Robert Martin dice: *'Las entidades de software deben estar abiertas para su extensión, pero cerradas para su modificación'*.  
> Parece una paradoja: ¿cómo agregamos funciones sin tocar el código?  
> Está **abierto para extensión** porque podemos dotarlo de nuevos comportamientos.  
> Y está **cerrado para modificación** porque el código fuente previo permanece intacto y blindado. La clave técnica para lograrlo es la **abstracción**."

### Diapositiva 6 — Dos interpretaciones del mismo principio
> "En resumen: la visión de Meyer dependía de herencia estricta de clases concretas, generando fuerte acoplamiento. La visión moderna de Martin cierra un contrato abstracto mediante interfaces y deja abiertas infinitas implementaciones. Ahora mi compañero Santiago explicará esto en código."

---

## 💻 BLOQUE 2: Santiago Palma (Diapositivas 7 a 11)
**Enfoque:** El problema técnico (switch/if-else), la solución con interfaces y casos reales en Java.

### Diapositiva 7 — El problema: cada figura reabre la función
> "En pantalla vemos el anti-patrón típico: una función con un `switch` que evalúa tipos concretos.  
> Si hoy tenemos Círculo y Cuadrado, funciona. Pero si mañana nos piden Triángulo, nos vemos **obligados a abrir y modificar este método**.  
> Viola OCP porque la clase no está cerrada a modificación, concentra conocimiento de todos los tipos y obliga a re-testear todo el módulo cada vez que se agrega una figura."

### Diapositiva 8 — La solución: depender de una abstracción
> "La solución con OCP consiste en invertir la dependencia:  
> 1. Creamos la interfaz `Shape` con el método `draw()`.  
> 2. La clase cliente solo depende de la abstracción y llama a `shape.draw()`.  
> 3. Cada figura concreta implementa su propio método.  
> Para agregar un Triángulo o Pentágono, solo creamos una clase nueva. La clase cliente **jamás se vuelve a modificar**."

### Diapositiva 9 — Tres mecanismos para cerrar un módulo
> "Para cerrar un módulo combinamos tres pilares de POO:  
> 1. **Abstracciones estables:** Interfaces y contratos invariables.  
> 2. **Polimorfismo dinámico:** La máquina virtual despacha la llamada al objeto correspondiente en tiempo de ejecución.  
> 3. **Inyección de dependencias:** Inyectar la implementación en lugar de instanciarla rígidamente con `new`."

### Diapositiva 10 — Caso práctico: Descuentos en Tienda
> "Esto mismo lo implementamos en nuestro repositorio para una tienda:  
> Sin OCP: Teníamos una calculadora llena de `if/else` (`ESTUDIANTE`, `BLACK_FRIDAY`, `NAVIDAD`). Cada campaña exigía alterar la calculadora.  
> Con OCP: Creamos la interfaz `Descuento`. La calculadora solo coordina y delega la ejecución. Para añadir la campaña `CyberMonday`, solo creamos un archivo nuevo sin tocar el código anterior."

### Diapositiva 11 — OCP en el ecosistema Java del mundo real
> "Toda la arquitectura de Java funciona bajo este principio. En **JDBC**, `Connection` y `Statement` son interfaces. Motores como MySQL, Oracle o PostgreSQL crean sus propios drivers `.jar` implementando esas interfaces. La máquina virtual de Java nunca tuvo que modificarse ni recompilarse para soportar nuevos motores de bases de datos. Ahora mi compañero Johan presentará el balance, los patrones y el cierre."

---

## 📊 BLOQUE 3: Johan Gonzalez (Diapositivas 12 a 17)
**Enfoque:** Comparativa, patrones GoF, límites (YAGNI), SOLID y cierre.

### Diapositiva 12 — Comparativa: Antes vs. Después de OCP
> "En esta tabla vemos el balance técnico:  
> Sin OCP, el código parece más rápido de programar al inicio, pero el riesgo de regresiones y el costo de mantenimiento crecen con cada sprint.  
> Con OCP, invertimos un poco más de tiempo al inicio diseñando interfaces, pero obtenemos un sistema escalable donde añadir una función no pone en riesgo las funcionalidades ya existentes."

### Diapositiva 13 — Patrones que materializan OCP
> "Muchos patrones del Gang of Four nacieron para satisfacer OCP:  
> 1. **Strategy:** Permite intercambiar algoritmos de negocio bajo una interfaz común (el que usamos para los descuentos).  
> 2. **Decorator:** Añade comportamiento envolviendo un objeto dinámicamente sin alterar la clase original.  
> 3. **Template Method:** Fija el esqueleto de un proceso y delega los pasos variables a subclases."

### Diapositiva 14 — Cerrar todo es imposible — y contraproducente (YAGNI)
> "¿Debemos aplicar OCP en absolutamente todas las clases del sistema? La respuesta es **NO**.  
> Intentar cerrar todo de antemano es sobreingeniería y viola el principio **YAGNI** (*You Aren't Gonna Need It*).  
> La regla recomendada por Robert Martin es simple: escribe código directo la primera vez. Si el cambio se repite una segunda o tercera vez, entonces identifica el punto de variación y refactoriza aplicando OCP."

### Diapositiva 15 — OCP funciona dentro de SOLID
> "OCP se apoya fuertemente en los otros principios:  
> En la **'D' (Inversión de Dependencias)**, porque para cerrar una clase debemos depender de abstracciones y no de clases concretas.  
> Y en la **'L' (Sustitución de Liskov)**, porque cualquier nueva implementación debe poder reemplazar a la interfaz sin alterar el comportamiento esperado por el cliente."

### Diapositiva 16 y 17 — Conclusiones y Referencias
> "Como conclusión, diseñar bajo el Principio Abierto/Cerrado es encontrar el balance entre proteger lo que ya funciona y permitir que el sistema crezca de forma limpia.  
> En nuestro repositorio de GitHub está disponible el código fuente en Java y las pruebas ejecutables. Muchas gracias por su atención y quedamos atentos a cualquier pregunta."
