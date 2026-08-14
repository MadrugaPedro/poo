# Entrega das leituras

> Escolha a seção correspondente ao sistema operacional do seu computador. No Windows, execute os comandos no PowerShell, não no Prompt de Comando (CMD).

- [Linux](#linux)
- [Windows](#windows)

## Linux

### Procedimento para entrega das leituras

* Escrever manualmente o resumo em folhar A4 branca
* Fazer Fork do repositório da disciplina
* Digitalizar em PDF e gravar no diretório `readings/NN-XXXX/seunome-seusobrenome.pdf`
* Fazer commit e push
* Enviar Pull Request para o repositório da disciplina
* Submeter link do Pull Request no [Ambiente Virtual](https://ambientevirtual.idp.edu.br/)
* Entregar o resumo físico em mãos na sala de aula
* Respeitar o prazo para cada texto de acordo prazo definido no ambiente virtual e acordado em sala
## Windows

### Procedimento para entrega das leituras no Windows

* Escrever manualmente o resumo em folha A4 branca
* Fazer fork do repositório da disciplina
* Digitalizar em PDF e gravar no diretório `readings\NN-XXXX\seunome-seusobrenome.pdf`
* Fazer commit e push

```powershell
git add .
git commit -m "entrega da leitura NN"
git push
```

* Enviar pull request

```powershell
gh pr create --base 2026.2 --head seu-usuario:2026.2 --title "Leitura NN" --body "Entrega do resumo da leitura NN."
```

* Submeter link do pull request no [Ambiente Virtual](https://ambientevirtual.idp.edu.br/)
* Entregar o resumo físico em mãos na sala de aula
* Respeitar o prazo para cada texto de acordo com o prazo definido no ambiente virtual e acordado em sala
