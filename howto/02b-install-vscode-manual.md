# Instalação manual do VS Code

> Escolha a seção correspondente ao sistema operacional do seu computador. No Windows, execute os comandos no PowerShell, não no Prompt de Comando (CMD).

- [Linux](#linux)
- [Windows](#windows)

## Linux

_Ainda não há instruções específicas para Linux._

## Windows

### Instalar o VS Code no Windows manualmente

Alternativa para os casos em que o winget não está disponível ou falha.

1. **Baixar o instalador**

Acessar https://code.visualstudio.com/download e baixar o instalador para Windows x64 (User Installer).

2. **Executar o instalador**

Na tela "Selecionar tarefas adicionais", marcar as opções abaixo:

* Adicionar a ação "Abrir com Code" ao menu de contexto de arquivo do Windows Explorer
* Adicionar a ação "Abrir com Code" ao menu de contexto de diretório do Windows Explorer
* Adicionar ao PATH

A última opção é obrigatória para que o comando `code` funcione no terminal.

3. **Fechar o PowerShell e abrir uma janela nova**

4. **Verificar instalação**

```powershell
code --version
```

5. **Instalar as extensões de Java**

```powershell
code --install-extension vscjava.vscode-java-pack
```
