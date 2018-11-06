Plants vs Zombie Puzzle Simulation Authors: 
Alexander Johns,Pragya Singh,Noor Ncho,Johan Westeinde

This is out milestone 2 code for Plants vs Zombie Puzzle Simulation. In this phase there is an added GUI, which allows the user to have a more interactive and personal feel with the game. The UML and sequence diagrams have been modified from iteration one in order to add in the interaction between the controller view and model. 

                                          The Design
The design pattern that was used to implement this GUI is MCV. The controller updates the GUI based, on player input while updating and keeping track of health of the flower, the balance of the player’s sun points and the attack and health of the zombies. 
The Gui is composed of a grid layout that has buttons that are landmarks that represent possible locations a player may want to plant a peashooter or a sunflower but not both. After clicking on the grid another window will pop up allowing the player to choose what they would like to plant, confirming that they are able to purchase this item with their current balance while outputting a message if they are able to based on their balance, so that the player knows why they are able to or not able to purchase a plant of their choosing. 
The reason our GUI is composed of two classes is to ensure that there is high cohesion, and low coupling. Each class is encourage of one frame and not both as they both have different functions. The main frame purpose is to pick where to put the plants and show the user where they have placed the plants. While the choice frame purpose function is to pick which plant the player would like to plant. The controller allows the view(GUI) to work independently of the model ( all the plant, zombie classes) as they are not aware of each other but the controller is as it passes information in between the view and the model. 

                                              Roles
Milestone 1:
UML Diagram- Pragya and Johan
Sequence Diagram- Noor and Alexander
All Plant related classes- Pragya and Noor
Any Zombie and game board related classes- Alexander and Johan
Refactoring and Java Docs: Everyone

Milestone 2:
View Classes( ButtonLayout, BLayout)- Pragya Singh 
Controller- Noor, Pragya, Johan, Alexander 
UML Diagrams-Pragya
Testing-
Read Me-Pragya 
                                                  Change log 
	New: 
	Visual Improvement
          There will now be an interactive visual view of the bored. Where by users are able to put their desired piece on the board (sunflower plant/pea plants) and view the health of these pieces as the game progresses. They will also be able to find out when the waves of zombies will appear due to a simple message that will indicate the zombies attacking.  
	Fixed:
	Changed: The main class is now a different class as this class is now in charge of initializing the view, model and controller class as they all need to be initialized in order for the game to start properly.
	Developer: What is this?
	Unresolved:
Known Issues: do we need this ?
Road Map:
	Next Deliverable: To create and implement the game so that the player is able to choose from a variety of different plants and types of zombies, while adding in a redo button, that can be used as many times as possible.
	

