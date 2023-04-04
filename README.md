# Sudoku Vocab

<h1> User Stories </h1>


    
1. As a novice user of the software, I want to understand and navigate the contents of the game with ease, so that I can play the game and learn a new language.
<br> Status: Complete ✅

    - TDD Examples: 

        - Visible State: When a user opens the app, there is a simple menu with two buttons: new game, and settings. The game title is also present with a background image.
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
<br> Status: Complete ✅ 
    
    - TDD Examples: 

        - Visible State: when the user starts a game, they are presented with  three rows of nine words in the language being studied at the bottom of the screen, below the game board. 

        - User Action: The user clicks on the cell they wish to input the word into.
        - System Response: The selected cell is highlighted.
        - User Action: After clicking on a cell, the user clicks on the word they want to input. 
        - System Response: the selected word appears in the cell that the user selected. 
    <br>
    <img src="https://i.imgur.com/SMzJ2Gm.png" title="mockup2: imgur.com" height="400"/>
    <img src="https://i.imgur.com/ETSKyl0.png" title="mockup2: imgur.com" height="400"/>
    <img src="https://i.imgur.com/kPoeTfv.png" title="mockup2: imgur.com" height="400"/>
    <br>

3. As a novice language learner, I want to be able to delete the words I have inputted from the grid so that I can try other words and fix my mistakes.
<br> Status: Complete ✅
    - TDD Examples: 

        - Visible State: The user is presented with a erase button on the bottom right of the screen next to the grid.
        - User Action: The user clicks on the cell they wish to empty.
        - System Response: The selected cell is highlighted.
        - User Action: After selecting the cell they wish to empty, the user clicks on the erase button.
        - System Response: The word from the selected cell will disappear and the cell will become empty. 
    <br>
    <img src="https://i.imgur.com/CYOesMF.png" title="mockup3: imgur.com" height="400"/>
    <img src="https://i.imgur.com/0zGED4O.png" title="mockup3: imgur.com" height="400"/>
    <img src="https://i.imgur.com/K4TDJc9.png" title="mockup3: imgur.com" height="400"/>
    <br>


4. As a language learning teacher, I want to be able to give the students a hint if they are not sure about a translation so that they can improve their understanding of the language studied. 
<br> Status: Complete ✅

    - TDD Example:
    
        - Visible State: The user is presented with a hint button on the bottom of the screen. 
        - User Action: The user clicks the hint button.
        - System Response: a pop up box appears showing the translation for all words. The pop up box has an okay button at the bottom. 
        - User action: The user clicks on the okay button in the pop-up box to dismiss the hint.
        - System response: the pop up box disappears and the game screen is shown clearly again ready to for the user to continue playing
    <br>
    <img src="https://i.imgur.com/rykRC3C.png" title="mockup4: imgur.com" height="400"/>
    <img src="https://i.imgur.com/WRDY5Iw.png" title="mockup4: imgur.com" height="400"/>
    <br>
    
5. As an intermediate language learner, I want to know if my answer is correct or if I have made any errors so that I can fix my mistakes.
<br> Status: Complete ✅

    - TDD Example:
        - Visible state: At the bottom of the game screen there is a check button
        - User action: Click on the check button.
        - System response: All the incorrect user inputs are erased from the board, while the correct ones remain on the board. 
    
    <br>



6. As an expert language learner, I want to have different difficulty levels so that I can choose the one that fits my ability.
<br> Status: Complete ✅
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

7. As a user, I want to be able to exit the game so that I can start a new game or quit when I need to.
<br> Status: Complete ✅
    - TDD Example:
         - Visible State: in the game page, there is a gear icon at the top right.
        - User Action: The user clicks on the gear icon.
        - System Response: a pop up box appears giving the user four buttons to click; resume, settings, new game, and quit game. 
        - User Action: The user clicks on the quit game button.
        - System Response: A pop up box appears and asks the user if they want to quit the game?
        - User Action: The user choose “No”
        - System Response: The pop up box disappears and the user is able to continue with the settings page.
        - User Action:The user choose “Yes”
        - System Response: Bring the user back to the main menu.
    <br>
    <img src="https://i.imgur.com/NgJmDpw.png" title="mockup7: imgur.com" height="400"/>
    <br>

8.  As a user I want to be able to view the instructions on how to play the game whenever I want. 
<br> Status: Complete ✅
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
<br> Status: Status: Complete ✅

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
10. As a vocabulary learner practicing at home, I want to use my tablet for Sudoku vocabulary practice.
<br> Status: Status: Complete ✅

    - TDD Example:
        - Visible state: The user is presented with bigger words and the app screen fits the tablet screen.
    <br>
    <img src = "https://i.imgur.com/K08qanI.png" title = "mockup10: imgur.com" height="400"/>
    <img src = "https://i.imgur.com/kNNiC2O.png" title = "mockup10: imgur.com" height="400"/>
    <br>
11. As a vocabulary learner taking the bus, I want to use my phone in landscape mode for Sudoku vocabulary practice.
<br> Status: Status: Complete ✅
    - TDD Example:
        - Scenario 1:
            - Visible state: The user is presented with a bigger font when they open the app in landscape mode than when their phone is in portrait mode.
        - Scenario 2:
            - Visible state: When the user open the app with their phone in portrait mode, they are presented with standard mode of Sudoku.
            - User action: The user changes to landscape mode.
            - System response: The game is saved and the user can continue playing in landscape mode. They are presented with a bigger font than when they are in portrait mode.
    <br>
    <img src = "https://i.imgur.com/FiSOJ2b.png" title = "mockup11: imgur.com" height="400"/>
    <img src = "https://i.imgur.com/dZSB3i7.png" title = "mockup11: imgur.com" height="400"/>
    <br>
12. As a teacher of elementary and junior high school children, I want scaled versions of Sudoku that use 4x4 and 6x6 grids.
<br> Status: Complete ✅

    - TDD Example:
        - Visible state: The user is presented with 4 options for the size of the grid: 9x9 (default), 4x4, 6x6, and 12x12 in the settings.
        - User action: The user choose 1 option.
        - System response: The chosen box next to chosen mode is filled with black and the next game the user starts will have the selected mode applied.
        - User action: The user starts a new game.
        - System response: 
            - Scenario 1: The user chose 4x4 grid.
                - The application releases a new game, the overall grid id divided into squares of 4 cells each
            - Scenario 2: The user chose 6x6 grid.
                - The application releases a new game, the overall grid should be divided into rectangles of six cells each (2x3).
    <br>
    <img src = "https://i.imgur.com/7fJDQmp.png" title = "mockup12: imgur.com" height="400"/>
    <img src = "https://i.imgur.com/wlpcHpT.png" title = "mockup12: imgur.com" height="400"/>
    <img src = "https://i.imgur.com/NBac6qW.png" title = "mockup12: imgur.com" height="400"/>
    <img src = "https://i.imgur.com/zKfcuZi.png" title = "mockup12: imgur.com" height="400"/>
    <br>
13. As a vocabulary learner who wants extra challenging mode, I want a 12x12 version of Sudoku to play on my tablet.
 <br> Status: Complete ✅ 
    - TDD Example:
        - Visible state: The user is presented with 4 options for the size of the grid: 9x9 (default), 4x4, 6x6, and 12x12 in the settings.
        - User action: The user choose 12x12.
        - System response: The chosen box next to chosen mode is filled with black and the next game the user starts will have the selected mode applied.
        - User action: The user starts a new game.
        - System response: The application releases a new game, the overall grid will be divided into rectanglesof 12 cells each (3x4).
    <br>
    <img src = "https://i.imgur.com/7fJDQmp.png" title = "mockup13: imgur.com" height="400"/>
    <img src = "https://i.imgur.com/LraCeFq.png" title = "mockup13: imgur.com" height="400"/>
    <br>
14. As a student who wants to practice my understanding of spoken words in the language that I am learning, I want a listening comprehension mode.
    - TDD Example:
        - Visible state: The user is presented with a setting button in the main menu / game page.
        - User Action: The user clicks on the setting button.
        - Visible state: In the settings page, there is an option to turn on listening comprehension mode or not
        - User Action: The user chooses “On”.
        - System Response: The checkbox next to “On” is filled.
        - User Action: The user starts a new game
        - Visible state: When user is in a game, numbers will appear in the prefilled cells.
        - User action: The user presses the number
        - System response: the corresponding word in the language that the user is learning will be read out to him. The user can then test his listening comprehension by selecting from the menu the correct English translation of the word.
    <br>
    <img src = "https://i.imgur.com/84tOYY6.png" title = "mockup14: imgur.com" height="400"/>
    <br>

    



