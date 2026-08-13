# Preparação do repositório da disciplina

> Escolha a seção correspondente ao sistema operacional do seu computador. No Windows, execute os comandos no PowerShell, não no Prompt de Comando (CMD).

- [Linux](#linux)
- [Windows](#windows)

## Linux

### Preparar repositório da disciplina

* Realizar fork do repositório da disciplina
```bash
gh repo fork fabriciosantana/poo
```
   
* Clonar seu repositório que você acabou de clonar (substituir `seu-usuario` por seu login no github)
```bash
git clone https://github.com/seu-usuario/poo.git
```
## Windows

### Preparar repositório da disciplina no Windows

* Navegar até o diretório onde os projetos são armazenados, pois o clone ocorre no diretório atual

```powershell
cd C:\Users\seu-usuario\projetos
```

* Realizar fork do repositório da disciplina e clonar em uma única operação

```powershell
gh repo fork fabriciosantana/poo --clone
```

* Entrar no diretório e selecionar a branch da disciplina

```powershell
cd poo
git checkout 2026.2
```

* Verificar os repositórios remotos

```powershell
git remote -v
```

O remoto `origin` deve apontar para o seu usuário e o `upstream` para `fabriciosantana`. Caso o `origin` aponte para o repositório do professor, o fork não foi criado e o push não será permitido.

```powershell
origin    https://github.com/seu-usuario/poo.git (fetch)
origin    https://github.com/seu-usuario/poo.git (push)
upstream  https://github.com/fabriciosantana/poo.git (fetch)
upstream  https://github.com/fabriciosantana/poo.git (push)
```

* Atualizar o repositório local com as alterações publicadas pelo professor durante o semestre

```powershell
git fetch upstream
git merge upstream/2026.2
```
