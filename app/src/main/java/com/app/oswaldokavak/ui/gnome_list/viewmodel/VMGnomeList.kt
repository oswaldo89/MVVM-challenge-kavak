/**
 * Created by Oswaldo GH on 15/03/21.
 */

package com.app.oswaldokavak.ui.gnome_list.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.oswaldokavak.domain.Repo

class VMGnomeList (private val repo: Repo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Repo::class.java).newInstance(repo)
    }
}