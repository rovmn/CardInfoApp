package com.example.cardinfoapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.cardinfoapp.R
import com.example.cardinfoapp.domain.model.Card

@Composable
fun CardInfoView (
    card: Card,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = colorResource(R.color.gray),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(4.dp)
    ) {
        card.scheme?.let {
            Row {
                TitleText(stringResource(R.string.scheme))
                Text(card.scheme)
            }
        }
        card.type?.let{
            Row {
                TitleText(stringResource(R.string.type))
                Text(card.type)
            }
        }
        card.brand?.let {
            Row {
                TitleText(stringResource(R.string.brand))
                Text(card.brand)
            }
        }
        card.prepaid?.let {
            Row {
                TitleText(stringResource(R.string.prepaid))
                Text(card.prepaid.toString())
            }
        }
        Row {
            TitleText(stringResource(R.string.country))
            Column {
                Text(card.country.numeric?.toString() ?: "")
                Text(card.country.alpha2?.toString() ?: "")
                Text(card.country.name?.toString() ?: "")
                Text(card.country.emoji?.toString() ?: "")
                Text(card.country.currency?.toString() ?: "")
                Text(card.country.latitude?.toString() ?: "")
                Text(card.country.longitude?.toString() ?: "")
            }
        }
        Row {
            TitleText(stringResource(R.string.bank))
            Column {
                Text(card.bank.name?.toString() ?: "")
                Text(card.bank.url?.toString() ?: "")
                Text(card.bank.phone?.toString() ?: "")
                Text(card.bank.city?.toString() ?: "")
            }
        }
    }
}

@Composable
private fun TitleText (
    text: String
) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold
    )
}