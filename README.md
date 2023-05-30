# NetworkPing
Application qui simplifie le changement d'adresse ip et qui scan son réseau, permettant ainsi d'identifier selon adresse mac un modèle précis définis. L'application va effectuer un ping aux 40 premières adresses du réseau et, en fonction du paramètre pré-définis (Hanwha, Uniview, Tout), on affichera en conséquence les équipements correspondants.

[![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)]()

---

## 📌 Aperçu

![Apercu](https://github.com/clementolivierdev/NetworkPing/blob/main/githubResources/CaptureIHM.PNG)

---

## ▶️ Fonctionnalités
L'utilisateur peut :
- Changer son adresse IPv4 en statique
- Changer son adresse IPv4 en dynamique
- Ping les 40 premières adresses de son réseau
- Afficher un type d'équipement précis

Liste des équipements détectables :

| Nom du modèle   | Fonctionne    |
|-----------------|---------------|
| Hanwha          | oui           |
| Uniview         | à confirmer   |
| Planet          | à confirmer   |
| Antennes        | non           |

Dernière version stable: **```1.2.8```**

---

## ✔️ Téléchargement

#### ⚠️ Fonctionnement

Pour que l'application fonctionne, il est impératif de garder le fichier ```elevate.exe``` à la racine du dossier. L'application ```.jar``` en a besoin pour effectuer une commande qui requiert les droits administrateurs.

#### 💻 Application

La dernière version stable de l'application est téléchargeable [ici](https://github.com/clementolivierdev/NetworkPing/releases/download/1.2.8/LogicielNetworkPing.rar) dans un fichier rar, pensez à extraire le dossier pour utiliser l'application ```NetworkPing-1-2-8-SNAPSHOT.jar``` .

---

## 🆘 Problèmes

En cas d'erreur, n'hésitez pas à [créer une demande](https://github.com/clementolivierdev/NetworkPing/issues/new) avec les détails qui conviennent pour que je puisse le corriger.

---

## 🔜 A l'avenir

`1. Classes Test`
`2. Ajout d'autre type de modèle`
