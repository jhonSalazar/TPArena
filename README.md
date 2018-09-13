# Utilizando Patrón MVC

Lector de Notas - Entrega #1

Contexto

Para los docentes y estudiantes, la gestión de las notas es una tarea importantísima: los docentes tienen que calificar las distintas tareas de los estudiantes, y estos a su vez, están ciertamente interesados en saber qué nota obtuvieron.

Entonces, ¿cómo podemos cargarlas y mostrarlas a nuestros estudiantes? Tradicionalmente, mediante una planilla en papel y comunicando las notas personalmente, pero con los tiempos que corren, se ha vuelto muy frecuente informatizar esta tarea, utilizando planillas online, como por ejemplo las de Google Docs.

¿Y qué problema hay con ellas? Primero, para los docentes es fácil equivocarse: ingresando notas con un formato incorrecto (porque las hay numéricas y conceptuales), haciéndolo para una tarea equivocada, intercambiando estudiantes, etc. Y segundo, por motivos de privacidad de datos, una nota debería ser solo notificada a quien la obtuvo y no estar pública, tal como en los viejos tiempos del papel y el lápiz.

Por eso es que los docentes de Diseño de Sistemas no tuvieron mejor idea que construir un sistema web para cargarlas, con el siguiente modelo de dominio:

Hay muchos estudiantes, de los que se sabe su nombre y legajo
Hay muchas tareas, que el docente puede definir, como parciales y trabajos prácticos. El docente establece un tipo de calificación para estas tareas: numéricas o conceptuales (letras como M, B- y R+)
Cada estudiante tiene muchas asignaciones de tareas, que son las relaciones entre una tarea y el estudiante, y para cada asignación, puede tener muchas notas, una por cada vez que se evaluó (por ejemplo, en un parcial podés tener hasta 3 notas)
No se maneja el concepto de curso (al menos por ahora)

Aún el sistema web donde se persistirán las notas no se encuentra realizado, por lo tanto los datos utilizados deberán sacarse de memoria.
Objetivo

El objetivo principal es una aplicación de escritorio desarrollada en la tecnología Java 8 que permita, para un estudiante: 
Ver su nota actual para cada asignación, y saber si la aprobó.
Actualizar sus datos de estudiante: nombre y apellido, legajo y usuario github.
