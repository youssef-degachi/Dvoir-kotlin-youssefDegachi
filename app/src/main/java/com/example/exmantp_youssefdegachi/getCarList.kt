package com.example.exmantp_youssefdegachi

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.exmantp_youssefdegachi.data.Database
import com.example.exmantp_youssefdegachi.data.model.Car

@Composable
class getCarList(dbHelper:Database,car:Car ,onAddCar: ()-> getCarList) {
    val car = remember { mutableStateOf(dbHelper.getAllCars()) }

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Button(onClick = onAddCar, Modifier.fillMaxWidth()) {
            Text("Add Student")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (car.value.isEmpty()) {
            Text("No cars available", style = MaterialTheme.typography.bodyLarge)
        } else {
            LazyColumn {
                items(car.value) { car ->
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onAddCar(car) }
                        .padding(8.dp)) {
                        Text(car.name, Modifier.weight(1f))
                        Text("name${car.name}")
                        Text("description${car.description}")
                        Text("mark${car.mark}")
                        Text("price${car.price}")
                    }
                }
            }
        }
    }
}