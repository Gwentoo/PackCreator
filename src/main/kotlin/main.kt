import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import pack.Pack
import utils.loadJsonFileAsMap
import view.mainScreen

@Composable
@Preview
fun app() {

    mainScreen()

}

fun main() = application {

    Window(
        onCloseRequest = ::exitApplication,
        title = "PackCreator",
        icon = painterResource("icon.png"),
        state = WindowState(width = 1920.dp, height = 1080.dp)
        ) {
        app()
    }




}
