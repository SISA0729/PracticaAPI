# 🌍 PracticaAPI – Kotlin Multiplatform Project

Este proyecto fue desarrollado por **Alejandro, Johan y SISA** como parte de una práctica de programación usando **Kotlin Multiplatform**, apuntando a la creación de aplicaciones para **Android, Web y Escritorio** desde un solo código base. 💻📱🌐

---

## 🚀 Descripción

`PracticaAPI` es un proyecto estructurado con Kotlin Multiplatform + Compose para desarrollar interfaces que se adapten a distintos sistemas desde una única base lógica.  
Está orientado a la práctica del uso compartido de código (shared code) y compilación en distintos targets como Android, navegador y escritorio.

---

## 🛠️ Tecnologías Usadas

- 🧠 **Kotlin Multiplatform**
- 🖌️ **JetBrains Compose Multiplatform**
- ⚙️ **Gradle Kotlin DSL**
- 🌐 **WebAssembly (para la versión web)**

---

## 📁 Estructura del Proyecto

├── composeApp/ # Código compartido entre plataformas │ ├── commonMain/ # Lógica común │ └── otrosTargets/ # Código específico por plataforma ├── kotlin-js-store/ # Almacenamiento web (JS) ├── build.gradle.kts # Configuración del proyecto ├── settings.gradle.kts # Configuración general ├── README.md # Este archivo

---

## ▶️ Cómo ejecutar

1. Clona el repositorio:

```bash
git clone https://github.com/SISA0729/PracticaAPI.git
cd PracticaAPI
