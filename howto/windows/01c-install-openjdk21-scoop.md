### Instalação do OpenJDK 21 no Windows via Scoop

O SDKMAN não funciona no Windows nativo. O gerenciador equivalente é o Scoop, que permite instalar e alternar entre várias versões do JDK.

Use este método apenas se precisar manter mais de uma versão do Java na máquina. Para a disciplina, a instalação via winget é suficiente.

1. **Habilitar a execução de scripts no PowerShell**

```powershell
Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
```

2. **Instalar o Scoop**

```powershell
Invoke-RestMethod -Uri https://get.scoop.sh | Invoke-Expression
```

3. **Adicionar o repositório de pacotes Java**

```powershell
scoop bucket add java
```

4. **Instalar o OpenJDK 21**

```powershell
scoop install openjdk21
```

5. **Verificar a instalação**

```powershell
java -version
javac -version
```

6. **Alternar entre versões instaladas**

```powershell
scoop reset openjdk21
```
