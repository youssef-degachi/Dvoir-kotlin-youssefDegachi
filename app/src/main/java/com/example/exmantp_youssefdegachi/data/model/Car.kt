package com.example.exmantp_youssefdegachi.data.model

class Car {
    val id: Int
    val name: String
    val mark: String
    val price: Double
    val description: String

    constructor(id: Int, name: String, price: String, mark: String, description: String) {
        this.id = id
        this.name = name
        this.mark = mark
        this.price = price
        this.description = description
    }
}