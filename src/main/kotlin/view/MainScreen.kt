package view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pack.Pack

import utils.loadJsonFileAsMap


@Composable
fun mainScreen(){
    var expanded by remember { mutableStateOf(false) }
    val pack = Pack(loadJsonFileAsMap("D:\\Progs\\PackCreator\\src\\main\\kotlin\\pack\\testPack\\test.json"))
    var name by remember { mutableStateOf("Название пака") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("PackCreator") },
                actions = {
                    // Элемент меню "Файл"
                    IconButton(onClick = { expanded = !expanded }) {
                        Text("Файл")
                    }
                    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                        DropdownMenuItem(onClick = {

                            expanded = false
                        }) {
                            Text("Открыть")
                        }
                        DropdownMenuItem(onClick = {

                            expanded = false
                        }) {
                            Text("Сохранить")
                        }
                        DropdownMenuItem(onClick = {

                            expanded = false
                        }) {
                            Text("Выход")
                        }
                    }
                }
            )
        },
    ) {

        Box(
            modifier = Modifier.fillMaxSize().padding(30.dp),
        ) {


            Box(modifier = Modifier.width(155.dp).height(215.dp).border(2.dp, Color.Black)){

                Row(modifier = Modifier
                    .height(60.dp)
                    .width(155.dp)
                    .border(2.dp, Color.Black))
                {
                    TextField(

                        value = name,
                        onValueChange = {name = it},
                        modifier = Modifier
                            .fillMaxSize(),
                        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent, cursorColor = Color.Red),
                        textStyle = TextStyle(
                            fontWeight = FontWeight.ExtraBold,
                            //textAlign = TextAlign.Center,
                            fontSize = when {
                                name.length > 20 -> 11.sp
                                name.length > 15 -> 13.sp
                                name.length > 10 -> 14.sp
                                else -> 20.sp
                            })
                    )
                }
            }

        }
    }




}