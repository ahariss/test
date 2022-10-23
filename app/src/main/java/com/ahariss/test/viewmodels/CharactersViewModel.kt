package com.ahariss.test.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahariss.test.mvvm.models.CharactersResponse
import com.ahariss.test.mvvm.data.network.Resource
import com.ahariss.test.mvvm.data.repository.CharactersRepository
import com.ahariss.test.mvvm.models.MarvelCharacter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val repository: CharactersRepository) :
    ViewModel() {

    private var offset : Int = 0

    var chars: MutableList<MarvelCharacter>  = mutableListOf()

    private val _characters: MutableLiveData<List<MarvelCharacter>> = MutableLiveData()
    val characters: LiveData<List<MarvelCharacter>>
        get() = _characters



    private val _api: MutableLiveData<Resource<CharactersResponse>> = MutableLiveData()
    val api: LiveData<Resource<CharactersResponse>>
        get() = _api



    fun getCharacters() = viewModelScope.launch {
        _api.value = Resource.Loading
        val response : Resource<CharactersResponse> = repository.getCharacters(offset);
        if(response is Resource.Success){
            response.value.data?.characters?.let {
                chars.addAll(it)
                _characters.value?.toMutableList()?.addAll(chars)
                _api.value = response
            }
        }else{
            _api.value = response
        }

    }



}