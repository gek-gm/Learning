# Random Presenter

Random presenter is a command line java based tool. It allows to select random presenters from a participant list provided as csv file. 
It also keeps track of the absent participants history of each execution.

# Usage

usage: java -jar [RandomPresenter.jar] [PARTICIPANTS_CSV_FILE] 

[PARTICIPANTS_CSV_FILE] is the participants csv list, it must include headers row, fields are first name, last name and whether the participant is absent or not.
A sample participants csv file is provided with the release.

CSV file Example:
**firstName,lastName,absent**
John,Doe,true
Terry,ivan,

Note: "absent" possible value are "false" or "true", fallback value is false

Command line example:
java -jar RandomPresenter.jar myParticipantsList.csv


## Pick random Presenter from the list
The main menu of Random Presenter provides 3 command:
* pick random presenter from the participants list
Extract a random presenter from the participants list. Any random presenter can be extracted only once until the list is reset.
* reset participants list
Reset the status of the participants list as if nobody was picked up yet.
* exit
Exit the program

## Absence history
The absent participants will be saved in a csv file in the current user's working directory, 
the user executing the program must have write permission on it. 
Every time that the program is executed with a valid input the csv file will be updated



