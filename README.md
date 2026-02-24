# 📇Contact App
📌 Description

Contact App is a simple Android application developed using Java and SQLite that allows users to store and manage contact information. The app provides basic contact management features such as adding, viewing, updating, and deleting contacts. It has alphabetical sorting and a clean modern UI.

🚀 Features
- ✅ Add new contacts
- ✅ Edit existing contacts
- ✅ View all saved contacts
- ✅ Alphabetical sorting (A–Z)
- ✅ Underlined contact item design
- ✅ SQLite local database storage
- ✅ Clean and responsive UI
- ✅ RecyclerView implementation

🛠 Tech Stack
- **Language:** Java  
- **Database:** SQLite  
- **UI Components:** RecyclerView, FloatingActionButton  
- **IDE:** Android Studio

📂 Project Structure
app/
├── manifests/
│ └── AndroidManifest.xml
│
├── java/com/example/contact/
│ ├── activities/
│ │ ├── MainActivity.java
│ │ └── AddEditContactActivity.java
│ │
│ ├── adapter/
│ │ └── ContactAdapter.java
│ │
│ └── database/
│ └── DBHelper.java
│
└── res/
├── layout/
│ ├── activity_main.xml
│ ├── activity_add_edit.xml
│ └── item_contact.xml
└── drawable/

🛠 How It Works
-DBHelper.java handles SQLite database creation and CRUD operations.
-MainActivity.java displays a sorted list of contacts in a RecyclerView.
-AddEditContactActivity.java provides UI to add or edit contact details.
-ContactAdapter.java populates the RecyclerView and designs each item.

🚀 Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/Swosti-Makaju/Contact_App.git
2.Open in Android Studio
3.Let Gradle sync
4.Run on emulator or physical device

📸 Screenshots
<img width="342" height="714" alt="image" src="https://github.com/user-attachments/assets/f62f9d93-b989-41dc-84dc-e77515baa86f" />
<img width="343" height="703" alt="image" src="https://github.com/user-attachments/assets/0965edce-8511-4326-9fb9-098607c2eff7" />

