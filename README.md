# OOP-JAVA
Connect Four – Java Swing

Overview:

  This project is a two-player Connect Four game implemented in Java using Swing. The goal was to build a clean, interactive GUI application while applying object-oriented design, event-driven programming, and basic game logic.
  Players alternate turns dropping pieces into a 6×7 grid. The program handles valid placement, detects winning conditions, and resets the game when it ends.


Key Features:
  
  Interactive GUI built with JFrame, JButton, and GridLayout
  Standard Connect Four board (6 rows × 7 columns)
  Turn-based gameplay with automatic turn switching
  Piece placement logic that simulates gravity


Win detection in all directions:
  
  Horizontal
  Vertical
  Diagonal (both directions)
  Detection of full columns and full board states
  Automatic game reset after completion


Implementation Details:
  
  The board is represented as a JButton[][], allowing direct mapping between UI elements and game state.
  User input is handled through ActionListener, enabling real-time interaction.
  Color values (RED, YELLOW, and light blue for empty cells) are used to track board state.
  Win checking is done by scanning the grid and evaluating all valid four-in-a-row combinations.
  The game resets cleanly without restarting the application.


How to Run:

Ensure Java (JDK) is installed.

Place the file in the correct package structure:
  gui/Project_Two.java

Compile:
  javac gui/Project_Two.java

Run:
  java gui.Project_Two


Skills Demonstrated:
  Object-oriented programming in Java
  Event-driven programming
  GUI development with Swing
  Control flow and condition checking
  Debugging and logical problem solving
  Writing maintainable, readable code
  

Author: Mashroof Samin
