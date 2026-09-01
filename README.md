# DOSW Parcial T1

**Nombre:** Juan Nicolás Álvarez Muñoz
**Grupo:** DOSW-1
**Enunciado Parte 3:**

---

## Evidencias de Prerrequisitos

### Acceso a Herramientas
![Herramienta de Modelado (Draw.io)]

<img width="1365" height="644" alt="image" src="https://github.com/user-attachments/assets/c61a1def-985f-4a5c-9107-d04b646376e9" />

![Figma]

<img width="1365" height="647" alt="image" src="https://github.com/user-attachments/assets/c5761c47-4b88-4f97-a33c-ad8fb436aa3a" />

### Compilación Exitosa con Maven
![Build Success]

<img width="1366" height="768" alt="image" src="https://github.com/user-attachments/assets/2efaa873-c490-40a2-bc08-6e0def48747e" />

---

#Punto 1 Diagrama de Contexto:

<img width="495" height="494" alt="image" src="https://github.com/user-attachments/assets/0deed9ac-4fb1-4e7c-a032-241dc812680f" />


### 2. Requerimientos del Sistema

| Código | Nombre del requerimiento | Descripción breve | Actor principal | Servicio |
| :--- | :--- | :--- | :--- | :--- |
| **PWH-RF-01** | Filtrar catálogo de mascotas | Permite recorrer y filtrar el inventario bajo criterios específicos (especie, edad, compatibilidad) ocultando la estructura interna **(Justifica Iterator)**. | Usuario | Catálogo |
| **PWH-RF-02** | Consultar red de refugios | Permite visualizar el inventario tratando de manera uniforme a un refugio local, una ciudad o la red nacional completa **(Justifica Composite)**. | Usuario | Refugios |
| **PWH-RF-03** | Gestionar estado de adopción | Permite cambiar el estado de una solicitud (Pendiente, En revisión, Aprobada, Rechazada, Completada) para el control del proceso. | Refugio | Adopciones |
| **PWH-RNF-01** | Tiempo de respuesta del catálogo | Las búsquedas en el catálogo de mascotas deben ejecutarse en un tiempo ≤ 1 s para el 90% de las consultas realizadas. | Sistema | Rendimiento |
| **PWH-RNF-02** | Escalabilidad del inventario | El sistema debe estar en capacidad de soportar hasta 10.000 mascotas registradas sin presentar degradación en su rendimiento. | Sistema | Infraestructura |

### 3. Diagramas de Caso de Uso e Historias de Usuario

**Requerimiento: PWH-RF-01 (Filtrar catálogo de mascotas - Patrón Iterator)**
* **Historia de Usuario:** Como usuario interesado en adoptar, quiero poder filtrar el catálogo de mascotas por especie, rango de edad y compatibilidad, para encontrar rápidamente la mascota que mejor se adapte a las condiciones de mi hogar sin importar cómo estén almacenadas internamente.

**Requerimiento: PWH-RF-02 (Consultar red de refugios - Patrón Composite)**
* **Historia de Usuario:** Como usuario interesado en adoptar, quiero poder visualizar las mascotas disponibles tanto en un refugio local específico como en toda la red de una ciudad o a nivel nacional, para explorar todas mis opciones de adopción de manera uniforme.

Diagrama:

<img width="1056" height="272" alt="CasosDeUso drawio (1)" src="https://github.com/user-attachments/assets/85b95615-17b2-4de0-9787-cdc3d2b463de" />


#Punto 4 plantilla de Análisis de Requerimientos:
Archivos subidos a docs/requirements/ 

### 6. Identificación y Especificación de Patrones de Diseño

#### a. Nombre del Patrón y Tipo
* **Iterator:** Patrón de **Comportamiento**.
* **Composite:** Patrón **Estructural**.

#### b. Justificación de la Decisión en el Contexto de ECI Paw Connect
* **Iterator:** La plataforma necesita permitir a los usuarios explorar y filtrar el catálogo de mascotas bajo múltiples criterios como por especie, por rango de edad, por compatibilidad, o en su totalidad. El patrón Iterator es ideal porque permite recorrer toda la colección de mascotas sin exponer la estructura de almacenamiento interna, ofreciendo una separación limpia entre los datos y los algoritmos de recorrido.
* **Composite:** La estructura organizacional de la fundación es jerárquica. El patrón Composite permite tratar a un refugio individual (hoja) y a una red completa de refugios (compuesto) de exactamente la misma manera. Esto facilita que una consulta a nivel de ciudad o nacional agrupe y devuelva el inventario de forma transparente sin que el cliente conozca los detalles de la jerarquía.

d. Cuáles principios SOLID está aplicando y por qué
Single Responsibility (SRP): Establece que una clase debe ser responsable de una sola cosa. Se aplica separando la estructura jerárquica de la lógica de recorrido.  

Open/Closed (OCP): Las entidades deben estar abiertas para su extensión pero cerradas para su modificación. Si el día de mañana Paw Connect quiere filtrar por Tamaño, solo se crea un nuevo IteradorPorTamaño que implemente la interfaz IteradorMascota, sin modificar el código de los refugios ni de los iteradores existentes.  

Dependency Inversion (DIP): Los módulos de alto nivel no deben depender de los de bajo nivel, las dependencias deben estar en las abstracciones. El sistema de búsqueda dependerá de las interfaces ComponenteRefugio e IteradorMascota, ignorando si está tratando con un RefugioLocal específico o un IteradorPorEspecie.








