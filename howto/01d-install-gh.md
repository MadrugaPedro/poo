# Instalação do GitHub CLI

> Escolha a seção correspondente ao sistema operacional do seu computador. No Windows, execute os comandos no PowerShell, não no Prompt de Comando (CMD).

- [Linux](#linux)
- [Windows](#windows)

## Linux

## Instalação do gh

1. **Adicione o repositório oficial do GitHub CLI (https://cli.github.com/)**
```bash
type -p curl >/dev/null || sudo apt install curl -y
curl -fsSL https://cli.github.com/packages/githubcli-archive-keyring.gpg | \
  sudo dd of=/usr/share/keyrings/githubcli-archive-keyring.gpg

sudo chmod go+r /usr/share/keyrings/githubcli-archive-keyring.gpg

echo "deb [arch=$(dpkg --print-architecture) \
signed-by=/usr/share/keyrings/githubcli-archive-keyring.gpg] \
https://cli.github.com/packages stable main" | \
sudo tee /etc/apt/sources.list.d/github-cli.list > /dev/null
```

2. **Atualize os pacotes**
```bash
sudo apt update
```

3. **Instale o GitHub CLI**
```bash
sudo apt install gh -y
```

4. **Verifique a instalação**
```bash
gh --version
```

5. **Autenticar**
```bash
gh auth login
```

6. **Verificar**
```bash
gh auth status
```
## Windows

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
