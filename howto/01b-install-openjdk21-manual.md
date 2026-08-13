# Instalação manual do OpenJDK 21

> Escolha a seção correspondente ao sistema operacional do seu computador. No Windows, execute os comandos no PowerShell, não no Prompt de Comando (CMD).

- [Linux](#linux)
- [Windows](#windows)

## Linux

### Instalação manual do OpenJDK 21 no Linux

Executar os seguintes comandos no terminal para instalar o OpenJDK 21 no Linux:

1. **Baixar o OpenJDK**

Baixar executando o comando abaixo no terminal ou fazer download da versão 21 em https://jdk.java.net/archive/

```bash
wget https://download.java.net/java/GA/jdk21.0.2/f2283984656d49d69e91c558476027ac/13/GPL/openjdk-21.0.2_linux-x64_bin.tar.gz
```

2. **Extrair o arquivo baixado e mova para o diretório /opt/**

```bash
tar -xvzf openjdk-21.0.2_linux-x64_bin.tar.gz
sudo mv jdk-21.0.2 /opt/
```

3. **Configurar variáveis de ambiente**

```bash
echo "export JAVA_HOME=/opt/jdk-21.0.2" >> ~/.bashrc
echo "export PATH=\$JAVA_HOME/bin:\$PATH" >> ~/.bashrc
source ~/.bashrc
```

4. **Verificar a instalação**

```bash
java -version
```

5. **Confirmar a instalação**

```bash
openjdk version "21.0.2" 2024-01-16
OpenJDK Runtime Environment (build 21.0.2+13-58)
OpenJDK 64-Bit Server VM (build 21.0.2+13-58, mixed mode, sharing)
```

6. **Configuarar o OpenJDK 21 como padrão**

Esse passo é necessário apenas caso tenha várias versões do Java instaladas

```bash
sudo update-alternatives --config java
```

```bash
sudo update-alternatives --config javac
```
## Windows

### Instalação manual do OpenJDK 21 no Windows

Alternativa para os casos em que o winget não está disponível ou falha.

1. **Baixar o instalador**

Acessar https://learn.microsoft.com/java/openjdk/download e baixar o arquivo `.msi` do JDK 21 para a arquitetura x64.

2. **Executar o instalador**

Na tela de opções, marcar as opções abaixo:

* Add to PATH
* Set JAVA_HOME variable

3. **Fechar o PowerShell e abrir uma janela nova**

4. **Verificar a instalação**

```powershell
java -version
javac -version
```

5. **Verificar a variável JAVA_HOME**

```powershell
$env:JAVA_HOME
```

Saída esperada:

```powershell
C:\Program Files\Microsoft\jdk-21.0.12.8-hotspot
```
