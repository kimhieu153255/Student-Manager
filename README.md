#Student Management System
##Author
**_FB: [Le Kim Hieu - 20120474](https://www.facebook.com/hopwj/)_**

## Description

This is a student management system that allows you to add, edit, delete, view students and export them to a csv file.

## Structure

- **`bin`** contains binary file `Input.bin`.
- **`lib/exportCSV`** contains the code for exporting to a csv file.
- **`lib/Img`** contains the Avatars used in the program.
- **`src`** contains the source code for the program.
  - **`controller`** contains the code for the controller.
  - **`model`** contains the code for the Student model.
  - **`renderer`** contains the code for the renderer. It converts path into a Image.
  - **`App.java`** contains the main method.

## How to run

- Run **`App.java`** to start the program.

## Features

- Add a student:
  - Click on the **`Add`** button in main screen.
  - Fill in the information (exception: ID must be unique, **`mark`** and **`note`** can empty ).
- Edit a student:
  - Click on the **`Edit`** button in main screen.
  - Select the student you want to edit by entering the **`ID`** of Student.
  - Change the information you want.
- Delete a student:
  - Click on the **`Delete`** button in main screen.
  - Select the student you want to delete by entering the **`ID`** of Student.
- Export to a csv file:
  - Click on the **`Export`** button in main screen.
  - Select the folder you want to export to.
  - Enter the name of the file **`CSV`**.
  - Click on the **`Export`** button.
- Import from a csv file:
  - Click on the **`Import`** button in main screen.
  - Select the file you want to import.
  - Click on the **`Import`** button.
- Sort by ID or Mark:
  - Click on the _Header table_ **`ID`** or **`Mark`** in Table.

## Thank you for reading!
