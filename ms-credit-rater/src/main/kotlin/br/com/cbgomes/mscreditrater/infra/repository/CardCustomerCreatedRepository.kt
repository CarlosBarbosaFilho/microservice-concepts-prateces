package br.com.cbgomes.mscreditrater.infra.repository

import br.com.cbgomes.mscreditrater.domain.CardCustomerCreated
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CardCustomerCreatedRepository: JpaRepository<CardCustomerCreated, Long> {
}