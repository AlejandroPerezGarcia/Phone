# Phone APP

Aplicacion que muestra datos basico de un celular, detalle del producto con posibilidad de mandar con un boton flotante un correo con el celular selecionado
con los dato de celular y id unico de cada producto.

##Consumo de Api

Consume dato de la Api

```bash
    Productos
    http://my-json-server.typicode.com/Himuravidal/FakeAPIdata/products/
    Detalle
    https://my-json-server.typicode.com/Himuravidal/FakeAPIdata/details
```

## Implementacion

- [Retrofit](https://square.github.io/retrofit/) - Consumo de API
- [Picasso](https://square.github.io/picasso/) - Importar imágenes
- [Lifecycle](https://developer.android.com/jetpack/androidx/releases/lifecycle) - Respuesta segun ciclo de vida de los componentes
- [Room](https://developer.android.com/jetpack/androidx/releases/room) - Acceso a base de datos

## Capturas de pantallas

![Pantalla Inicio](screenshots/Phone_Pantalla_Inicio.png "Pantalla Inicio")
![Pantalla Detalle](screenshots/Phone_Pantalla_Detalle.png "Pantalla Detalle")
![Patalla Detalle 2](screenshots/Phone_Pantalla_Detalle2.png "Pantalla Detalle 2")
![Pantalla Correo](screenshots/Phone_Correo.png "Pantalla Correo")

## Funcionamiento

- La aplicación muestra un listado de Productos
- La aplicación muestra un detalle de Productos
- La aplicación con el boton flotante habre el correo electronico e envia un mail con datos ya determinados

## Desarrollado por Alejandro Pérez García


