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
                card.country.numeric?.let {
                    Text(stringResource(R.string.numeric) + it.toString())
                }
                card.country.alpha2?.let {
                    Text(stringResource(R.string.alpha2) + it.toString())
                }
                card.country.name?.let {
                    Text(stringResource(R.string.name) + it.toString())
                }
                card.country.emoji?.let {
                    Text(stringResource(R.string.emoji) + it.toString())
                }
                card.country.currency?.let {
                    Text(stringResource(R.string.currency) + it.toString())
                }
                card.country.latitude?.let {
                    Text(stringResource(R.string.latitude) + it.toString())
                }
                card.country.longitude?.let {
                    Text(stringResource(R.string.longitude) + it.toString())
                }
            }
        }
        Row {
            TitleText(stringResource(R.string.bank))
            Column {
                card.bank.name?.let {
                    Text(stringResource(R.string.name) + it.toString())
                }
                card.bank.url?.let {
                    Text(stringResource(R.string.url) + it.toString())
                }
                card.bank.phone?.let {
                    Text(stringResource(R.string.phone) + it.toString())
                }
                card.bank.city?.let {
                    Text(stringResource(R.string.city) + it.toString())
                }
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