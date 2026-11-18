package com.felipe.appdecafeteria.repositorio

import com.felipe.appdecafeteria.datasource.DataSource
import com.felipe.appdecafeteria.model.Produto
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class CarrinhoRepositorio @Inject constructor(private val dataSource: DataSource){
    fun getProdutos(
        response: (MutableList<Produto>) -> Unit
    ) {
       dataSource.getProdutos(response)
    }

}