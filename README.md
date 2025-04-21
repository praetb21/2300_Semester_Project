# 2300_Semester_Project

**Project Name:** Military Vehicle Database  
**Team name:** Praet Industries  
**Team member:** Brandon Praet 

A JavaFX-based desktop application designed to store and manage data on military vehicles and defense manufacturers. Built as a course project for CSI 2300 - Object-Oriented Programming, this project demonstrates principles of modular design, file handling, and graphical user interface (GUI) development.

## Features

- **Structured UI** for entering and displaying vehicles and manufacturers.
- **JavaFX TableViews** with custom object classes (`Vehicle`, `Manufacturer`).
- **Plain text (.txt) data persistence** using CSV format.
- **Basic operations**: Add, Save, and Remove entries for both datasets.
- **Object-oriented design** using UML principles and class separation.

---

## Project Structure

- App.java : Main entry point. Sets up the GUI layout and event handlers.
- Vehicle.java : Represents military vehicle objects.
- Manufacturer.java : Represents defense company objects.
- Tables.java : Constructs and configures TableView instances for data display.
- FileHandler.java : Handles loading, saving, and removing data from .txt files.

---

## File Structure

- VehicleInfo.txt : Stores vehicle entries (CSV format).
- ManufacturerInfo.txt : Stores manufacturer entries (CSV format).

Example entry formats:
- M1 Abrams,General Dynamics,4.3,1980,Main Battle Tank 
- GDLS,Sterling Heights,Armored Vehicles,1952

## Usage Instructions
- **Add Entries**: Fill out the text fields and click **Add Vehicle** or **Add Company**.
- **Save Entries**: Click **Save** to write current table data to the '.txt' files.
- **Remove Entries**: Select a row and click **Remove Vehicle** or **Remove Company**.
See the User Manual for full instructions.


