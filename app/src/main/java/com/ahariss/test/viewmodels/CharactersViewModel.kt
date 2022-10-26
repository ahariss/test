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

    private var offset: Int = 0

    private var hasMore= true


    private val _characters: MutableLiveData<List<MarvelCharacter>> = MutableLiveData()
    val characters: LiveData<List<MarvelCharacter>>
        get() = _characters

    private val _api: MutableLiveData<Resource<CharactersResponse>> =
        MutableLiveData<Resource<CharactersResponse>>().apply { postValue(Resource.Initial) }
    val api: LiveData<Resource<CharactersResponse>>
        get() = _api


    fun getCharacters(loadfromCache: Boolean = false) = viewModelScope.launch {
        //loadFrom local database for first time
        if(loadfromCache){
            val response: Resource<CharactersResponse> = repository.getCharactersLocal();
            if(response is Resource.Success){
                offset = response.value.data?.offset!!
                _api.value = response
            }
        }

        if(hasMore){
            if(offset==0) {
                _api.value = Resource.Loading
            }
            val response: Resource<CharactersResponse> = repository.getCharacters(offset);
            if (response is Resource.Success) {
                response.value.data?.characters?.let {
                    offset = offset + it.size
                    hasMore = response.value.data!!.offset + response.value.data?.count!! < response.value.data!!.total
                    _api.value = response
                    repository.saveCharacters(it)
                }
            }
            _api.value = response
        }



    }


}