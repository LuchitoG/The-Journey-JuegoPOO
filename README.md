# Trabajo Final: Juego tipo Roguelike - The Journey

## 1. Integrantes del Equipo

- Giovannini Luciano Gabriel
- Gil Luca Agustín
- Flores León Emiliano
- 

### Descripción del Juego

Queremos desarrollar un juego estilo Roguelike, cuyo titulo es: The Journey.
El juego se basa en un Hechizero (Jugador) que entra a una mazmorra en busca de derrotar a el jefe final llamado "x", el camino se va encontrando con diversos obstaculos, enemigos y equipamiento para facilitar el camino.

### Objetivo del Juego - Checklist de features

**MUNDO**
├── **3 niveles**
├── **habitaciones aleatorias** (Estas habitaciones serán elegidas aleatoriamente de una lista de         │                                habitaciones presets, se planean entre 5 y 10 habitaciones.)
├── **Puertas** (Las puertas permaneceran cerradas si hay enemigos en la habitacion)
├── **1 habitación bonus por nivel** 
│       └──  Recompensa de monedas 
└── **3 jefes** 
    └── 1 por nivel


**JUGADOR**
├── Vida
├── Daño
├── Velocidad
└── Firerate 


**ENEMIGOS**
├──  Cangrejo
│   └── Persigue al jugador, son rápidas, no escalan obstáculos ni nada, solo son molestas
│
├──  Murcielago
│   └── Movimiento simple, te toca y te hace daño, vuelan sobre todos los obstaculos.
│
├── Cangrejo Kamikaze
│   └── Persigue y explota, daño de area a todas las entidades, solo tiene solo 1 hp, son pequeños.
│
├── Gigante
│   └── Lento + mucha vida, te golpea
│
└──  TipoCañón
    └── Será un ojo anclado al piso, dispara en la dirección deljugador en ese instante
// Cada enemigo tiene un 25% de droppear un item (a excepcion de los kamikazes), la probabilidad es alta para que los profes puedan ver todos los items.

 **ITEMS / DROPS**
├── Botiquín (cura 2 corazones)
├── +Daño  (aumentar daño de la bala, aumentar tamaño)
├── +Velocidad (Aumenta la velocidad de movimiento del jugador)
├──  +Cadencia (Aumenta el firerate)
└──  +Vida máxima (Aumenta la salud maxima (más corazónes))
//Como se mencionó anteriormente, tienen 25% de chances de aparecer con cada enemigo que mates

 **COMBATE**
├── Proyectiles (bolas de fuego del pj principal, balas de los enemigos)
└── Colisiones (Daño al contacto con enemigos o se "rompe" la bala cuando choca con alguna hitbox)


**OBSTÁCULOS**
├── Pinchos (Si el jugador pisa los Pinchos recibe daño)
├── Piedras (Bloquean el paso, se pueden romper con bombas o cangrejos kamikaze)
└──  Agua / Hueco en el piso (funcionan como la piedra, con la diferencia de que no se pueden romper)


**SHOP**
├── Tienen una chance de 35% en aparecer por piso.
└── Comprar items
// Los items muestran el precio y una breve descripción de que hace el item, el jugador debará pasar por encima para dicha mecanica.
// Lo dejaremos para lo último, porque pensamos que nos podria atrasar mucho.


**Recompenzas**
├── Completar habitación (chance de 1/3, ya que la habitacion puede droppear monedas, una bomba o nada )
└── Habitación bonus (Es una habitacion llena de monedas)
 

**Ranking**
Se va a basar en que tan rápido el jugador pase el juego, cuantos enemigos mataste y cuantas monedas agarraste.