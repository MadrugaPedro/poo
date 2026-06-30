#!/bin/bash
set -euo pipefail

# Diretório base do repositório
BASE_DIR="$(pwd)"

echo "🧹 Limpando diretórios submissions em assignments/ (mantendo .gitkeep)..."
if [ -d "${BASE_DIR}/assignments" ]; then
  find "${BASE_DIR}/assignments" -type d -name submissions | while read -r submission_dir; do
    find "$submission_dir" -mindepth 1 -not -name ".gitkeep" -exec rm -rf {} +
  done
fi

echo "🧹 Limpando binários temporários de submissões em assignments/..."
if [ -d "${BASE_DIR}/assignments" ]; then
  find "${BASE_DIR}/assignments" -path "*/submissions/*/bin" -type d -exec rm -rf {} +
fi

echo "🧹 Limpando arquivos enviados em assignments/03-readings/ (mantendo .gitkeep)..."
if [ -d "${BASE_DIR}/assignments/03-readings" ]; then
  find "${BASE_DIR}/assignments/03-readings" -mindepth 2 -type f -not -name ".gitkeep" -exec rm -f {} +
fi

echo "🧹 Limpando arquivos enviados em assignments/05-prompts/..."
if [ -d "${BASE_DIR}/assignments/05-prompts" ]; then
  find "${BASE_DIR}/assignments/05-prompts" -mindepth 1 \
    -not -name "README.md" \
    -not -name "00-context.md" \
    -not -name "01-introduction.md" \
    -not -name "02-basic-elements.md" \
    -not -name "03-control-structures.md" \
    -not -name "04-object-oriented.md" \
    -not -name "05-arrays-arraylist.md" \
    -not -name "06-exception.md" \
    -not -name "07-collections.md" \
    -not -name "08-file.md" \
    -not -name "09-jdbc.md" \
    -exec rm -rf {} +
fi

echo "✅ Limpeza concluída para a estrutura atual do repositório."
