package com.example.rickandmortyapi.presenter

import androidx.fragment.app.Fragment

interface FragmentNavigator {
    fun moveToFragment(container: Int, fragment:Fragment)

    fun removeUpperFragment()

}