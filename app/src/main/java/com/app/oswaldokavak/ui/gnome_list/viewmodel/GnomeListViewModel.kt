/**
 * Created by Oswaldo GH on 15/03/21.
 */

package com.app.oswaldokavak.ui.gnome_list.viewmodel

import androidx.lifecycle.*
import com.app.oswaldokavak.domain.Repo
import com.app.oswaldokavak.utils.Resource
import kotlinx.coroutines.Dispatchers

class GnomeListViewModel(private val repo: Repo) : ViewModel(), LifecycleObserver {

    private val accessList: MutableLiveData<Boolean> = MutableLiveData()

    fun attemptGetList() {
        this.accessList.value = true
    }

    val gnomeList =  accessList.switchMap {
        liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                emit(repo.getList())
            } catch (e: Exception) {
                emit(Resource.Failure(e.message ?: "Unknown Error", e))
            }
        }
    }

}