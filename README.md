# Trabajo Final: Juego tipo Roguelike - The Journey

## 1. Integrantes del Equipo

* Giovannini Luciano Gabriel
* Gil Luca Agustín
* Flores León Emiliano
* Saucedo Ciro

## 2. Descripción del Juego

Queremos desarrollar un juego estilo Roguelike, cuyo título es: The Journey.

El juego se basa en un Hechicero (Jugador) que entra a una mazmorra en busca de derrotar al jefe final. En el camino se encontrará con diversos obstáculos, enemigos y equipamiento para facilitar su avance.

## 3. Objetivo del Juego - Checklist de Features

### MUNDO

* 3 niveles.
* Habitaciones aleatorias: estas habitaciones serán elegidas aleatoriamente de una lista de habitaciones prediseñadas. Se planean entre 5 y 10 habitaciones.
* Puertas: las puertas permanecerán cerradas si hay enemigos en la habitación.
* 1 jefe, accesible al conseguir las 3 llaves de oro.

### JUGADOR

* Vida.
* Daño.
* Velocidad.
* Firerate.
* Maná.

### ENEMIGOS

**Cangrejo**

* Persigue al jugador.
* Es rápido.
* Tiene 1 HP.
* No puede atravesar obstáculos.

**Murciélago**

* Movimiento simple.
* Al tocar al jugador le causa daño.
* Puede volar sobre todos los obstáculos.

**Cangrejo Kamikaze**

* Persigue al jugador y explota.
* Causa daño de área a todas las entidades cercanas.
* Tiene 1 HP.
* Es de pequeño tamaño.

**Gigante**

* Es lento.
* Tiene mucha vida.
* Causa daño al contacto con el jugador.

**Ojo Cañón**

* Será un ojo anclado al piso.
* Dispara en la dirección del jugador en ese instante.

> Cada enemigo tendrá un 25% de probabilidad de soltar un Item al ser derrotado, a excepción de los enemigos kamikaze. La probabilidad es relativamente alta para que los profesores puedan observar todos los tipos de objetos durante las pruebas.

### ITEMS / DROPS

* Botiquín: recupera 2 corazones.
* +Daño: aumenta el daño de la bala y su tamaño.
* +Velocidad: aumenta la velocidad de movimiento del jugador.
* +Cadencia: aumenta el firerate.
* +Vida máxima: aumenta la salud máxima del jugador.
* Llave de oro: permite abrir la puerta que conduce al jefe final.

### COMBATE

* Proyectiles: Hechizo de Hielo del personaje principal y balas de los enemigos.
* Colisiones: Los proyectiles causan daño al entrar en contacto con los enemigos o se destruyen al colisionar con determinadas hitboxes.

### OBSTÁCULOS

**Pinchos**

* Si el jugador pisa los pinchos, recibe daño.

**Piedras**

* Bloquean el paso.
* Se pueden romper con bombas o mediante la explosión de los cangrejos kamikaze.

**Agua / Hueco en el piso**

* Funcionan como las piedras, con la diferencia de que no se pueden romper.

### SHOP

* Tiene una probabilidad del 35% de aparecer.
* Permite comprar Items.

> Los Items muestran el precio y una breve descripción de lo que hace. El jugador deberá pasar por encima del objeto para realizar dicha mecánica.

> El sistema de tienda se dejará para lo último, porque consideramos que podría atrasar el desarrollo de las funcionalidades principales.

### RECOMPENSAS

* Completar habitación: existe una probabilidad de 1/3 de recibir una recompensa, ya que la habitación puede soltar monedas, una bomba o nada.
* Habitación bonus: es una habitación llena de monedas.

### RANKING

El ranking se basará en:

* Qué tan rápido el jugador complete el juego (speedrun).

## 4. Maquetas

### Habitación
<img width="1152" height="648" alt="TheJourney_MaquetaHABITACION" src="https://github.com/user-attachments/assets/49b21716-eb46-40f2-ac76-13c794bf56a0" />

### SHOP
<img width="1152" height="648" alt="TheJourney_MaquetaSHOP" src="https://github.com/user-attachments/assets/c24138cf-6eb6-460b-a19b-14100e7d02de" />

### Personaje principal / Jugador
<img width="480" height="480" alt="Mago_Hielo_PJprincipal" src="https://github.com/user-attachments/assets/c1854491-bd6d-48c6-8390-cc867ce06ca3" />

### Menu Principal y Primera habitación
<img width="1920" height="1080" alt="menuPrincipal_primeraHabitacion" src="https://github.com/user-attachments/assets/e2b0d008-5300-4b55-a544-19369844b78b" />
### Soundtrack y efectos de sonido (FX)
El soundtrack y efectos de sonido del juego será compuesto y producido por Flores León Emiliano.
