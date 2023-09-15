# Bienvenid@s!
Esta es mi prueba tecnica para nisum, para probar esta aplicacion se requiere tener instalado:
***
        1 - Java 1.8
        2 - Maven
***
Sigue los siguiente pasos:
***
    1 - Ubicarse dentro de la capeta raiz y abrir la ventana de consola de maven
    2 - Ejecutar el siguiente comando mvn spring-boot:run
***
Despues con la aplicacion de postman probar el api:
***
    1 - Realizar una peticion POST a la siguiente URI: http://localhost:8080/usuario
    2 - Ingresar un body tipo JSON con el siguiente formato:
***
        {
            "username": "string",
            "email": "string",
            "password": "string",
            "phone": [
                {
                    "number": "string",
                    "cityCode": "string",
                    "countryCode": "string"
                }
            ]
        }
     3 - Despues dar click en el boton send o enviar.
