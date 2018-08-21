package br.com.paulosales.schedule.ui.shared

interface BaseContract {
    interface Presenter {
        fun attachView(view: BaseContract.View)
        fun destroy()
    }

    interface View
}
