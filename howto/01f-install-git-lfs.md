# Instalação do Git LFS

> Escolha a seção correspondente ao sistema operacional do seu computador. No Windows, execute os comandos no PowerShell, não no Prompt de Comando (CMD).

- [Linux](#linux)
- [Windows](#windows)

## Linux

## Instalação do Git LFS

1.  **Adicionar o repositório do Git LFS**

    ```bash
    wget -qO - https://packagecloud.io/install/repositories/github/git-lfs/script.deb.sh | sudo bash
    ```

2.  **Atualizar os pacotes**

    ```bash
    sudo apt update
    ```

3.  **Instalar o Git LFS**

    ```bash
    sudo apt install git-lfs
    git lfs install
    ```

## Windows

### Instalação do Git LFS no Windows

1. **Instalar o Git LFS**

```powershell
winget install GitHub.GitLFS
```

2. **Fechar o PowerShell e abrir uma janela nova**

3. **Habilitar o Git LFS para o usuário**

```powershell
git lfs install
```

4. **Verificar a instalação**

```powershell
git lfs version
```
