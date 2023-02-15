# Sudoku Vocab

<h1> User Stories </h1>


    
1. As a novice user of the software, I want to understand and navigate the contents of the game with ease, so that I can play the game and learn a new language.
    - TDD Examples: 

        - Visible State: When a user opens the app, there is a simple menu with three buttons: new game, settings, resume, and instructions. The game title is also present with a background image.
        - User Action: The user presses the new game button. 
        - System Response: The game board appears on the screen with columns and rows. Words from the user’s native language are scattered across the board and a list of possible words in the language of instruction are presented at the bottom of the screen for the user to choose from. 
        - (note: in the mockup images, the words in the users native language are replaced with numbers for universal accessiblity)
        - Visible State: in the game page, there is a gear icon at the top right.
        - User Action: The user clicks on the gear icon.
        - System Response: a pop up box appears giving the user four buttons to click; resume, settings, new game, and quit game. 

    <br>
    <img src="https://i.imgur.com/NO6Gu9u.png" title="mockup1: imgur.com" height="400"/>
    <img src="https://i.imgur.com/SMzJ2Gm.png" title="mockup1: imgur.com" height="400"/>
    <img src="https://i.imgur.com/w2oJ6Ln.png" title="mockup4: imgur.com" height="400"/>

    <br>
2. As a user, I want to be presented with a list of the possible words I need to input into the grid so that I can finish the game.
    - TDD Examples: 

        - Visible State: when the user starts a game, they are presented with  three rows of nine words in the language being studied at the bottom of the screen, below the game board. 
        - User Action: The user clicks on the word they wish to input located at the bottom half of the screen.
        - System Response: The selected word is highlighted.
        - User Action: After clicking on a word, the user clicks on an empty spot in the grid. 
        - System Response: the selected word appears in the cell that the user selected 
    <br>
    <img src="https://i.imgur.com/SMzJ2Gm.png" title="mockup2: imgur.com" height="400"/>
    <img src="https://i.imgur.com/ETSKyl0.png" title="mockup2: imgur.com" height="400"/>
    <img src="https://i.imgur.com/kPoeTfv.png" title="mockup2: imgur.com" height="400"/>
    <br>

3. As a novice language learner, I want to be able to delete the words I have inputted from the grid so that I can try other words and fix my mistakes.

    - TDD Examples: 

        - Visible State: The user is presented with a delete button on the bottom right of the screen next to the grid.
        - User Action: The user clicks on the cell they wish to empty.
        - System Response: The selected cell is highlighted.
        - User Action: After selecting the cell they wish to empty, the user clicks on the delete button.
        - System Response: The word from the selected cell will disappear and the cell will become empty. 
    <br>
    <img src="https://i.imgur.com/CYOesMF.png" title="mockup3: imgur.com" height="400"/>
    <img src="https://i.imgur.com/0zGED4O.png" title="mockup3: imgur.com" height="400"/>
    <img src="https://i.imgur.com/K4TDJc9.png" title="mockup3: imgur.com" height="400"/>
    <br>


4. As a language learning teacher, I want to be able to give the students a hint if they are not sure about a translation so that they can improve their understanding of the language studied. 
    - TDD Example:
    
        - Visible State: The user is presented with a hint button on the bottom of the screen. 
        - User Action: The user clicks on the word they need a hint about
        - System Response: The selected word is highlighted.
        - User Action: The user clicks the hint button after selecting the desired word
        - System Response: a pop up box appears showing the translation for that word. The pop up box has an okay button at the bottom. 
        - User action: The user clicks on the okay button in the pop-up box to dismiss the hint.
        - System response: the pop up box disappears and the game screen is shown clearly again ready to for the user to continue playing
    <br>
    <img src="https://i.imgur.com/rykRC3C.png" title="mockup4: imgur.com" height="400"/>
    <img src="https://i.imgur.com/WRDY5Iw.png" title="mockup4: imgur.com" height="400"/>
    <br>
    
5. As an intermediate language learner, I want to know when I have finished the puzzle, if my answer is correct or if I have made any errors so that I can fix my mistakes.
    - TDD Example:
        - Visible state: If the user has completed the game and solved the puzzle correctly:
            - A screen appears, congratulating the user on completing the puzzle correctly with an "okay" button to exit the game.
        - If the user has completed the game but made mistakes while solving the puzzle:
            - No pop up box appears indicating the game is not yet finished.
        - User action: Click the exit button if there’s a pop up box.
        - System response: Bring the user back to the main menu. 
    
    <br>
    <img src="https://i.imgur.com/wpx8KnS.png" title="mockup5: imgur.com" height="400"/>
    <br>


6. As an expert language learner, I want to have different difficulty levels so that I can choose the one that fits my ability.
    - TDD Example:
       
        - Visible state: The user is presented with a setting button in the main menu and in the game page at the top right.
        - User Action: The user clicks on the setting button.
        - System Response: The setting page appears on the screen.
        - Visible state: The user is presented with 3 modes: default, intermediate, expert, and a save changes button.
        - User Action: The user chooses the mode they want and presses "save changes".
        - System Response: The chosen box next to chosen mode is filled with black and the next game the user starts will have the selected mode applied
    <br>
    <img src="https://i.imgur.com/9QdF8hr.png" title="mockup4: imgur.com" height="400"/>
    <br>

7. As a user, I want to be able to exit the game so that I can start a new game or quit when I need to 
    - TDD Example:
        - Visible state: The user is presented with an exit button in the game page.
        - User Action: The user clicks on the exit button.
        - System Response: A pop up box appears and asks the user if they want to exit the game?
        - User Action: The user choose “No”
        - System Response: The pop up box disappears and the user is able to continue with the game.
        - User Action:The user choose “Yes”
        - System Response: Bring the user back to the main menu.
    <br>
    <img src="https://i.imgur.com/NgJmDpw.png" title="mockup7: imgur.com" height="400"/>
    <br>

8.  As a user I want to be able to view the instructions on how to play the game whenever I want. 

    - TDD Example:
        - Visible state: The user is presented with a setting button in the main menu / game page.
        - User Action: The user clicks on the setting button.
        - System Response: The setting page appears on the screen.
        - User Action: The user clicks on the ‘How to play?’ button
        - System Response: A pop up appears giving the detailed instructions on how to play the game. 
    <br>
    <img src="https://i.imgur.com/9QdF8hr.png" title="mockup8: imgur.com" height="400"/>
    <img src="https://i.imgur.com/qx2jzsJ.png" title="mockup8: imgur.com" height="400"/>
    <br>

9. As a user, I want a timer so that I can know how much time I spent on the game.
    - TDD Example:

        - Visible state: The user is presented with a setting button in the main menu / game page.
        - User Action: The user clicks on the setting button.
        - Visible state: In the settings page, there is an option to show a timer or not
        - User Action: The user chooses “On”.
        - System Response: The checkbox next to “On” is filled. There is a timer on the top left of the game page if the user starts a new game. If the user completes the game, the congratulations page shows their total time. 
        
    <br>
    <img src="https://i.imgur.com/9QdF8hr.png" title="mockup9: imgur.com" height="400"/>
    <img src="https://i.imgur.com/SMzJ2Gm.png" title="mockup9: imgur.com" height="400"/>
    <img src="https://i.imgur.com/wpx8KnS.png" title="mockup9: imgur.com" height="400"/>
    <br>





    



