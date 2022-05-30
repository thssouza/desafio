# desafio
Desafio para Atech

Instalação

* Cuidado com outros containers que possam estar executando e possam causar conflitos de portas (5432,8080 e 86).

- Para instalação, primeiramente sincronizar a pasta do git no ambiente local;
- Navegar até o diretório Docker na raiz do projeto;
- Executar o comando abaixo para baixar as imagens do DockerHub;
´docker-compose -f docker-compose.yml up´
- Apos o container ter subido executar o comando abaixo para popular o banco;
- ´docker exec -i containerDesafio psql -U admin atech_desafio < data/start.sql´

Com isso a aplicação vai estar em execução, e existe um pgadmin disponivel também;

------------------------------------------------------------------------------------------------

PgAdmin:
http://localhost:86/browser/
login: desafio@atech.com
Senha: desafio

Na configuração do servidor, no caminho utilizar o nome do container "containerDesafio", a porta é a padrão 5432, login e senha "admin"

------------------------------------------------------------------------------------------------
Swagger:
http://localhost:8080/swagger-ui/index.html
