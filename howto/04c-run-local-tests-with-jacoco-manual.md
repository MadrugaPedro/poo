# Execução dos testes locais com cobertura JaCoCo

> Escolha a seção correspondente ao sistema operacional do seu computador. No Windows, execute os comandos no PowerShell, não no Prompt de Comando (CMD).

- [Linux](#linux)
- [Windows](#windows)

## Linux

### Instruções para testes locais das atividades

Cada atividade é acompanhada de testes unitários. Para avaliar seu código antes de submetê-lo, execute os seguintes comandos a partir de seu diretório pessoal de cada atividade

* Criar diretório para armazenar as dependências
 ```bash
 mkdir -p lib
 ```
* Baixar o junit
```bash
 curl -L -o lib/junit-platform-console-standalone-1.11.4.jar https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.11.4/junit-platform-console-standalone-1.11.4.jar
```
* Compilar o código do programa e dos testes unitários. O código do teste unitário já é fornecido.
```bash
 javac -cp "lib/*" -d bin src/*.java ../../test/*.java
 ```
 * Executar testes unitários e verificar o resultado no console
 ```bash
 java -jar lib/junit-platform-console-standalone-1.11.4.jar execute --class-path bin --scan-class-path
 ```

* Baixar o JaCoCo Cli
```bash
curl -L -o lib/jacococli.jar https://repo1.maven.org/maven2/org/jacoco/org.jacoco.cli/0.8.13/org.jacoco.cli-0.8.13-nodeps.jar
```

* Baixar o JaCoCo Agent
```bash
curl -L -o lib/jacocoagent.jar https://repo1.maven.org/maven2/org/jacoco/org.jacoco.agent/0.8.13/org.jacoco.agent-0.8.13-runtime.jar
```

* Rodar os testes com cobertura JaCoCo
```bash
java -javaagent:lib/jacocoagent.jar=destfile=lib/jacoco.exec -jar lib/junit-platform-console-standalone-1.11.4.jar execute --class-path bin --scan-class-path
```

* Gerar o relatório com o JaCoCo CLI
```bash
java -jar lib/jacococli.jar report lib/jacoco.exec --classfiles bin --sourcefiles src --html coverage-report --name "JoCoCo Coverage"
```

* Servir relatório de cobertura via HTTP
```bash
npx http-server coverage-report 8080
```

## Windows

### Instruções para testes locais das atividades com cobertura no Windows

Cada atividade é acompanhada de testes unitários. Para avaliar seu código antes de submetê-lo, execute os seguintes comandos a partir de seu diretório pessoal de cada atividade.

* Criar diretório para armazenar as dependências

```powershell
New-Item -ItemType Directory -Force -Path lib
```

* Baixar o junit

```powershell
curl.exe -L -o lib\junit-platform-console-standalone-1.11.4.jar https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.11.4/junit-platform-console-standalone-1.11.4.jar
```

No PowerShell, `curl` é um apelido para `Invoke-WebRequest`, que não reconhece as opções `-L` e `-o`. É obrigatório utilizar `curl.exe`, disponível no Windows 10 e 11.

* Montar a lista de arquivos-fonte do programa e dos testes

```powershell
$sources = Get-ChildItem -Path src, ..\..\test -Filter *.java -Recurse | ForEach-Object { $_.FullName }
```

* Compilar o código do programa e dos testes unitários. O código do teste unitário já é fornecido.

```powershell
javac -cp "lib/*" -d bin $sources
```

* Executar testes unitários e verificar o resultado no console

```powershell
java -jar lib\junit-platform-console-standalone-1.11.4.jar execute --class-path bin --scan-class-path
```

* Baixar o JaCoCo Cli

```powershell
curl.exe -L -o lib\jacococli.jar https://repo1.maven.org/maven2/org/jacoco/org.jacoco.cli/0.8.13/org.jacoco.cli-0.8.13-nodeps.jar
```

* Baixar o JaCoCo Agent

```powershell
curl.exe -L -o lib\jacocoagent.jar https://repo1.maven.org/maven2/org/jacoco/org.jacoco.agent/0.8.13/org.jacoco.agent-0.8.13-runtime.jar
```

* Rodar os testes com cobertura JaCoCo

```powershell
java -javaagent:lib\jacocoagent.jar=destfile=lib\jacoco.exec -jar lib\junit-platform-console-standalone-1.11.4.jar execute --class-path bin --scan-class-path
```

* Gerar o relatório com o JaCoCo CLI

```powershell
java -jar lib\jacococli.jar report lib\jacoco.exec --classfiles bin --sourcefiles src --html coverage-report --name "JaCoCo Coverage"
```

* Abrir o relatório de cobertura no navegador

```powershell
Start-Process coverage-report\index.html
```

* Servir relatório de cobertura via HTTP (opcional, requer Node.js instalado)

```powershell
npx http-server coverage-report 8080
```
