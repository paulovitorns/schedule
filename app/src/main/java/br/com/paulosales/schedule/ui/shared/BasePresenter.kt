package br.com.paulosales.schedule.ui.shared

abstract class BasePresenter<T: BaseUi> {
    private var view: T? = null

    open fun attachView(ui: T) {
        this.view = ui
    }

    open fun destroy() {
        view = null
    }

    @Suppress("UNCHECKED_CAST")
    fun <I : BaseUi> baseUi(): I? = view as I?
}
