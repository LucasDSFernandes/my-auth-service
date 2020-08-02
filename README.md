# auth-service API

Aplicação simples em spring boot para cadastro de usuário utilizando spring security, spring jpa, swagger, mysql.

### Api Autenticação de usuario.

Essa aplicação contem os seguintes endpoints

		- (POST) http://localhost:8082/login/token (Endpoint gerar hash do token) 
		- (POST) http://localhost:8082/login/refresh (Endpoint verificar se o usuario esta com token valido)


 - Obs.: No endpoints  http://localhost:8082/login/token, precisara passar no seu body o seguinte json.
 
 ```sh
	$ 	{
	$		"login":"",
	$		"password":""
	$	}
 ```` 
 
### Configuração da api

Para poder startar aplicação, colocar nas configurações o seguinte:

 ```sh
	$ --spring.config.location=src/main/resources/application.yml --spring.config.name=application.yml
 ````

