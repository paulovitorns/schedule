package br.com.paulosales.schedule.ui.shared

abstract class BasePresenter<T>
    : BaseContract.Presenter {
    protected abstract var view: T?

    override fun destroy() {
        view = null
    }
}
