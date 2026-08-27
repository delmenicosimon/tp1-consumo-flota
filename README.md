# Trabajo Práctico 1 — Entorno, Git y fundamentos de Java
## Simon Delmenico, Programacion 2

## Lista de programas:
* ### Viajes.java
    Viajes es un programa que se dedica a darte estos datos:
    1. Km recorridos
    2. Consumo de litros de gasoil por kilometro
    3. Kilometros recorridos por litro de gasoil
    4. Costo de el gas para el viaje
    5. Porcentaje de carga realizada para el viaje
    
    ### Para ejecutarlo:
    #### Dependencias:
    [Java](https://www.oracle.com/latam/java/technologies/downloads/)
    Primero se debe clonar el repositorio, despues se compila el codigo:

    ```
    javac Viajes.java
    ```
    Y para ejecutarlo se utiliza:
    ```
    java Viajes
    ```
* ### Flota.java
    Flota es un programa que se dedica a preguntarte datos de 6 camiones, y te devuelve estos datos:
    1. Km recorridos
    2. Litros de gasolina consumidos
    3. Promedio de kilometros por camion
    4. Patente del camion con mas recorrido
    5. Patente del camion con menos recorrido
    6. Consumo de gasolina cada 100 kilometros por flota
    7. Consumo de toda la flota dividido en EFICIENTE,NORMAL,EXCESIVO
    8. Camiones por categoria de consumo
  ### Para ejecutarlo:
  #### Dependencias:
  [Java](https://www.oracle.com/latam/java/technologies/downloads/)
  
  Si ya clonaste el repositorio, para ejecutarlo se usa:
  ```
  javac Flota.java
  java Flota
  ```
  
## Preguntas:
1. En la parte C calculaste un promedio dividiendo un total por una cantidad. Explicá por qué ese cálculo puede dar un resultado equivocado en Java aunque el programa compile y no dé ningún error, y cómo lo resolviste.

* Respuesta: El calculo puede dar un resultado equivocado, debido a que hay numeros que en formato decimal no pueden ser representados con precision en binario, que es como se guardan dentro de la memoria. Para solucionarlo utilice una clase llamada BigDecimal que viene con el paquete java.math, lo provee son metodos para calcular con precision los numeros decimales.

2. Explicá para qué te sirvió haber trabajado la parte C en una rama aparte en vez de escribirla directamente
sobre la rama principal. No repitas la definición de rama: contá qué te habilitó a hacer en este trabajo concreto.

* Respuesta: Gracias a la todo poderosa rama c, si hubiese cometido un error y comitteado algo erroneo, no arriesgo nada de la anterioridad del proyecto (ej viajes, el gitignore,etc) y es como si fuera un espacio seguro en el que trabajas tranquilo y cuando ya supe que estaba bien, lo mergee con main, en este caso tuve 1 commit en la parte c, por lo que no ayudo mucho, pero eso es porque apure mucho el tema, si hubiese tardado varios dias, lo mas probable es que hubiese tenido mas commits.

3. Mirá el historial de tu repositorio con git log. Elegí uno de tus mensajes de commit que hoy escribirías
distinto, transcribilo, y escribí la versión mejorada explicando qué le faltaba al original.

* Respuesta: El Commit 38a5e29 : "Terminado v1 funcionando", rompio las reglas de nombrado de commits en mi repositorio, generando una grieta que rompe mi corazon, sin poder cambiar el historial debido a que no lo vi, lo renombraria "C: Terminado viajes.java".
