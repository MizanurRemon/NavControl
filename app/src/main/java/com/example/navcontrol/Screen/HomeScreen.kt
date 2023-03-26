package com.example.navcontrol.Screen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.navcontrol.Navigation.Screens
import com.example.navcontrol.Utils.Constants

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(onSendClick: () -> Unit, navController: NavHostController) {

    var message = remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    Scaffold() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(Constants.defaultPadding.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            OutlinedTextField(
                label = {
                    Text(text = "Message")
                },
                value = message.value,
                onValueChange = {
                    message.value = it.toString()
                }, placeholder = {
                    Text(text = "Text Here")
                })

            Divider(
                color = Color.Transparent,
                modifier = Modifier.height(Constants.defaultPadding.dp)
            )

            Button(onClick = {

                if (message.value.isNotEmpty()) {
                    navController.navigate(route = Screens.DATA.name + "/${message.value}")

                } else {
                    Toast.makeText(context, "empty message", Toast.LENGTH_SHORT).show()
//                    Snackbar(backgroundColor = Color.Yellow) {
//                        Text(text = "empty message")
//                    }
                }

            }) {
                Text(text = "Send")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    //HomeScreen(onSendClick = {},})
}