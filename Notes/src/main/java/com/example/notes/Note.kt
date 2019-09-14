package com.example.notes

class Note {

    private var title: String = ""
    private var description: String = ""

    constructor(){

    }

    constructor(title: String, description: String) {
        this.title = title
        this.description = description
    }

    fun getTitle(): String {
        return title
    }

    fun getDescription(): String {
        return description
    }
}


