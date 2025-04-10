/*
PROJECT: NOTE HANDLER 
Version: 0.0
DESCRIPTION: THis program emulates the basic functionalities of a simple Note-taking App.
The basic CRUD functions work correctly showing the content of the note-app in realtime. 
Author: Rosana Garcia
Date: 9/04/2025
*/

/* 
CLASS NAME: NOTE
PROPERTIES:
    - description: is the text body of the note
    - id: Unique identifier of the Note Class inside the list
    - index: Note position inside the Note List
*/ 
class Note(var description: String, var id: Int, var index: Int) {

}


/* 
CLASS NAME: QUERY
DESCRIPTION: This list contains all notes written by the user
CRUD functions are developed as functionalities of the Query
PROPERTIES:
    - NoteList: ArrayList of Notes the pricipal object of the project 
    - index: the number of elements that have been added regardless they
    have been deleted or not.
*/ 
class Query{

    val NoteList: ArrayList<Note> = ArrayList<Note>()
    var index = 0

    // Add a Note to the List
    fun add(item: Note) {
        item.id = index + 1
        NoteList.add(item)
        index = index + 1
        
    }
    // Create a new note to be added to the main list
    fun createNote() {
        print(">> ")
        var content = readln()
        var len = NoteList.size
        var nota = Note(content, -1, len)
        add(nota)
    }

    // displays the current list of notes with their respective positions
    fun showCurrentList(){
        if(NoteList.size > 0){
            for (x in NoteList) {
                println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
                var i = x.index
                print("[$i] - ")
                println(x. description)
              }  
            println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
        }

    }

    // delete the note in the indicated position
    fun delete() {
        if (NoteList.size > 0){
            print("Insert note's Index (between []): ")
            //Index of the Note on the List
            var ind = readln().toInt()
            // 
            NoteList.removeAt(ind)
            
            //length of List after remove element 
            var top = NoteList.size - 1
            for (i in ind..top) {
                NoteList[i].index = i
            }
        }
        else{
            println("There are no current notes")
        }
    }

    // change the content of a selected note 
    fun update() {
        println()
        
        print("Insert the updating note's Index (between []): ")
        //Index of the Note on the List
        var ind = readln().toInt()

        print("(By continue previous note will be erased. Yes (y) No (anyother key): ")
        val option = readln()
        if(option == "y"){
            print("Insert note's Index (between []): ")
            //Index of the Note on the List
            var ind = readln().toInt()
            print(">> ")
            var content = readln()
            NoteList[ind].description = content
        }
    }
}

fun menu(notes: Query){

    var i = -1

    while ( (i != 0)  ) {
        println("WELLCOME TO THE MAINBOARD!")
        println()
        println("1- Add Note")
        println("2- Delete Note")
        println("3- Update Note")
        println("4- Display current notes")
        println("0- exit")

        notes.showCurrentList()
    
        print("Select an Option (insert the number): ")
        i = readln().toInt()

        when (i) {
            1 -> notes.createNote()
            2 -> notes.delete()
            3 -> notes.update()
            else -> println("Invalid input.")
          }

          println()
          println()
          println()

      } 
}

fun main(args: Array<String>) {

    val Q1 = Query()
    
    //var len1 = Q1.NoteList.size
    //println(len1)

    //Q1.add(t1)
    //Q1.add(t2)

    //len1 = Q1.NoteList.size
    //println(t1.description)
    //println(len1)

    menu(Q1)
} 
