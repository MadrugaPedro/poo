# Instalação do Docker

> Escolha a seção correspondente ao sistema operacional do seu computador. No Windows, execute os comandos no PowerShell, não no Prompt de Comando (CMD).

- [Linux](#linux)
- [Windows](#windows)

## Linux

_Ainda não há instruções específicas para Linux._

## Windows

### Instalação do Docker no Windows

O Docker é necessário a partir do módulo de JDBC, para executar o PostgreSQL com o banco de dados `dvdrental`.

1. **Instalar o Docker Desktop**

```powershell
winget install Docker.DockerDesktop
```

2. **Reiniciar o computador**

O Docker Desktop utiliza o WSL2 e habilita o componente durante a instalação.

3. **Abrir o Docker Desktop**

Aguardar até o ícone da baleia indicar que o serviço está em execução.

4. **Verificar a instalação**

```powershell
docker --version
docker run hello-world
```

5. **Executar o PostgreSQL**

```powershell
docker run --name pg-idp -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres:16
```

6. **Restaurar o banco dvdrental**

Baixar o arquivo `dvdrental.zip`, extrair o `dvdrental.tar` e executar:

```powershell
docker cp dvdrental.tar pg-idp:/tmp/
docker exec -it pg-idp createdb -U postgres dvdrental
docker exec -it pg-idp pg_restore -U postgres -d dvdrental /tmp/dvdrental.tar
```

7. **Verificar a restauração**

```powershell
docker exec -it pg-idp psql -U postgres -d dvdrental -c "SELECT count(*) FROM film;"
```
