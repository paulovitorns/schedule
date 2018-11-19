package br.com.paulosales.schedule.ui.shared

import android.os.Bundle
import android.view.MenuItem
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

interface BaseUi

abstract class BaseView<T : BasePresenter<BaseUi>> : DaggerAppCompatActivity(), BaseUi {

    @Inject
    protected lateinit var presenter: T

    fun setTitle(title: String, showHome: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(showHome)
        supportActionBar?.title = title
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        presenter.attachView(this)
    }

    override fun onDestroy() {
        presenter.destroy()
        super.onDestroy()
    }
}
