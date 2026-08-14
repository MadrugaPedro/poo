# Instalação do OpenJDK 21 com o gerenciador de pacotes

> Escolha a seção correspondente ao sistema operacional do seu computador. No Windows, execute os comandos no PowerShell, não no Prompt de Comando (CMD).

- [Linux](#linux)
- [Windows](#windows)

## Linux

### Instalação do OpenJDK 21 no Linux via apt

Executar os seguintes comandos no terminal para instalar o OpenJDK 21 no Linux:

1. **Atualizar pacotes**

```bash
sudo apt update && sudo apt upgrade -y
```

2. **Instalar o OpenJDK 21**

```bash
sudo apt install -y openjdk-21-jdk
```

3. **Verificar a instalação**

```bash
java -version
```
4. **Confirmar a instalação**

```bash
openjdk version "21.0.2" 2024-01-16
OpenJDK Runtime Environment (build 21.0.2+13-58)
OpenJDK 64-Bit Server VM (build 21.0.2+13-58, mixed mode, sharing)
```

5. **Configuarar o OpenJDK 21 como padrão**

Esse passo é necessário apenas caso tenha várias versões do Java instaladas

```bash
sudo update-alternatives --config java
```

```bash
sudo update-alternatives --config javac
```
## Windows

### Instalação do OpenJDK 21 no Windows via winget

Executar os seguintes comandos no PowerShell para instalar o OpenJDK 21 no Windows:

1. **Instalar o OpenJDK 21**

```powershell
winget install Microsoft.OpenJDK.21
```

2. **Fechar o PowerShell e abrir uma janela nova**

O PATH só é recarregado em uma sessão nova do terminal.

3. **Verificar a instalação**

```powershell
java -version
javac -version
```

4. **Confirmar a instalação**

```powershell
openjdk version "21.0.12" 2026-07-21 LTS
OpenJDK Runtime Environment Microsoft-14653896 (build 21.0.12+8-LTS)
OpenJDK 64-Bit Server VM Microsoft-14653896 (build 21.0.12+8-LTS, mixed mode, sharing)
javac 21.0.12
```

5. **Configurar o OpenJDK 21 como padrão**

Esse passo é necessário apenas caso tenha várias versões do Java instaladas. No Windows não existe o `update-alternatives`, a versão padrão é definida pela ordem das entradas no PATH.

Verificar qual executável está sendo chamado primeiro:

```powershell
where.exe java
```

A primeira linha da saída é a versão em uso. Se ela apontar para uma instalação antiga, remover a entrada correspondente do PATH:

* Tecla Windows, buscar "variáveis de ambiente"
* Abrir "Editar as variáveis de ambiente do sistema"
* Botão "Variáveis de Ambiente"
* Em "Variáveis do sistema", selecionar `Path` e clicar em Editar
* Excluir a linha da instalação antiga (exemplo: `C:\ProgramData\Oracle\Java\javapath`)
* Confirmar que existe a linha `C:\Program Files\Microsoft\jdk-21.x.x-hotspot\bin`
* Confirmar com OK, fechar o PowerShell e abrir uma janela nova
