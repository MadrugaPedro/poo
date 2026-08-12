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
