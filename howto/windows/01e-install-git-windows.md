### Instalação do Git no Windows

1. **Instalar o Git (https://git-scm.com/)**

```powershell
winget install Git.Git
```

2. **Fechar o PowerShell e abrir uma janela nova**

3. **Verificar a instalação**

```powershell
git --version
```

4. **Configurar identidade**

Utilizar o mesmo endereço de email da conta do GitHub, caso contrário os commits não são atribuídos ao perfil correto.

```powershell
git config --global user.name "Seu Nome"
git config --global user.email "seu-email@dominio.com"
```

5. **Configurar o tratamento de quebra de linha**

O Windows utiliza CRLF e o repositório utiliza LF. Sem esta configuração, arquivos inteiros aparecem como modificados no `git diff` mesmo sem alteração de conteúdo.

```powershell
git config --global core.autocrlf true
```

6. **Verificar a configuração**

```powershell
git config --global --list
```
