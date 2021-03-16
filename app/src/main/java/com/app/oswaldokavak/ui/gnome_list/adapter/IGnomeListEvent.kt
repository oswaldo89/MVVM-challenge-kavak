/**
 * Created by Oswaldo GH on 16/03/21.
 */

package com.app.oswaldokavak.ui.gnome_list.adapter

import com.app.oswaldokavak.data.model.Brastlewark

interface IGnomeListEvent {
    fun onGnomeClick(item: Brastlewark)
}