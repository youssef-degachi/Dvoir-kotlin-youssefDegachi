package com.example.exmantp_youssefdegachi

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.exmantp_youssefdegachi.data.Database
import com.example.exmantp_youssefdegachi.data.model.Car

fun CarDetail(dbHelper: Database,car:Car){
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Name: ${car.name}")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Email: ${car.mark}")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Age: ${car.price}")
        Spacer(modifier = Modifier.height(16.dp))
        Text("description: ${car.description}")
        Spacer(modifier = Modifier.height(16.dp))
        Image(painter = painterResource(id = R.drawable.ic_launcher_background.xml),

        Button(onClick = {
            dbHelper.deleteCar(car.id)
            onDelete()
        }) {
            Text("Delete Student")
        }
    }
}