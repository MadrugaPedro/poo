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
