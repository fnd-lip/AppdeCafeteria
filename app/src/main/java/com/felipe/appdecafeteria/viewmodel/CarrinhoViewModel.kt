package com.felipe.appdecafeteria.viewmodel

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.felipe.appdecafeteria.model.Carrinho
import com.felipe.appdecafeteria.model.Produto
import com.felipe.appdecafeteria.repositorio.CarrinhoRepositorio
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarrinhoViewModel @Inject constructor(private val carrinhoRepositorio: CarrinhoRepositorio): ViewModel() {

    var produtosCarrinho = mutableStateListOf<Carrinho>()
    var totalItens = mutableIntStateOf(0)

    fun getProdutos(
        response: (MutableList<Produto>) -> Unit
    ){
       viewModelScope.launch {
           carrinhoRepositorio.getProdutos(response)
       }
    }

    fun adicionarProdutoCarrinho(produto: Carrinho){
        produtosCarrinho.add(produto)
        totalItens.intValue += 1
    }

    fun removerProdutoCarrinho(produto: Carrinho){
        produtosCarrinho.remove(produto)
        totalItens.intValue -= 1
    }

    fun calcularTotal(): Double{
        return produtosCarrinho.sumOf { it.preco.toDouble() }
    }

}