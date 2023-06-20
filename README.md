
# Service Manage Places

API para gerenciar lugares que faz parte desse desafio técnico para quem se candidata a ClickBus.


## O que foi usado

- Spring Boot
- Spring Data 
- MySQL
- Lombok
- Validation


## Documentação da API

#### Retorna todos os itens

```http
  GET :8080/place
```

#### Retorna um item

```http
  GET :8080/place/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do item que você quer |

#### Inserir um lugar

```http
  POST :8080/place
```

| Parâmetro   | Tipo       |                                    |
| :---------- | :--------- | :------------------------------------------ |
| `name` `slug` `state`     | `String` `String` `String` | **Obrigatório**. Os 3 campos |

```
{
    "name": "Exemplo",
    "slug": "exemplo",
    "state": "Exemplo"
}
```

#### Atualizar um lugar

```http
  PUT :8080/place
```

| Parâmetro   | Tipo       |                                    |
| :---------- | :--------- | :------------------------------------------ |
| `id` `name` `slug` `state`     | `Long` `String` `String` `String` | **Obrigatório**. O id para acesso a referência. |

```
{
    "id": 1,
    "name": "Exemplo",
    "slug": "exemplo",
    "state": "Exemplo"
}
```



