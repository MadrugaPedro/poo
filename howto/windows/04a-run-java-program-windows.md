### Como compilar, empacotar, decompilar e executar programa java na linha de comando no Windows

Execute os comandos abaixo no PowerShell para compilar, empacotar, decompilar e executar programa java na linha de comando.

Duas diferenças em relação ao Linux devem ser observadas:

* O PowerShell não expande curingas como `src\*.java` para programas externos. A lista de arquivos precisa ser montada antes da chamada ao `javac`
* O separador entre entradas de classpath é o ponto e vírgula (`;`) e não os dois pontos (`:`)

O curinga de arquivos JAR (`-cp "lib/*"`) funciona normalmente, pois é expandido pela própria JVM.

* Montar a lista de arquivos-fonte

```powershell
$sources = Get-ChildItem -Path src -Filter *.java -Recurse | ForEach-Object { $_.FullName }
```

* Compilar o código do programa e dos testes unitários. O código do teste unitário já é fornecido.

```powershell
javac -cp "lib/*" -d bin $sources
```

* Executar programa java

```powershell
java -cp bin HelloWorld
```

* Executar programa java com mais de uma entrada no classpath

```powershell
java -cp "bin;lib/*" HelloWorld
```

* Criar um jar com o programa

```powershell
jar --create --file bin\HelloWorld.jar --main-class HelloWorld -C bin\ HelloWorld.class
```

* Executar programa java por meio do jar

```powershell
java -jar bin\HelloWorld.jar
```

* Decompilar classe Java

```powershell
javap -cp bin -c HelloWorld
```
