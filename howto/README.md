# Guias de uso

Este diretório reúne instruções para configurar o ambiente da disciplina, preparar o repositório, entregar atividades e executar programas e testes. Use este arquivo apenas como ponto de partida: os procedimentos e comandos estão nos documentos específicos.

## Escolha o sistema operacional

Cada guia reúne as instruções para Linux e Windows em seções separadas. Ao abrir um documento, use os links no topo para acessar a seção correspondente ao sistema operacional do seu computador.

No Windows, execute os comandos no **PowerShell**, não no Prompt de Comando (CMD). O uso no macOS não é coberto de forma geral, embora o procedimento com SDKMAN do guia de gerenciadores de versões também contemple esse sistema.

## 1. Configure o ambiente

Instale primeiro as ferramentas necessárias. Quando houver mais de um método para a mesma ferramenta, escolha apenas um deles.

### Java 21

- [Instalar com o gerenciador de pacotes](01a-install-openjdk21-package-manager.md): `apt` no Linux ou `winget` no Windows.
- [Fazer a instalação manual](01b-install-openjdk21-manual.md), como alternativa em ambos os sistemas.
- [Instalar com um gerenciador de versões](01c-install-openjdk21-version-manager.md): SDKMAN no Linux ou macOS e Scoop no Windows.

### Git e GitHub

- [Instalar o GitHub CLI (`gh`)](01d-install-gh.md).
- [Instalar o Git](01e-install-git.md).
- [Instalar o Git LFS](01f-install-git-lfs.md).

### Ferramentas adicionais

- [Instalar o VS Code com o gerenciador de pacotes](02a-install-vscode-package-manager.md).
- [Instalar o VS Code manualmente](02b-install-vscode-manual.md).
- [Instalar o Docker](01g-install-docker.md).

## 2. Prepare o repositório

Depois de configurar as ferramentas, siga [Preparar repositório da disciplina](03a-prepare-repo.md) para criar sua cópia no GitHub e cloná-la no computador.

## 3. Desenvolva e verifique as atividades

Consulte o guia adequado ao que deseja fazer:

- [Compilar, empacotar, inspecionar e executar um programa Java](04a-run-java-program.md).
- [Executar os testes locais manualmente](04b-run-local-tests-manual.md).
- [Executar os testes locais e gerar a cobertura com JaCoCo](04c-run-local-tests-with-jacoco-manual.md).

Os comandos desses guias devem ser executados no diretório indicado pela própria instrução. Confirme os caminhos da atividade antes de executá-los.

## 4. Faça a entrega

- Para exercícios de programação, siga [Entrega das atividades](03a-submit-assignments.md).
- Para resumos de textos, siga [Entrega das leituras](03b-submit-readings.md).

Antes de enviar, confira a especificação da atividade ou leitura correspondente, pois ela define os requisitos e prazos que complementam estes guias.
