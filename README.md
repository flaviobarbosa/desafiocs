## Cadastro

###### POST https://still-gorge-14107.herokuapp.com/user/add

```
{
    "name": "João da Silva",
    "email": "joao@silva.org",
    "password": "hunter2",
    "phones": [
        {
            "number": "987654321",
            "ddd": "21"
        }
    ]
}
```

## Login

###### POST https://still-gorge-14107.herokuapp.com/user/login

```
{
    "email": "joao@silva.org",
    "password": "hunter2"
}
```

## Perfil

###### GET https://still-gorge-14107.herokuapp.com/user/{id}

