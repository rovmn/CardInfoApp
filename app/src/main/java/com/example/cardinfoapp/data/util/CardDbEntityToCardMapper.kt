package com.example.cardinfoapp.data.util

import com.example.cardinfoapp.data.local.entity.CardDbEntity
import com.example.cardinfoapp.domain.model.Bank
import com.example.cardinfoapp.domain.model.Card
import com.example.cardinfoapp.domain.model.Country
import com.example.cardinfoapp.domain.model.Number

class CardDbEntityToCardMapper {

    fun map(cardDbEntities: List<CardDbEntity>): List<Card> {
        return cardDbEntities.map { cardDbEntity ->
            Card(
                number = Number(
                    length = cardDbEntity.number.length,
                    luhn = cardDbEntity.number.luhn
                ),
                scheme = cardDbEntity.scheme,
                type = cardDbEntity.type,
                brand = cardDbEntity.brand,
                prepaid = cardDbEntity.prepaid,
                country = Country(
                    numeric = cardDbEntity.country.numeric,
                    alpha2 = cardDbEntity.country.alpha2,
                    name = cardDbEntity.country.name,
                    emoji = cardDbEntity.country.emoji,
                    currency = cardDbEntity.country.currency,
                    latitude = cardDbEntity.country.latitude,
                    longitude = cardDbEntity.country.longitude
                ),
                bank = Bank(
                    name = cardDbEntity.bank.name,
                    url = cardDbEntity.bank.url,
                    phone = cardDbEntity.bank.phone,
                    city = cardDbEntity.bank.city
                )
            )
        }
    }

    fun reverseMap(card: Card): CardDbEntity {
        return CardDbEntity(
            number = card.number,
            scheme = card.scheme,
            type = card.type,
            brand = card.brand,
            prepaid = card.prepaid,
            country = card.country,
            bank = card.bank
        )
    }
}