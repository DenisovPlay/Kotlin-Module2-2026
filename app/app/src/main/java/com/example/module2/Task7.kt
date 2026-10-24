package com.example.module2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private val contacts = listOf(
    listOf("Имя: Евгений", "Отчество: Андреевич", "Фамилия: Лукашин", "Мобильный телефон: +7 495 495 95 95", "Адрес: г. Москва, 3-я улица Строителей, д. 25, кв. 12"),
    listOf("Имя: Василий", "Отчество: Егорович", "Фамилия: Кузякин", "Мобильный телефон: ---", "Адрес: Ивановская область, дер. Крутово, д. 4"),
    listOf("Имя: Людмила", "Отчество: Прокофьевна", "Фамилия: Калугина", "Мобильный телефон: +7 495 788 78 78", "Адрес: Москва, Большая Никитская, д. 43, кв. 290")
)

@Preview(name = "portrait", showSystemUi = true)
@Composable
fun ContactColumnPreview() {
    Column {
        contacts[0].forEach { Text(it) }
    }
}

@Preview(name = "portrait", showSystemUi = true)
@Composable
fun ListPreview() {
    Column(Modifier.padding(8.dp)) {
        contacts.forEach { contact ->
            Column(
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                contact.forEach { Text(it) }
            }
        }
    }
}

@Preview(name = "portrait", showSystemUi = true)
@Composable
fun ContactRowPreview() {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally) {
            contacts[0].forEach { Text(it, textAlign = TextAlign.Center) }
        }
        Image(painterResource(android.R.drawable.btn_star_big_on), contentDescription = null)
    }
}
