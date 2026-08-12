### Instruções para testes locais das atividades no Windows

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

O caminho até o diretório `test` varia conforme a estrutura da atividade. Ajustar a quantidade de `..\` caso a atividade possua subdiretório numerado.

* Compilar o código do programa e dos testes unitários. O código do teste unitário já é fornecido.

```powershell
javac -cp "lib/*" -d bin $sources
```

* Executar testes unitários e verificar o resultado no console

```powershell
java -jar lib\junit-platform-console-standalone-1.11.4.jar execute --class-path bin --scan-class-path
```
