package com.example.exmantp_youssefdegachi

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.example.exmantp_youssefdegachi.ui.theme.ExmanTpYoussefDegachiTheme

import androidx.compose.ui.unit.dp
import com.example.exmantp_youssefdegachi.data.Database
import com.example.exmantp_youssefdegachi.data.model.Car

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExmanTpYoussefDegachiTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    UserCarScreen(this)
                }
            }
        }
    }
}
@Composable
fun UserCarScreen(context: Context) {
    var name by remember { mutableStateOf("") }
    var mark by remember { mutableStateOf("") }
    var price by remember { mutableStateOf<Double?>(null) }
    var description by remember { mutableStateOf("") }
    var car = new Car(name,mark,price,description)
    val dbase = Database(context)

    LaunchedEffect(Unit) {
        mark = dbase.getAllCars().toString()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Donnée") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (price != null) {
                dbase.updateCar(car)
                price = null
            } else {
                dbase.insertCar(name)
            }
            name = ""
            lsitcar = dbase.getAllCars().toString()
        }) {
            Text(if (price == null) "Enregistrer" else "Modifier")
        }

        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(lsitcar) { car ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text( car, modifier = Modifier.align(Alignment.CenterVertically))

                    Button(onClick = {
                        price = car.price
                        name = car.name
                    }) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Modifier")
                    }

                    Button(onClick = {
                        dbase.deleteCar(car)
                        lsitcar = dbase.getAllCars()
                    }) {
                        Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Supprimer")
                    }

                }
            }
        }
    }
}


//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            ExmanTpYoussefDegachiTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//                getCar(db)
//            }
//            }
//        }
//    }
//}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ExmanTpYoussefDegachiTheme {
//        Greeting("Android")
//    }
//}