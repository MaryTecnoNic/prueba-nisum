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
    1 - Realizar una peticion POST a la siguiente URI: http://localhost:8080/login e ingresar en el body lo siguiente (esto retorna un token):
***
        {
            "username":"admin",
            "password":"123456"
        }
***  
            
    2 - El token retornado en la anterior api se debe ingresar como Authorization de tipo Bearer Token en la api http://localhost:8080/crearUsuario es aqui donde el body debera de ir con el siguiente formato:
    
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
***
     3 - Despues dar click en el boton send o enviar.
