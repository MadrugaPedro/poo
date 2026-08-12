### Instalação do gh no Windows

1. **Instalar o GitHub CLI (https://cli.github.com/)**

```powershell
winget install GitHub.cli
```

2. **Fechar o PowerShell e abrir uma janela nova**

3. **Verificar a instalação**

```powershell
gh --version
```

4. **Autenticar**

```powershell
gh auth login
```

Responder às perguntas na seguinte ordem:

* Where do you use GitHub? → `GitHub.com`
* What is your preferred protocol? → `HTTPS`
* Authenticate Git with your GitHub credentials? → `Y`
* How would you like to authenticate? → `Login with a web browser`

O código de autorização no formato `XXXX-XXXX` é exibido no próprio terminal, na linha imediatamente anterior ao aviso de abertura do navegador. Copiar o código antes de pressionar Enter.

5. **Verificar**

```powershell
gh auth status
```
