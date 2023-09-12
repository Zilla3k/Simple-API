# API Simples com Java Spring Boot

### Início
- Necessário um Banco de Dados inicializado (Prefêrencialmente MongoDB).
- Ache e salve o nome do banco, login, senha e cluster.
- Vincule os as informações salvas conforme o arquivo `.env.example` e crie um `.env`.

### IDE
- IntelliJ IDEA

### Comandos para requisições
- ##### Lista todos os filmes
```http
  GET /api/v1/movie
```
- ##### Lista o filme pelo imdbId
```http
  GET /api/v1/movie/tt8093700
```
- ##### Cria uma avaliação
```http
  POST /api/v1/reviews
```
Código exemplo para colocar no `body` pelo `raw`
```JSON
{
  "reviewBody": "Eu realmente gostei deste.",
  "imdbId": "tt8093700"
}
```

## Stack utilizada
**Back-end:** Java Spring Boot