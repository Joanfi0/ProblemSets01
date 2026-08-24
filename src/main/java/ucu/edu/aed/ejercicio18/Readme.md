# Ejercicio 18:
## 1. Elección de comportamientos

En nuestro TDA Lista para decidi que comportamiento deberia tener evaluamos los siguiente:

1. **Quitar:** Desconecta el nodo de la estructura modificando únicamente los punteros "siguiente". Ademas el objeto contenido en el nodo queda disponible para ser reutilizado, o bien queda se encarga el recolector de basura si ya no se utiliza.
2. **Eliminar:** Además de desconectar el nodo, anula explícitamente sus referencias internas "siguiente = null", de esta forma libera la memoria de manera inmediata.
3. **Comportamiento elegido:** Actualmente decidimos dejar el método booleano `remover(T elem)`, el cual recibe el elemento como parámetro de entrada, busca su coincidencia en la lista y devuelve `true` si fue removido con éxito o `false` en caso de que no existiera.

---

## 2. Casos de Prueba en JUnit

Los test se encuentran en la carpeta test:
* Elemento existente.
* Elemento inexistente.
* Lista vacía.

