# Instalação do Git

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

## Windows

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
