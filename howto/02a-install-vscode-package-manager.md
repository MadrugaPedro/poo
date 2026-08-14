# Instalação do VS Code com o gerenciador de pacotes

> Escolha a seção correspondente ao sistema operacional do seu computador. No Windows, execute os comandos no PowerShell, não no Prompt de Comando (CMD).

- [Linux](#linux)
- [Windows](#windows)

## Linux

### Instalar o VS Code via apt

1. **Atualizar pacotes**

```bash
sudo apt update && sudo apt upgrade -y
```

2. **Baixar o VS Code e adicionar a chave do GPG da Microsoft**

```bash
wget -qO- https://packages.microsoft.com/keys/microsoft.asc | gpg --dearmor | sudo tee /usr/share/keyrings/packages.microsoft.gpg > /dev/null
```

3. **Adicionar o repositório do VS Code

```bash
echo "deb [arch=amd64 signed-by=/usr/share/keyrings/packages.microsoft.gpg] https://packages.microsoft.com/repos/code stable main" | sudo tee /etc/apt/sources.list.d/vscode.list
```

4. **Instalar o VS Code**

```bash
sudo apt update
sudo apt install -y code
```

5. **Verificar instalação**

```bash
code --version
```

6. **Confirmar instalação**

```bash
1.96.4
cd4ee3b1c348a13bafd8f9ad8060705f6d4b9cba
x64
```
## Windows

### Instalar o VS Code no Windows via winget

1. **Instalar o VS Code**

```powershell
winget install Microsoft.VisualStudioCode
```

2. **Fechar o PowerShell e abrir uma janela nova**

3. **Verificar instalação**

```powershell
code --version
```

4. **Confirmar instalação**

```powershell
1.96.4
cd4ee3b1c348a13bafd8f9ad8060705f6d4b9cba
x64
```

5. **Instalar as extensões de Java**

```powershell
code --install-extension vscjava.vscode-java-pack
```

6. **Confirmar as extensões instaladas**

```powershell
code --list-extensions | Select-String java
```

A saída deve conter `vscjava.vscode-java-pack` e as extensões que acompanham o pacote.
