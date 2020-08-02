# Auth-service API

Aplicação em spring boot para cadastro de usuário utilizando spring security, spring jpa, swagger, mysql, h2.

### Api Autenticação de usuario.

Essa aplicação contem os seguintes endpoints

		- (POST) http://localhost:8082/api/signin (Endpoint gerar hash do token) 
		- (POST) http://localhost:8082/refresh/token (Endpoint verificar se o usuario esta com token valido)
 
### Configuração da api

Para poder startar aplicação, colocar nas configurações o seguinte:

 ```sh
	$ Program arguments: --spring.config.location=src/main/resources/application.yml --spring.config.name=application.yml
	$ VM Arguments: -Dspring.profiles.active=test (Para utilizar banco em memoria) ou -Dspring.profiles.active=dev (utilizar banco mysql) 
 ````

