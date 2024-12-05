package com.example.exmantp_youssefdegachi

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import com.example.exmantp_youssefdegachi.data.Database
import com.example.exmantp_youssefdegachi.data.model.Car

@Composable
class addCar (dbHelper: Database,car:Car) {

    val name = remember { mutableStateOf("") }
    val mark = remember { mutableStateOf("") }
    val price = remember { mutableStateOf(0.0) }
    val description = remember { mutableStateOf("") }
    val dbHelper = Database()


    Column(Modifier.fillMaxSize().padding(16.dp)) {
        TextField(value = name.value, onValueChange = { name.value = it }, label = { Text("Name") })
        TextField(value = mark.value, onValueChange = { mark.value = it }, label = { Text("Mark") })
        TextField(value = price.value, onValueChange = { price.value = price }, label = { Text("Price") })
        TextField(value = description.value, onValueChange = { description.value = it }, label = { Text("Description") })

        Button(onClick = {
            dbHelper.insertCar(name.value, mark.value, price.value.toFloat(), description.value.toInt())
            onAddCar()
        }) {
            Text("Save Student")
        }
    }
}